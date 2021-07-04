package cinema.util;

import cinema.model.Role;
import cinema.model.RoleName;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class AdminInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public AdminInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        roleService.add(new Role(RoleName.ROLE_ADMIN));
        roleService.add(new Role(RoleName.ROLE_USER));

        User admin = new User();
        admin.setEmail("admin");
        admin.setPassword("admin");
        admin.setRoles(Set.of(roleService.getRoleByName(RoleName.ROLE_ADMIN)));
        userService.add(admin);
    }
}
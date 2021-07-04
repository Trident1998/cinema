package cinema.service;

import cinema.model.Role;
import cinema.model.RoleName;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(RoleName roleName);
}

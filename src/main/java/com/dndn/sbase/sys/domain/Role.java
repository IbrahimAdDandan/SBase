package com.dndn.sbase.sys.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Role extends BaseModel {

    private String roleName;

    @OneToMany( mappedBy = "role")
    List<RolePermission> permissions;

    @OneToMany(mappedBy = "role")
    List<UserRole> users;

    public Role() {
        super();
    }

    public Role(String roleName, List<RolePermission> permissions, List<UserRole> users) {
        super();
        this.roleName = roleName;
        this.permissions = permissions;
        this.users = users;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public List<UserRole> getUsers() {
        return users;
    }

    public void setUsers(List<UserRole> users) {
        this.users = users;
    }
}

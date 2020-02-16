package com.dndn.sbase.sys.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class RolePermission extends BaseModel {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Permission permission;

    public RolePermission() {
        super();
    }

    public RolePermission(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}

package com.dndn.sbase.sys.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission extends BaseModel {

    private String permissionName;

    private String description;

    @OneToMany(mappedBy = "permission")
    private List<RolePermission> role;

    public Permission() {
        super();
    }

    public Permission(String permissionName, String description) {
        super();
        this.permissionName = permissionName;
        this.description = description;
    }

    public Permission(String permissionName, List<RolePermission> role, String description) {
        super();
        this.permissionName = permissionName;
        this.description = description;
        this.role = role;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<RolePermission> getRole() {
        return role;
    }

    public void setRole(List<RolePermission> role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

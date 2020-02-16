package com.dndn.sbase.sys.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class UserRole extends BaseModel {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Auth auth;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;

    public UserRole() {
        super();
    }

    public UserRole(Auth auth, Role role) {
        super();
        this.auth = auth;
        this.role = role;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

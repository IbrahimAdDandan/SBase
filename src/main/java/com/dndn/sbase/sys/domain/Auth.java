package com.dndn.sbase.sys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Auth extends BaseModel{

    @Column( unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    private boolean isEnabled;

    private String roleName;

    public Auth() {
        super();
    }

    public Auth(String username, String password, String email, boolean isEnabled, String roleName) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.isEnabled = isEnabled;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

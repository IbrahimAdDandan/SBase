package com.dndn.sbase.sys.listner;

import com.dndn.sbase.sys.domain.Privilege;
import com.dndn.sbase.sys.domain.Role;
import com.dndn.sbase.sys.domain.User;
import com.dndn.sbase.sys.repository.UserRepository;
import com.dndn.sbase.sys.repository.PrivilegeRepository;
import com.dndn.sbase.sys.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialDataLoader
        implements ApplicationListener<ContextRefreshedEvent>
{

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE", "Can Read anything");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE", "Can write anything");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        createAdminIfNotFound();
        alreadySetup = true;
    }

    @Transactional
    User createAdminIfNotFound() {
        User u = userRepository.findByEmail("test@test.com");
        if (u == null) {
            Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
            User user = new User();
            user.setUsername("admin");
            user.setPassword("{noop}admin");
            user.setEmail("test@test.com");
            user.setRoles(Arrays.asList(adminRole));
            user.setEnabled(true);
            userRepository.save(user);
        }
        return u;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name, String description) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name, description);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, List<Privilege> privileges) {

        Role role = roleRepository.findByRoleName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
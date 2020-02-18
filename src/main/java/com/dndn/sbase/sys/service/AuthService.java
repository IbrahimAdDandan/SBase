package com.dndn.sbase.sys.service;

import com.dndn.sbase.sys.domain.Privilege;
import com.dndn.sbase.sys.domain.Role;
import com.dndn.sbase.sys.domain.User;
import com.dndn.sbase.sys.repository.RoleRepository;
import com.dndn.sbase.sys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("userDetailsService")
@Transactional
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private IUserService service;

//    @Autowired
//    private MessageSource messages;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", "{noop} ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleRepository.findByRoleName("ROLE_USER"))));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    public List<User> getUsers() { return (List<User>) userRepository.findAll();}

    public User get() {
        return new User();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getAuthByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public User add(User user) {
        return userRepository.save(user);
    }
}

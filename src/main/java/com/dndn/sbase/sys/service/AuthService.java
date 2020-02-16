package com.dndn.sbase.sys.service;

import com.dndn.sbase.sys.domain.Auth;
import com.dndn.sbase.sys.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth user = authRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return new AuthDetailsImp(user);
    }

    public List<Auth> getUsers() { return (List<Auth>) authRepository.findAll();}

    public Auth get() {
        return new Auth();
    }

    public Optional<Auth> getUserById(Long id) {
        return authRepository.findById(id);
    }

    public Auth getAuthByUsername(String username) {
        return authRepository.findByUsername(username);
    }

    public void remove(Long id) {
        authRepository.deleteById(id);
    }

    public Auth add(Auth user) {
        return authRepository.save(user);
    }
}

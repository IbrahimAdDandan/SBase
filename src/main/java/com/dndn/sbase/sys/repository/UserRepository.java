package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);

    public User findByEmail(String email);
}

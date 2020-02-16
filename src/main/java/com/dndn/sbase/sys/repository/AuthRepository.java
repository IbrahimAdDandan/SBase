package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.Auth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Auth, Long> {
    public Auth findByUsername(String username);
}

package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    public Role findByRoleName(String name);
    public List<Role> findByIsDeleted(boolean isDeleted);
}

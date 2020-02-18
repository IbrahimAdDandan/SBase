package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends GenericRepository<Role> {
    public Role findByRoleName(String name);
}

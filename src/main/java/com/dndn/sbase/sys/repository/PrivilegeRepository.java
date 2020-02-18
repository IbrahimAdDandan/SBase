package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.Privilege;

public interface PrivilegeRepository extends GenericRepository<Privilege> {
    public Privilege findByName(String name);
}

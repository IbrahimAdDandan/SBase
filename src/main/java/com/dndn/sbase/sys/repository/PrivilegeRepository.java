package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.Privilege;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
    public Privilege findByName(String name);
    public List<Privilege> findByIsDeleted(boolean isDeleted);
}

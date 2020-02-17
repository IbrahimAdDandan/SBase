package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.BaseModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenericRepository extends CrudRepository<BaseModel, Long> {

    public List<BaseModel> findByIsDeleted(boolean isDeleted);
}

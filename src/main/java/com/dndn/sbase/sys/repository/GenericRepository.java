package com.dndn.sbase.sys.repository;

import com.dndn.sbase.sys.domain.BaseModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenericRepository<Type extends BaseModel> extends CrudRepository<BaseModel, Long> {

    public List<Type> findByIsDeleted(boolean isDeleted);
}

package com.dndn.sbase.sys.controller;

import com.dndn.sbase.sys.domain.BaseModel;
import com.dndn.sbase.sys.domain.Permission;
import com.dndn.sbase.sys.repository.PermissionRepository;
import com.dndn.sbase.sys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseController {


    private PermissionService permissionService;

    @Autowired
    public BaseController(PermissionService permissionService) {
        this.permissionService = permissionService;
        String controllerName = this.getClass().getSimpleName();
        List<Permission> defaultPermissions = new ArrayList<>();
        defaultPermissions.add(new Permission("GET_"+controllerName, "Get All or one "+controllerName));
        defaultPermissions.add(new Permission("ADD_"+controllerName, "Add "+controllerName));
        defaultPermissions.add(new Permission("UPDATE_"+controllerName, "Update"+controllerName));
        defaultPermissions.add(new Permission("DELETE_"+controllerName, "Delete "+controllerName));
//        System.out.println(defaultPermissions);
        permissionService.saveAll(defaultPermissions);
    }
}

package com.dndn.sbase.sys.controller;

import com.dndn.sbase.sys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class BaseController {


    private PermissionService permissionService;

    @Autowired
    public BaseController(PermissionService permissionService) {
        this.permissionService = permissionService;
        String controllerName = this.getClass().getSimpleName();
//        List<Privilege> defaultPermissions = new ArrayList<>();
//        defaultPermissions.add(new Privilege("GET_"+controllerName, "Get All or one "+controllerName));
//        defaultPermissions.add(new Privilege("ADD_"+controllerName, "Add "+controllerName));
//        defaultPermissions.add(new Privilege("UPDATE_"+controllerName, "Update"+controllerName));
//        defaultPermissions.add(new Privilege("DELETE_"+controllerName, "Delete "+controllerName));
//        System.out.println(defaultPermissions);
//        permissionService.saveAll(defaultPermissions);
    }
}

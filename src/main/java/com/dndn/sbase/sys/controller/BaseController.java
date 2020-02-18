package com.dndn.sbase.sys.controller;

import com.dndn.sbase.sys.domain.Privilege;
import com.dndn.sbase.sys.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseController {


    private PrivilegeService privilegeService;

    @Autowired
    public BaseController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
        String controllerName = this.getClass().getSimpleName();
        List<Privilege> defaultPermissions = new ArrayList<>();
        defaultPermissions.add(new Privilege("GET_"+controllerName, "Get All or one "+controllerName));
        defaultPermissions.add(new Privilege("ADD_"+controllerName, "Add "+controllerName));
        defaultPermissions.add(new Privilege("UPDATE_"+controllerName, "Update"+controllerName));
        defaultPermissions.add(new Privilege("DELETE_"+controllerName, "Delete "+controllerName));

        privilegeService.saveAll(defaultPermissions);
    }
}

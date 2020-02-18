package com.dndn.sbase.sys.controller;

import com.dndn.sbase.sys.service.PermissionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Permission extends BaseController {

    public Permission(PermissionService permissionService) {
        super(permissionService);
    }
}

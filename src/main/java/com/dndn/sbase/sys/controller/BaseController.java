package com.dndn.sbase.sys.controller;

import com.dndn.sbase.sys.domain.Privilege;
import com.dndn.sbase.sys.helper.AuthorityHelper;
import com.dndn.sbase.sys.service.PrivilegeService;
import com.dndn.sbase.sys.type.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
@RequestMapping("baseModels")
public class BaseController {


    private PrivilegeService privilegeService;

    @Autowired
    public BaseController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
        String controllerName = this.getClass().getSimpleName();
        List<Privilege> defaultPermissions = new ArrayList<>();
        defaultPermissions.add(new Privilege("GET_"+controllerName, "Get All or one "+controllerName));
        defaultPermissions.add(new Privilege("ADD_"+controllerName, "Add "+controllerName));
        defaultPermissions.add(new Privilege("UPDATE_"+controllerName, "Update "+controllerName));
        defaultPermissions.add(new Privilege("DELETE_"+controllerName, "Delete "+controllerName));

        privilegeService.saveAll(defaultPermissions);

    }

    @RequestMapping("/forTest")
    @ResponseBody
    public ResponseEntity<?> forTest(Authentication authentication) {

        UserDetails user = (UserDetails)authentication.getPrincipal();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.addAll(authentication.getAuthorities());
//        if (AuthorityHelper.hasAuthority(authorities, "WRITE_PRIVILEGE")) {
        if (AuthorityHelper.hasAuthority(user, this.getClass().getSimpleName(), OperationType.GET)) {
            return new ResponseEntity<>(" the user has write privilege bla bla", HttpStatus.OK);
        }
        return new ResponseEntity<>("NoOoOp", HttpStatus.OK);
    }
}

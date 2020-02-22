package com.dndn.sbase.sys.controller;


import com.dndn.sbase.sys.domain.Privilege;
import com.dndn.sbase.sys.helper.AuthorityHelper;
import com.dndn.sbase.sys.service.PrivilegeService;
import com.dndn.sbase.sys.type.OperationType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    public BaseController(PrivilegeService privilegeService) {
        String getPrivilege = OperationType.GET.name() + "_" + this.getClass().getSimpleName();
        String postPrivilege = OperationType.ADD.name() + "_" + this.getClass().getSimpleName();
        String updatePrivilege = OperationType.UPDATE.name() + "_" + this.getClass().getSimpleName();
        String deletePrivilege = OperationType.DELETE.name() + "_" + this.getClass().getSimpleName();

        List<Privilege> privileges = new ArrayList<>();

        if (privilegeService.getBYName(getPrivilege) == null)
            privileges.add(new Privilege(getPrivilege,"Get one or all"));

        if (privilegeService.getBYName(getPrivilege) == null)
            privileges.add(new Privilege(postPrivilege,"Insert Privilege"));

        if (privilegeService.getBYName(getPrivilege) == null)
            privileges.add(new Privilege(updatePrivilege,"Update Privilege"));

        if (privilegeService.getBYName(getPrivilege) == null)
            privileges.add(new Privilege(deletePrivilege,"Delete Privilege"));

        privilegeService.saveAll(privileges);
    }

//    @RequestMapping("/forTest")
//    @ResponseBody
//    public ResponseEntity<?> forTest(Authentication authentication) {
//
//        UserDetails user = (UserDetails)authentication.getPrincipal();
////        List<GrantedAuthority> authorities = new ArrayList<>();
////        authorities.addAll(authentication.getAuthorities());
////        if (AuthorityHelper.hasAuthority(authorities, "WRITE_PRIVILEGE")) {
//        if (AuthorityHelper.hasAuthority(user, this.getClass().getSimpleName(), OperationType.GET)) {
//            return new ResponseEntity<>(" the user has write privilege bla bla", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("NoOoOp", HttpStatus.OK);
//    }
}

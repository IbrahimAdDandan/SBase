package com.dndn.sbase.sys.controller;

import com.dndn.sbase.sys.helper.AuthorityHelper;
import com.dndn.sbase.sys.type.OperationType;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequestMapping("baseModels")
public class BaseController {


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

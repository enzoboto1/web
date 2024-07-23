package com.rungroop.web.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {
    
    public static UserDetails getSessionUser(){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof Object) {
            return (UserDetails) user;
        }
        return null;
    }
}

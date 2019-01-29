package com.demo.cloud.authserver.service;

import com.demo.cloud.authserver.domain.Account;
import com.demo.cloud.authserver.domain.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * COPYRIGHT © 2005-2018 CHARLESKEITH ALL RIGHTS RESERVED.
 *
 * @author Batman.qin
 * @create 2019-01-04 15:12
 */
@Service
public class AuthServiceImpl implements AuthService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    DomainUserDetailsService userDetailsService;
    @Override
    public JsonResult<Account> register(Account userToAdd) {
        return null;
    }

    @Override
    public JsonResult<String> login(String username, String password) {
        try {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return JsonResult.<String>builder().data("").build();
        } catch (BadCredentialsException e) {
            logger.debug(e.getMessage());
            return JsonResult.<String>builder().error("帐号或密码错误").build();
        }
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }
}

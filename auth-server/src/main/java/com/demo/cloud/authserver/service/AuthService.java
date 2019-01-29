package com.demo.cloud.authserver.service;

import com.demo.cloud.authserver.domain.Account;
import com.demo.cloud.authserver.domain.JsonResult;

/**
 * COPYRIGHT © 2005-2018 CHARLESKEITH ALL RIGHTS RESERVED.
 *
 * @author Batman.qin
 * @create 2019-01-04 15:10
 */
public interface AuthService {
    JsonResult<Account> register(Account userToAdd);

    JsonResult<String> login(String username, String password);

    String refresh(String oldToken);
}

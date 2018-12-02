package com.demo.cloud.authserver.repository;

import com.demo.cloud.authserver.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    /**
     * 根据用户名查找账户信息
     * @param username 用户名
     * @return 账户信息
     */
    Account findByUserName(String username);
}

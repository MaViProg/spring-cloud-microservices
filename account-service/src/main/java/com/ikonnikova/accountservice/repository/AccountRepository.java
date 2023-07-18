package com.ikonnikova.accountservice.repository;

import com.ikonnikova.accountservice.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}

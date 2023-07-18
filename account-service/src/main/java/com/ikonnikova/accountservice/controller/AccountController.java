package com.ikonnikova.accountservice.controller;

import com.ikonnikova.accountservice.dto.AccountRequestDTO;
import com.ikonnikova.accountservice.dto.AccountResponseDto;
import com.ikonnikova.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialNotFoundException;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{accountId}")
    public AccountResponseDto getAccount(@PathVariable Long accountId) {
        return new AccountResponseDto(accountService.getAccountById(accountId));
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(),
                accountRequestDTO.getBills());
    }

    @PutMapping("{accountId}")
    public AccountResponseDto updateAccount(@PathVariable Long accountId,
                                            @RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDto(accountService.updateAccount
                (accountId, accountRequestDTO.getName(),
                        accountRequestDTO.getEmail(),
                        accountRequestDTO.getPhone(),
                        accountRequestDTO.getBills()));
    }

    @DeleteMapping("{accountId}")
    public AccountResponseDto delete(@PathVariable Long accountId) {
        return new AccountResponseDto(accountService.deleteAccount(accountId));
    }
}

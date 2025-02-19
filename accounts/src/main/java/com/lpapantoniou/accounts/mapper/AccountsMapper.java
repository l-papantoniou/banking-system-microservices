package com.lpapantoniou.accounts.mapper;

import com.lpapantoniou.accounts.dto.AccountDto;
import com.lpapantoniou.accounts.entities.Account;

public class AccountsMapper {

        public static AccountDto mapToAccountDto(Account account) {
            AccountDto accountDto = new AccountDto();
            accountDto.setAccountNumber(account.getAccountNumber());
            accountDto.setAccountType(account.getAccountType());
            accountDto.setBranchAddress(account.getBranchAddress());
            return accountDto;
        }

        public static Account mapToAccount(AccountDto accountDto) {
            Account account = new Account();
            account.setAccountNumber(accountDto.getAccountNumber());
            account.setAccountType(accountDto.getAccountType());
            account.setBranchAddress(accountDto.getBranchAddress());
            return account;
        }


}

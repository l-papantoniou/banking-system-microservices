package com.lpapantoniou.accounts.service.impl;

import com.lpapantoniou.accounts.constants.AccountsConstants;
import com.lpapantoniou.accounts.dto.AccountDto;
import com.lpapantoniou.accounts.dto.CustomerDto;
import com.lpapantoniou.accounts.entities.Account;
import com.lpapantoniou.accounts.entities.Customer;
import com.lpapantoniou.accounts.exception.CustomerAlreadyExistsException;
import com.lpapantoniou.accounts.exception.ResourceNotFoundException;
import com.lpapantoniou.accounts.mapper.AccountsMapper;
import com.lpapantoniou.accounts.mapper.CustomerMapper;
import com.lpapantoniou.accounts.repositories.AccountRepository;
import com.lpapantoniou.accounts.repositories.CustomerRepository;
import com.lpapantoniou.accounts.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
public class AccountServiceImpl implements AccountService {

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    public AccountServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber");
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);
        customerDto.setAccountDto(AccountsMapper.mapToAccountDto(account));
        return customerDto;
    }


    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {


        Account account = accountRepository.findById(customerDto.getAccountDto().getAccountNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "AccountNumber", customerDto.getAccountDto().getAccountNumber().toString())
        );

        Customer customer = customerRepository.findById(account.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "CustomerID", account.getCustomerId().toString())
        );

        if (customerDto.getAccountDto() != null) {
            AccountDto accountDto = customerDto.getAccountDto();
            account.setAccountType(accountDto.getAccountType() != null ? accountDto.getAccountType() : account.getAccountType());
            account.setBranchAddress(accountDto.getBranchAddress() != null ? accountDto.getBranchAddress() : account.getBranchAddress());
        }

        // Save the updated account
        accountRepository.save(account);

        // Convert the updated account entity back to a DTO and return it
        return true;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber)
        );

        accountRepository.deleteByCustomerId(customer.getCustomerId());

        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

}

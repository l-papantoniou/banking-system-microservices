package com.lpapantoniou.accounts.service;

import com.lpapantoniou.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {


    /**
     *
     * @param customerDto customer Dto
     */
    void createAccount(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Accounts details based on given mobile Number
     */
    CustomerDto fetchAccount(String mobileNumber);


    /**
     *
     * @param customerDto - Customer Dto
     * @return true if update is successful
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber - Input mobile number
     * @return true if delete is successful
     */
    boolean deleteAccount(String mobileNumber);


}

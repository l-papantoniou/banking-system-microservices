package com.lpapantoniou.accounts.repositories;


import com.lpapantoniou.accounts.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value="Select customer from Customer customer " +
            "where customer.mobileNumber =:mobileNumber")
    Optional<Customer> findByMobileNumber(@Param("mobileNumber") String mobileNumber);
}

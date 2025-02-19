package com.lpapantoniou.accounts.repositories;

import com.lpapantoniou.accounts.entities.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT account FROM Account account " +
            "WHERE account.customerId = :customerId")
    Optional<Account> findByCustomerId(Long customerId);

    @Query("SELECT account FROM Account account " +
            "WHERE account.accountNumber = :accountNumber")
    Optional<Account> findByAccountNumber(Long accountNumber);

    @Modifying
    @Transactional
    void deleteByCustomerId(Long customerId);
}

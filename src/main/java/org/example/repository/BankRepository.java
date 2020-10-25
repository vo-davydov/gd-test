package org.example.repository;

import org.example.entity.Bank;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankRepository extends PagingAndSortingRepository<Bank, Long> {
    Bank getOne(Long id);
}

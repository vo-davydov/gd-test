package org.example.repository;

import org.example.entity.Bank;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BankRepository extends PagingAndSortingRepository<Bank, Long> {
    Bank getOne(Long id);

    @Query(value = "select * from bank b where b.BIK = ?1",
            countQuery = "select count(*) from bank b where b.BIK = ?1",
            nativeQuery = true
    )
    List<Bank> findAllByBIK(String BIK, Pageable pageable);

    @Query(value = "select * from bank b where b.name = ?1",
            countQuery = "select count(*) from bank b where b.name = ?1",
            nativeQuery = true
    )
    List<Bank> findAllByName(String name, Pageable pageable);
}

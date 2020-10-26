package org.example.repository;

import org.example.entity.Contribution;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;
import java.util.List;

public interface ContributionRepository extends PagingAndSortingRepository<Contribution, Long> {
    Contribution getOne(Long id);

    @Query(value = "select * from contributions c where c.open_date = ?1",
            countQuery = "select count(*) from contributions c where c.open_date = ?1",
            nativeQuery = true
    )
    List<Contribution> findAllByOpenDate(Date openDate, Pageable pageable);

    @Query(value = "select * from contributions c where c.percent = ?1",
            countQuery = "select count(*) from contributions c where c.percent = ?1",
            nativeQuery = true
    )
    List<Contribution> findAllByPercent(Double percent, Pageable pageable);

    @Query(value = "select * from contributions c where c.period_in_month = ?1",
            countQuery = "select count(*) from contributions c where c.period_in_month  = ?1",
            nativeQuery = true
    )
    List<Contribution> findAllByPeriodInMonth(Integer periodInMonth, Pageable pageable);

    @Query(value = "select * from contributions c where c.client_id = ?1",
            countQuery = "select count(*) from contributions c where c.client_id  = ?1",
            nativeQuery = true
    )
    List<Contribution> findAllByClientId(Integer periodInMonth, Pageable pageable);

    @Query(value = "select * from contributions c where c.bank_id = ?1",
            countQuery = "select count(*) from contributions c where c.bank_id  = ?1",
            nativeQuery = true
    )
    List<Contribution> findAllByBankId(Integer periodInMonth, Pageable pageable);
}

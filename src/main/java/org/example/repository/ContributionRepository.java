package org.example.repository;

import org.example.entity.Contribution;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContributionRepository extends PagingAndSortingRepository<Contribution, Long> {
    Contribution getOne(Long id);
}

package org.example.repository;

import org.example.entity.Okopf;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OkopfRepository extends PagingAndSortingRepository<Okopf, Long> {
    Okopf getOne(Long id);
}

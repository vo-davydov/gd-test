package org.example.repository;

import org.example.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    Client getOne(Long id);
}

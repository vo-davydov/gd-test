package org.example.repository;

import org.example.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    Client getOne(Long id);

    @Query(value = "select * from client c where c.okopf_id = ?1",
            countQuery = "select count(*) from client c where c.okopf_id = ?1",
            nativeQuery = true
    )
    List<Client> findAllByOkopf(int okopfId, Pageable pageable);

    @Query(value = "select * from client c where c.name = ?1",
            countQuery = "select count(*) from client c where c.name = ?1",
            nativeQuery = true
    )
    List<Client> findAllByName(String name, Pageable pageable);

    @Query(value = "select * from client c where c.inn = ?1",
            countQuery = "select count(*) from client c where c.inn = ?1",
            nativeQuery = true
    )
    List<Client> findAllByInn(String inn, Pageable pageable);

    @Query(value = "select * from client c where c.short_name = ?1",
            countQuery = "select count(*) from client c where c.short_name = ?1",
            nativeQuery = true
    )
    List<Client> findAllByShortName(String shortName, Pageable pageable);

    @Query(value = "select * from client c where c.address = ?1",
            countQuery = "select count(*) from client c where c.address = ?1",
            nativeQuery = true
    )
    List<Client> findAllByAddress(String address, Pageable pageable);
}

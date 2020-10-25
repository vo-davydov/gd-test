package org.example.service;

import org.example.dto.BankDto;
import org.example.mapper.BankMapper;
import org.example.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {
    private final BankRepository repository;
    private final BankMapper mapper;

    @Autowired
    public BankService(BankRepository bankRepository, BankMapper bankMapper) {
        this.repository = bankRepository;
        this.mapper = bankMapper;
    }

    public BankDto save(BankDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public BankDto get(Long id) {
        try {
            return mapper.toDto(repository.getOne(id));
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean changeEntity(Long id, BankDto newBankDto) {
        BankDto bankDto = get(id);
        if (bankDto != null) {
            bankDto.setName(newBankDto.getName());
            bankDto.setBIK(newBankDto.getBIK());
            save(bankDto);
            return true;
        } else {
            return false;
        }
    }

    public List<BankDto> getAll(Pageable pageable) {
        List<BankDto> result = new ArrayList<>();
        repository.findAll(pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    public List<BankDto> getAllSorted(int page, int size, String sort) {
        if ("desc".equals(sort)) {
            return getAll(PageRequest.of(page, size, Sort.Direction.DESC, "id"));
        } else {
            return getAll(PageRequest.of(page, size, Sort.Direction.ASC, "id"));
        }
    }
}
package org.example.service;

import org.example.dto.ClientDto;
import org.example.dto.ContributionDto;
import org.example.entity.Bank;
import org.example.entity.Client;
import org.example.entity.Contribution;
import org.example.mapper.ContributionMapper;
import org.example.repository.BankRepository;
import org.example.repository.ClientRepository;
import org.example.repository.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContributionService {
    private final ContributionRepository repository;
    private final ContributionMapper mapper;
    private final BankRepository bankRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ContributionService(ContributionRepository repository, ContributionMapper mapper,
                               BankRepository bankRepository, ClientRepository clientRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.bankRepository = bankRepository;
        this.clientRepository = clientRepository;
    }

    public ContributionDto save(ContributionDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }


    public ContributionDto get(Long id) {

        try {
            return mapper.toDto(repository.getOne(id));
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void deleteById(Long id) {
        Contribution contribution = repository.getOne(id);
        Bank bank = bankRepository.getOne(contribution.getBank().getId());
        Client client = clientRepository.getOne(contribution.getClient().getId());
        bank.getContributions().remove(contribution);
        client.getContributions().remove(contribution);
        repository.deleteById(id);
    }

    public boolean changeEntity(Long id, ContributionDto newContributionDto) {
        ContributionDto contributionDto = get(id);
        if (contributionDto != null) {
            contributionDto.setOpenDate(newContributionDto.getOpenDate());
            contributionDto.setPercent(newContributionDto.getPercent());
            contributionDto.setPeriodInMonth(newContributionDto.getPeriodInMonth());
            contributionDto.setClientId(newContributionDto.getClientId());
            contributionDto.setBankId(newContributionDto.getBankId());
            save(contributionDto);
            return true;
        } else {
            return false;
        }
    }

    public List<ContributionDto> getAll(Pageable pageable) {
        List<ContributionDto> result = new ArrayList<>();
        repository.findAll(pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    public List<ContributionDto> getAllSorted(int page, int size, String sort) {
        if ("desc".equals(sort)) {
            return getAll(PageRequest.of(page, size, Sort.Direction.DESC, "id"));
        } else {
            return getAll(PageRequest.of(page, size, Sort.Direction.ASC, "id"));
        }
    }

    public List<ContributionDto> getAllSortedByParam(int page, int size, String sort, Date openDate, Double percent, Integer periodInMonth, int clientId, int bankId) {
        Pageable pageable;
        if ("desc".equals(sort)) {
            pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
            return getContributionDtos(openDate, percent, periodInMonth, clientId, bankId, pageable);
        } else {
            pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
            return getContributionDtos(openDate, percent, periodInMonth, clientId, bankId, pageable);
        }
    }

    private List<ContributionDto> getContributionDtos(Date openDate, Double percent, Integer periodInMonth, Integer clientId, Integer bankId, Pageable pageable) {
        if (openDate != null) {
            return getAllByOpenDate(openDate, pageable);
        } else if (percent != null) {
            return getAllByPercent(percent, pageable);
        } else if (periodInMonth != null) {
            return getAllByPeriodInMonth(periodInMonth, pageable);
        } else if (clientId != null) {
            return getAllByClientId(clientId, pageable);
        } else if (bankId != null) {
            return getAllByBankId(bankId, pageable);
        } else {
            return getAll(pageable);
        }
    }

    private List<ContributionDto> getAllByOpenDate(Date openDate, Pageable pageable) {
        List<ContributionDto> result = new ArrayList<>();
        repository.findAllByOpenDate(openDate, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ContributionDto> getAllByPercent(Double percent, Pageable pageable) {
        List<ContributionDto> result = new ArrayList<>();
        repository.findAllByPercent(percent, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ContributionDto> getAllByPeriodInMonth(Integer periodInMonth, Pageable pageable) {
        List<ContributionDto> result = new ArrayList<>();
        repository.findAllByPeriodInMonth(periodInMonth, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ContributionDto> getAllByClientId(Integer clientId, Pageable pageable) {
        List<ContributionDto> result = new ArrayList<>();
        repository.findAllByClientId(clientId, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ContributionDto> getAllByBankId(Integer bankId, Pageable pageable) {
        List<ContributionDto> result = new ArrayList<>();
        repository.findAllByBankId(bankId, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

}

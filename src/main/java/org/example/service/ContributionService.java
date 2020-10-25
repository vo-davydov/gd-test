package org.example.service;

import org.example.dto.ContributionDto;
import org.example.mapper.ContributionMapper;
import org.example.repository.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContributionService {
    private final ContributionRepository repository;
    private final ContributionMapper mapper;

    @Autowired
    public ContributionService(ContributionRepository repository, ContributionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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

}

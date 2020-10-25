package org.example.service;

import org.example.dto.OkopfDto;
import org.example.mapper.OkopfMapper;
import org.example.repository.OkopfRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OkopfService {
    private final OkopfRepository repository;
    private final OkopfMapper mapper;

    @Autowired
    public OkopfService(OkopfRepository repository, OkopfMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public OkopfDto save(OkopfDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public OkopfDto get(Long id) {

        try {
            return mapper.toDto(repository.getOne(id));
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean changeEntity(Long id, OkopfDto newOkopfDto) {
        OkopfDto okopfDto = get(id);
        if (okopfDto != null) {
            okopfDto.setCode(newOkopfDto.getCode());
            okopfDto.setName(newOkopfDto.getName());
            save(okopfDto);
            return true;
        } else {
            return false;
        }
    }

    public List<OkopfDto> getAll(Pageable pageable) {
        List<OkopfDto> result = new ArrayList<>();
        repository.findAll(pageable).forEach(o -> {
            result.add(mapper.toDto(o));
        });
        return result;
    }

    public List<OkopfDto> getAllSorted(int page, int size, String sort) {
        if ("desc".equals(sort)) {
            return getAll(PageRequest.of(page, size, Sort.Direction.DESC, "id"));
        } else {
            return getAll(PageRequest.of(page, size, Sort.Direction.ASC, "id"));
        }
    }
}

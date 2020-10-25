package org.example.service;

import org.example.dto.ClientDto;
import org.example.dto.OkopfDto;
import org.example.mapper.ClientMapper;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final OkopfService okopfService;

    @Autowired
    public ClientService(ClientRepository repository, ClientMapper mapper, OkopfService okopfService) {
        this.repository = repository;
        this.mapper = mapper;
        this.okopfService = okopfService;
    }

    public ClientDto save(ClientDto dto) {
        OkopfDto okopfDto = dto.getOkopfDto();
        if (okopfDto != null && okopfDto.getId() == null) {
            dto.setOkopfDto(okopfService.save(okopfDto));
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public ClientDto get(Long id) {
        try {
            return mapper.toDto(repository.getOne(id));
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean changeEntity(Long id, ClientDto newClientDto) {
        ClientDto clientDto = get(id);
        if (clientDto != null) {
            clientDto.setName(newClientDto.getName());
            clientDto.setInn(newClientDto.getInn());
            clientDto.setOkopfDto(newClientDto.getOkopfDto());
            clientDto.setShortName(newClientDto.getShortName());
            clientDto.setAddress(newClientDto.getAddress());
            save(clientDto);
            return true;
        } else {
            return false;
        }
    }

    public List<ClientDto> getAll(Pageable pageable) {
        List<ClientDto> result = new ArrayList<>();
        repository.findAll(pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    public List<ClientDto> getAllSorted(int page, int size, String sort) {
        if ("desc".equals(sort)) {
            return getAll(PageRequest.of(page, size, Sort.Direction.DESC, "id"));
        } else {
            return getAll(PageRequest.of(page, size, Sort.Direction.ASC, "id"));
        }
    }
}

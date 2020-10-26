package org.example.service;

import org.example.dto.ClientDto;
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
        dto.setOkopfId(okopfService.get(dto.getOkopfId()).getId());
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
            if (okopfService.get(newClientDto.getOkopfId()) != null) {
                clientDto.setOkopfId(newClientDto.getOkopfId());
            }
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

    public List<ClientDto> getAllSortedByParam(int page, int size, String sort, Integer okopf, String name,
                                               String inn, String shortName, String address) {
        Pageable pageable;
        if ("desc".equals(sort)) {
            pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
            return getClientDtos(okopf, name, inn, shortName, address, pageable);
        } else {
            pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
            return getClientDtos(okopf, name, inn, shortName, address, pageable);
        }
    }

    private List<ClientDto> getClientDtos(Integer okopf, String name, String inn, String shortName, String address, Pageable pageable) {
        if (okopf != null) {
            return getAllByOkopf(okopf, pageable);
        } else if (name != null) {
            return getAllByName(name, pageable);
        } else if (inn != null) {
            return getAllByInn(inn, pageable);
        } else if (shortName != null) {
            return getAllByShortName(shortName, pageable);
        } else if (address != null) {
            return getAllByAddress(address, pageable);
        } else {
            return getAll(pageable);
        }
    }

    private List<ClientDto> getAllByOkopf(int okopfId, Pageable pageable) {
        List<ClientDto> result = new ArrayList<>();
        repository.findAllByOkopf(okopfId, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ClientDto> getAllByName(String name, Pageable pageable) {
        List<ClientDto> result = new ArrayList<>();
        repository.findAllByName(name, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ClientDto> getAllByInn(String inn, Pageable pageable) {
        List<ClientDto> result = new ArrayList<>();
        repository.findAllByInn(inn, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ClientDto> getAllByShortName(String shortName, Pageable pageable) {
        List<ClientDto> result = new ArrayList<>();
        repository.findAllByShortName(shortName, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

    private List<ClientDto> getAllByAddress(String address, Pageable pageable) {
        List<ClientDto> result = new ArrayList<>();
        repository.findAllByAddress(address, pageable).forEach(c -> {
            result.add(mapper.toDto(c));
        });
        return result;
    }

}


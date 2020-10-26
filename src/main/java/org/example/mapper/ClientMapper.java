package org.example.mapper;

import org.example.dto.ClientDto;
import org.example.entity.Client;
import org.example.entity.Contribution;
import org.example.service.ContributionService;
import org.example.service.OkopfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ClientMapper {

    @Autowired
    private ContributionMapper contributionMapper;

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private OkopfService okopfService;

    @Autowired
    private OkopfMapper okopfMapper;

    public Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Client client = new Client();

        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setInn(clientDto.getInn());
        client.setShortName(clientDto.getShortName());
        client.setAddress(clientDto.getAddress());

        if (clientDto.getOkopfId() != null) {
            client.setOkopf(okopfMapper.toEntity(okopfService.get(clientDto.getOkopfId())));
        }
        if (clientDto.getContributionIds() != null) {
            Set<Contribution> contributions = new HashSet<>();
            clientDto.getContributionIds().forEach(c -> {
                if (contributionService.get(c) != null) {
                    contributions.add(contributionMapper.toEntity(contributionService.get(c)));
                }
            });
            client.setContributions(contributions);
        }
        return client;
    }

    public ClientDto toDto(Client client) {
        if (client == null) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setInn(client.getInn());
        clientDto.setShortName(client.getShortName());
        clientDto.setAddress(client.getAddress());
        clientDto.setCreated(client.getCreated());
        clientDto.setUpdated(client.getUpdated());
        if (client.getOkopf() != null) {
            clientDto.setOkopfId(client.getOkopf().getId());
        }

        if (client.getContributions() != null) {
            Set<Long> contributionIds = new HashSet<>();
            client.getContributions().forEach(c -> {
                contributionIds.add(c.getId());
            });
            clientDto.setContributionIds(contributionIds);
        }

        return clientDto;
    }
}

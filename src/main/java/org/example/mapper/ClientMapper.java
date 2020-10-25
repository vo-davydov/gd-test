package org.example.mapper;

import org.example.dto.ClientDto;
import org.example.dto.ContributionDto;
import org.example.entity.Client;
import org.example.entity.Contribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ClientMapper {

    @Autowired
    private ContributionMapper contributionMapper;

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
        client.setOkopf(new OkopfMapper().toEntity(clientDto.getOkopfDto()));
        if (clientDto.getContributionDto() != null) {
            Set<Contribution> contributions = new HashSet<>();
            clientDto.getContributionDto().forEach(c -> {
                contributions.add(contributionMapper.toEntity(c));
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
        clientDto.setOkopfDto(new OkopfMapper().toDto(client.getOkopf()));
        Set<ContributionDto> contributions = new HashSet<>();
        client.getContributions().forEach(c -> {
            contributions.add(contributionMapper.toDto(c));
        });
        return clientDto;
    }
}

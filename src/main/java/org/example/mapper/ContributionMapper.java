package org.example.mapper;

import org.example.dto.ContributionDto;
import org.example.entity.Contribution;
import org.example.repository.BankRepository;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContributionMapper {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Contribution toEntity(ContributionDto contributionDto) {
        if (contributionDto == null) {
            return null;
        }

        Contribution contribution = new Contribution();

        contribution.setId(contributionDto.getId());
        contribution.setOpenDate(contributionDto.getOpenDate());
        contribution.setPercent(contributionDto.getPercent());
        contribution.setPeriodInMonth(contributionDto.getPeriodInMonth());
        contribution.setBank(bankRepository.getOne(contributionDto.getBankId()));
        contribution.setClient(clientRepository.getOne(contributionDto.getClientId()));

        return contribution;
    }

    public ContributionDto toDto(Contribution contribution) {
        if (contribution == null) {
            return null;
        }

        ContributionDto contributionDto = new ContributionDto();

        contributionDto.setId(contribution.getId());
        contributionDto.setOpenDate(contribution.getOpenDate());
        contributionDto.setPercent(contribution.getPercent());
        contributionDto.setPeriodInMonth(contribution.getPeriodInMonth());
        contributionDto.setClientId(contribution.getClient().getId());
        contributionDto.setBankId(contribution.getBank().getId());

        return contributionDto;
    }
}

package org.example.mapper;

import org.example.dto.BankDto;
import org.example.entity.Bank;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BankMapper {

    public Bank toEntity(BankDto bankDto) {
        if (bankDto == null) {
            return null;
        }

        Bank bank = new Bank();
        bank.setId(bankDto.getId());
        bank.setName(bankDto.getName());
        bank.setBIK(bankDto.getBIK());

        return bank;
    }

    public BankDto toDto(Bank bank) {
        if (bank == null) {
            return null;
        }

        BankDto bankDto = new BankDto();
        bankDto.setCreated(bank.getCreated());
        bankDto.setUpdated(bank.getUpdated());
        bankDto.setId(bank.getId());
        bankDto.setName(bank.getName());
        bankDto.setBIK(bank.getBIK());

        if (bank.getContributions() != null) {
            Set<Long> contributionIds = new HashSet<>();
            bank.getContributions().forEach(b -> {
                contributionIds.add(b.getId());
            });
            bankDto.setContributionIds(contributionIds);
        }

        return bankDto;
    }
}

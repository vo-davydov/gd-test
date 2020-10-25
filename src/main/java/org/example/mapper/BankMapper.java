package org.example.mapper;

import org.example.dto.BankDto;
import org.example.dto.ClientDto;
import org.example.entity.Bank;
import org.example.entity.Client;
import org.springframework.stereotype.Component;

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

        bankDto.setId(bank.getId());
        bankDto.setName(bank.getName());
        bankDto.setBIK(bank.getBIK());

        return bankDto;
    }
}

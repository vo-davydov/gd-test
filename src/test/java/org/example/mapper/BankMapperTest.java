package org.example.mapper;

import org.example.dto.BankDto;
import org.example.entity.Bank;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BankMapperTest {

    private Bank bank;
    private BankDto bankDto;
    private BankMapper bankMapper;

    @Before
    public void init() {
        this.bank = createBank();
        this.bankDto = createBankDto();
        this.bankMapper = new BankMapper();
    }

    private BankDto createBankDto() {
        BankDto bankDto = new BankDto();
        bankDto.setName("Test name dto");
        bankDto.setBIK("Test BIK dto");
        return bankDto;
    }

    private Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Test name");
        bank.setBIK("Test BIK");
        return bank;
    }

    @Test
    public void toEntity() {
        Bank bank = bankMapper.toEntity(this.bankDto);
        assertEquals(bank.getBIK(), bankDto.getBIK());
        assertEquals(bank.getName(), bankDto.getName());
    }

    @Test
    public void toDto() {
        BankDto bankDto = bankMapper.toDto(this.bank);
        assertEquals(bank.getBIK(), bankDto.getBIK());
        assertEquals(bank.getName(), bankDto.getName());
    }
}

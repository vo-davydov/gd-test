package org.example.dto;

import java.util.Set;

public class BankDto extends AbstractDto{
    private String name;
    private String BIK;
    private Set<ContributionDto> contributionDto;

    public BankDto() {

    }

    public Set<ContributionDto> getContributionDto() {
        return contributionDto;
    }

    public void setContributionDto(Set<ContributionDto> contributionDto) {
        this.contributionDto = contributionDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBIK() {
        return BIK;
    }

    public void setBIK(String BIK) {
        this.BIK = BIK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BankDto bankDto = (BankDto) o;

        if (!name.equals(bankDto.name)) return false;
        return BIK.equals(bankDto.BIK);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + BIK.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BankDto{" +
                "name='" + name + '\'' +
                ", BIK='" + BIK + '\'' +
                '}';
    }
}

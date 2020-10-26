package org.example.dto;

import java.util.Set;

public class BankDto extends AbstractDto {
    private String name;
    private String BIK;
    private Set<Long> contributionIds;

    public BankDto() {

    }

    public Set<Long> getContributionIds() {
        return contributionIds;
    }

    public void setContributionIds(Set<Long> contributionIds) {
        this.contributionIds = contributionIds;
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

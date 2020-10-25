package org.example.dto;


import java.sql.Date;

public class ContributionDto extends AbstractDto {
    private Date openDate;
    private Double percent;
    private Integer periodInMonth;
    private Long clientId;
    private Long bankId;

    public ContributionDto() {

    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Integer getPeriodInMonth() {
        return periodInMonth;
    }

    public void setPeriodInMonth(Integer periodInMonth) {
        this.periodInMonth = periodInMonth;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }


    @Override
    public String toString() {
        return "ContributionDto{" +
                "openDate=" + openDate +
                ", percent=" + percent +
                ", periodInMonth=" + periodInMonth +
                ", clientId=" + clientId +
                ", bankId=" + bankId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ContributionDto that = (ContributionDto) o;

        if (!openDate.equals(that.openDate)) return false;
        if (!percent.equals(that.percent)) return false;
        if (!periodInMonth.equals(that.periodInMonth)) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        return bankId != null ? bankId.equals(that.bankId) : that.bankId == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + openDate.hashCode();
        result = 31 * result + percent.hashCode();
        result = 31 * result + periodInMonth.hashCode();
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        return result;
    }
}

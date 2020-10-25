package org.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "CONTRIBUTIONS")
public class Contribution extends AbstractEntity {
    private Date openDate;
    private Double percent;
    private Integer periodInMonth;
    private Client client;
    private Bank bank;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    public Client getClient() {
        return client;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BANK_ID")
    public Bank getBank() {
        return bank;
    }

    public Contribution() {

    }

    public Contribution(Date openDate, Double percent, Integer periodInMonth, Client client, Bank bank) {
        this.openDate = openDate;
        this.percent = percent;
        this.periodInMonth = periodInMonth;
        this.client = client;
        this.bank = bank;
    }

    @Column(name = "OPEN_DATE")
    @NotNull(message = "OPEN DATE is required.")
    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Column(name = "PERCENT")
    @NotNull(message = "PERCENT is required.")
    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Column(name = "PERIOD_IN_MONTH")
    @NotNull(message = "PERIOD IN MONTH is required.")
    public Integer getPeriodInMonth() {
        return periodInMonth;
    }

    public void setPeriodInMonth(Integer periodInMonth) {
        this.periodInMonth = periodInMonth;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Contribution that = (Contribution) o;

        if (!openDate.equals(that.openDate)) return false;
        if (!percent.equals(that.percent)) return false;
        if (!periodInMonth.equals(that.periodInMonth)) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        return bank != null ? bank.equals(that.bank) : that.bank == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + openDate.hashCode();
        result = 31 * result + percent.hashCode();
        result = 31 * result + periodInMonth.hashCode();
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "openDate=" + openDate +
                ", percent=" + percent +
                ", periodInMonth=" + periodInMonth +
                ", client=" + client +
                ", bank=" + bank +
                '}';
    }
}

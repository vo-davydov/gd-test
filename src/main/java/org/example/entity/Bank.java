package org.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "BANK")
public class Bank extends AbstractEntity {
    private String name;
    private String BIK;
    private Set<Contribution> contributions;

    public Bank() {

    }

    public Bank(LocalDateTime created, LocalDateTime updated, String name, String BIK, Set<Contribution> contributions) {
        super(created, updated);
        this.name = name;
        this.BIK = BIK;
        this.contributions = contributions;
    }

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    public Set<Contribution> getContributions() {
        return contributions;
    }

    @Column(name = "NAME")
    @NotNull(message = "NAME is required.")
    public String getName() {
        return name;
    }

    @Column(name = "BIK", unique = true)
    @NotNull(message = "BIK is required.")
    public String getBIK() {
        return BIK;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBIK(String BIK) {
        this.BIK = BIK;
    }

    public void setContributions(Set<Contribution> contributions) {
        this.contributions = contributions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bank bank = (Bank) o;

        if (!name.equals(bank.name)) return false;
        return BIK.equals(bank.BIK);
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
        return "Bank{" +
                "name='" + name + '\'' +
                ", BIK='" + BIK + '\'' +
                '}';
    }
}

package org.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client extends AbstractEntity {
    private String name;
    private String inn;
    private String shortName;
    private String address;
    private Okopf okopf;
    private Set<Contribution> contributions;

    public Client() {

    }

    public Client(LocalDateTime created, LocalDateTime updated, String name, String inn, String shortName, String address, Okopf okopf, Set<Contribution> contributions) {
        super(created, updated);
        this.name = name;
        this.inn = inn;
        this.shortName = shortName;
        this.address = address;
        this.okopf = okopf;
        this.contributions = contributions;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OKOPF_ID")
    public Okopf getOkopf() {
        return okopf;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true)
    public Set<Contribution> getContributions() {
        return contributions;
    }

    @Column(name = "NAME")
    @NotNull(message = "NAME is required.")
    public String getName() {
        return this.name;
    }

    @Column(name = "INN", unique = true)
    @NotNull(message = "INN is required.")
    public String getInn() {
        return this.inn;
    }

    @Column(name = "SHORT_NAME")
    public String getShortName() {
        return this.shortName;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return this.address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOkopf(Okopf okopf) {
        this.okopf = okopf;
    }

    public void setContributions(Set<Contribution> contributions) {
        this.contributions = contributions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (!inn.equals(client.inn)) return false;
        if (shortName != null ? !shortName.equals(client.shortName) : client.shortName != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        return okopf != null ? okopf.equals(client.okopf) : client.okopf == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + inn.hashCode();
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (okopf != null ? okopf.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", shortName='" + shortName + '\'' +
                ", address='" + address + '\'' +
                ", okopf=" + okopf +
                '}';
    }
}

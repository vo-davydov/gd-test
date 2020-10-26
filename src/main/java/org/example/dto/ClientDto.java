package org.example.dto;

import java.util.Set;

public class ClientDto extends AbstractDto {
    private String name;
    private String inn;
    private Long okopfId;
    private String shortName;
    private String address;
    private Set<Long> contributionIds;

    public ClientDto() {

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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Long getOkopfId() {
        return okopfId;
    }

    public void setOkopfId(Long okopfId) {
        this.okopfId = okopfId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ClientDto clientDto = (ClientDto) o;

        if (name != null ? !name.equals(clientDto.name) : clientDto.name != null) return false;
        if (!inn.equals(clientDto.inn)) return false;
        if (okopfId != null ? !okopfId.equals(clientDto.okopfId) : clientDto.okopfId != null) return false;
        if (shortName != null ? !shortName.equals(clientDto.shortName) : clientDto.shortName != null) return false;
        if (address != null ? !address.equals(clientDto.address) : clientDto.address != null) return false;
        return contributionIds != null ? contributionIds.equals(clientDto.contributionIds) : clientDto.contributionIds == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + inn.hashCode();
        result = 31 * result + (okopfId != null ? okopfId.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contributionIds != null ? contributionIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", okopfId=" + okopfId +
                ", shortName='" + shortName + '\'' +
                ", address='" + address + '\'' +
                ", contributionIds=" + contributionIds +
                '}';
    }
}

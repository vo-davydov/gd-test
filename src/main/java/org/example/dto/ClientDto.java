package org.example.dto;

import java.util.Set;

public class ClientDto extends AbstractDto {
    private String name;
    private String inn;
    private OkopfDto okopfDto;
    private String shortName;
    private String address;
    private Set<ContributionDto> contributionDto;

    public ClientDto() {

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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public OkopfDto getOkopfDto() {
        return okopfDto;
    }

    public void setOkopfDto(OkopfDto okopfDto) {
        this.okopfDto = okopfDto;
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

        ClientDto clientDto = (ClientDto) o;

        if (name != null ? !name.equals(clientDto.name) : clientDto.name != null) return false;
        if (!inn.equals(clientDto.inn)) return false;
        if (okopfDto != null ? !okopfDto.equals(clientDto.okopfDto) : clientDto.okopfDto != null) return false;
        if (shortName != null ? !shortName.equals(clientDto.shortName) : clientDto.shortName != null) return false;
        return address != null ? address.equals(clientDto.address) : clientDto.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + inn.hashCode();
        result = 31 * result + (okopfDto != null ? okopfDto.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", okopfDto=" + okopfDto +
                ", shortName='" + shortName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

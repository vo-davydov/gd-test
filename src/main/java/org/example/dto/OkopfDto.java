package org.example.dto;

public class OkopfDto extends AbstractDto {
    private String name;
    private String code;

    public OkopfDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OkopfDto okopfDto = (OkopfDto) o;

        if (name != null ? !name.equals(okopfDto.name) : okopfDto.name != null) return false;
        return code != null ? code.equals(okopfDto.code) : okopfDto.code == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OkopfDto{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

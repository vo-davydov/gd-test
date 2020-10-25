package org.example.mapper;

import org.example.dto.OkopfDto;
import org.example.entity.Okopf;
import org.springframework.stereotype.Component;

@Component
public class OkopfMapper {

    public Okopf toEntity(OkopfDto okopfDto) {
        if (okopfDto == null) {
            return null;
        }

        Okopf okopf = new Okopf();

        okopf.setId(okopfDto.getId());
        okopf.setCreated(okopfDto.getCreated());
        okopf.setUpdated(okopfDto.getUpdated());
        okopf.setName(okopfDto.getName());
        okopf.setCode(okopfDto.getCode());

        return okopf;
    }

    public OkopfDto toDto(Okopf okopf) {
        if (okopf == null) {
            return null;
        }

        OkopfDto okopfDto = new OkopfDto();

        okopfDto.setId(okopf.getId());
        okopfDto.setCreated(okopf.getCreated());
        okopfDto.setUpdated(okopf.getUpdated());
        okopfDto.setName(okopf.getName());
        okopfDto.setCode(okopf.getCode());

        return okopfDto;
    }
}

package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GenderDTO;
import com.alkemy.disney.disney.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenderMapper {

    @Autowired
    MovieMapper movieMapper;

    public Gender genderDTO2Entity(GenderDTO dto){
        Gender entity = new Gender();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

    public GenderDTO genderEntity2DTO(Gender entity, boolean charge) {
        GenderDTO dto = new GenderDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        if(charge){
            dto.setGenderMovies(movieMapper.movieEntityList2DTOList(entity.getGenderMovies(), false));
        }
        return dto;
    }

    public List<GenderDTO> genderEntityList2DTOList(List<Gender> entities, boolean charge) {
        return entities.stream().map(entity -> genderEntity2DTO(entity, false)).collect(Collectors.toList());
    }


}

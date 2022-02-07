package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharcterBasicDTO;
import com.alkemy.disney.disney.dto.CharcterDTO;
import com.alkemy.disney.disney.entity.Charcter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharcterMapper {

    @Autowired
    private MovieMapper movieMapper;

    public Charcter charcterDTO2Entity(CharcterDTO dto){
        Charcter entity = new Charcter();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setImage(dto.getImage());
        entity.setHistory(dto.getHistory());
        entity.setWeight(dto.getWeight());
        return entity;
    }

    public CharcterDTO charcterEntity2DTO(Charcter entity, boolean charge){
        CharcterDTO dto = new CharcterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setImage(entity.getImage());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());
        if(charge){
            dto.setCharcterMovies(movieMapper.movieEntityList2DTOList(entity.getCharctersMovies(), false));
        }
        return dto;
    }

    public List<CharcterDTO> charcterEntityList2DTOList(List<Charcter> entities, boolean charge){
        return entities.stream().map(entity -> charcterEntity2DTO(entity, false)).collect(Collectors.toList());
    }

    public CharcterBasicDTO charcterEntity2BasicDTO(Charcter entity){
        CharcterBasicDTO basicDTO = new CharcterBasicDTO();
        basicDTO.setId(entity.getId());
        basicDTO.setName(entity.getImage());
        basicDTO.setName(entity.getName());
        return basicDTO;
    }

    public List<CharcterBasicDTO> charcterEntityList2BasicDTOList(List<Charcter> entities){
        return entities.stream().map(entity -> charcterEntity2BasicDTO(entity)).collect(Collectors.toList());
    }
}

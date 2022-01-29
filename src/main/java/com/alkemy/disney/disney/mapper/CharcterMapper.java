package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharcterBasicDTO;
import com.alkemy.disney.disney.dto.CharcterDTO;
import com.alkemy.disney.disney.entity.Charcter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public Charcter updateCharcterDTO2Entity(Charcter entity, CharcterDTO dto){
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());

        return entity;
    }

    public CharcterDTO charcterEntity2DTO(Charcter entity, boolean chargeMovies){
        CharcterDTO dto = new CharcterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setImage(entity.getImage());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());
        if(chargeMovies){
            dto.setMovies(movieMapper.movieEntityList2DTOList(entity.getMovies(), false));
        }
        return dto;
    }

    public List<CharcterDTO> charcterEntityList2DTOList(List<Charcter> entities, boolean chargeMovies){
        List<CharcterDTO> dtos = new ArrayList<>();
        for(Charcter entity: entities){
            dtos.add(charcterEntity2DTO(entity, chargeMovies));
        }
        return dtos;
    }

    public CharcterBasicDTO charcterEntity2BasicDTO(Charcter entity){
        CharcterBasicDTO basicDTO = new CharcterBasicDTO();
        basicDTO.setId(entity.getId());
        basicDTO.setName(entity.getImage());
        basicDTO.setName(entity.getName());
        return basicDTO;
    }

    public List<CharcterBasicDTO> charcterEntityList2BasicDTOList(List<Charcter> entities){
        List<CharcterBasicDTO> basicDTOS = new ArrayList<>();
        for(Charcter entity: entities){
            basicDTOS.add(charcterEntity2BasicDTO(entity));
        }
        return basicDTOS;
    }
}

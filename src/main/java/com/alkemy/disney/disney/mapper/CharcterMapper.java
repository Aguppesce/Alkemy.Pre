package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharcterBasicDTO;
import com.alkemy.disney.disney.dto.CharcterDTO;
import com.alkemy.disney.disney.dto.CharcterDetailedDTO;
import com.alkemy.disney.disney.entity.Charcter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharcterMapper {

    public Charcter charcterDTO2Entity(CharcterDTO dto){
        Charcter charcterEntity = new Charcter();
        charcterEntity.setName(dto.getName());
        charcterEntity.setAge(dto.getAge());
        charcterEntity.setImage(dto.getImage());
        charcterEntity.setHistory(dto.getHistory());
        charcterEntity.setWeight(dto.getWeight());
        charcterEntity.setMovies(dto.getMovies());
        return charcterEntity;
    }

    public CharcterDTO charcterEntity2DTO(Charcter entity){
        CharcterDTO charcterDTO = new CharcterDTO();
        charcterDTO.setId(entity.getId());
        charcterDTO.setName(entity.getName());
        charcterDTO.setAge(entity.getAge());
        charcterDTO.setImage(entity.getImage());
        charcterDTO.setHistory(entity.getHistory());
        charcterDTO.setWeight(entity.getWeight());
        charcterDTO.setMovies(entity.getMovies());

        return charcterDTO;
    }

    public List<CharcterDTO> charcterEntityList2DTOList(List<Charcter> entities){
        List<CharcterDTO> dtos = new ArrayList<>();
        for (Charcter entity: entities){
            dtos.add(this.charcterEntity2DTO(entity));
        }

        return dtos;
    }

    public CharcterBasicDTO charcterEntity2CharcterBasicDTO(Charcter charcter){
        CharcterBasicDTO basic = new CharcterBasicDTO();
        basic.setImage(charcter.getImage());
        basic.setName(charcter.getName());
        return basic;
    }

    public List<CharcterBasicDTO> charcterEntityList2CharcterBasicList(List<Charcter> charcters){
        List<CharcterBasicDTO> charctersBasic = new ArrayList<>();
        for(Charcter charcter: charcters){
            charctersBasic.add(charcterEntity2CharcterBasicDTO(charcter));
        }
        return charctersBasic;
    }

    public CharcterDetailedDTO charcterEntity2CharcterDetailedDTO(Charcter charcter){
        CharcterDetailedDTO charcterDetailed = new CharcterDetailedDTO();
        charcterDetailed.setId(charcter.getId());
        charcterDetailed.setMovies(charcter.getMovies());
        charcterDetailed.setHistory(charcter.getHistory());
        charcterDetailed.setWeight(charcter.getWeight());
        charcterDetailed.setImage(charcter.getImage());
        charcterDetailed.setAge(charcter.getAge());
        return charcterDetailed;
    }

    public List<CharcterDetailedDTO> charcterEntity2CharcterDetailedDTOList(List<Charcter> charcters){
        List<CharcterDetailedDTO> charctersDetailed = new ArrayList<>();
        for(Charcter charcter: charcters){
            charctersDetailed.add(charcterEntity2CharcterDetailedDTO(charcter));
            return charctersDetailed;
        }
    }
}

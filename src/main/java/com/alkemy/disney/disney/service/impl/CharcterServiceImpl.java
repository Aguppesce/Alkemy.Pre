package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.CharcterDTO;
import com.alkemy.disney.disney.dto.CharcterDetailedDTO;
import com.alkemy.disney.disney.dto.CharcterFiltersDTO;
import com.alkemy.disney.disney.entity.Charcter;
import com.alkemy.disney.disney.mapper.CharcterMapper;
import com.alkemy.disney.disney.repository.CharcterRepository;
import com.alkemy.disney.disney.service.CharcterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharcterServiceImpl implements CharcterService {

    @Autowired
    private CharcterMapper charcterMapper;

    @Autowired
    private CharcterRepository charcterRepository;

    public CharcterDTO save(CharcterDTO dto){
        Charcter entity = charcterMapper.charcterDTO2Entity(dto);
        Charcter entitySave = charcterRepository.save(entity);
        CharcterDTO result = charcterMapper.charcterEntity2DTO(entitySave);
        return result;
    }

    public List<CharcterDTO> getAllCharcters(){
        List<Charcter> entities = charcterRepository.findAll();
        List<CharcterDTO> result = charcterMapper.charcterEntityList2DTOList(entities);
        return result;
    }

    public void delete(Long id){this.charcterRepository.deleteById(id);}

    public List<CharcterDetailedDTO> getByFilters(String name, Byte age, Double weight, Set<Long> movies, String order){
        CharcterFiltersDTO filtersDTO = new CharcterFiltersDTO(name, age, weight, movies, order);
        List<Charcter> charcters = charcterRepository.findAll(charcterSpecification.getByFilters(filtersDTO));
        List<CharcterDetailedDTO> charctersDTO = charcterMapper.charcterEntity2CharcterDetailedDTOList(charcters);
        return charctersDTO;
    }

    public List<CharcterDetailedDTO> getAllDetailed() {
        List<Charcter> charcters = charcterRepository.findAll();
        List<CharcterDetailedDTO> charctersDTO = charcterMapper.charcterEntity2CharcterDetailedDTOList(charcters);
        return charctersDTO;
    }

    public CharcterDTO getCharcterByName(String name){
        Charcter entity = charcterRepository.findByName(name).orElseThrow();
        CharcterDTO dto = charcterMapper.charcterEntity2DTO(entity);
        return dto;
    }

    public CharcterDTO update(Long id, CharcterDTO dto){
        Charcter entity = charcterRepository.findById(id).orElseThrow();
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        entity.setWeight(dto.getWeight());
        dto.setId(entity.getId());
        dto.setMovies(entity.getMovies());

        return dto;
    }

    public CharcterDTO getCharcterById(Long id){
        Charcter entity = charcterRepository.findById(id).orElseThrow();
        CharcterDTO dto = charcterMapper.charcterEntity2DTO(entity);
        return dto;
    }
}

package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.CharcterDTO;
import com.alkemy.disney.disney.dto.CharcterFiltersDTO;
import com.alkemy.disney.disney.entity.Charcter;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.CharcterMapper;
import com.alkemy.disney.disney.repository.CharcterRepository;
import com.alkemy.disney.disney.repository.specification.CharcterSpecification;
import com.alkemy.disney.disney.service.CharcterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharcterServiceImpl implements CharcterService {

    @Autowired
    private CharcterMapper charcterMapper;
    @Autowired
    private CharcterRepository charcterRepository;
    @Autowired
    private CharcterSpecification charcterSpecification;

    public CharcterDTO save(CharcterDTO dto){
        Charcter entity = charcterMapper.charcterDTO2Entity(dto);
        Charcter entitySave = charcterRepository.save(entity);
        CharcterDTO result = charcterMapper.charcterEntity2DTO(entitySave, false);
        return result;
    }

    public List<CharcterDTO> getAllCharcters(){
        List<Charcter> entities = charcterRepository.findAll();
        List<CharcterDTO> result = charcterMapper.charcterEntityList2DTOList(entities, false);
        return result;
    }

    public CharcterDTO getCharcterDetails(Long id){
        Charcter entity = handleFindById(id);
        CharcterDTO dto = charcterMapper.charcterEntity2DTO(entity, true);
        return dto;
    }

    public CharcterDTO update(Long id, CharcterDTO dto){
        Charcter entity = handleFindById(id);
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        entity.setWeight(dto.getWeight());
        Charcter entityUpdate = charcterRepository.save(entity);
        CharcterDTO result = charcterMapper.charcterEntity2DTO(entityUpdate,false);
        return result;
    }

    public void delete(Long id){this.charcterRepository.deleteById(id);}

    public List<CharcterDTO> getByFilters(String name, Byte age, Set<Long> movies){
        CharcterFiltersDTO filtersDTO = new CharcterFiltersDTO(name, age, movies);
        List<Charcter> entities = charcterRepository.findAll(charcterSpecification.getByFilters(filtersDTO));
        List<CharcterDTO> dtos = charcterMapper.charcterEntityList2DTOList(entities, true);
        return dtos;
    }

    public Charcter handleFindById(Long id){
        Optional<Charcter> search = charcterRepository.findById(id);
        if(!search.isPresent()) {
            throw new ParamNotFound("Charcter id: " + id + " not found" );
        }
        return search.get();
    }
}

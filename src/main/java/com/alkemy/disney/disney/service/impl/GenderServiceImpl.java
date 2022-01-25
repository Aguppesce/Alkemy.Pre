package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.GenderDTO;
import com.alkemy.disney.disney.entity.Gender;
import com.alkemy.disney.disney.mapper.GenderMapper;
import com.alkemy.disney.disney.repository.GenderRepository;
import com.alkemy.disney.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    public GenderDTO save(GenderDTO dto) {
        Gender entity = genderMapper.genderDTO2Entity(dto);
        Gender entitySave = genderRepository.save(entity);
        GenderDTO result = genderMapper.genderEntity2DTO(entitySave);
        return result;
    }

    public List<GenderDTO> getAllGenders() {
        List<Gender> entities = genderRepository.findAll();
        List<GenderDTO> result = genderMapper.genderEntityList2DTOList(entities);
        return result;
    }

    public void delete(Long id){
        this.genderRepository.deleteById(id);
    }

    public GenderDTO update(Long id, GenderDTO dto){
        Gender entity = genderRepository.findById(id).orElseThrow();
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        dto.setId(entity.getId());
        dto.setMovies(entity.getMovies());
        return dto;
    }

    public GenderDTO getGenderById(Long id){
        Gender entity = genderRepository.findById(id).orElseThrow();
        GenderDTO dto = genderMapper.genderEntity2DTO(entity);
        return dto;
    }

    public GenderDTO getGenderByName(String name){
        Gender entity = genderRepository.findByName(name).orElseThrow();
        GenderDTO dto = genderMapper.genderEntity2DTO(entity);
        return dto;
    }

}

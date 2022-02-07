package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.GenderDTO;
import com.alkemy.disney.disney.entity.Gender;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.GenderMapper;
import com.alkemy.disney.disney.repository.GenderRepository;
import com.alkemy.disney.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    public GenderDTO save(GenderDTO dto) {
        Gender entity = genderMapper.genderDTO2Entity(dto);
        Gender entitySave = genderRepository.save(entity);
        GenderDTO result = genderMapper.genderEntity2DTO(entitySave, false);
        return result;
    }

    public List<GenderDTO> getAllGenders() {
        List<Gender> entities = genderRepository.findAll();
        List<GenderDTO> result = genderMapper.genderEntityList2DTOList(entities, false);
        return result;
    }

    public void delete(Long id){
        this.genderRepository.deleteById(id);
    }

    public GenderDTO update(Long id, GenderDTO dto){
        Gender entitySave = this.handleFindById(id);
        entitySave.setImage(dto.getImage());
        entitySave.setName(dto.getName());
        Gender entityUpdate = genderRepository.save(entitySave);
        dto.setGenderMovies(entitySave.getGenderMovies());
        return dto;
    }

    public GenderDTO getGenderById(Long id){
        Gender entity = genderRepository.findById(id).orElseThrow();
        GenderDTO dto = genderMapper.genderEntity2DTO(entity, false);
        return dto;
    }

    public GenderDTO getGenderByName(String name){
        Gender entity = genderRepository.findByName(name).orElseThrow();
        GenderDTO dto = genderMapper.genderEntity2DTO(entity, false);
        return dto;
    }

    public Gender handleFindById(Long id) {
        Optional<Gender> search = genderRepository.findById(id);
        if(!search.isPresent()){
            throw new ParamNotFound("Gender id: " + id + " not found" );
        }
        return search.get();
    }
}

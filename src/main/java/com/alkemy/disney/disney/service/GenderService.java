package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.GenderDTO;

import java.util.List;

public interface GenderService {

    List<GenderDTO> getAllGenders();

    GenderDTO save(GenderDTO dto);

    GenderDTO update(Long id, GenderDTO dto);

    GenderDTO getGenderById(Long id);

    GenderDTO getGenderByName(String name);

    void delete(Long id);

}

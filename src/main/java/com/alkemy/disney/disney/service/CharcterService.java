package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharcterDTO;

import java.util.List;

public interface CharcterService {

    CharcterDTO save(CharcterDTO dto);

    List<CharcterDTO> getAllCharcters();

    void delete(Long id);

    CharcterDTO getCharcterById(Long id);

    CharcterDTO getCharcterByName(String name);

    CharcterDTO update(Long id, CharcterDTO dto);
}

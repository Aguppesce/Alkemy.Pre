package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharcterBasicDTO;
import com.alkemy.disney.disney.dto.CharcterDTO;

import java.util.List;
import java.util.Set;

public interface CharcterService {

    CharcterDTO save(CharcterDTO dto);

    List<CharcterDTO> getAllCharcters();

    void delete(Long id);

    CharcterDTO getCharcterDetails(Long id);

    CharcterDTO update(Long id, CharcterDTO dto);

    List<CharcterDTO> getByFilters(String name, Byte age, Set<Long> movies);
}

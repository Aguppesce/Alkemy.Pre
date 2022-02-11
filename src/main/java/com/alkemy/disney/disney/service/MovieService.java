package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieDetails(Long id);

    List<MovieDTO> getByFilters(String name, Set<Long> gender, String order);

    void delete(Long id);

    void addCharcterOnMovie(Long idMovie, Long idCharcter);

    void addGenderOnMovie(Long idMovie, Long idGender);

    MovieDTO update(Long id, MovieDTO dto);
    

}

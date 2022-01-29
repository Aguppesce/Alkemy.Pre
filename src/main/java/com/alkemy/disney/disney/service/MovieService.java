package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.MovieDTO;

import java.util.List;
public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieDetails(Long id);

    List<MovieDTO> getByFilters(String name, Long idGender, String order);

    void delete(Long id);

    void saveCharcterOnMovie(Long idMovie, Long idCharcter);

    void saveGenderOnMovie(Long idMovie, Long idGender);

    MovieDTO update(Long id, MovieDTO dto);
}

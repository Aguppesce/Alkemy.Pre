package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieByTitle(String title);

    MovieDTO getMovieById(Long id);

    void delete(Long id);

    MovieDTO update(Long id, MovieDTO dto);
}

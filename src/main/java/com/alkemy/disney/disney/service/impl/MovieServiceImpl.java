package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.Movie;
import com.alkemy.disney.disney.mapper.MovieMapper;
import com.alkemy.disney.disney.repository.MovieRepository;
import com.alkemy.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO save(MovieDTO dto){
        Movie entity = movieMapper.movieDTO2Entity(dto);
        Movie entitySave = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySave);

        return result;
    }

    public List<MovieDTO> getAllMovies(){
        List<Movie> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities);
        return result;
    }

    public void delete(Long id){this.movieRepository.deleteById(id);}

    public MovieDTO getMovieByTitle (String title) {
        Movie entity = movieRepository.findByTitle(title).orElseThrow();
        MovieDTO dto = movieMapper.movieEntity2DTO(entity);
        return dto;
    }

    public MovieDTO getMovieById(Long id) {
        Movie entity = movieRepository.findById(id).orElseThrow();
        MovieDTO dto = movieMapper.movieEntity2DTO(entity);
        return dto;
    }

    public MovieDTO update(Long id, MovieDTO dto){
        Movie entity = movieRepository.findById(id).orElseThrow();
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCalification(dto.getCalification());
        entity.setGender(dto.getGender());
        entity.setCreateDate(dto.getCreateDate());
        dto.setCharcters(entity.getCharcters());
        dto.setId(entity.getId());

        return dto;
    }
}

package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.dto.MovieFiltersDTO;
import com.alkemy.disney.disney.entity.Gender;
import com.alkemy.disney.disney.entity.Movie;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.MovieMapper;
import com.alkemy.disney.disney.repository.MovieRepository;
import com.alkemy.disney.disney.repository.specification.MovieSpecification;
import com.alkemy.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharcterServiceImpl charcterService;
    @Autowired
    private MovieSpecification movieSpecification;
    @Autowired
    private GenderServiceImpl genderService;

    public MovieDTO save(MovieDTO dto){
        Movie entity = movieMapper.movieDTO2Entity(dto);
        Movie entitySave = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySave, false);

        return result;
    }

    public void saveCharcterOnMovie(Long idMovie, Long idCharcter){
        Movie saveMovie = this.handleFindById(idMovie);
        Character saveCharcter = charcterService.handleFindById(idCharcter);
        saveMovie.getCharcters().size();
        saveMovie.saveCharcterOnMovie(saveCharcter);
        movieRepository.save(saveMovie);
    }

    public void saveGenderOnMovie(Long idMovie, Long idGender) {
        Movie saveMovie = this.handleFindById(idMovie);
        Gender saveGender = genderService.handleFindById(idGender);
        saveMovie.saveGenderOnMovie(saveGender);
        movieRepository.save(saveMovie);
    }
    public List<MovieDTO> getAllMovies(){
        List<Movie> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities, false);
        return result;
    }

    public MovieDTO getMovieDetails (Long id) {
        Movie entity = this.handleFindById(id);
        MovieDTO dto = movieMapper.movieEntity2DTO(entity, true);
        return dto;
    }

    public MovieDTO update(Long id, MovieDTO dto){
        Movie entity = this.handleFindById(id);
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCalification(dto.getCalification());
        entity.setCreateDate(movieMapper.string2LocalDate(dto.getCreateDate()));
        Movie entityUpdate = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entityUpdate, false);
        return result;
    }

    public void delete(Long id){this.movieRepository.deleteById(id);}

    public List<MovieDTO> getByFilters(String title, Long idGender, String order){
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, idGender, order);
        List<Movie> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));
        List<MovieDTO> dtos = movieMapper.movieEntityList2DTOList(entities, true);
        return dtos;
    }

    public Movie handleFindById(Long id) {
        Optional<Movie> searchMovie = movieRepository.findById(id);
        if(!searchMovie.isPresent()) {
            throw new ParamNotFound("Movie id: " + id + " not found");
        }
        return searchMovie.get();
    }
}

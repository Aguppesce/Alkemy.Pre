package com.alkemy.disney.disney.mapper;


import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public Movie movieDTO2Entity(MovieDTO dto){
        Movie movieEntity = new Movie();
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setImage(dto.getImage());
        movieEntity.setCreateDate(dto.getCreateDate());
        movieEntity.setCalification(dto.getCalification());
        movieEntity.setCharcters(dto.getCharcters());
        movieEntity.setGender(dto.getGender());

        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(Movie entity){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setTitle(entity.getTitle());
        movieDTO.setImage(entity.getImage());
        movieDTO.setCreateDate(entity.getCreateDate());
        movieDTO.setCalification(entity.getCalification());
        movieDTO.setCharcters(entity.getCharcters());
        movieDTO.setGender(entity.getGender());

        return movieDTO;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<Movie> entities){
        List<MovieDTO> dtos = new ArrayList<>();
        for(Movie entity: entities){
            dtos.add(this.movieEntity2DTO(entity));
        }
        return dtos;
    }

}

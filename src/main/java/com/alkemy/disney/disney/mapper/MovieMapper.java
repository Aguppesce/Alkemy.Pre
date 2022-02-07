package com.alkemy.disney.disney.mapper;


import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    @Autowired
    private CharcterMapper charcterMapper;
    @Autowired
    private GenderMapper genderMapper;

    public Movie movieDTO2Entity(MovieDTO dto){
        Movie entity = new Movie();
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setCreateDate(this.string2LocalDate(dto.getCreateDate()));
        entity.setCalification(dto.getCalification());
        return entity;
    }

    public MovieDTO movieEntity2DTO(Movie entity, boolean charge){
        MovieDTO dto = new MovieDTO();
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setCreateDate(this.localDateToString(entity.getCreateDate()));
        dto.setCalification(entity.getCalification());
        if(charge){
            dto.setMovieCharcters(charcterMapper.charcterEntityList2DTOList(entity.getMovieCharcters(),false));
            dto.setMovieGenders(genderMapper.genderEntityList2DTOList(entity.getMovieGender(),false));
        }
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<Movie> entities, boolean chargeMovie){
        return entities.stream().map(entity -> movieEntity2DTO(entity, false)).collect(Collectors.toList());
    }

    public MovieBasicDTO movieEntity2BasicDTO(Movie entity){
        MovieBasicDTO basicDTO = new MovieBasicDTO();
        basicDTO.setImage(entity.getImage());
        basicDTO.setTitle(entity.getTitle());
        basicDTO.setCreateDate(this.localDateToString(entity.getCreateDate()));
        return basicDTO;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<Movie> entities){
        List<MovieBasicDTO> basicDTOS = new ArrayList<>();
        for(Movie entity: entities){
            basicDTOS.add(this.movieEntity2BasicDTO(entity));
        }
        return basicDTOS;
    }

    public LocalDate string2LocalDate (String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        return convertedDate;
    }

    public String localDateToString(LocalDate createDate){
        String formatDate = createDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        return formatDate;
    }

}

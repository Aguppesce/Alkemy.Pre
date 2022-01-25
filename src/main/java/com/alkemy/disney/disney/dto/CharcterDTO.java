package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharcterDTO {

    private Long id;

    private String image;

    private String name;

    private Byte age;

    private Double weight;

    private String history;

    private List<Movie> movies;

    private boolean deleted = Boolean.FALSE;

}

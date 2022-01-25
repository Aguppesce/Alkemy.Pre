package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.entity.Gender;
import com.alkemy.disney.disney.entity.Charcter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String image;
    private String title;
    private LocalDate createDate;
    private Integer calification;
    private List<Charcter> charcters;
    private Gender gender;

}

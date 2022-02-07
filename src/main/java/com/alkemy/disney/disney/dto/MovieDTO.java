package com.alkemy.disney.disney.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String image;
    private String title;
    private String createDate;
    private Byte calification;
    private List<CharcterDTO> movieCharcters;
    private List<GenderDTO> movieGenders;

}

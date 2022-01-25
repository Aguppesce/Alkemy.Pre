package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class CharcterFiltersDTO {

    private String name;
    private Byte age;
    private Double weight;
    private Set<Long> movies;
    private String order;

    public boolean isASC(){return this.order.compareToIgnoreCase("ASC") == 0;}

    public boolean isDESC(){return this.order.compareToIgnoreCase("DESC") == 0;}
}

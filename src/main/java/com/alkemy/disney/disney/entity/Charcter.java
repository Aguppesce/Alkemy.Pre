package com.alkemy.disney.disney.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SQLDelete(sql = "UPDATE charcter SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Charcter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private Byte age;
    private Double weight;
    private String history;
    private Boolean deleted = Boolean.FALSE;

    @ManyToMany( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "movies_charcters",
            joinColumns = @JoinColumn(name = "id_charcter"),
            inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private List<Movie> movies;


}

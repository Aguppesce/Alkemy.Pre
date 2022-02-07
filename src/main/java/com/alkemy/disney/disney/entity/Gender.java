package com.alkemy.disney.disney.entity;


import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SQLDelete(sql = "UPDATE gender SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;

    private Boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "gender", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Movie> genderMovies;
}

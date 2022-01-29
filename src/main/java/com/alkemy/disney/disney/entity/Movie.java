package com.alkemy.disney.disney.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String title;

    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate createDate;

    private Integer calification;
    private Boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER)
    private List<Charcter> charcters = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "fk_gender", insertable = false, updatable = false)
    private Gender gender;

    @Column(name = "id_gender", nullable = false)
    private Long idGender;

}

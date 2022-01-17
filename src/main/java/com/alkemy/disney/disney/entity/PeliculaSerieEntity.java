package com.alkemy.disney.disney.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Data
public class PeliculaSerieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pelicula")
    private Long idPelicula;

    private String imagen;
    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Integer calificacion;

    @ManyToMany(mappedBy = "peliculas", cascade = CascadeType.ALL)
    private List<PersonajeEntity> personajes = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_genero")
    private GeneroEntity genero;

}

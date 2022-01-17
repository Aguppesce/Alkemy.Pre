package com.alkemy.disney.disney.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Data
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_personaje")
    private Long idPersonaje;

    private String imagen;
    private String nombre;
    private Byte edad;
    private Double peso;
    private String historia;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<PeliculaSerieEntity> peliculas = new ArrayList<>();


}

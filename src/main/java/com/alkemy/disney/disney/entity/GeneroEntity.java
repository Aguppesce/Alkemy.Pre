package com.alkemy.disney.disney.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genero")
@Data
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_genero")
    private Long idGenero;

    @Column(name = "fecha_creacion")
    private String fechaCreacion;

    private String nombre;
    private String imagen;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.PERSIST)
    private List<PeliculaSerieEntity> peliculas;
}

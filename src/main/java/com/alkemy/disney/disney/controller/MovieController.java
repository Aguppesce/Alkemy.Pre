package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(){
        List<MovieDTO> movies = this.movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/allBasic")
    public ResponseEntity<List<MovieBasicDTO>> getBasicAll(){
        List<MovieBasicDTO> moviesBasic = movieService.getBasicDTOList();
        return ResponseEntity.ok().body(moviesBaisc);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<MovieDTO> getDetailsById(@PathVariable Long id){
        MovieDTO movie = movieService.getMovieDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PostMapping("/save")
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO dto){
        MovieDTO movieSave = movieService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSave);
    }

    @PostMapping("/{idMovie}/charcter/{idCharcter")
    public ResponseEntity<Void> saveChar(@PathVariable Long idMovie, @PathVariable Long idCharcter){
        movieService.saveCharcterOnMovie(idMovie, idCharcter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{idMovie}/gender/{idGender}")
    public ResponseEntity<Void> saveGender(@PathVariable Long idMovie, @PathVariable Long idGender){
        movieService.saveGenderOnMovie(idMovie, idGender);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO dto){
        MovieDTO result = movieService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity delete(@PathVariable Long id){
        this.movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getDetailsByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long idGender,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<MovieDTO> movies = movieService.getByFilters(title, idGender, order);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

}

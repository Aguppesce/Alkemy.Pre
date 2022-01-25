package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll(){
        List<MovieDTO> movies = this.movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping("/save")
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO dto){
        MovieDTO movieSave = movieService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSave);
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


}

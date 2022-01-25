package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.CharcterDTO;
import com.alkemy.disney.disney.service.CharcterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("charcters")
public class CharcterController {

    @Autowired
    private CharcterService charcterService;

    @GetMapping
    public ResponseEntity<List<CharcterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) Set<Long> movies,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<CharcterDTO> charcters = this.charcterService.getByFilters(name, age, weight, movies, order);
        return ResponseEntity.ok(charcters);
    }
    @GetMapping
    public ResponseEntity<List<CharcterDTO>> getAllCharcters(){
        List<CharcterDTO> charcters = this.charcterService.getAllCharcters();
        return ResponseEntity.ok().body(charcters);
    }

    @PostMapping("/save")
    public ResponseEntity<CharcterDTO> save(@RequestBody CharcterDTO dto){
        CharcterDTO charcterSave = charcterService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(charcterSave);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CharcterDTO> udpate(@PathVariable Long id, @RequestBody CharcterDTO dto){
        CharcterDTO result = charcterService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity delete(@PathVariable Long id){
        this.charcterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

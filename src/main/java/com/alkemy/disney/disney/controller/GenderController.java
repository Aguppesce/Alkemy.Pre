package com.alkemy.disney.disney.controller;


import com.alkemy.disney.disney.dto.GenderDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<GenderDTO>> getAllGender(){
        List<GenderDTO> genders = this.genderService.getAllGenders();
        return ResponseEntity.ok().body(genders);
    }

    @PostMapping("/save")
    public ResponseEntity<GenderDTO> save(@RequestBody GenderDTO gender){
        GenderDTO genderSave = genderService.save(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(genderSave);
    }

    //TODO GetMapping("/{id}")

    @PutMapping("/{id}/update")
    public ResponseEntity<GenderDTO> update(@PathVariable Long id, @RequestBody GenderDTO gender){
        GenderDTO result = genderService.update(id, gender);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable Long id){
        this.genderService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

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
@RequestMapping("/charcters")
public class CharcterController {

    @Autowired
    private CharcterService charcterService;

    @GetMapping("/all")
    public ResponseEntity<List<CharcterDTO>> getAllCharcters(){
        List<CharcterDTO> dtos = charcterService.getAllCharcters();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CharcterDTO> getDetailsById(@PathVariable Long id){
        CharcterDTO dto = charcterService.getCharcterDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/save")
    public ResponseEntity<CharcterDTO> save(@RequestBody CharcterDTO dto){
        CharcterDTO saveCharcter = charcterService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCharcter);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CharcterDTO> udpate(@PathVariable Long id, @RequestBody CharcterDTO dto){
        CharcterDTO result = charcterService.update(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity delete(@PathVariable Long id){
        charcterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/filters")
    public ResponseEntity<List<CharcterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Byte age,
            @RequestParam(required = false) Set<Long> movies
    ){
        List<CharcterDTO> charcters = this.charcterService.getByFilters(name, age, movies);
        return ResponseEntity.ok().body(charcters);
    }

}

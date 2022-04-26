package com.example.springsecurity.rest;

import com.example.springsecurity.model.Developer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    
    private List<Developer> DEVELOPERS = Stream.of(
        new Developer(1L, "Ivan", "Ivanov"),
        new Developer(2L, "Sergey", "Sergeev"),
        new Developer(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());
    
    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS; 
    }
    
    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){ 
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null); 
    }
    
    @PostMapping
    public Developer create(@RequestBody Developer developer){
        this.DEVELOPERS.add(developer);
        return developer;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
    
}

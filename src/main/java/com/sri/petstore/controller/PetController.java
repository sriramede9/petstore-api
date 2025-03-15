package com.sri.petstore.controller;


import com.sri.petstore.model.Pet;
import com.sri.petstore.repository.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable String id) {
        return petRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable String id) {
        petRepository.deleteById(id);
        return "Pet deleted";
    }
}

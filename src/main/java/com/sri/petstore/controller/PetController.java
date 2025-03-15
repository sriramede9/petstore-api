package com.sri.petstore.controller;

import com.sri.petstore.dto.PetDTO;
import com.sri.petstore.utility.PetMapper;
import com.sri.petstore.model.Pet;
import com.sri.petstore.repository.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<PetDTO> getAllPets() {
        return petRepository.findAll().stream()
                .map(PetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PetDTO addPet(@RequestBody PetDTO petDTO) {
        Pet pet = PetMapper.toEntity(petDTO);
        Pet savedPet = petRepository.save(pet);
        return PetMapper.toDTO(savedPet);
    }

    @PostMapping("/bulk")
    public List<PetDTO> addPets(@RequestBody List<PetDTO> petDTOs) {
        List<Pet> pets = petDTOs.stream()
                .map(PetMapper::toEntity)
                .collect(Collectors.toList());
        List<Pet> savedPets = petRepository.saveAll(pets);
        return savedPets.stream()
                .map(PetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PetDTO getPetById(@PathVariable String id) {
        return petRepository.findById(id)
                .map(PetMapper::toDTO)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public PetDTO updatePet(@PathVariable String id, @RequestBody PetDTO petDTO) {
        return petRepository.findById(id)
                .map(existingPet -> {
                    existingPet.setName(petDTO.getName());
                    existingPet.setBreed(petDTO.getBreed());
                    existingPet.setPrice(petDTO.getPrice());
                    existingPet.setImageUrl(petDTO.getImageUrl());
                    Pet updatedPet = petRepository.save(existingPet);
                    return PetMapper.toDTO(updatedPet);
                })
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable String id) {
        petRepository.deleteById(id);
        return "Pet deleted";
    }
}

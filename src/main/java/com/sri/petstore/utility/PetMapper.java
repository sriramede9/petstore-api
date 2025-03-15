package com.sri.petstore.utility;

import com.sri.petstore.dto.PetDTO;
import com.sri.petstore.model.Pet;

public class PetMapper {

    public static PetDTO toDTO(Pet pet) {
        return new PetDTO(pet.getId(),pet.getName(), pet.getBreed(), pet.getPrice(), pet.getImageUrl());
    }

    public static Pet toEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setBreed(petDTO.getBreed());
        pet.setPrice(petDTO.getPrice());
        pet.setImageUrl(petDTO.getImageUrl());
        return pet;
    }
}

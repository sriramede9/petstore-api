package com.sri.petstore.repository;
import com.sri.petstore.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PetRepository extends MongoRepository<Pet, String> {
    List<Pet> findByBreed(String breed);
}

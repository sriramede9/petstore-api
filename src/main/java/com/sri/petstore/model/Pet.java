package com.sri.petstore.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    private String id;
    private String name;
    private String breed;
    private double price;
    private String imageUrl;
}

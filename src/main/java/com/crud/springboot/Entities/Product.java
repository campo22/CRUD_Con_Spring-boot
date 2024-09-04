package com.crud.springboot.Entities;

import com.crud.springboot.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired(message = "{IsRequired.product.name}")
    @Size(min = 2, max = 20)
    @Column(name = "name", nullable = false, columnDefinition = "varchar(25)")
    private String name;

    @Min(500)
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(225)")
    @IsRequired
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}



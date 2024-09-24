package com.crud.springboot.Services;

import com.crud.springboot.Entities.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> update(Long id,Product product);

    Optional<Product> delete(Long id);

    boolean existsBySku(String value);
}

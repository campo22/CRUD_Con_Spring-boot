package com.crud.springboot.Repositories;

import com.crud.springboot.Entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

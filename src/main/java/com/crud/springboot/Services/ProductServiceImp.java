package com.crud.springboot.Services;

import com.crud.springboot.Entities.Product;
import com.crud.springboot.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product produdb = productOptional.get();
            produdb.setName(product.getName());
            produdb.setPrice(product.getPrice());
            produdb.setDescription(product.getDescription());
            return Optional.of(productRepository.save(produdb));

        }
        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptiona = productRepository.findById(id);
        productOptiona.ifPresent(p -> {
            productRepository.delete(p);
        });
        return productOptiona;
    }

    @Override
    public boolean existsBySku(String value) {
        return false;
    }
}

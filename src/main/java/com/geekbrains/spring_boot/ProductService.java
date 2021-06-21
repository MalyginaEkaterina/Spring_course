package com.geekbrains.spring_boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepository;

    public long getProductsCount() {
        return productRepository.count();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

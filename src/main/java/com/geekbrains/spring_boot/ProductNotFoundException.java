package com.geekbrains.spring_boot;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("Not found product with id = " + id);
    }
}

package com.geekbrains.spring_boot;
import lombok.*;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private double cost;
}

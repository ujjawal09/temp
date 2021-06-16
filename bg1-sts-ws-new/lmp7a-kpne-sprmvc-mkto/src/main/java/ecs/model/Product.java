package ecs.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private float price;
    private String available;
    private LocalDateTime createdOn;

    public Product() {
        this.createdOn = LocalDateTime.now();
    }
}

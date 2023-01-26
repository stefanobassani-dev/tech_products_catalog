package com.unimol.spring_backend.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInput {
    private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    private float price;
}

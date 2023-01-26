package com.unimol.spring_backend.product.service;

import com.unimol.spring_backend.product.Product;
import com.unimol.spring_backend.product.ProductInput;
import com.unimol.spring_backend.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public void insertAllProducts(List<ProductInput> products) {
        for (ProductInput p : products) {
            Product product = Product
                    .builder()
                    .name(p.getName())
                    .description(p.getDescription())
                    .imgUrl(p.getImgUrl())
                    .price(p.getPrice())
                    .build();

            this.productRepository.save(product);
        }
    }
}

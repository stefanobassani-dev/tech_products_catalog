package com.unimol.spring_backend.product.service;

import com.unimol.spring_backend.product.Product;
import com.unimol.spring_backend.product.ProductInput;
import com.unimol.spring_backend.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public void insertAllProducts() {
        List<ProductInput> products = new ArrayList<>();

        products.add(ProductInput
                .builder()
                .name("Iphone 14 Pro")
                .description("Last model of Apple")
                .imgUrl("""
                        https://store.storeimages.cdn-apple.com/4668/as-images
                        .apple.com/is/iphone-14-finish-select-202209-6-1inch-blue
                        ?wid=2560&hei=1440&fmt=p-jpg&qlt=80&.v=1661026582322""")
                .price(1298.99)
                .build());

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

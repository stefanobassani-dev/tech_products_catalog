package com.unimol.spring_backend.product;

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
                .name("Apple Iphone 14 Pro")
                .description("Last model of Apple phone")
                .imgUrl("""
                        https://store.storeimages.cdn-apple.com/4668/
                        as-images.apple.com/is/
                        iphone-14-finish-select-202209-6-1inch-blue
                        ?wid=2560&hei=1440&fmt=p-jpg&qlt=80&.v=1661026582322""")
                .price(1298.99)
                .build());

        products.add(ProductInput
                .builder()
                .name("Apple Macbook Pro 13 M2")
                .description("Last model of Apple Notebook")
                .imgUrl("""
                        https://store.storeimages.cdn-apple.com/4668/
                        as-images.apple.com/is/
                        mbp-spacegray-select-202206_GEO_IT
                        ?wid=640&hei=595&fmt=jpeg&qlt=95&
                        .v=1664497359241""")
                .price(1298.99)
                .build());

        products.add(ProductInput
                .builder()
                .name("Apple Earpods 2022")
                .description("Last model of Apple earphones")
                .imgUrl("""
                        https://static1.unieuro.it/medias/sys_master
                        /root/hb8/hb0/34370507440158
                        /-api-rest-
                        00ed29448a7522f610cac04d7b9ea7e0
                        -assets-3602c93e0f68e88cf9f8de090b2a5cdc
                        -preview-sgmConversionBaseFormat
                        -sgmProductFormat.jpg""")
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

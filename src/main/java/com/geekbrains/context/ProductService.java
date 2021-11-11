package com.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //получение объекта продукта по id
    public Product getProductById(int id){
        return productRepository.findProductById(id);
    }

    public void showAllProduct(List<Product> productList){
        productList.stream().iterator().forEachRemaining(p -> System.out.println(p.productInfo()));
    }

}

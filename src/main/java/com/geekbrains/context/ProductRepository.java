package com.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    private ProductService productService;

    @Autowired
    public void setPs(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Масло" , 50.00),
                new Product(2, "Хлеб" , 35.5),
                new Product(3, "Чипсы" , 68.30),
                new Product(4, "Вода" , 45.00),
                new Product(5, "Окорочка" , 200.00)
        ));
    }

    //поиск объекта продукта по id
    public Product findProductById(int id){
        if (id > 0 && id <= 5){
            return productList.stream().filter(p -> p.getId()==id).findFirst().orElseThrow(()-> new RuntimeException());
        }
        return null;
    }

    public void showAllProduct(){
        productService.showAllProduct(productList);
    }

}

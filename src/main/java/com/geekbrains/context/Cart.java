package com.geekbrains.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") //для создания новой корзины
public class Cart {
    private List<Product> cartOfProducts = new ArrayList<>();
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    //добавление продукта в корзину по id
    public void addProduct(int id) {
        if (productService.getProductById(id) != null){
            cartOfProducts.add(productService.getProductById(id));
            System.out.println("В корзину добавлен товар: " + productService.getProductById(id).getTitle());
        }else {
            System.out.println("Товар с таким ID отсутствует.");
        }

    }

    //удаление продукта из корзины по id
    public void deleteProduct(int id) {
        if (checkProductInCart(id)) {
            cartOfProducts.remove(productService.getProductById(id));
            System.out.println("Из корзины удален товар: " + productService.getProductById(id).getTitle());
        } else {
            System.out.println("В корзине нет товара с таким id.");
        }
    }


    public void showAllProductInCart() {
        System.out.println("В корзине сейчас:");
        productService.showAllProduct(cartOfProducts);
    }

    private boolean checkProductInCart(int id) {
        for (Product p : cartOfProducts) {
            if (p.getId() == productService.getProductById(id).getId()) {
                return true;
            }
        }
        return false;
    }
}

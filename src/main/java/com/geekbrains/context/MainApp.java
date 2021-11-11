package com.geekbrains.context;

import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.context");
        Cart cart1 = context.getBean(Cart.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Команды для работы с корзиной:");
        System.out.println("cart add id - добавить в корзину товар с определенным id\n" +
                "cart delete id - удалить из корзины товар с определенным id\n" +
                "cart show - показать товары в корзине\n" +
                "exit - выйти из приложения");

        while (true) {
            String command = sc.nextLine();
            String[] token = command.split("\\s+");
            if (token.length == 3 && checkIdInCommand(token[2])) {
                if (command.startsWith("cart delete")){
                    cart1.deleteProduct(Integer.parseInt(token[2]));
                }
                if (command.startsWith("cart add")){
                    cart1.addProduct(Integer.parseInt(token[2]));
                }
            } else if (command.startsWith("cart show") && token.length == 2) {
                cart1.showAllProductInCart();
            } else if (command.startsWith("exit")) {
                System.out.println("Конец");
                break;
            } else {
                System.out.println("Команда отсутствует или введена неверно.");
            }
        }

    }

    private static boolean checkIdInCommand(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

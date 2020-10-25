package com.catherine_te.homework_basket;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, Integer>> clients = new TreeMap<String, TreeMap<String, Integer>>();

        System.out.println("Введите имя покупателя, наименование товара и его количество:");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();

            if (s.equals("Q")) {
                System.out.println("Выход из консоли!");
                break;
            }

            String[] parts = s.split(" ");
            String name = parts[0];
            String productName = parts[1];
            Integer amount = Integer.parseInt(parts[2]);

            if (!clients.containsKey(name))
                clients.put(name, new TreeMap<String, Integer>());


            TreeMap<String, Integer> temp = clients.get(name);


            if (!temp.containsKey(productName))
                temp.put(productName, 0);

            Integer oldAmount = temp.get(productName);

            temp.put(productName, oldAmount + amount);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : clients.entrySet()) {
            String key = entry.getKey(); // ключ - покупатель
            TreeMap<String, Integer> value = entry.getValue(); // значения для конкретного покупателя (продукт и количество)

            System.out.println(key + ":");

            for (Map.Entry<String, Integer> product : value.entrySet()) {
                String keyProduct = product.getKey();
                Integer valueProduct = product.getValue();

                System.out.println(keyProduct + " " + valueProduct);
            }
        }
    }
}



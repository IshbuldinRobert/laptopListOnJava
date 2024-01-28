package projectLaptop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class mainLaptop {
    static Scanner input = new Scanner(System.in);
    static Map<String, Object> filters = new HashMap<>();
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(1212, "Asus", "F15", 8, 512, "Windows");
        Laptop laptop2 = new Laptop(2323, "Asus", "A14", 16, 512, "Windows");
        Laptop laptop3 = new Laptop(3434, "Huawei", "MateBook D16", 16, 1024, "Windows");
        Laptop laptop4 = new Laptop(4545, "Lenovo", "P6", 8, 512, "Linux");
        Laptop laptop5 = new Laptop(5656, "Apple", "Air 13", 32, 1024, "MacOs");
        Laptop laptop6 = new Laptop(6767, "Apple", "Air 16", 16, 512, "MacOs");

        HashSet<Laptop> laptopList = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6));

        choiceFilter(laptopList);
    }

    static void choiceFilter(HashSet<Laptop> list) {
        System.out.println("\nКритерии выбора ноутбука:\n"+
                            "1) Производитель\n"+
                            "2) Оперативная память\n"+
                            "3) Внутренняя память\n"+
                            "4) Операционная система\n"+
                            "5) Очистить фильтр критериев\n"+
                            "6) Завершить фильтрацию и вывести список ноутбуков\n");
        System.out.print("Введите номер пункта: ");
        String choice = input.nextLine();



        if (choice.equals("1")) {
            System.out.print("Введите наименование производителя: ");
            String choiceMaker = input.nextLine();
            filterMaker(choiceMaker, list);
            choiceFilter(list);
        }
        else if (choice.equals("2")) {
            System.out.print("Введите минимальный объём RAM: ");
            int ram = input.nextInt();
            input.nextLine();
            filterRam(ram, list);
            choiceFilter(list);
        }
        else if (choice.equals("3")) {
            System.out.print("Введите объём ROM: ");

        }
        else if (choice.equals("4")) {
            
        }
        else if (choice.equals("5")) {
            filters.clear();
            System.out.println("Фильтр очищен!");
            choiceFilter(list);
        }
        else if (choice.equals("6")) {
            if (filters.isEmpty()) {
                for (Laptop laptop : list) {
                    System.out.println(laptop);
                }
            }
            else {
                for (Laptop laptop : list) {
                    if (laptop.getMaker().trim().toLowerCase().equals(filters.get("laptopMaker").toString().trim().toLowerCase())
                        && laptop.getRam() >= (int) filters.get("Ram"))
                    {
                        System.out.println(laptop);
                    }
                }
            }

            filters.clear();
        }
        else {
            System.out.println("Неверный критерий! Попробуйте снова :)\n");
            choiceFilter(list);
        }
    }

    static void filterMaker(String maker, HashSet<Laptop> laptopList) {
        int count = 0;
        for (Laptop laptop : laptopList) {
            if (laptop.getMaker().trim().toLowerCase().equals(maker.trim().toLowerCase())) {
                count++;
            }
        }
        if (count > 0) {
            filters.put("laptopMaker", maker);
            System.out.println("Фильтр обновлен!");
        }
        else {
            System.out.println("Производителя с таким наименованием нет!");
        }
    }

    static void filterRam(int ram, HashSet<Laptop> laptopList) {
        int count = 0;
        for (Laptop laptop : laptopList) {
            if (laptop.getRam() >= ram) {
                count++;
            }
        }
        if (count > 0) {
            filters.put("Ram", ram);
            System.out.println("Фильтр обновлен!");
        }
        else {
            System.out.println("Нет подходящих ноутбуков!");
        }
    }
}
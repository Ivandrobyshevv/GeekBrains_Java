package MainProject;

import java.util.*;

public class Laptop {
    HashMap<Integer, LaptopNew> dictLaptop = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    class LaptopNew {
        private String brand;

        private String model;
        private String price;
        private String RAM;
        private String HDD;
        private String color;

        LaptopNew initLaptop() {
            LaptopNew laptop = new LaptopNew();
            System.out.print("Введиет бренд: ");
            laptop.brand = scanner.next();

            System.out.print("Введите модель: ");
            laptop.model = scanner.next();

            System.out.print("Введите размер оперативной памяти: ");
            laptop.RAM = scanner.next();

            System.out.print("Введите размер жесткого диска:");
            laptop.HDD = scanner.next();

            System.out.print("Введите цвет модели: ");
            laptop.color = scanner.next();


            System.out.print("Введите цену: ");
            laptop.price = scanner.next();

            return laptop;
        }

    }

    void addLaptop(int key) {
        LaptopNew odj = new LaptopNew();
        LaptopNew laptop = odj.initLaptop();
        this.dictLaptop.put(key, laptop);

    }

    LaptopNew searchForId() {
        System.out.print("Введите id товрвра: ");
        int id = scanner.nextInt();
        return dictLaptop.get(id);
    }

    List<LaptopNew> searchForFeature(String val) {
        List<LaptopNew> listObjects = new ArrayList<>();

        for (int key : dictLaptop.keySet()) {
            if (dictLaptop.get(key).brand.equals(val)) {
                listObjects.add(dictLaptop.get(key));
            }
            if (dictLaptop.get(key).model.equals(val)) {
                listObjects.add(dictLaptop.get(key));
            }
            if (dictLaptop.get(key).HDD.equals(val)) {
                listObjects.add(dictLaptop.get(key));
            }
            if (dictLaptop.get(key).RAM.equals(val)) {
                System.out.print(dictLaptop.get(key).RAM.equals(val));
                listObjects.add(dictLaptop.get(key));

            }
            if (dictLaptop.get(key).color.equals(val)) {
                listObjects.add(dictLaptop.get(key));
            }
            if (dictLaptop.get(key).price.equals(val)) {
                listObjects.add(dictLaptop.get(key));
            }
        }
        return listObjects;

    }


    void deleteLaptop() {
        System.out.print("Введите ID модели:");
        int id = scanner.nextInt();
        LaptopNew laptop = dictLaptop.get(id);
        System.out.println("Вы действительно хотите удалить" + "[" + laptop.brand + " " + laptop.model + ", " + laptop.RAM + "]?\n" +
                "1-Yes\n2-No");
        int val = scanner.nextInt();
        if (val == 1) {
            dictLaptop.remove(id);
            System.out.println("Ноутбук удален");
        }

    }

    void searchLaptop() {
        System.out.println("Поиск по\n1-ID\n2-Характкристики");
        int val = scanner.nextInt();
        switch (val) {
            case 1:
                LaptopNew laptop = searchForId();
                System.out.println("Бренд: " + laptop.brand);
                System.out.println("Модель: " + laptop.model);
                System.out.println("Оперативная паямть: " + laptop.RAM);
                System.out.println("Жесткий диск: " + laptop.HDD);
                System.out.println("Цвет: " + laptop.color);
                System.out.println("Цена: " + laptop.price);
                break;
            case 2:
                System.out.println("Поиск по:\n1-Бренд\n2-Модель\n3-RAM\n4-HDD\n5-Color\n6-Price");
                int check = scanner.nextInt();
                List<LaptopNew> list = null;
                String values;
                switch (check) {
                    case 1:
                        System.out.print("Введите бренд: ");
                        values = scanner.next();
                        list = searchForFeature(values);
                        break;
                    case 2:
                        System.out.print("Введите модель: ");
                        values = scanner.next();
                        list = searchForFeature(values);
                        break;
                    case 3:
                        System.out.print("Введите RAM: ");
                        values = scanner.next();
                        list = searchForFeature(values);
                        break;
                    case 4:
                        System.out.print("Введите HHD: ");
                        values = scanner.next();
                        list = searchForFeature(values);
                        break;
                    case 5:
                        System.out.print("Введите color: ");
                        values = scanner.next();
                        list = searchForFeature(values);
                        break;
                    case 6:
                        System.out.print("Введите price: ");
                        values = scanner.next();
                        list = searchForFeature(values);
                        break;
                }
                for (LaptopNew s : list) {
                    System.out.println("\t{\n\tБренд : " + s.brand + ","
                            + "\n\tМодель : " + s.model + "," +
                            "\n\tОперативная память : " + s.RAM + "Гб" + ", " + "\n\tЖеский диск : "
                            + s.HDD + "Гб" + "," + "\n\tЦвет : " + s.color +
                            "\n\tЦена : " + s.price + "Руб" + "\n\t}");
                }
                break;
        }
    }

    void printAllLaptop() {
        System.out.println("[");
        for (int key : dictLaptop.keySet()) {
            System.out.println("ID: " + key + ":" + "\t{\n\tБренд : " + dictLaptop.get(key).brand + ","
                    + "\n\tМодель : " + dictLaptop.get(key).model + "," +
                    "\n\tОперативная память : " + dictLaptop.get(key).RAM + "Гб" + ", " + "\n\tЖеский диск : "
                    + dictLaptop.get(key).HDD + "Гб" + "," + "\n\tЦвет : " + dictLaptop.get(key).color +
                    "\n\tЦена : " + dictLaptop.get(key).price + "Руб" + "\n\t}");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        Laptop dict = new Laptop();
        int key = 1;
        int stop = 1;
        while (stop > 0) {
            System.out.println("1-Добваить ноутбук\n2-Показать все ноутбуки\n3-Поиск ноутбука\n4-Удалить ноутбк\n0-Выйти");
            int value = scanner.nextInt();
            switch (value) {
                case 1:
                    dict.addLaptop(key);
                    key += 1;
                    continue;
                case 2:
                    dict.printAllLaptop();
                    continue;
                case 3:
                    dict.searchLaptop();
                    continue;
                case 4:
                    dict.deleteLaptop();
                    continue;
                case 0:
                    stop = 0;
                    break;

            }
        }
    }
}


package Lesson5.Task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, String> phoneBook = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public void writePhoneNumber() {
        System.out.println("Введите Имя");
        String name = scanner.next();
        System.out.println("Введите Фамилию");
        String surname = scanner.next();
        System.out.println("Введите номер телефона");
        String phoneNumber = scanner.next();
        String fullName = getFullName(name, surname);
        System.out.println("Контакт:" + fullName + " c номером телефона: " + phoneNumber + " создан");
        phoneBook.put(phoneNumber, fullName);
    }

    public void showPhoneBook() {
        for (Map.Entry entry : phoneBook.entrySet()) {
            System.out.println(entry);
        }
    }

    public String getFullName(String name, String surname) {
        String fullName = name + " " + surname;
        return fullName;
    }

    public static void main(String[] args) {
        PhoneBook user = new PhoneBook();
        while (true) {
            System.out.println("1-Создать новый контак\n2-Показать все контакты\n3-Выйти из программы");
            int value = scanner.nextInt();
            if (value == 1) {
                user.writePhoneNumber();
            } else if (value == 2) {
                System.out.println("\nВсе контакты");
                user.showPhoneBook();
                System.out.println("----");
            } else {
                System.out.println("\nЗавершение программы");
                break;
            }
        }
    }

}


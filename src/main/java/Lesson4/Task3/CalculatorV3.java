package Lesson4.Task3;

import java.util.LinkedList;
import java.util.Scanner;

public class CalculatorV3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        float num1 = getNum();
        list.add(num1);

        while (true) {
            char operator = getOperation();
            if (checkResult()) {
                num1 = (float) list.peekLast();
                System.out.println("Число: " + num1);
                continue;
            } else {
                float num2 = getNum();
                num1 = (float) list.peekLast();
                list.remove(num1);
                list.add(calc(num1, num2, operator));
                System.out.println("Результат: " + calc(num1, num2, operator));
            }
        }


    }

    public static float getNum() {
        //Получение числа
        System.out.println("Введите число:");
        float num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getNum();
        }
        return num;
    }

    public static char getOperation() {
        //Получение оператора
        System.out.println("Введите операцию:");

        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static float calc(float num1, float num2, char operation) {
        float result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }

    public static boolean checkResult() {
        System.out.println("Для отмены оператора введите 'q'");
        String value = scanner.next().toLowerCase();
        if (value.equals("q")) {
            return true;
        } else {
            return false;
        }
    }
}


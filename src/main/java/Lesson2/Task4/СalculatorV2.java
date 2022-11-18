package Lesson2.Task4;

import Lesson2.Task2.BubbleSort;


import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class СalculatorV2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        FileHandler log = new FileHandler("src/main/java/Lesson2/Task4/logcalc.xml");
        logger.addHandler(log);
        XMLFormatter xml = new XMLFormatter();
        log.setFormatter(xml);
        Formatter string = new Formatter();
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        string.format("%d %s %d = %d", num1, operation, num2, result);
        logger.info("Операция " + string);
        System.out.println(string);

    }

    public static int getInt() {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {

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

    public static int calc(int num1, int num2, char operation) {

        int result;

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
}

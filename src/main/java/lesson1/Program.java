package lesson1;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.BitSet;
public class Program {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Выберите программу:");
        System.out.println("1-Вычислить n-ое треугольного число");
        System.out.println("2-Вывести все простые числа от 1 до 1000");
        System.out.println("3-Простой калькулятор");
        System.out.println("4-*Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.");
        String value = iScanner.nextLine();
        Controller(value);
        iScanner.close();
    }

    public static void Controller(String value) {
        switch (value) {
            case "1":GetNumberTriangle();break;
            case "2":GetPrimeNumbers();break;
            case "3": lesson1.Сalculator.Сalculators();break;
            case "4": lesson1.Equation.solutionEquation();break;
        }

    }
    public static void GetNumberTriangle() {
        Scanner in = new Scanner(System.in);
        System.out.println("1-Вычислить n-ое треугольного число");
        System.out.println("Введите число n: ");
        int num = in.nextInt();
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result += i;
        }
        in.close();
        System.out.println(result);
    }
    public static void GetPrimeNumbers() {
        System.out.println("2-Вывести все простые числа от 1 до 1000");
        int num = 1000;
        var sieve = new BitSet(num);
        sieve.set(0, num - 1, true);
        sieve.set(0, false);
        sieve.set(1, false);
        for (int i = 2; i * i < sieve.length(); i++) {
            if (sieve.get(i)) {
                for (int j = i * i; j < sieve.length(); j += i) {
                    sieve.set(j, false);
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < sieve.length(); i++) {
            if (sieve.get(i)) {
                primes.add(i);
            }
        }
        System.out.println(primes);
    }
    
}   

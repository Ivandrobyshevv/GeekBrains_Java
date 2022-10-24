package Lesson3.Task2;

import Lesson3.Task1.MergeSort;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class OddNumbers {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(MergeSort.class.getName());
        FileHandler log = new FileHandler("src/main/java/Lesson3/Task1/log.xml");
        logger.addHandler(log);
        XMLFormatter xml = new XMLFormatter();
        log.setFormatter(xml);
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите длинну массива (n >= 2): ");
            n = sc.nextInt();
        } while (n < 2);
        int[] array = createRandomArray(n, 1, 9);
        logger.info("Дан массив: " + Arrays.toString(array));
        String numbers = evenElementsMakeZero(array);
        logger.info("Нечетные элементы: " + numbers);

    }

    //СОЗДАЁМ МАССИВ ЗАДАННОЙ ДЛИННЫ И ЗАПОЛНЯЕМ СЛУЧАЙНЫМИ ЧИСЛАМИ ОТ MIN ДО MAX (ВКЛЮЧИТЕЛЬНО)
    public static int[] createRandomArray(int length, int min, int max) {
        int[] result = length > 0 ? new int[length] : new int[0];
        if (length > 0) {
            Random rand = new Random();
            for (int index = 0; index < length; index++) {
                result[index] = rand.nextInt(Math.abs(max - min) + 1) + min;
            }
        }
        return result;
    }

    // ВЫБИРАЕМ НЕЧЕТНЫЕ ЭЛЕМЕНТЫ
    public static String evenElementsMakeZero(int[] array) {
        String numbers = "[ ";
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array.length - i == 1){
                    numbers += Integer.toString(array[i]);
                }
                else {
                    numbers += Integer.toString(array[i]) + ", ";
                }
            }
        }
        numbers += " ]";
        return numbers;
    }
}
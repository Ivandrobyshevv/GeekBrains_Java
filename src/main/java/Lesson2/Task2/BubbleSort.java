package Lesson2.Task2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class BubbleSort {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        FileHandler log = new FileHandler("src/main/java/Lesson2/Task2/log.xml");
        logger.addHandler(log);
        XMLFormatter xml = new XMLFormatter();
        log.setFormatter(xml);

        int[] mas = {11, 3, 14, 16, 7};
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
            logger.info(Arrays.toString(mas));
        }
    }
}
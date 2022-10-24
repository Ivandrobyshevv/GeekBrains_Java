package Lesson3.Task3;

import Lesson3.Task1.MergeSort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Program {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(MergeSort.class.getName());
        FileHandler log = new FileHandler("src/main/java/Lesson3/Task3/log.xml");
        logger.addHandler(log);
        XMLFormatter xml = new XMLFormatter();
        log.setFormatter(xml);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(100);
        numbers.add(150);
        numbers.add(10);
        numbers.add(0);
        numbers.add(-15);
        logger.info("Дан массив: " + numbers.toString());
        logger.info("Максимальное число: " + Collections.max(numbers));
        logger.info("Минимальное число: " + Collections.min(numbers));
    }
}

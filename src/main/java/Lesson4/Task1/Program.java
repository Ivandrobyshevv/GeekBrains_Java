package Lesson4.Task1;

import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        LinkedList<Integer> numbersList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            numbersList.add(i);
        }
        LinkedList<Integer> newNumbersList = new LinkedList();
        System.out.println("Изначальный список: " + numbersList);
        int s = numbersList.size();
        for (int i = 0; i < numbersList.size();) {
            newNumbersList.add(numbersList.pollLast());
        }
        System.out.println("Перевернутый список: " + newNumbersList);
    }
}

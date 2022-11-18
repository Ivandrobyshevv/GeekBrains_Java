package Lesson4.Task2;

import java.util.LinkedList;
import java.util.Stack;

public class TurnList {
    private static class Turn {
        LinkedList<Integer> turn = new LinkedList<>();


        public void enqueue(int num) {
            /* enqueue() - помещает элемент в конец очереди */
            this.turn.addLast(num);
        }

        public void dequeue() {
            /* dequeue() - возвращает первый элемент из очереди и удаляет его */
            System.out.println(this.turn.pollFirst());
        }

        public void first() {
            /* first() - возвращает первый элемент из очереди, не удаляя */
            System.out.println(this.turn.peekFirst());

        }

        public void show_turn() {
            /* show_turn() -выводит список в консоль */
            System.out.println(this.turn);
        }
    }

    public static void main(String[] args) {
        Turn turn = new Turn();
        turn.enqueue(2);
        turn.enqueue(3);
        turn.enqueue(4);
        turn.show_turn();
        turn.dequeue();
        turn.show_turn();
        turn.first();
        turn.show_turn();

    }


}

package Lesson4.Task4;

import Lesson2.Task2.BubbleSort;

import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class PostfixNotation {
    static Scanner scanner = new Scanner(System.in);
    private Stack theStack;
    private String input;
    private String output = "";

    public PostfixNotation(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new Stack(stackSize);
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            output = output + theStack.pop();
        }
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else
                    output = output + opTop;
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }

    public static void main(String[] args)
            throws IOException {
        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        FileHandler log = new FileHandler("src/main/java/Lesson4/Task4/log.xml");
        logger.addHandler(log);
        XMLFormatter xml = new XMLFormatter();
        log.setFormatter(xml);

        System.out.println("Введите выражение в инфиксной записи:");
        String input = scanner.next();
        logger.info("Инфиксная запис: " + input);
        String output;
        PostfixNotation theTrans = new PostfixNotation(input);
        output = theTrans.doTrans();
        logger.info("Постфиксная запись: " + output);
//        System.out.println("Постфиксная запись: " + output + '\n');
    }

    class Stack {
        private int maxSize;
        private char[] stackArray;
        private int top;

        public Stack(int max) {
            maxSize = max;
            stackArray = new char[maxSize];
            top = -1;
        }

        public void push(char j) {
            stackArray[++top] = j;
        }

        public char pop() {
            return stackArray[top--];
        }

        public char peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }
}

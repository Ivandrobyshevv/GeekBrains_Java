package lesson1;


import java.util.Scanner;

public class Equation {
    public static void solutionEquation(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите уравнение которое, ребуется восстановить выражение до верного равенства.");
        String equation = iScanner.nextLine();
        System.out.println( equation+" -> "+ FillTheGaps(equation));
        iScanner.close();
    }
    public static String FillTheGaps(String eq) {
        int numOfQue = CountOccurrences(eq);
        System.out.println(numOfQue);
        String answer = CheckOneQue(eq, numOfQue);        
        return answer;
    }
    public static String CheckOneQue(String eq, int num) {

        String sol = "No solution";
        if (num == 1) {
            for (int i = 0; i < 10; i++) {
                String temp = eq.replaceFirst("\\?", String.valueOf(i));
                String[] words = temp.split("[+=]");
                for (int j = 0; j < words.length; j++) {
                    words[j] = words[j].trim();
                }
                if (Integer.parseInt(words[0]) + Integer.parseInt(words[1]) == Integer.parseInt(words[2]))
                    return temp;
            }
            return "No solution";
        } else {

            for (int i = 0; i < 10; i++) {
                String recursive = CheckOneQue(eq.replaceFirst("\\?", String.valueOf(i)), num - 1);
                if (sol != recursive)
                    return recursive;
            }

        }
        return "None";
    }
    public static int CountOccurrences(String eqation) {
        int count = 0;
        for (int i = 0; i < eqation.length(); i++) {
            if (eqation.charAt(i) == '?') {
                count+=1;
            }
        }
        return count;
    }
    
}

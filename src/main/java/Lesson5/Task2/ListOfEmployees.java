package Lesson5.Task2;

import java.util.*;

public class ListOfEmployees {

    List<String> employees = Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
            "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
            "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
    );

    public static <K, V extends Comparable> Map<K, V> sortByValues(Map<K, V> map) {

        List<Map.Entry<K, V>> mappings = new ArrayList<>(map.entrySet());

        Collections.sort(mappings, Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(mappings);

        Map<K, V> linkedHashMap = new LinkedHashMap<>();

        for (Map.Entry<K, V> entry : mappings) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }

    public HashMap nameAndCount(List employees) {
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            String[] words = employees.get(i).toString().split("\\s");

            if (count.containsKey(words[0])) {
                int value = count.get(words[0]) + 1;
                count.put(words[0], value);
            } else
                count.put(words[0], 0);
        }
        return count;

    }


    public static void main(String[] args) {
        ListOfEmployees employees = new ListOfEmployees();
        Map listValues = employees.nameAndCount(employees.employees);

        listValues = sortByValues(listValues);

        for (Object entry : listValues.entrySet()) {
            System.out.println(entry);
        }


    }
}

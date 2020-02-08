package Lesson3;
// Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

import java.util.*;

public class ArrayWords {

    public static void main(String[] args) {
        String[] words = initStringsArray();

        Map<String, Integer> countedWords = countWords(words);

        countedWords.forEach((word, number) -> System.out.println(word + ": " + number));
    }

    private static Map<String, Integer> countWords(String[] words) {
        // TreeMap - чтобы слова были отсортированы по алфавиту
        Map<String, Integer> wordMap = new TreeMap<>(Comparator.naturalOrder());

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        return wordMap;
    }

    private static String[] initStringsArray() {
        return new String[] {
                "ORANGE",
                "JUICE",
                "APPLE",
                "ORANGE",
                "KEYBOARD",
                "WINDOW",
                "MOTOR",
                "JUICE",
                "APPLE",
                "WINDOW"
        };
    }
}
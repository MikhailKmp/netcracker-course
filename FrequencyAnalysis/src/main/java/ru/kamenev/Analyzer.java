package ru.kamenev;

import java.util.*;

/**
 * Класс, в котором реализованы методы по частотному
 * анализу символов в строках
 */
public class Analyzer {

    /**
     * Метод, который производит частотный анализ символов в
     * указанных строках в тексте и возвращает
     * символы, которые входят в обе строки
     * @param text текст для аналиха
     * @param firstLine номер первой строки (нумерация с 0)
     * @param secondLine номер второй строки
     * @return множество символов, которые входят в обе строки
     */
    public static Set<Character> intersection(String text, int firstLine, int secondLine) {
        List<Set> list = returnSetChar(text, firstLine, secondLine);
        Set<Character> firstSet = list.get(0);
        Set<Character> secondSet = list.get(1);
        firstSet.retainAll(secondSet);
        return firstSet;
    }

    /**
     * Метод, который производит частотный анализ символов в
     * указанных строках в тексте и возвращает
     * символы, которые входят в firstLine и не входят в secondLine
     * @param text текст для анализа
     * @param firstLine номер первой строки (нумерация с 0)
     * @param secondLine номер второй строки
     * @return множество символов, которые входят в firstLine и не входят в secondLine
     */
    public static Set<Character> difference(String text, int firstLine, int secondLine) {
        List<Set> list = returnSetChar(text, firstLine, secondLine);
        Set<Character> firstSet = list.get(0);
        Set<Character> secondSet = list.get(1);
        firstSet.removeAll(secondSet);
        return firstSet;
    }

    /**
     * Метод, которые производит частотный анализ символов в
     * указанных строках в тексте и возвращает
     * символы, которые содеражтся хотя бы в одной строке
     * @param text текст для анализа
     * @param firstLine номер первой строки (нумерация с 0)
     * @param secondLine номер второй строки
     * @return множество символов, которые содержатся хотя бы в одной строке
     */
    public static Set<Character> union(String text, int firstLine, int secondLine) {
        List<Set> list = returnSetChar(text, firstLine, secondLine);
        Set<Character> firstSet = list.get(0);
        Set<Character> secondSet = list.get(1);
        firstSet.addAll(secondSet);
        return firstSet;
    }

    /**
     * Метод, который возвращает список из двух множеств, которые содержат
     * символы в указанных строках
     * @param text текст для анализа
     * @param firstLine номер первой строки (нумерация с 0)
     * @param secondLine номер второй строки
     * @return список из двух множеств, которые содержат символы в указанных строках
     */
    private static List<Set> returnSetChar(String text, int firstLine, int secondLine) {
        Scanner scanner = new Scanner(text);
        List<String> listString = new ArrayList<>();

        //поиск строк и добавление их в listString
        int count = 0;
        while (scanner.hasNextLine()) {
            if (count == firstLine || count == secondLine) {
                listString.add(scanner.nextLine());
            }
            else {
                scanner.nextLine();
            }
            count++;
        }

        //если в тексте нет строки с указанным номером
        if (listString.size() != 2) {
            throw new NoSuchElementException();
        }

        //заполняем множество символами из строки firstLine
        Set<Character> firstSet = new LinkedHashSet<>();
        for (char temp : listString.get(0).toCharArray()) {
            firstSet.add(temp);
        }

        //заполняем множество символами из строки secondLine
        Set<Character> secondSet = new LinkedHashSet<>();
        for (char temp : listString.get(1).toCharArray()) {
            secondSet.add(temp);
        }

        List<Set> listSet = new ArrayList<>();
        listSet.add(firstSet);
        listSet.add(secondSet);

        return listSet;
    }
}
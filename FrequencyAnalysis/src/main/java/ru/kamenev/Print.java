package ru.kamenev;

import java.util.*;

/**
 * Класс, в котором реализованы методы по выводу
 * множества символов
 */
public class Print {

    /**
     * Метод выводит символы в обычном порядке
     * @param set множество символов
     */
    public static void print(Set<Character> set) {
        for (Character character : set) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    /**
     * Метод выводит символы в обратном порядке
     * @param set множество символов
     */
    public static void printReverse(Set<Character> set) {
        List<Character> list = new ArrayList<>(set);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * Метод выводит символы в порядке возрастания циклического
     * сдвига влево на n разрядов хэш-функции символа
     * @param set множество символов
     */
    public static void printHashShift(Set<Character> set) {
        Map<Integer, Character> map = new TreeMap<>();
        int count = 1;
        for (Character character : set) {
            map.put(character.hashCode() << count, character);
            count = count == 31 ? 0 : count + 1;
        }
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }
}
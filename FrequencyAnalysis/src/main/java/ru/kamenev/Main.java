package ru.kamenev;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String text = "ab cd \n" +
                "ef jk \n" +
                "cek b \n" +
                "jfm n";

        Set<Character> set1 = Analyzer.intersection(text,0 , 2); // result:  'b', ' ', 'c'
        System.out.print("set1: ");
        Print.print(set1);

        Set<Character> set2 = Analyzer.difference(text, 1, 2); // result: 'f', 'j'
        System.out.print("set2: ");
        Print.print(set2);

        Set<Character> set3 = Analyzer.union(text, 2, 3); //result:  'c', 'e', 'k', ' ', 'b', 'j', 'f', 'm', 'n'
        System.out.print("set3: ");
        Print.print(set3);

        System.out.print("Вывод set1 в обычном порядке: ");
        Print.print(set1);

        System.out.print("Вывод set1 в обратном порядке: ");
        Print.printReverse(set1);

        System.out.print("Вывод set1 в порядке возрастания циклического сдвига: ");
        Print.printHashShift(set1);
    }
}
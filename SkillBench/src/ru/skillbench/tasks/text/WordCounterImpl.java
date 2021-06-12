package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;

public class WordCounterImpl implements WordCounter {

    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
        if (text == null) {
            throw new IllegalStateException();
        }

        Scanner scanner = new Scanner(text);
        Map<String, Long> map = new HashMap<>();

        while (scanner.hasNext()) {
            String string = scanner.next();
            if (string.matches("<.*>")) {
                continue;
            }
            string = string.toLowerCase();
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            }
            else {
                map.put(string, 1L);
            }
        }
        return map;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        Map<String, Long> map = getWordCounts();
        return sort(map, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, comparator);
        return list;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for (Map.Entry<K, V> entry : entries) {
            ps.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
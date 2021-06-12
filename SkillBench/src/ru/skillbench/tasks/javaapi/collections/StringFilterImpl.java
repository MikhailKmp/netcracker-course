package ru.skillbench.tasks.javaapi.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringFilterImpl implements StringFilter {

    private Set<String> set;

    public StringFilterImpl() { set = new HashSet<>(); }

    @Override
    public void add(String s) {
        if (s != null) {
            s = s.toLowerCase();
        }
        set.add(s);
    }

    @Override
    public boolean remove(String s) {
        if (s != null) {
            s = s.toLowerCase();
        }
        return set.remove(s);
    }

    @Override
    public void removeAll() {
        set.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return set;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
       Filter filter = new Filter() {
           @Override
           public boolean filter(String string, String chars) {
               return string.contains(chars);
           }
       };
       return filter.getStringsByFilter(set, chars);
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        Filter filter = new Filter() {
            @Override
            public boolean filter(String string, String chars) {
                chars = chars.toLowerCase();
                return string.startsWith(chars);
            }
        };
        return filter.getStringsByFilter(set, begin);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        Filter filter = new Filter() {
            @Override
            public boolean filter(String string, String chars) {
                char[] stringArr = string.toCharArray();
                for (int i = 0; i < stringArr.length; i++) {
                    if (stringArr[i] >= 48 && stringArr[i] <= 57) {
                        stringArr[i] = '#';
                    }
                }
                string = String.valueOf(stringArr);
                return string.equals(chars);
            }
        };
        return filter.getStringsByFilter(set, format);
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        Filter filter = new Filter() {
            @Override
            public boolean filter(String string, String chars) {
                int indexFirst = chars.indexOf('*');
                int indexSecond = chars.indexOf('*', indexFirst + 1);
                if (indexFirst == -1 && indexSecond == -1) {
                    return string.equals(chars);
                }
                else if (indexFirst != -1 && indexSecond == -1) {
                    return string.startsWith(chars.substring(0, indexFirst)) &&
                            string.endsWith(chars.substring(indexFirst + 1));
                }
                else {
                    return string.startsWith(chars.substring(0, indexFirst)) &&
                            string.contains(chars.substring(indexFirst + 1, indexSecond)) &&
                            string.endsWith(chars.substring(indexSecond + 1));
                }
            }
        };
        return filter.getStringsByFilter(set, pattern);
    }

    interface Filter {
        default Iterator<String> getStringsByFilter(Set<String> set, String chars) {
            if (chars == null || chars.equals("")) {
                return set.iterator();
            }
            Set<String> result = new HashSet<>();
            for (String string : set) {
                if (string == null) {
                    continue;
                }
                if (filter(string, chars)) {
                    result.add(string);
                }
            }
            return result.iterator();
        }

        boolean filter(String string, String chars);
    }
}
package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsImpl implements Patterns {
    @Override
    public Pattern getSQLIdentifierPattern() {
        return Pattern.compile("\\w([\\w\\d_]{1,29})?");
    }

    @Override
    public Pattern getEmailPattern() {
        return Pattern.compile("[\\w\\d]([\\w\\d-_.]{1,20}[\\w\\d])?@[\\w\\d]([\\w\\d-]*[\\w\\d])?(\\.[\\w\\d]([\\w\\d-]*[\\w\\d]))+");
    }

    @Override
    public Pattern getHrefTagPattern() {
        return Pattern.compile("<\\s?a\\s?href\\s?=\\s?(\".*\"|[^\\s\"]*)\\s?/?>", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public List<String> findAll(String input, Pattern pattern) {
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    @Override
    public int countMatches(String input, String regex) {
        int count = 0;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
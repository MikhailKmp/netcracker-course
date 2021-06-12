package ru.skillbench.tasks.text.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {

    private String text;
    private HashMap<String, String> hide;

    @Override
    public void setText(String text) {
        this.text = text;
        hide = new HashMap<>();
    }

    @Override
    public String getText() {
        if (text == null) {
            throw new IllegalStateException();
        }
        return text;
    }

    @Override
    public List<Phone> getPhones() {
        text = getText();

        List<Phone> phones = new ArrayList<>();
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher =  pattern.matcher(text);

        while (matcher.find()) {
            int areaCode = matcher.group(2) != null ? Integer.parseInt(matcher.group(2)) : -1;
            int extension = matcher.group(7) != null ? Integer.parseInt(matcher.group(7)) : -1;
            phones.add(new Phone(matcher.group(), areaCode, extension));
        }
        return phones;
    }

    @Override
    public String getFullName() {
        text = getText();

        Pattern pattern = Pattern.compile("([A-Z][a-z]*[a-z.] )([A-Z][a-z]*[a-z.])( [A-Z][a-z]*[a-z.])?");
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            throw new NoSuchElementException();
        }
        return matcher.group();
    }

    @Override
    public String getFirstName() {
        String fullName = getFullName();
        Pattern pattern = Pattern.compile("[A-Z][a-z]*[a-z.]");
        Matcher matcher = pattern.matcher(fullName);
        matcher.find();
        return matcher.group(0);
    }

    @Override
    public String getMiddleName() {
        String fullName = getFullName();

        String middleName = null;
        Pattern pattern = Pattern.compile("[A-Z][a-z]*[a-z.]");
        Matcher matcher = pattern.matcher(fullName);

        int count = 0;
        while (matcher.find()) {
            count++;
            if (count == 2) {
                middleName = matcher.group();
            }
        }
        if (count == 3) {
            return middleName;
        }
        return null;
    }

    @Override
    public String getLastName() {
        String fullName = getFullName();
        String lastName = null;
        Pattern pattern = Pattern.compile("[A-Z][a-z]*[a-z.]");
        Matcher matcher = pattern.matcher(fullName);
        while (matcher.find()) {
            lastName = matcher.group();
        }
        return lastName;
    }

    @Override
    public void updateLastName(String newLastName) {
        String fullName = getFullName();
        String newFullName = fullName.replace(getLastName(), newLastName);
        text = text.replace(fullName, newFullName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if (!text.contains(oldPhone.getNumber())) {
            throw new IllegalArgumentException();
        }
        text =  text.replaceFirst(oldPhone.getNumber(), newPhone.getNumber());
    }

    @Override
    public void hide(String piece) {
        text = getText();
        if (!text.contains(piece)) {
            throw new IllegalArgumentException();
        }
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < piece.length(); i++) {
            if (piece.charAt(i) == ' ' || piece.charAt(i) == '.' || piece.charAt(i) == '@') {
                replacement.append(piece.charAt(i));
            }
            else {
                replacement.append("X");
            }
        }
        hide.put(replacement.toString(), piece);
        text = text.replace(piece, replacement.toString());
    }

    @Override
    public void hidePhone(String phone) {
        text = getText();
        if (!text.contains(phone)) {
            throw new IllegalArgumentException();
        }
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) >= 48 && phone.charAt(i) <= 57) {
                replacement.append("X");
            }
            else {
                replacement.append(phone.charAt(i));
            }
        }
        hide.put(replacement.toString(), phone);
        text = text.replace(phone, replacement.toString());
    }

    @Override
    public int unhideAll() {
        text = getText();
        int count = hide.size();
        for (Map.Entry<String, String> temp : hide.entrySet()) {
            text = text.replace(temp.getKey(), temp.getValue());
        }
        return count;
    }
}
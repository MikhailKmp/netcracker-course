package ru.skillbench.tasks.text;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ContactCardImpl implements ContactCard {

    private String fullName;
    private String organization;
    private char gender;
    private LocalDate birthday;
    private List<String> phones;

    @Override
    public ContactCard getInstance(Scanner scanner) {
        boolean checkFN = false;
        boolean checkORG = false;
        String string = scanner.nextLine();

        if (!string.equals("BEGIN:VCARD")) {
            throw new NoSuchElementException();
        }
        while (scanner.hasNextLine()) {
            string = scanner.nextLine();

            if (string.startsWith("FN")) {
                if (!string.startsWith("FN:")) {
                    throw new InputMismatchException();
                }
                fullName = string.substring(3);
                checkFN = true;
            }

            if (string.startsWith("ORG")) {
                if (!string.startsWith("ORG:")) {
                    throw new InputMismatchException();
                }
                organization = string.substring(4);
                checkORG = true;
            }

            if (string.startsWith("GENDER")) {
                if (!string.startsWith("GENDER:") ||
                        !string.substring(7).equals("F") && !string.substring(7).equals("M")) {
                    throw new InputMismatchException();
                }
                gender = string.charAt(7);
            }

            if (string.startsWith("BDAY")) {
                if (!string.startsWith("BDAY:") || !string.substring(5).matches("\\d{2}-\\d{2}-\\d{4}")) {
                    throw new InputMismatchException();
                }
                birthday = LocalDate.of(Integer.parseInt(string.substring(11)),
                        Integer.parseInt(string.substring(8, 10)),
                        Integer.parseInt(string.substring(5, 7)));
            }

            if (string.matches("TEL;TYPE=\\w+.*")) {
                if (!string.matches("TEL;TYPE=\\w+:\\d{10}")) {
                    throw new InputMismatchException();
                }
                if (phones == null) {
                    phones = new ArrayList<>();
                }
                phones.add(string.substring(string.indexOf(';') + 1));
            }
        }

        if (!string.equals("END:VCARD") || !checkFN || !checkORG) {
            throw new NoSuchElementException();
        }
        return this;
    }

    @Override
    public ContactCard getInstance(String data) {
        Scanner scanner = new Scanner(data);
        return getInstance(scanner);
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getOrganization() {
        return organization;
    }

    @Override
    public boolean isWoman() {
        if (gender == 'F') {
            return true;
        }
        return false;
    }

    @Override
    public Calendar getBirthday() {
        if (birthday == null) {
            throw new NoSuchElementException();
        }
        Date date = new Date(birthday.getYear() - 1900, birthday.getMonthValue() - 1, birthday.getDayOfMonth());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar;
    }

    @Override
    public Period getAge() {
        if (birthday == null) {
            throw new NoSuchElementException();
        }
        return Period.between(birthday, LocalDate.now());
    }

    @Override
    public int getAgeYears() {
        if (birthday == null) {
            throw new NoSuchElementException();
        }
        return (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }

    @Override
    public String getPhone(String type) {
        if (phones == null) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).contains(type)) {
                String phone = phones.get(i).substring(phones.get(i).indexOf(":") + 1);
                return "(" + phone.substring(0, 3) + ") " + phone.substring(3,6) + "-" + phone.substring(6);
            }
        }
        throw new NoSuchElementException();
    }
}
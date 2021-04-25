package ru.kamenev;

/**
 * Сущность персона
 */
public class Person {

    private String firstName;
    private String lastName;
    private String patronymic;

    /**
     * Метод возвращает ФИО в формете: "Фамилия И. О.",
     * если имя или отчетсво отсутствуют, возвращается только фамилия
     * @return полное имя
     */
    public String getName() {
        if (firstName == null || patronymic == null) {
            return lastName;
        }
        return new StringBuffer(lastName)
                .append(" ").append(firstName.charAt(0)).append(". ").append(patronymic.charAt(0)).append(".").toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
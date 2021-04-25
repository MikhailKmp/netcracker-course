package ru.kamenev.entity;

/**
 * Сущность студент
 */
public class Student {
    /** id студента */
    private int idStudent;
    /** имя студента */
    private String firstName;
    /** фамилия студента */
    private String lastName;
    /** группа студента */
    private int idGroup;
    /** количество долгов у студента */
    private int dolgCount;

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getDolgCount() {
        return dolgCount;
    }

    public void setDolgCount(int dolgCount) {
        this.dolgCount = dolgCount;
    }
}
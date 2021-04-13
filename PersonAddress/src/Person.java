import java.util.Date;

/**
 * Класс, который представляет из себя сущность человека
 */
public class Person {
    /** Имя */
    private String firstName;
    /** Фамилия */
    private String lastName;
    /** День рождения */
    private Date dateOfBirth;
    /** Адрес */
    private Address address;

    public Person(String firstName, String lastName, Date dateOfBirth, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
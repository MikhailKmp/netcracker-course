import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, в котором реализованы методы по поиску человека (людей)
 * по определенному параметру
 */
public class PeopleSearch {

    /**
     * Метод осуществялет поиск в списке по фамилии.
     * @param personList - список людей, в котором будет осуществляться поиск
     * @param lastName - параметр (фамилия), по которому будет осуществляться поиск
     * @return возвращает человека, у которого совпадает фамилия с параметром lastName или null, если ничего не найдено
     */
    public Person findPersonByLastName(List<Person> personList, String lastName) {
        for (Person person : personList) {
            if (lastName.equals(person.getLastName())) {
                return person;
            }
        }
        return null;
    }

    /**
     * Метод осуществялет поиск в списке по адресу.
     * @param personList - список людей, в котором будет осуществляться поиск
     * @param address - параметр (адрес), по которому будет осуществляться поиск
     *                (сравнение осуществляется переопределеныым методом equals)
     * @return возвращает человека, у которого совпадает адрес с параметром address или null, если ничего не найдено
     */
    public Person findPersonByAddress(List<Person> personList, Address address) {
        for (Person person : personList) {
            if (person.getAddress().equals(address)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск людей, которые родились между указанными датами.
     * @param personList - список людей, в котором будет осуществляться поиск
     * @param date1 - дата, позже которой родился человек
     * @param date2 - дата, раньше которой родился человек
     * @return возвращает список людей, которые родились между указанными датами
     */
    public List<Person> findPersonByTwoDates(List<Person> personList, Date date1, Date date2) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.getDateOfBirth().after(date1) && person.getDateOfBirth().before(date2)) {
                result.add(person);
            }
        }
        return result;
    }

    /**
     * Метод возвращает самого молодого человека в списке
     * @param personList - список людей, в котором будет осуществляться поиск
     * @return возвращает самого молодого человека
     */
    public Person findTheYoungest(List<Person> personList) {
        Person youngest = personList.get(0);
        for (int i = 1; i < personList.size(); i++) {
            if (personList.get(i).getDateOfBirth().after(youngest.getDateOfBirth())) {
                youngest = personList.get(i);
            }
        }
        return youngest;
    }

    /**
     * Метод осуществляет поиск людей, которые проживают на указанной улице
     * @param personList - список людей, в котором будет осуществляться поиск
     * @param street - улица, по которой будет осуществляться поиск
     * @return возвращает список людей, которые живут на указанной улице
     */
    public List<Person> findPersonByStreet(List<Person> personList, String street) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAddress().getStreet().equals(street)) {
                result.add(person);
            }
        }
        return result;
    }
}
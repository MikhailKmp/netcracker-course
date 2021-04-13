import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    Класс, в котором демонстрируется работа класса PeopleSearch
 */
public class Main {
    public static void main(String[] args) {
        //создается 5 адресов
        Address address1 = new Address("Lomonosova", 25, 15);
        Address address2 = new Address("Lomonosova", 78, 75);
        Address address3 = new Address("Karla Marks", 98, 14);
        Address address4 = new Address("Lomonosova", 25, 15);
        Address address5 = new Address("Truda", 48, 57);

        //создается 5 человек
        Person person1 = new Person("Mikhail", "Kamenev", new Date(1999, 3, 2), address1);
        Person person2 = new Person("Ivan", "Ivanov", new Date(1999, 5, 27), address2);
        Person person3 = new Person("Vasya", "Pupkin", new Date(1998, 8, 13), address3);
        Person person4 = new Person("Petya", "Petrov", new Date(1975, 4, 5), address4);
        Person person5 = new Person("Igor", "Trutnev", new Date(1968, 7, 1), address5);

        //В список (динамический массив) добавляются 5 человек
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        PeopleSearch peopleSearch = new PeopleSearch();

        //демонстрируется работа метода findPersonByLastName
        Person person = peopleSearch.findPersonByLastName(personList, "Ivanov");
        System.out.println("Найден человек (по фамилии): " + person.getFirstName() + " " + person.getLastName());

        //демонстрируется работа метода findPersonByAddress
        Address address = new Address("Karla Marks", 98, 14);
        person = peopleSearch.findPersonByAddress(personList, address);
        System.out.println("Найден человек (по атрибуду адресс): " + person.getFirstName() + " " + person.getLastName());

        //демонстрируется работа метода findPersonByTwoDates
        Date date1 = new Date(1998, 1, 1);
        Date date2 = new Date(1999, 4, 1);

        List<Person> list = peopleSearch.findPersonByTwoDates(personList, date1, date2);
        for (Person thePerson : list) {
            System.out.println("Найден человек (родившийся между датами): " + thePerson.getFirstName()
                    + " " + thePerson.getLastName());
        }

        //демонстрируется работа метода findTheYoungest
        person = peopleSearch.findTheYoungest(personList);
        System.out.println("Найден человек (самый молодой): " + person.getFirstName() + " " + person.getLastName());

        //демонстрируется работа метода findPersonByStreet
        list = peopleSearch.findPersonByStreet(personList, "Lomonosova");
        for (Person thePerson : list) {
            System.out.println("Найден человек (проживающий на улице Lomonosova): "
                    + thePerson.getFirstName() + " " + thePerson.getLastName());
        }
    }
}
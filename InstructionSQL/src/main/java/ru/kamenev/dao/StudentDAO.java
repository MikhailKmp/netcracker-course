package ru.kamenev.dao;

import ru.kamenev.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, в котором реализована логика
 * обращения к базе данных
 */
public class StudentDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "5752";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Метод возвращает студентов из таблицы T_Student,
     * которые относятся к некоторой группе и имеют количетсво
     * долгов большее, чем dolgCount
     * @param idGroup номер группы
     * @param dolgCount количетсво долгов
     * @return список студентов
     */
    public List<Student> getStudents(int idGroup, int dolgCount) {
        List<Student> students = new ArrayList<>();

        try {
            //создаем утверждение
            Statement statement = connection.createStatement();
            //формируем SQL запрос
            String SQL = "SELECT * FROM \"T_Student\" WHERE \"id_Group\" = " + idGroup +
                    " AND \"dolgCount\" > " + dolgCount;
            //выполняем запрос и получаем результат
            ResultSet resultSet = statement.executeQuery(SQL);

            //проходим по каждой строке resultSet,
            //создаем объекты Student и добавляем их в список
            while (resultSet.next()) {
                Student student = new Student();

                student.setIdGroup(resultSet.getInt("id_Student"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setIdGroup(resultSet.getInt("id_Group"));
                student.setDolgCount(resultSet.getInt("dolgCount"));

                students.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }


    /**
     * Метод вставляет строки в таблицу T_GroupSelected
     * @param students список студентов, данные для которых
     *                 необходимо вставить в таблицу
     */
    public void saveStudents(List<Student> students) {

        for (Student student : students) {
            try {
                Statement statement = connection.createStatement();
                String SQL = "INSERT INTO \"T_GroupSelected\" VALUES (" + student.getIdStudent() + ", '" +
                        student.getFirstName() + "', '" + student.getLastName() + "', " + student.getIdGroup() + ")";

                statement.executeUpdate(SQL);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * Метод формирует одну SQL инструкцию, которая вставляет в таблицу
     * T_GroupSelected студентов, которые есть в таблтце T_Student
     * и относятся к некоторой группе
     * и  так же имеют количество долгов большее, чем dolgCount
     * @param idGroup номер группы
     * @param dolgCount количество долгов
     */
    public void instructionSQL(int idGroup, int dolgCount) {
        //получаем студентов из таблицы T_Student, которые относятся к некоторой группе
        //и имеют количетсво долгов большее, чем dolgCount
        List<Student> students = getStudents(idGroup, dolgCount);

        StringBuffer studentsSQL = new StringBuffer("");

        //формируем часть SQL инструкции
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            studentsSQL.append("(").append(student.getIdStudent()).append(", '").append(student.getFirstName()).
                    append("', '").append(student.getLastName()).append("', ").append(student.getIdGroup()).append(")");
            if (i != students.size() - 1)
                studentsSQL.append(",");
        }

        try {
            Statement statement = connection.createStatement();
            //формируем итоговую SQL инструкцию
            String SQL = "INSERT INTO \"T_GroupSelected\" VALUES " + studentsSQL;
            //выполнение инструкции
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
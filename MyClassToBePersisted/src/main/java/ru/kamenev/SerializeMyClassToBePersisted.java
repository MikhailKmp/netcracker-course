package ru.kamenev;

import java.io.*;

public class SerializeMyClassToBePersisted {
    public static void main(String[] args) {

        //создание объекта
        MyClassToBePersisted myClass = new MyClassToBePersisted();
        myClass.setProfile("Profile");
        myClass.setGroup("Group");

        //сериализация в файл
        try (OutputStream outputStream =
                     new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Netcracker\\MyClassToBePersisted\\files\\file");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(myClass);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
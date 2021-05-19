package ru.kamenev;

import java.io.*;

public class DeserializeMyClassToBePersisted {
    public static void main(String[] args) {

        //считывание файла и десириализация в объект
        try (InputStream inputStream =
                     new FileInputStream("C:\\Users\\User\\IdeaProjects\\Netcracker\\MyClassToBePersisted\\files\\file");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            MyClassToBePersisted myClass = (MyClassToBePersisted) objectInputStream.readObject();
            System.out.println(myClass.getProfile() + " " + myClass.getGroup());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
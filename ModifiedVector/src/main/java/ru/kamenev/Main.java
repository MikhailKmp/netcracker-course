package ru.kamenev;

import java.io.*;
import java.util.Arrays;

//проверочный класс
public class Main {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Netcracker\\ModifiedVector\\file\\file");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
             FileInputStream inputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Netcracker\\ModifiedVector\\file\\file");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            //создаем ArrayVector
            ArrayVector arrayVector = new ArrayVector();
            arrayVector.set(1,2,3,4.5);

            //создаем LinkedListVector
            LinkedListVector linkedListVector = new LinkedListVector();
            linkedListVector.set(0, 0);
            linkedListVector.set(1, 1);
            linkedListVector.set(2, 2);
            linkedListVector.set(3, 3);

            //записываем ArrayVector и LinkedListVector
            objectOutputStream.writeObject(arrayVector);
            objectOutputStream.writeObject(linkedListVector);

            //читаем ArrayVector
            ArrayVector newArrayVector = (ArrayVector) objectInputStream.readObject();
            System.out.println(Arrays.toString(arrayVector.get()));
            System.out.println(Arrays.toString(newArrayVector.get()));

            //читаем LinkedListVector
            LinkedListVector newLinkedListVector = (LinkedListVector) objectInputStream.readObject();
            System.out.println(linkedListVector.get());
            System.out.println(newLinkedListVector.get());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
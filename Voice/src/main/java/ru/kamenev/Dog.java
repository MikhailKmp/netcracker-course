package ru.kamenev;

public class Dog implements Voice {
    @Override
    public void voice() {
        System.out.println("Woof!");
    }
}
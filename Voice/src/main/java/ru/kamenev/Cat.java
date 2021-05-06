package ru.kamenev;

public class Cat implements Voice {
    @Override
    public void voice() {
        System.out.println("Meow!");
    }
}
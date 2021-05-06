package ru.kamenev;

public class Cow implements Voice {
    @Override
    public void voice() {
        System.out.println("Moo!");
    }
}
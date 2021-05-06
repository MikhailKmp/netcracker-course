package ru.kamenev;

//проверочный класс
public class Main {
    public static void main(String[] args) {
        Runner runner = new RunnerImpl();

        runner.run();
        runner.run();
        runner.run();
        runner.run();
        runner.run();
        runner.run();

        runner.getDistance();
    }
}
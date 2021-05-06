package ru.kamenev;

public class RunnerImpl implements Runner {

    private int count;
    private int distance;

    public RunnerImpl() {
        count = 0;
        distance = 0;
    }

    @Override
    public void run() {
        count++;
        distance += count;
    }

    @Override
    public void getDistance() {
        System.out.println(distance);
    }
}
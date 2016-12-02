package com.company;

import java.util.LinkedList;
import java.util.Random;

import static com.company.Main.country;
import static com.company.Main.working;

public class Main {
    static LookThread look;
    static WriteThread write;
    public static LinkedList<Region> country;
    public static boolean working=true;
    public static void main(String[] args) throws InterruptedException {
        country = new LinkedList<>();
        write = new WriteThread();
        look = new LookThread();
        write.start();
        look.start();
    }
}

class LookThread extends Thread {
    @Override
    public void run() {
        final Random random = new Random();
        for (;working ; ) {
            try {
                sleep(random.nextInt(800));
            } catch (InterruptedException e) {
            }
            if (country.size()>0) {
                System.out.println("Second thread read " + country.get(country.size() - 1).getCountPeople());
                country.remove(country.size() - 1);
            } else {
                System.out.println("ArrayList.size == 0");
                working=false;
            }
        }
    }
}

class WriteThread extends Thread {
    @Override
    public void run() {
        final Random random = new Random();
        for (;working ; ) {
            country.add(new Region());
            country.get(country.size() - 1).setCountPeople(random.nextInt(2000000));
            System.out.println("First thread write " + country.get(country.size() - 1).getCountPeople());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
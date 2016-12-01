package com.company;
import java.util.LinkedList;
import java.util.Random;

import static com.company.Main.country;

public class Main {
    static lookThread look;
    static writeThread write;
    public static LinkedList<Region> country;
    public static void main(String[] args) throws InterruptedException {
        country = new LinkedList<>();
        write = new writeThread();
        look = new lookThread();
        write.start();
        look.start();
    }
}

class lookThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<7;i++){
            try{
                sleep(1000);
            }catch(InterruptedException e){}
            try {
                System.out.println("Second thread read " + country.get(i).getCountPeople());
            }catch (ArrayIndexOutOfBoundsException e){}
        }
    }
}

class writeThread extends Thread{
    @Override
    public void run() {
        final Random random = new Random();
        for (int i=0;i<4;i++){
            country.add(new Region());
            country.get(i).setCountPeople(random.nextInt(2000000));
            System.out.println("First thread write " + country.get(i).getCountPeople());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }
    }
}
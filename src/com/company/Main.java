package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       MyThread myThread = new MyThread();

        ThreadGroup mainGroup = new ThreadGroup("Main");
        ThreadGroup insideMainGroup = new ThreadGroup(mainGroup,"insideMain");

        final Thread thread1 = new Thread(insideMainGroup, myThread);
        final Thread thread2 = new Thread(insideMainGroup, myThread);
        final Thread thread3 = new Thread(insideMainGroup, myThread);
        final Thread thread4 = new Thread(mainGroup, myThread);

        thread1.setName("Первый второстепенный ");
        thread2.setName("Второй второстепенный ");
        thread3.setName("Третий второстепенный ");
        thread4.setName("Важный ");

        System.out.println(" \n Создаю потоки : \n");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);

        System.out.println(" \nЗавершаю потоки : ");
        mainGroup.interrupt();
    }
}

package main.java.lessonFive;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("I work!");
        System.out.println("wait");

        try {
            sleep(3000L);
        } catch (InterruptedException var2) {
            System.out.println("someone interrupted me!");
        }

        System.out.println("I sleep!");
    }
}
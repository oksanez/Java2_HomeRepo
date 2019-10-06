package main.java.lessonFive;

public class MainClass {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;

    public MainClass() {
    }

    private static synchronized void incAllVars() {
        for(int i = 0; i < 1000000; ++i) {
            ++a;
            ++b;
            ++c;
        }

        System.out.println(Thread.currentThread().getName());
        System.out.println(String.format("a = %d, b = %d, c = %d", a, b, c));
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                MainClass.incAllVars();
            }
        };
        (new Thread(r, "Thread #1")).start();
        (new Thread(r, "Thread #2")).start();
        (new Thread(r, "Thread #3")).start();
    }

    private static void joinExample() {
        MyThread t = new MyThread("MyThread");
        t.start();
        t.interrupt();

        try {
            t.join();
            System.out.println("Main joins");
        } catch (InterruptedException var2) {
            throw new RuntimeException(var2);
        }

        System.out.println("I'm a Main");
    }

    private static void runnableExaple() {
        Runnable r = new Runnable() {
            public void run() {
                while(true) {
                    System.out.println("I'm a runnable");

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var2) {
                        var2.printStackTrace();
                    }
                }
            }
        };
        Thread tr = new Thread(r);
        tr.start();
    }
}


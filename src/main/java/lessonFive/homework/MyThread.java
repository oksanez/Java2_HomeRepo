package main.java.lessonFive.homework;

public class MyThread extends Thread {

    private float[] a;
    private float[] arr;
    private int position;
    private int thread;

    static final int size = 10000000;
    static final int h = size / 2;

    MyThread(float[] arr, float[] a, int position, int thread) {
        this.arr = arr;
        this.a = a;
        this.position = position;
        this.thread = thread;
    }

    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            a[i] = (float)(a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a, 0, arr, position, h);
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения потока №" + thread + ": " + (finish - start));
    }
}

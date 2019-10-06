package main.java.lessonFive.homework;

public class MyHomeWork {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        myFirstMethod();
        mySecondMethod();
    }

    private static void myFirstMethod() {

        float[] arr = arr();

        long start = System.currentTimeMillis();

        // Для каждой ячейки вычисление нового значения
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long finish = System.currentTimeMillis();

        System.out.println("Время выполнения метода вычисления нового значения массива: " + (finish - start));

    }

    private static void mySecondMethod() {
        float[] arr = arr();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        // Разбивание массива на два
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения метода разбивки массива: " + (finish - start));


        // Вычисление нового значения для массива с использованием двух потоков
        MyThread threadFirst = new MyThread(arr, a1, 0, 1);
        MyThread threadSecond = new MyThread(arr, a2, h, 2);

        threadFirst.start();
        threadSecond.start();

        try {
            threadFirst.join();
            threadSecond.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Склеивание массива в один
        start = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        finish = System.currentTimeMillis();
        System.out.println("Время выполнения метода склеивания массива: " + (finish - start));
    }

    /**
     * Заполнение массива единицами
     * @return float[]
     */
    private static float[] arr() {
        float[] arr = new float[size];
        // Заполение массива единицами
        for(int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}

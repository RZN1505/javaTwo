package ru.gb.jtwo.elesson.online;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            System.out.println(getName() + " started");
//            while(!isInterrupted());
            for (long i = 0; i < 10_000_000_000L; i++) {
                long a = i * 432;
            }
            System.out.println(getName() + " stopped");
        }
    }

    private static int a = 0;
    private static int b = 0;
    private static int c = 0;

    private synchronized static void increment() {
        synchronized (Main.class) {
            for (int i = 0; i < 1_000_000; i++) {
                a = a + 1;
                b = b + 1;
                c = c + 1;
            }
            System.out.printf("a=%d, b=%d, c=%d\n", a, b, c);
        }
    }

    private static void createArrOne(int size, float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        };

        for (int i = 0; i < size; i++) {
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        };
    }

    private static void createArrTwo(int h, float[] arr) {
        long a1t = System.currentTimeMillis();
        float[] a1 = new float[h];;
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

         Runnable r1 = new Runnable() {
            @Override
            public void run() {
                createArrOne(h, a1);
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                createArrOne(h, a2);
            }
        };
        Thread t1 = new Thread(r1, "Thread#1");
        t1.start();
        Thread t2 = new Thread(r2, "Thread#2");
        t2.start();

        try {
            t1.join();
            t2.join();
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
            long b1 = System.currentTimeMillis();
            System.out.printf("res2=%d\n",b1 - a1t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };

    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        createArrOne(size, arr);
        long b = System.currentTimeMillis();
        System.out.printf("res1=%d\n",b - a);

        createArrTwo(h, arr);
       /* new Thread(r, "Thread#1").start();
        new Thread(r, "Thread#2").start();
        new Thread(r, "Thread#3").start();*/
    }

    private static void joinExample() {
        System.out.println("main started");
        MyThread m0 = new MyThread("Thread--00");
        try {
            m0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main wants to wait for m0");
    }

    private static void interruptExample() {
        System.out.println("main started");
        MyThread m0 = new MyThread("Thread--00");
        for (long i = 0; i < 10_000_000_000L; i++) {
            long a = i * 432;
        }
        System.out.println("Main wants to close m0 thread");
        m0.interrupt();
    }

    private static void initExamples() {
        new MyThread("Thread--01");
        new MyThread("Thread--02");
        new MyThread("Thread--03");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from runnable");
            }
        };
        Thread t = new Thread(r);
        t.start();

        System.out.println(Thread.currentThread().getName());
    }
}

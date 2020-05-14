package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MainWindow extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[2];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        MainCanvas canvas = new MainCanvas(this);
        Background bg = new Background(canvas);
        initApplication();
        add(canvas);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public Sprite[] remove(Sprite[] arr, int index) {
        if (index >= 0 && index < arr.length) {
            Sprite[] copy = new Sprite[arr.length - 1];
            System.arraycopy(arr, 0, copy, 0, index);
            System.arraycopy(arr, index + 1, copy, index, arr.length - index - 1);
            return copy;
        }
        return arr;
    }

    public Sprite[] add(Sprite[] arr) {
        Sprite[] newArray = Arrays.copyOf(arr, arr.length + 1);
        newArray[newArray.length - 1]= new Ball();
        return newArray;
    }

    void onActionHandler(String action) {
        int helperVar = sprites.length;
        Sprite[] helper = sprites;
        System.out.println("helperVar ");
        System.out.println(helperVar);
        switch (action) {
            case "inc":
                sprites = add(helper);
                ;
                System.out.println(sprites.length);
                break;
            case "dec":
                sprites = remove(helper, 1);
                System.out.println(sprites.length);
                break;
            default:
                break;
        }
    }

    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private static void method1(Animal a) {
        a.name = "Barsik";
    }

    private static void sum(int a, int b) {

    }

    private static void typecastExample() {
        Cat c = new Cat("Barsik");
        Bird b = new Bird("Chijik");

        Animal[] zoo = {c, b};

        for (int i = 0; i < zoo.length; i++) {
            zoo[i].walk();

            if (zoo[i] instanceof Bird) {
                ((Bird) zoo[i]).fly();
            }
        }
    }
}

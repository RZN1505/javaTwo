package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCanvas extends JPanel {

    MainWindow gameController;
    long lastFrame;
    float deltaTime;
    Graphics globG;
    MainCanvas link;

    MainCanvas(MainWindow gameController) {
        this.gameController = gameController;
        lastFrame = System.nanoTime();
        JButton btnInc = new JButton("Increment");
        JButton btnIDec = new JButton("Decrement");

        ActionListener actionListenerInc = new btnIncActionListener();
        ActionListener actionListenerDec = new btnDecActionListener();

        btnInc.addActionListener(actionListenerInc);
        btnIDec.addActionListener(actionListenerDec);

        add(btnInc);
        add(btnIDec);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.globG = g;
        this.link = this;
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        this.deltaTime = (currentTime - lastFrame) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrame = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public class btnIncActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("inc");
            gameController.onActionHandler("inc");
        }
    }

    public class btnDecActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("dec");
            gameController.onActionHandler("dec");
        }
    }

    public int getLeft() { return 0; }

    public int getRight() { return getWidth() - 1; }

    public int getTop() { return 0; }

    public int getBottom() { return getHeight() - 1; }
}

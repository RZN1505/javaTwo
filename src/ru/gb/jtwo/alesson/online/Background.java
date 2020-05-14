package ru.gb.jtwo.alesson.online;

import java.awt.*;
import java.util.*;

public class Background {
    MainCanvas canvas;
    private Timer mTimer;

    Background(MainCanvas canvas) {
        this.canvas = canvas;

        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        TimerTask TimerTaskSetBgColor = new TimerTask() {
            @Override
            public void run() {
                Color colorPanel = new Color((int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255));
                canvas.setBackground(colorPanel);
            }
        };

        mTimer.schedule(TimerTaskSetBgColor, 1000, 5000);

    }
}

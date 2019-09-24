package main.java.lessonOne.circles;

import javax.swing.*;
import java.awt.*;

/**
 * Java. Уровень 2. Урок 1
 *
 * @version 2019-09-22
 */
public class GameCanvas extends JPanel { // JPanel позволяет рисовать

    private MainCircles gameWindow;
    private long lastFrameTime;

    GameCanvas(MainCircles gameWindow) {
        this.gameWindow = gameWindow;
        //setBackground(Color.BLUE); // фон фрейма
        this.lastFrameTime = System.nanoTime();
    }

    // Любой элемент можно перерисовывать
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float delta = (float)(currentTime - this.lastFrameTime) * 1.0E-9F;
        this.lastFrameTime = currentTime;
        try {
            Thread.sleep(17L); // ожидание для отрисовки и что бы не нагружать процессор сильно
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.gameWindow.onDrawFrame(this, g, delta);
        this.repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return this.getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return this.getHeight() - 1;
    }
}

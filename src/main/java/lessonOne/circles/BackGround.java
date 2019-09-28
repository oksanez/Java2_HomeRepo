package main.java.lessonOne.circles;

import java.awt.*;

/**
 * Java. Уровень 2. Урок 1
 *
 * @version 2019-09-22
 */
public class BackGround extends GameCanvas {

    private long lastFrameTime;
    private long delta = 0;

    private final Color color = new Color(
            (int)(Math.random() * 255.0D),
            (int)(Math.random() * 255.0D),
            (int)(Math.random() * 255.0D)
    );

    public BackGround(MainCircles gameWindow) {
        super(gameWindow);
        this.lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        delta = (currentTime - this.lastFrameTime);
        this.lastFrameTime = currentTime;
        try {
            Thread.sleep(17L); // ожидание для отрисовки и что бы не нагружать процессор сильно
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delta--; // получили дельту и это значение взяла что бы замедлить обновление фона
        if(delta == 0) {
            setColorBackground(this);
        }
    }

    private void setColorBackground(GameCanvas gameCanvas) {
        gameCanvas.setBackground(color);
    }
}

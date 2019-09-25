package main.java.lessonOne.circles;

import java.awt.*;

/**
 * Java. Уровень 2. Урок 1
 *
 * Класс BackGround с разбора домашнего задания
 *
 * @version 2019-09-24
 */
public class BackgroundFromLesson extends Sprite {

    private float time;
    private Color color;
    private final float AMPLITUDE = 127.5F;

    public BackgroundFromLesson() {
    }

    public void update(GameCanvas canvas, float deltaTime) {
        this.time += deltaTime;
        int red = Math.round(127.5F + 127.5F * (float)Math.sin((double)(this.time * 3.0F)));
        int blue = Math.round(127.5F + 127.5F * (float)Math.sin((double)(this.time * 2.0F)));
        int green = Math.round(127.5F + 127.5F * (float)Math.sin((double)this.time));
        this.color = new Color(red, green, blue);
    }

    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(this.color);
    }

}

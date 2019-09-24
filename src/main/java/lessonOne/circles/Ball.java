package main.java.lessonOne.circles;

import java.awt.*;

/**
 * Java. Уровень 2. Урок 1
 *
 * @version 2019-09-22
 */
public class Ball extends Sprite {

    private float vx = 150.0F + (float)(Math.random() * 200.0D); // скорость по x
    private float vy = 150.0F + (float)(Math.random() * 200.0D); // скорость по y
    private final Color color = new Color(
            (int)(Math.random() * 255.0D),
            (int)(Math.random() * 255.0D),
            (int)(Math.random() * 255.0D)
    );


    Ball() {
        this.halfHeight = 20.0F + (float)(Math.random() * 50.0D);
        this.halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas canvas, float deltaTime) {
        this.x += this.vx * deltaTime; // расстояние x = скорость * время
        this.y += this.vy * deltaTime;
        // что бы не вышли за пределы поля
        if (this.getLeft() < (float)canvas.getLeft()) {
            this.setLeft((float)canvas.getLeft());
            this.vx = -this.vx; // если вышли за границу, то меняем направление движения шарика
        }

        if (this.getRight() > (float)canvas.getRight()) {
            this.setRight((float)canvas.getRight());
            this.vx = -this.vx;
        }

        if (this.getTop() < (float)canvas.getTop()) {
            this.setTop((float)canvas.getTop());
            this.vy = -this.vy;
        }

        if (this.getBottom() > (float)canvas.getBottom()) {
            this.setBottom((float)canvas.getBottom());
            this.vy = -this.vy;
        }
    }

    @Override
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(this.color);
        g.fillOval((int)this.getLeft(), (int)this.getTop(), (int)this.getWidth(), (int)this.getHeight());
    }
}



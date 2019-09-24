package main.java.lessonOne.circles;

import java.awt.*;

/**
 * Java. Уровень 2. Урок 1
 * Sprite - класс, который объединяет в себе данные/методы и др,
 * что может быть общим для любого объекта (например, координаты)
 *
 * @version 2019-09-22
 */
public class Sprite {

    protected float x; // берется координата не угла с которого будет отрисовываться, а середина обекта (центр круга)
    protected float y;
    protected float halfWidth; // берется половина ширины, т.к. координата не от угла а от середины (круга), поэтому это ширина радиуса
    protected float halfHeight; // можно и полные ширину и высоту брать, здесь взято так для удобства

    public Sprite() {
    }

    protected float getLeft() {
        return this.x - this.halfWidth;
    }

    protected void setLeft(float left) {
        this.x = left + this.halfWidth;
    }

    protected float getRight() {
        return this.x + this.halfWidth;
    }

    protected void setRight(float right) {
        this.x = right - this.halfWidth;
    }

    protected float getTop() {
        return this.y - this.halfHeight;
    }

    protected void setTop(float top) {
        this.y = top + this.halfHeight;
    }

    protected float getBottom() {
        return this.y + this.halfHeight;
    }

    protected void setBottom(float bottom) {
        this.y = bottom - this.halfHeight;
    }

    protected float getWidth() {
        return 2.0F * this.halfWidth;
    }

    protected float getHeight() {
        return 2.0F * this.halfHeight;
    }

    void update(GameCanvas canvas, float deltaTime) {
    }

    void render(GameCanvas canvas, Graphics g) {
    }
}

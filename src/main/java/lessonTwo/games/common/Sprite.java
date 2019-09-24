package main.java.lessonTwo.games.common;

import java.awt.Graphics;

public class Sprite implements GameObject {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

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

    public void update(GameCanvas canvas, float deltaTime) {
    }

    public void render(GameCanvas canvas, Graphics g) {
    }
}

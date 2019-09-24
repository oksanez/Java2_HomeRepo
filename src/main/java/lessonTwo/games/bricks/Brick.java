package main.java.lessonTwo.games.bricks;

import main.java.lessonTwo.games.common.GameCanvas;
import main.java.lessonTwo.games.common.Sprite;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Sprite {
    private float vx;
    private float vy;
    private final Color color;

    Brick() {
        this.vx = 150.0F + (float)(Math.random() * 200.0D);
        this.vy = 150.0F + (float)(Math.random() * 200.0D);
        this.color = new Color((int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D));
        this.halfHeight = 20.0F + (float)(Math.random() * 50.0D);
        this.halfWidth = this.halfHeight;
    }

    Brick(int x, int y) {
        this();
        this.x = (float)x;
        this.y = (float)y;
    }

    public void update(GameCanvas canvas, float deltaTime) {
        this.x += this.vx * deltaTime;
        this.y += this.vy * deltaTime;
        if (this.getLeft() < (float)canvas.getLeft()) {
            this.setLeft((float)canvas.getLeft());
            this.vx = -this.vx;
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

    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(this.color);
        g.fillRect((int)this.getLeft(), (int)this.getTop(), (int)this.getWidth(), (int)this.getHeight());
    }
}


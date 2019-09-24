package main.java.lessonTwo.games.circles;

import main.java.lessonTwo.games.common.GameCanvas;
import main.java.lessonTwo.games.common.GameObject;

import java.awt.Color;
import java.awt.Graphics;

public class Background implements GameObject {
    private float time;
    private Color color;
    private final float AMPLITUDE = 127.5F;

    public Background() {
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

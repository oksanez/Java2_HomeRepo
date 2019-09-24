package main.java.lessonTwo.games.bricks;

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
        this.color = Color.BLUE;
    }

    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(this.color);
    }
}

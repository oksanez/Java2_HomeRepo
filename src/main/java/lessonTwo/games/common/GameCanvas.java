package main.java.lessonTwo.games.common;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GameCanvas extends JPanel {
    CanvasListener gameWindow;
    private long lastFrameTime;

    public GameCanvas(CanvasListener gameWindow) {
        this.gameWindow = gameWindow;
        this.lastFrameTime = System.nanoTime();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float delta = (float)(currentTime - this.lastFrameTime) * 1.0E-9F;
        this.lastFrameTime = currentTime;

        try {
            Thread.sleep(17L);
        } catch (InterruptedException var6) {
            throw new RuntimeException(var6);
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

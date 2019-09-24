package main.java.lessonTwo.games.bricks;

import main.java.lessonTwo.games.common.CanvasListener;
import main.java.lessonTwo.games.common.GameCanvas;
import main.java.lessonTwo.games.common.GameObject;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainBricks extends JFrame implements CanvasListener {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private GameObject[] gameObjects;
    private int gameObjectsCount;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainBricks();
            }
        });
    }

    private MainBricks() {
        this.gameObjects = new GameObject[1];
        this.gameObjectsCount = 0;
        this.setDefaultCloseOperation(3);
        this.setBounds(600, 200, 800, 600);
        this.setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) {
                    MainBricks.this.addSprite(new Brick(e.getX(), e.getY()));
                } else if (e.getButton() == 3) {
                    MainBricks.this.removeSprite();
                }

            }
        });
        this.initApplication();
        this.add(gameCanvas, "Center");
        this.setVisible(true);
    }

    private void removeSprite() {
        if (this.gameObjectsCount > 1) {
            --this.gameObjectsCount;
        }

    }

    private void addSprite(GameObject object) {
        if (this.gameObjectsCount == this.gameObjects.length) {
            GameObject[] newSprites = new GameObject[this.gameObjects.length * 2];
            System.arraycopy(this.gameObjects, 0, newSprites, 0, this.gameObjects.length);
            this.gameObjects = newSprites;
        }

        this.gameObjects[this.gameObjectsCount++] = object;
    }

    private void initApplication() {
        this.addSprite(new Background());
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        this.update(canvas, deltaTime);
        this.render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for(int i = 0; i < this.gameObjectsCount; ++i) {
            this.gameObjects[i].update(canvas, deltaTime);
        }

    }

    private void render(GameCanvas canvas, Graphics g) {
        for(int i = 0; i < this.gameObjectsCount; ++i) {
            this.gameObjects[i].render(canvas, g);
        }

    }
}

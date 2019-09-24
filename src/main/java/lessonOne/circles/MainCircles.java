package main.java.lessonOne.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Java. Уровень 2. Урок 1
 *
 * @version 2019-09-22
 */
public class MainCircles extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDHT = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Sprite[] sprites = new Sprite[1];
    private int spritesCount = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // для правильного запуска фреймфорка swing
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    MainCircles() {
//        this.sprites = new Sprite[10]; // вынесли выше в переменные
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // полное закрытие приложения по нажатию на крестик
        this.setBounds(POS_X, POS_Y, WINDOW_WIDHT, WINDOW_HEIGHT); // координаты верхней левой вершины окна, а также его ширина и высота
        this.setTitle("Circles"); // Заголовок окна
//        BackGround backGround = new BackGround(this); // мой не правильный вариант
//        this.add(backGround, BorderLayout.CENTER);
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MouseAdapter() { // для отслеживания действий мышки
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) {
                    MainCircles.this.addSprite(new Ball(e.getX(), e.getY()));
                } else if (e.getButton() == 3) {
                    MainCircles.this.removeSprite();
                }

            }
        });
        this.add(gameCanvas, BorderLayout.CENTER); // добавление компоненты на фрейм
        this.initGame();
        this.setVisible(true);
    }

    private void removeSprite() {
        if (this.spritesCount > 1) {
            --this.spritesCount;
        }
    }

    private void addSprite(Sprite s) {
        if (this.spritesCount == this.sprites.length) {
            Sprite[] newSprites = new Sprite[this.sprites.length * 2];
            System.arraycopy(this.sprites, 0, newSprites, 0, this.sprites.length);
            this.sprites = newSprites;
        }
        this.sprites[this.spritesCount++] = s;
    }

    private void initGame() {
//        for(int i = 0; i < this.sprites.length; i++) {
//            this.sprites[i] = new Ball();
        this.addSprite(new BackgroundFromLesson());
    }

    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) { // для универсальности метода добавили переменные canvas и g
        this.update(canvas, deltaTime);
        this.render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for(int i = 0; i < this.spritesCount; ++i) {
            this.sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
//        g.setColor(Color.WHITE); // нарисует кружок во фрейме
//        g.drawOval(0, 0, 100, 100);
        for(int i = 0; i < this.spritesCount; ++i) {
            this.sprites[i].render(canvas, g);
        }
    }
}
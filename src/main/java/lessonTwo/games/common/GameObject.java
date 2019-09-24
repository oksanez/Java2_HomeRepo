package main.java.lessonTwo.games.common;

import java.awt.Graphics;

public interface GameObject {
    void update(GameCanvas var1, float var2);

    void render(GameCanvas var1, Graphics var2);
}


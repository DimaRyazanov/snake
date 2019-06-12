package ru.ryazanov.snake.model.gameobjects;

import java.awt.*;

public class Section extends GameObject {
    public Section(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }


}

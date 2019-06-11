package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.constant.ModelSettings;

import java.awt.*;

public abstract class GameObject {
    private int x;
    private int y;
    private int width = ModelSettings.CELL_SIZE;
    private int height = ModelSettings.CELL_SIZE;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw(Graphics graphics);
}

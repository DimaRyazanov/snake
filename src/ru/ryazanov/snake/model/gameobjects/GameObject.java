package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.constant.ModelSettings;

import java.awt.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return x == that.x &&
                y == that.y &&
                width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }
}

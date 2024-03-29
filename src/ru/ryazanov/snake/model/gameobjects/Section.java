package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.constant.ModelSettings;

import java.awt.*;
import java.util.Objects;

public class Section {
    private int x;
    private int y;
    private int width = ModelSettings.CELL_SIZE;
    private int height = ModelSettings.CELL_SIZE;

    Section(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    private int getWidth() {
        return width;
    }

    private int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    void draw(Graphics graphics) {
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return x == section.x &&
                y == section.y &&
                width == section.width &&
                height == section.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }
}

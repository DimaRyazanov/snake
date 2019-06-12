package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.Interfaces.Drawable;

import java.awt.*;

public class Rabbit implements Drawable {
    private Section body;

    public Rabbit(int x, int y) {
        this.body = new Section(x, y);
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        body.draw(graphics);
    }
}

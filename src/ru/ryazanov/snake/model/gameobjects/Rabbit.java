package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.Interfaces.Drawable;
import ru.ryazanov.snake.model.Randomizer;

import java.awt.*;

public class Rabbit implements Drawable {
    private Section body;

    public Rabbit() {
        this.body = new Section(Randomizer.getRandomPositionX(), Randomizer.getRandomPositionY());
    }


    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        body.draw(graphics);
    }

    public Section getBody() {
        return body;
    }
}

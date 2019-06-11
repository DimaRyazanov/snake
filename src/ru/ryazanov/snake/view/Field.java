package ru.ryazanov.snake.view;

import ru.ryazanov.snake.model.gameobjects.Snake;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private SnakeView snakeView;

    public Field(SnakeView snakeView) {
        this.snakeView = snakeView;
    }

    public void paint(Graphics graphics){
        Snake snake = new Snake();
        snake.draw(graphics);
    }
}

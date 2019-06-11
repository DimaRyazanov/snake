package ru.ryazanov.snake.view;

import ru.ryazanov.snake.controller.SnakeController;

import javax.swing.*;

public class SnakeView extends JFrame {
    private SnakeController snakeController;
    private Field field;

    public SnakeView(SnakeController snakeController) {
        this.snakeController = snakeController;
    }

    public void init(){
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setTitle("Snake game");
        setVisible(true);
        setResizable(false);
    }
}

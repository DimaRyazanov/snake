package ru.ryazanov.snake.controller;

import ru.ryazanov.snake.model.SnakeModel;
import ru.ryazanov.snake.view.SnakeView;

public class SnakeController {
    private SnakeModel snakeModel;
    private SnakeView snakeView;

    public SnakeController() {
        snakeModel = new SnakeModel();
        snakeView = new SnakeView(this);
        snakeView.init();
    }
}

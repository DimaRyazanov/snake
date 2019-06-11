package ru.ryazanov.snake.controller;

import ru.ryazanov.snake.model.GameObjects;
import ru.ryazanov.snake.model.SnakeModel;
import ru.ryazanov.snake.model.constant.Direction;
import ru.ryazanov.snake.view.SnakeView;

public class SnakeController implements EventListener {
    private SnakeModel snakeModel;
    private SnakeView snakeView;

    public SnakeController() {
        snakeModel = new SnakeModel();
        snakeView = new SnakeView(this);
        snakeView.init();
        snakeView.setEventListener(this);
        snakeModel.setEventListener(this);
    }

    @Override
    public void move(Direction direction) {
        snakeModel.move(direction);
        snakeView.update();
    }

    @Override
    public void restart() {

    }

    public GameObjects getGameObjects(){
        return snakeModel.getGameObjects();
    }
}

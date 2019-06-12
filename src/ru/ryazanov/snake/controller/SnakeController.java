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
        snakeModel.restart();
        snakeView.setEventListener(this);
        snakeModel.setEventListener(this);
    }

    public void move() {
        snakeModel.move();
        snakeView.update();
    }

    @Override
    public void setDirection(Direction direction) {
        snakeModel.setDirection(direction);
    }

    @Override
    public void restart() {
        snakeModel.restart();
        snakeView.update();
    }

    public GameObjects getGameObjects(){
        return snakeModel.getGameObjects();
    }

    public int snakeLength(){
        return snakeModel.getSnakeLength();
    }
}

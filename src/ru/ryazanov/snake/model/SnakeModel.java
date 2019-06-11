package ru.ryazanov.snake.model;

import ru.ryazanov.snake.controller.EventListener;
import ru.ryazanov.snake.model.constant.Direction;

public class SnakeModel {
    private EventListener eventListener;
    private Direction direction = Direction.UP;
    private GameObjects gameObjects = new GameObjects();


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void move() {
        gameObjects.getSnake().move(direction);
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setDirection(Direction direction) {
        Direction changeDirection = Direction.canChangeDirection(direction, this.direction);
        this.direction = changeDirection;
    }
}

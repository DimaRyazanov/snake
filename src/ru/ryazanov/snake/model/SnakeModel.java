package ru.ryazanov.snake.model;

import ru.ryazanov.snake.controller.EventListener;
import ru.ryazanov.snake.model.constant.Direction;

public class SnakeModel {
    private EventListener eventListener;
    private GameObjects gameObjects = new GameObjects();

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void move(Direction direction) {
        gameObjects.getSnake().move(direction);
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }
}

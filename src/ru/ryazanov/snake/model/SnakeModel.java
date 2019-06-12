package ru.ryazanov.snake.model;

import ru.ryazanov.snake.controller.EventListener;
import ru.ryazanov.snake.model.constant.Direction;
import ru.ryazanov.snake.model.constant.ModelSettings;
import ru.ryazanov.snake.model.gameobjects.Rabbit;
import ru.ryazanov.snake.model.gameobjects.Snake;

import java.util.List;

public class SnakeModel {
    private EventListener eventListener;
    private Direction direction = Direction.UP;
    private GameObjects gameObjects = new GameObjects();


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void move() {
        Snake snake = gameObjects.getSnake();
        List<Rabbit> rabbits = gameObjects.getRabbits();
        Rabbit eatableMouse = null;
        for (Rabbit rabbit : rabbits) {
            if (rabbit.getBody().equals(snake.getHead())) {
                snake.eatMouse();
                eatableMouse = rabbit;
                break;
            }
        }
        if (eatableMouse != null)
            gameObjects.eatMouse(eatableMouse);
        snake.move(direction);
        if (!snake.isAlive())
            eventListener.restart();
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setDirection(Direction direction) {
        this.direction = Direction.canChangeDirection(direction, this.direction);
    }

    public int getSnakeLength() {
        return gameObjects.getSnake().size() - ModelSettings.START_SNAKE_SIZE;
    }

    public void restart() {
        gameObjects.restartGame();
        this.direction = Direction.UP;
    }
}

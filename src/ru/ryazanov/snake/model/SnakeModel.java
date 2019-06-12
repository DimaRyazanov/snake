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
        for (int i = 0; i < rabbits.size(); i++) {
            if (rabbits.get(i).getBody().equals(snake.getHead())){
                snake.eatMouse();
                gameObjects.eatMouse(rabbits.get(i));
            }
        }
        snake.move(direction);
        if (!snake.isAlive())
            eventListener.restart();
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setDirection(Direction direction) {
        Direction changeDirection = Direction.canChangeDirection(direction, this.direction);
        this.direction = changeDirection;
    }

    public int getSnakeLength() {
        return gameObjects.getSnake().size() - ModelSettings.START_SNAKE_SIZE;
    }

    public void restart() {
        gameObjects.restartGame();
        this.direction = Direction.UP;
    }
}

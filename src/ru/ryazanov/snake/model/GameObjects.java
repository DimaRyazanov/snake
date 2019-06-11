package ru.ryazanov.snake.model;

import ru.ryazanov.snake.model.gameobjects.Snake;

public class GameObjects {
    private Snake snake;

    public GameObjects() {
        load();
    }

    public void load(){
        snake = new Snake();
    }

    public Snake getSnake() {
        return snake;
    }
}

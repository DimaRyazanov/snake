package ru.ryazanov.snake.controller;

import ru.ryazanov.snake.model.constant.Direction;

public interface EventListener {
    void move(Direction direction);
    void restart();
}

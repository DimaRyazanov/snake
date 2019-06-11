package ru.ryazanov.snake;

import ru.ryazanov.snake.controller.Runner;
import ru.ryazanov.snake.controller.SnakeController;

public class Application {
    public static void main(String[] args) {
        Runner runner = new Runner(new SnakeController());
        runner.start();
    }
}

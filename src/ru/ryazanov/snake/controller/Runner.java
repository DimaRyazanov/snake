package ru.ryazanov.snake.controller;

public class Runner extends Thread {
    private SnakeController snakeController;

    public Runner(SnakeController snakeController) {
        this.snakeController = snakeController;
    }

    @Override
    public void run() {
        try {
            while (true){
                snakeController.move();
                sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

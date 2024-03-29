package ru.ryazanov.snake.controller;

public class Runner extends Thread {
    private SnakeController snakeController;
    private boolean playGame = true;

    public Runner(SnakeController snakeController) {
        this.snakeController = snakeController;
    }

    @Override
    public void run() {
        try {
            while (playGame){
                snakeController.move();
                int speed = snakeController.snakeLength() > ControllerSettings.MAX_SIZE_SNAKE_SPEED ?
                            ControllerSettings.START_SNAKE_SPEED - ControllerSettings.MAX_SIZE_SNAKE_SPEED * ControllerSettings.SPEED_INCREASE :
                            ControllerSettings.START_SNAKE_SPEED - snakeController.snakeLength() * ControllerSettings.SPEED_INCREASE;
                sleep(speed);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopGame(){
        playGame = false;
    }
}

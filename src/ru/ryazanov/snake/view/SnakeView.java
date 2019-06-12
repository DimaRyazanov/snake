package ru.ryazanov.snake.view;

import ru.ryazanov.snake.controller.EventListener;
import ru.ryazanov.snake.controller.SnakeController;
import ru.ryazanov.snake.model.GameObjects;
import ru.ryazanov.snake.model.constant.ModelSettings;

import javax.swing.*;

public class SnakeView extends JFrame {
    private SnakeController snakeController;
    private GameField gameField;

    public SnakeView(SnakeController snakeController) {
        this.snakeController = snakeController;
    }

    public void init(){
        gameField = new GameField(this);
        add(gameField);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int size = ModelSettings.GAME_FIELD_SIZE;
        setSize(size, size);
        setLocationRelativeTo(null);
        setTitle("Snake game");
        setVisible(true);
        setResizable(false);
    }

    public void update(){
        gameField.repaint();
    }

    public void setEventListener(EventListener eventListener){
        gameField.setEventListener(eventListener);
    }

    public GameObjects getGameObjects(){
        return snakeController.getGameObjects();
    }
}

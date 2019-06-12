package ru.ryazanov.snake.view;

import ru.ryazanov.snake.controller.EventListener;
import ru.ryazanov.snake.model.constant.Direction;
import ru.ryazanov.snake.model.gameobjects.Rabbit;
import ru.ryazanov.snake.model.gameobjects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class GameField extends JPanel {
    private SnakeView snakeView;
    private EventListener eventListener;

    public GameField(SnakeView snakeView) {
        this.snakeView = snakeView;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, 0, snakeView.getWidth(), snakeView.getHeight());

        Snake snake = snakeView.getGameObjects().getSnake();
        snake.draw(graphics);

        List<Rabbit> rabbits = snakeView.getGameObjects().getRabbits();

        for (Rabbit rabbit :
                rabbits) {
            rabbit.draw(graphics);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case VK_LEFT:
                case VK_A:
                    eventListener.setDirection(Direction.LEFT);
                    break;
                case VK_RIGHT:
                case VK_D:
                    eventListener.setDirection(Direction.RIGHT);
                    break;
                case VK_UP:
                case VK_W:
                    eventListener.setDirection(Direction.UP);
                    break;
                case VK_DOWN:
                case VK_S:
                    eventListener.setDirection(Direction.DOWN);
                    break;
            }
        }
    }
}

package ru.ryazanov.snake.view;

import ru.ryazanov.snake.controller.EventListener;
import ru.ryazanov.snake.model.constant.Direction;
import ru.ryazanov.snake.model.gameobjects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
                    eventListener.move(Direction.LEFT);
                    break;
                case VK_RIGHT:
                case VK_D:
                    eventListener.move(Direction.RIGHT);
                    break;
                case VK_UP:
                case VK_W:
                    eventListener.move(Direction.UP);
                    break;
                case VK_DOWN:
                case VK_S:
                    eventListener.move(Direction.DOWN);
                    break;
            }
        }
    }
}

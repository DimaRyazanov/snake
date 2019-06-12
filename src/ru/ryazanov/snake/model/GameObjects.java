package ru.ryazanov.snake.model;

import ru.ryazanov.snake.model.gameobjects.Rabbit;
import ru.ryazanov.snake.model.gameobjects.Snake;

import java.util.ArrayList;
import java.util.List;

public class GameObjects {
    private Snake snake;
    private List<Rabbit> rabbits;

    public GameObjects() {
        restartGame();
    }

    public void restartGame(){
        snake = new Snake();
        rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(300, 480));
        rabbits.add(new Rabbit(80, 120));
    }

    public Snake getSnake() {
        return snake;
    }

    public List<Rabbit> getRabbits() {
        return rabbits;
    }
}

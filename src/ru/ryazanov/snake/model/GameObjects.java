package ru.ryazanov.snake.model;

import ru.ryazanov.snake.model.gameobjects.Rabbit;
import ru.ryazanov.snake.model.gameobjects.Section;
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
        rabbits.add(new Rabbit());
        rabbits.add(new Rabbit());
    }

    public Snake getSnake() {
        return snake;
    }

    public List<Rabbit> getRabbits() {
        return rabbits;
    }

    public void eatMouse(Rabbit rabbit) {
        Rabbit newRabbit = new Rabbit();
        if (checkSnake(newRabbit) || checkAnotherRabbit(newRabbit))
            eatMouse(rabbit);

        rabbits.remove(rabbit);
        rabbits.add(newRabbit);
    }

    private boolean checkAnotherRabbit(Rabbit newRabbit) {
        return false;
    }

    private boolean checkSnake(Rabbit newRabbit) {
        for (Section snakeSection :
                snake.getSections()) {
            if (snakeSection.equals(newRabbit.getBody()))
                return true;
        }
        return false;
    }
}

package ru.ryazanov.snake.model;

import ru.ryazanov.snake.model.constant.ModelSettings;

public class Randomizer {
    public static int getRandomPositionX(){
        return (int) (Math.random() * ((ModelSettings.GAME_FIELD_SIZE - ModelSettings.CELL_SIZE) / ModelSettings.CELL_SIZE)) * ModelSettings.CELL_SIZE;
    }

    public static int getRandomPositionY(){
        return (int) (Math.random() * ((ModelSettings.GAME_FIELD_SIZE - ModelSettings.CELL_SIZE * 2) / ModelSettings.CELL_SIZE)) * ModelSettings.CELL_SIZE;
    }
}

package ru.ryazanov.snake.model.constant;

public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Direction canChangeDirection(Direction direction, Direction oldDirection) {
        switch (oldDirection){
            case LEFT:
                if (direction == RIGHT) return LEFT;
                break;
            case RIGHT:
                if (direction == LEFT) return RIGHT;
                break;
            case UP:
                if (direction == DOWN) return UP;
                break;
            case DOWN:
                if (direction == UP) return DOWN;
                break;
        }

        return direction;
    }
}

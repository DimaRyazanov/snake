package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.Interfaces.Drawable;
import ru.ryazanov.snake.model.Interfaces.Moveble;
import ru.ryazanov.snake.model.constant.Direction;
import ru.ryazanov.snake.model.constant.ModelSettings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake implements Moveble, Drawable {
    private List<Section> sections;
    private boolean isAlive = true;
    private boolean eatMouse = false;

    public Snake() {
        sections = new ArrayList<>();

        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y));

        for (int i = 1; i < ModelSettings.START_SNAKE_SIZE; i++) {
            sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y + ModelSettings.CELL_SIZE * i));
        }
    }

    public void move(Direction direction) {
        Section head = sections.get(0);
        switch (direction) {
            case LEFT:
                sections.add(0, new Section(head.getX() - ModelSettings.CELL_SIZE, head.getY()));
                break;
            case RIGHT:
                sections.add(0, new Section(head.getX() + ModelSettings.CELL_SIZE, head.getY()));
                break;
            case UP:
                sections.add(0, new Section(head.getX(), head.getY() - ModelSettings.CELL_SIZE));
                break;
            case DOWN:
                sections.add(0, new Section(head.getX(), head.getY() + ModelSettings.CELL_SIZE));
                break;
        }

        if (!eatMouse)
            sections.remove(sections.size() - 1);
        else
            eatMouse = false;

        checkBorders(sections.get(0));
        checkBodySnake();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        sections.get(0).draw(graphics);
        graphics.setColor(Color.orange);
        for (int i = 1; i < sections.size(); i++) {
            sections.get(i).draw(graphics);
        }
    }

    public int size(){
        return sections.size();
    }

    private void checkBorders(Section headSnake){
        if (headSnake.getX() < 0 || headSnake.getY() < 0
                || headSnake.getX() > (ModelSettings.GAME_FIELD_SIZE - ModelSettings.CELL_SIZE * 2)
                || headSnake.getY() > (ModelSettings.GAME_FIELD_SIZE - ModelSettings.CELL_SIZE * 3))
            isAlive = false;
    }

    private void checkBodySnake(){
        Section head = sections.get(0);

        for (int i = 1; i < sections.size(); i++) {
            if (head.equals(sections.get(i)))
                isAlive = false;
        }
    }
    public boolean isAlive() {
        return isAlive;
    }

    public Section getHead(){
        return sections.get(0);
    }

    public void eatMouse(){
        eatMouse = true;
    }

    public List<Section> getSections() {
        return sections;
    }
}

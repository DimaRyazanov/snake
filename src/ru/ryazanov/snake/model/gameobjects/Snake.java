package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.Moveble;
import ru.ryazanov.snake.model.constant.Direction;
import ru.ryazanov.snake.model.constant.ModelSettings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake implements Moveble {
    private List<Section> sections;

    public Snake() {
        sections = new ArrayList<>();
        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y));
        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y + ModelSettings.CELL_SIZE));
        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y + ModelSettings.CELL_SIZE * 2));
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

        sections.remove(sections.size() - 1);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        sections.get(0).draw(graphics);
        graphics.setColor(Color.orange);
        for (int i = 1; i < sections.size(); i++) {
            sections.get(i).draw(graphics);
        }
    }
}

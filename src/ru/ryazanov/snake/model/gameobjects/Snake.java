package ru.ryazanov.snake.model.gameobjects;

import ru.ryazanov.snake.model.constant.ModelSettings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Section> sections;

    public Snake() {
        sections = new ArrayList<>();
        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y));
        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y + ModelSettings.CELL_SIZE));
        sections.add(new Section(ModelSettings.START_POSITION_X, ModelSettings.START_POSITION_Y + ModelSettings.CELL_SIZE * 2));
    }

    public void move(){

    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.red);
        sections.get(0).draw(graphics);
        graphics.setColor(Color.orange);
        for (int i = 1; i < sections.size(); i++) {
            sections.get(i).draw(graphics);
        }
    }
}

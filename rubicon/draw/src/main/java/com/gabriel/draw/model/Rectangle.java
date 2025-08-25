package com.gabriel.draw.model;

import com.gabriel.draw.service.RectangleRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

@Data
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Point topLeft, int width, int height) {
        super(topLeft);
        this.width = width;
        this.height = height;
        this.setColor(Color.GREEN);
        this.setRendererService(new RectangleRendererService());
    }
}
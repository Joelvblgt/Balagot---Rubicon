package com.gabriel.draw.model;

import com.gabriel.draw.service.EllipseRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

@Data
public class Ellipse extends Shape {
    private int width;
    private int height;

    public Ellipse(Point center, int width, int height) {
        super(center);
        this.width = width;
        this.height = height;
        this.setColor(Color.BLUE);
        this.setRendererService(new EllipseRendererService());
    }
}
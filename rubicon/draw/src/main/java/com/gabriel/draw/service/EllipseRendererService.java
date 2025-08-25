package com.gabriel.draw.service;

import com.gabriel.draw.model.Ellipse;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;

public class EllipseRendererService implements RendererService {
    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Ellipse ellipse = (Ellipse) shape;
        if (xor) {
            g.setXORMode(shape.getColor());
        } else {
            g.setColor(shape.getColor());
        }
        g.drawOval(ellipse.getLocation().x, ellipse.getLocation().y,
                ellipse.getWidth(), ellipse.getHeight());
    }
}

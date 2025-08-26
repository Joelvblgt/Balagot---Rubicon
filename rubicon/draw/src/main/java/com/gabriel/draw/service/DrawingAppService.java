package com.gabriel.draw.service;

import com.gabriel.draw.model.Line;
import com.gabriel.draw.model.Ellipse;
import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.service.MoverService;
import com.gabriel.drawfx.service.ScalerService;

import java.awt.*;

public class  DrawingAppService implements AppService {
    final private Drawing drawing;
    private Color color;
    Color fill;
    private ShapeMode shapeMode = ShapeMode.Line;
    private DrawMode drawMode = DrawMode.Idle;

    MoverService moverService;
    ScalerService scalerService;

    public DrawingAppService(){
        drawing = new Drawing();
        moverService = new MoverService();
        scalerService = new ScalerService();
    }

    @Override
    public ShapeMode getShapeMode() {
        return shapeMode;
    }

    @Override
    public void setShapeMode(ShapeMode shapeMode) {
        this.shapeMode = shapeMode;
    }

    @Override
    public DrawMode getDrawMode() {
        return drawMode;
    }

    @Override
    public void setDrawMode(DrawMode drawMode) {
        this.drawMode = drawMode;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getFill() {
        return fill;
    }

    @Override
    public void setFill(Color color) {
        this.fill = fill;
    }

    @Override
    public void move(Shape shape, Point newLoc) {
        moverService.move(shape, newLoc);}

    @Override
    public void scale(Shape shape, Point newEnd) {
        if (shape instanceof com.gabriel.draw.model.Line) {
            shape.setEnd(newEnd);
        } else if (shape instanceof com.gabriel.draw.model.Ellipse) {
            com.gabriel.draw.model.Ellipse ellipse = (com.gabriel.draw.model.Ellipse) shape;
            Point start = shape.getLocation(); // This is your original click point

            // Calculate the bounding rectangle that contains both start and end points
            int x = Math.min(start.x, newEnd.x);      // Leftmost point
            int y = Math.min(start.y, newEnd.y);      // Topmost point
            int width = Math.abs(newEnd.x - start.x); // Distance between points
            int height = Math.abs(newEnd.y - start.y);

            // Update the ellipse position and size
            ellipse.setLocation(new Point(x, y));
            ellipse.setWidth(width);
            ellipse.setHeight(height);
        } else if (shape instanceof com.gabriel.draw.model.Rectangle) {
            com.gabriel.draw.model.Rectangle rectangle = (com.gabriel.draw.model.Rectangle) shape;
            Point start = shape.getLocation();

            int x = Math.min(start.x, newEnd.x);
            int y = Math.min(start.y, newEnd.y);
            int width = Math.abs(newEnd.x - start.x);
            int height = Math.abs(newEnd.y - start.y);

            rectangle.setLocation(new Point(x, y));
            rectangle.setWidth(width);
            rectangle.setHeight(height);
        }
    }

    @Override
    public void create(Shape shape) {
        this.drawing.getShapes().add(shape);
    }

    @Override
    public void close() {
        System.exit(0);
    }

    @Override
    public Object getModel() {
        return drawing;
    }
}

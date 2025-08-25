package com.gabriel.draw.model;


import com.gabriel.draw.service.LineRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;


@Data
public class Line extends Shape {

    public Line(Point start, Point end){
        super(start); // calls shape instructor with start point
        this.setEnd(end); //sets the end point of the line
        this.setColor(Color.RED); //default color is red
        this.setRendererService(new LineRendererService()); //sets how to draw this line
    }
}

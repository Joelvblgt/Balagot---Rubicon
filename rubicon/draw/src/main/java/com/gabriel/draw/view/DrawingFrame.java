package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingFrame extends JFrame {

    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        //  drawing view
        DrawingView drawingView = new DrawingView(appService);

        //  toolbar with shape selection buttons
        JToolBar toolBar = new JToolBar("Shape Tools");
        toolBar.setFloatable(false);

        // Line button
        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appService.setShapeMode(ShapeMode.Line);
            }
        });

        // Ellipse button
        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appService.setShapeMode(ShapeMode.Ellipse);
            }
        });

        // Rectangle button
        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appService.setShapeMode(ShapeMode.Rectangle);
            }
        });

        // Add buttons to toolbar
        toolBar.add(lineButton);
        toolBar.add(ellipseButton);
        toolBar.add(rectangleButton);

        // Set up the layout
        this.setLayout(new BorderLayout());
        this.add(toolBar, BorderLayout.NORTH);
        this.add(drawingView, BorderLayout.CENTER);
    }
}
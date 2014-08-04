package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.ui;

import com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.logical.FeelerSensorComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 11:11 PM
 */
public class GamePanel extends JPanel implements KeyListener{

    private Logger logger = Logger.getLogger(getClass().getName());

    private CarComponent carComponent;
    private RoadComponent roadComponent;
    private FeelerSensorComponent feelerSensorComponent;


    public GamePanel(){
        setLayout(null);

        try {
            roadComponent = new RoadComponent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        feelerSensorComponent = new FeelerSensorComponent(this);

        carComponent = new CarComponent();
        carComponent.setBounds(
                roadComponent.getInitialLeftLane() + roadComponent.getRoadPieceWidth() * 3,
                roadComponent.getInitialBottomLane() + (roadComponent.getRoadPieceHeight() - carComponent.getHeight())/2,
                carComponent.getWidth(),
                carComponent.getHeight()
        );


        add(carComponent);
        feelerSensorComponent.initFeelerWires(carComponent);

        roadComponent.addToContentPanel(this);
        add(new BackgroundPanel());

        this.addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLACK);

        if(this.feelerSensorComponent.getLeftSideFeelerWire() != null){
            g2.draw(feelerSensorComponent.getLeftSideFeelerWire());
        }

        if(this.feelerSensorComponent.getRightSideFeelerWire() != null){
            g2.draw(feelerSensorComponent.getRightSideFeelerWire());
        }

        if(this.feelerSensorComponent.getFrontsideFeelerWire() != null){
            g2.draw(feelerSensorComponent.getFrontsideFeelerWire());
        }

        if(this.feelerSensorComponent.getBacksideFeelerWire() != null){
            g2.draw(feelerSensorComponent.getBacksideFeelerWire());
        }

        if(this.feelerSensorComponent.getFrontRightDiagonalFeelerWire() != null){
            g2.draw(feelerSensorComponent.getFrontRightDiagonalFeelerWire());
        }

        if(this.feelerSensorComponent.getFrontLeftDiagonalFeelerWire() != null){
            g2.draw(feelerSensorComponent.getFrontLeftDiagonalFeelerWire());
        }

        if(this.feelerSensorComponent.getBackRightDiagonalFeelerWire() != null){
            g2.draw(feelerSensorComponent.getBackRightDiagonalFeelerWire());
        }

        if(this.feelerSensorComponent.getBackLeftDiagonalFeelerWire() != null){
            g2.draw(feelerSensorComponent.getBackLeftDiagonalFeelerWire());
        }
    }

    //-----------------------------------
    //          KeyListener Methods
    //-----------------------------------

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        this.carComponent.keyTyped(keyEvent);
        this.feelerSensorComponent.initFeelerWires(carComponent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.carComponent.keyPressed(keyEvent);
        this.feelerSensorComponent.initFeelerWires(carComponent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
//        this.carComponent.keyReleased(keyEvent);
//        this.feelerSensorComponent.updateFeelerWires(carComponent);
    }
}

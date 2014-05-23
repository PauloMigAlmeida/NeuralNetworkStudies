package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 11:11 PM
 */
public class GamePanel extends JPanel implements KeyListener{


    private CarComponent carComponent;
    private RoadComponent roadComponent;


    public GamePanel(){
        setLayout(null);

        roadComponent = new RoadComponent();

        carComponent = new CarComponent();

        carComponent.setBounds(
                roadComponent.getInitialLeftLane() + roadComponent.getRoadPieceWidth() * 3,
                roadComponent.getInitialBottomLane() + (roadComponent.getRoadPieceHeight() - carComponent.getHeight())/2,
                carComponent.getWidth(),
                carComponent.getHeight()
        );

        add(carComponent);

        roadComponent.addToContentPanel(this);


        add(new BackgroundPanel());

        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        this.carComponent.keyTyped(keyEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.carComponent.keyPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.carComponent.keyReleased(keyEvent);
    }
}

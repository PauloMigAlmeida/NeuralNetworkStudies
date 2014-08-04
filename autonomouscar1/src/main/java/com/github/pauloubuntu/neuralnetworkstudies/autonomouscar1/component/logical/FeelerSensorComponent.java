package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.logical;

import com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.ui.CarComponent;

import javax.swing.*;
import java.awt.geom.Line2D;

/**
 * Project: autonomouscar1
 * User: paulo.rodenas
 * Date: 8/3/14
 * Time: 10:25 PM
 */
public class FeelerSensorComponent {

    private JPanel parentPanel;
    private Line2D backsideFeelerWire,rightDiagonalFeelerWire,leftDiagonalFeelerWire, frontsideFeelerWire;

    public FeelerSensorComponent(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public void updateFeelerWires(CarComponent carComponent){
            this.backsideFeelerWire = new Line2D.Double(
                    carComponent.getX() + carComponent.getWidth() - 1,
                    carComponent.getY() - carComponent.getHeight(),
                    (carComponent.getX() + carComponent.getWidth() - 1)  + (carComponent.getX() + carComponent.getWidth() - 1) * Math.cos(Math.toRadians(carComponent.getAngle())) ,
                    (carComponent.getY() + carComponent.getHeight() * 2)  + (carComponent.getY() + carComponent.getHeight() * 2) * Math.sin(Math.toRadians(carComponent.getAngle()))
            );


        //They are working properly, the reason why I've commented them is because I need to implement rotating by angle to make it 'follow' the car component
//            this.frontsideFeelerWire = new Line2D.Double(
//                    carComponent.getX() - carComponent.getWidth(),
//                    carComponent.getY() + carComponent.getHeight() / 2 ,
//                    carComponent.getX() + carComponent.getWidth(),
//                    carComponent.getY() + carComponent.getHeight() / 2
//            );
//
//            this.rightDiagonalFeelerWire = new Line2D.Double(
//                    carComponent.getX() - carComponent.getWidth(),
//                    carComponent.getY() - carComponent.getHeight() ,
//                    carComponent.getX() + carComponent.getWidth(),
//                    carComponent.getY() + carComponent.getHeight() / 2
//            );
//
//            this.leftDiagonalFeelerWire = new Line2D.Double(
//                    carComponent.getX() - carComponent.getWidth(),
//                    carComponent.getY() + carComponent.getHeight() * 2 ,
//                    carComponent.getX() + carComponent.getWidth(),
//                    carComponent.getY() + carComponent.getHeight() /2
//            );
        parentPanel.repaint();

    }

    public Line2D getBacksideFeelerWire() {
        return backsideFeelerWire;
    }

    public Line2D getRightDiagonalFeelerWire() {
        return rightDiagonalFeelerWire;
    }

    public Line2D getLeftDiagonalFeelerWire() {
        return leftDiagonalFeelerWire;
    }

    public Line2D getFrontsideFeelerWire() {
        return frontsideFeelerWire;
    }
}

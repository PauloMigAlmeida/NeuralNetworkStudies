package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.logical;

import com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.ui.CarComponent;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.logging.Logger;

/**
 * Project: autonomouscar1
 * User: paulo.rodenas
 * Date: 8/3/14
 * Time: 10:25 PM
 */
public class FeelerSensorComponent {

    private Logger logger = Logger.getLogger(getClass().getName());

    private JPanel parentPanel;
    private Line2D leftSideFeelerWire,rightSideFeelerWire, frontRightDiagonalFeelerWire, frontLeftDiagonalFeelerWire, frontsideFeelerWire, backsideFeelerWire, backRightDiagonalFeelerWire, backLeftDiagonalFeelerWire;

    public FeelerSensorComponent(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public void initFeelerWires(CarComponent carComponent){

            this.rightSideFeelerWire = new Line2D.Double(
                    (carComponent.getX() + carComponent.getWidth()  / 2),
                    (carComponent.getY() - carComponent.getHeight()),
                    (carComponent.getX() + carComponent.getWidth()  / 2 ) ,
                    (carComponent.getY() + carComponent.getHeight() / 2)
            );

            this.leftSideFeelerWire = new Line2D.Double(
                    (carComponent.getX() + carComponent.getWidth()  / 2),
                    (carComponent.getY() + carComponent.getHeight() / 2),
                    (carComponent.getX() + carComponent.getWidth()  / 2 ) ,
                    (carComponent.getY() + carComponent.getHeight() * 2)
            );

            this.frontsideFeelerWire = new Line2D.Double(
                    carComponent.getX() - carComponent.getWidth(),
                    carComponent.getY() + carComponent.getHeight() / 2 ,
                    carComponent.getX() + carComponent.getWidth() / 2,
                    carComponent.getY() + carComponent.getHeight() / 2
            );

            this.backsideFeelerWire = new Line2D.Double(
                    carComponent.getX() - carComponent.getWidth() / 2,
                    carComponent.getY() + carComponent.getHeight() / 2 ,
                    carComponent.getX() + carComponent.getWidth() * 2,
                    carComponent.getY() + carComponent.getHeight() / 2
            );

            this.frontRightDiagonalFeelerWire = new Line2D.Double(
                    carComponent.getX() - carComponent.getWidth(),
                    carComponent.getY() - carComponent.getHeight() ,
                    carComponent.getX() + carComponent.getWidth() / 2,
                    carComponent.getY() + carComponent.getHeight() / 2
            );

            this.backRightDiagonalFeelerWire = new Line2D.Double(
                    carComponent.getX() + carComponent.getWidth() / 2,
                    carComponent.getY() + carComponent.getHeight() / 2 ,
                    carComponent.getX() + carComponent.getWidth() * 2,
                    carComponent.getY() - carComponent.getHeight()
            );

            this.frontLeftDiagonalFeelerWire = new Line2D.Double(
                    carComponent.getX() - carComponent.getWidth(),
                    carComponent.getY() + carComponent.getHeight() * 2 ,
                    carComponent.getX() + carComponent.getWidth() / 2,
                    carComponent.getY() + carComponent.getHeight() /2
            );

            this.backLeftDiagonalFeelerWire = new Line2D.Double(
                    carComponent.getX() + carComponent.getWidth() / 2,
                    carComponent.getY() + carComponent.getHeight() / 2 ,
                    carComponent.getX() + carComponent.getWidth() * 2,
                    carComponent.getY() + carComponent.getHeight() * 2
            );
        parentPanel.repaint();

    }

    public Line2D getBackRightDiagonalFeelerWire() {
        return backRightDiagonalFeelerWire;
    }

    public Line2D getBackLeftDiagonalFeelerWire() {
        return backLeftDiagonalFeelerWire;
    }

    public Line2D getBacksideFeelerWire() {
        return backsideFeelerWire;
    }

    public Line2D getLeftSideFeelerWire() {
        return leftSideFeelerWire;
    }

    public Line2D getRightSideFeelerWire() {
        return rightSideFeelerWire;
    }

    public Line2D getFrontRightDiagonalFeelerWire() {
        return frontRightDiagonalFeelerWire;
    }

    public Line2D getFrontLeftDiagonalFeelerWire() {
        return frontLeftDiagonalFeelerWire;
    }

    public Line2D getFrontsideFeelerWire() {
        return frontsideFeelerWire;
    }
}

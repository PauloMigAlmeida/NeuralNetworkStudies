package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Project: autonomouscar1
 * User: paulo.rodenas
 * Date: 5/23/14
 * Time: 5:01 PM
 */
public class CarComponent extends AbstractImagePanel implements KeyListener{

    public CarComponent() {
        super("/car.png");
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("keyPressed");
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            Rectangle rect = this.getBounds();
            this.setLocation(rect.x - 5, rect.y);
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            Rectangle rect = this.getBounds();
            this.setLocation(rect.x + 5, rect.y);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

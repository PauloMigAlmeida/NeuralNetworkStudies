package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Project: autonomouscar1
 * User: paulo.rodenas
 * Date: 5/23/14
 * Time: 5:01 PM
 */

abstract class AbstractImagePanel extends JPanel{
    protected Image backgroundImage;

    public AbstractImagePanel(String imagePath){
        try {
            backgroundImage = ImageIO.read(this.getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(backgroundImage != null){
            g.drawImage(backgroundImage,0,0,null);
        }
    }

    @Override
    public int getWidth() {
        if(backgroundImage != null){
            return backgroundImage.getWidth(null);
        }
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        if(backgroundImage != null){
            return backgroundImage.getHeight(null);
        }
        return super.getHeight();
    }
}

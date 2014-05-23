package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 11:25 PM
 */
public class RoadComponent extends JPanel {

    private Image backgroundImage;


    public RoadComponent(){
        try {
            backgroundImage = ImageIO.read(this.getClass().getResourceAsStream("/road_texture.jpg"));
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

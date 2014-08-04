package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/25/14
 * Time: 12:05 PM
 */
public abstract class AbstractRotateImagePanel extends JPanel {
    protected BufferedImage backgroundImage;
    protected BufferedImage drawImage;
    private GraphicsConfiguration gc ;
    private int angle;
    private boolean useDefaultPaintComponent;

    protected AbstractRotateImagePanel(BufferedImage backgroundImage, int angle, boolean useDefaultPaintComponent) {
        this.backgroundImage = backgroundImage;
        this.angle = angle;
        this.useDefaultPaintComponent = useDefaultPaintComponent;
        gc = getDefaultConfiguration();
        drawImage = tilt(backgroundImage,Math.toRadians(angle),gc);
    }

    //-----------------------------------
    //          JPanel Methods
    //-----------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.useDefaultPaintComponent){
            Graphics2D g2d = (Graphics2D) g;
            Dimension size = getSize();
            int w = (int) size.getWidth(), h = (int) size.getHeight();
            g2d.drawImage(drawImage, (w - drawImage.getWidth())/2,(h - drawImage.getHeight())/2, null);
        }
    }

    @Override
    public int getWidth() {
        return drawImage.getWidth();
    }

    @Override
    public int getHeight() {
        return drawImage.getHeight();
    }

    //-----------------------------------
    //          UI Methods
    //-----------------------------------

    protected static BufferedImage tilt(BufferedImage image, double angle, GraphicsConfiguration gc) {
//        System.out.println("Angle is : " + angle);
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(angle, w/2, h/2);
        g.drawRenderedImage(image, null);
        g.setColor(Color.WHITE);
        g.drawLine(0,0,0,image.getHeight());
        return result;
    }

    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
}

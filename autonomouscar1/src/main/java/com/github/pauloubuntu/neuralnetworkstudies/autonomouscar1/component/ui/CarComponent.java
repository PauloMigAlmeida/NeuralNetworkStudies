package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Project: autonomouscar1
 * User: paulo.rodenas
 * Date: 5/23/14
 * Time: 5:01 PM
 */
public class CarComponent extends JPanel implements KeyListener {
    private BufferedImage backgroundImage;
    private BufferedImage drawImage;

    public static final int VELOCITY = 10;
    public static final int STEERING_WHEEL_FACTOR = 2;
    private int angle;
    private GraphicsConfiguration gc ;

    public CarComponent() {
        gc = getDefaultConfiguration();
//        this.setOpaque(false);
        setBackground(Color.RED);
        try {
            backgroundImage = ImageIO.read(this.getClass().getResourceAsStream("/car.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.angle = 0;
        drawImage = tilt(backgroundImage,Math.toRadians(angle),gc);
    }

    public int getAngle() {
        return angle;
    }

    //-----------------------------------
    //          JPanel Methods
    //-----------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension size = getSize();
        int w = (int) size.getWidth(), h = (int) size.getHeight();
        g2d.drawImage(drawImage, (w - drawImage.getWidth())/2,(h - drawImage.getHeight())/2, null);
    }

    @Override
    public int getWidth() {
        if(backgroundImage != null){
            return Math.max(backgroundImage.getWidth(),backgroundImage.getWidth());
        }
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        if(backgroundImage != null){
            return Math.max(backgroundImage.getWidth(),backgroundImage.getWidth());
        }
        return super.getHeight();
    }

    //-----------------------------------
    //          UI Methods
    //-----------------------------------

    public static BufferedImage tilt(BufferedImage image, double angle, GraphicsConfiguration gc) {
//        System.out.println("Angle is : " + angle);
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(angle, w/2, h/2);
        g.drawRenderedImage(image, null);
        return result;
    }

    public static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }

    //-----------------------------------
    //          KeyListener Methods
    //-----------------------------------

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        Rectangle rect = this.getBounds();
        int xDirection = 0, yDirection = 0;
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            xDirection = rect.x - (int) (VELOCITY * Math.cos(Math.toRadians(angle)));
            yDirection = rect.y -(int) (VELOCITY * Math.sin(Math.toRadians(angle)));
            this.setLocation(xDirection, yDirection);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            // It makes no difference on calculations but it's cleaner to read when we're debugging it
            if(this.angle - 3 < 0)
            {
                this.angle = 360;
            }
            this.angle -= 3 * STEERING_WHEEL_FACTOR;
            drawImage = tilt(backgroundImage,Math.toRadians(angle),gc);
            xDirection = rect.x - (int) (VELOCITY * Math.cos(Math.toRadians(angle)));
            yDirection = rect.y -(int) (VELOCITY * Math.sin(Math.toRadians(angle)));
            this.setLocation(xDirection, yDirection);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            // It makes no difference on calculations but it's cleaner to read when we're debugging it
            if(this.angle + 3 > 360)
            {
                this.angle = 0;
            }
            this.angle += 3 * STEERING_WHEEL_FACTOR;
            drawImage = tilt(backgroundImage,Math.toRadians(angle),gc);
            xDirection = rect.x - (int) (VELOCITY * Math.cos(Math.toRadians(angle)));
            yDirection = rect.y -(int) (VELOCITY * Math.sin(Math.toRadians(angle)));
            this.setLocation(xDirection, yDirection);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            xDirection = rect.x + (int) (VELOCITY * Math.cos(Math.toRadians(angle)));
            yDirection = rect.y + (int) (VELOCITY * Math.sin(Math.toRadians(angle)));
            this.setLocation(xDirection, yDirection);
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }



}

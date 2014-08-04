package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.gui;

import com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.ui.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 10:54 PM
 */
public class FormPrincipal extends JFrame implements KeyListener{
    private JPanel bottomPanel;
    private GamePanel centerPanel;
    private JLabel errorValueLabel, iterationValueLabel, errorLabel, iterationLabel;


    public FormPrincipal() {
        setTitle("Neural Network - Autonomous Car 1 Experiment");
        centerPanel = new GamePanel();

        bottomPanel = new JPanel(new GridLayout(1, 4));
        errorLabel = new JLabel("Error:");
        errorValueLabel = new JLabel("0");
        iterationLabel = new JLabel("Iteration:");
        iterationValueLabel = new JLabel("0");

        bottomPanel.add(errorLabel);
        bottomPanel.add(errorValueLabel);
        bottomPanel.add(iterationLabel);
        bottomPanel.add(iterationValueLabel);

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        setSize(1024, 658);
        setLocationRelativeTo(null);

        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        this.centerPanel.keyTyped(keyEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.centerPanel.keyPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.centerPanel.keyReleased(keyEvent);
    }
}

package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.gui;

import com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 10:54 PM
 */
public class FormPrincipal extends JFrame {
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
    }
}

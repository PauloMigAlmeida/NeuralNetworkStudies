package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.main;

import com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.gui.FormPrincipal;

import javax.swing.*;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 10:26 PM
 */
public class Main {

    public static void main(String[] args){
        FormPrincipal formPrincipal = new FormPrincipal();
        formPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formPrincipal.setVisible(true);
    }
}

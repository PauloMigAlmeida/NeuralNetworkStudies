package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: autonomouscar1
 * User: paulomiguelalmeida
 * Date: 5/22/14
 * Time: 11:11 PM
 */
public class GamePanel extends JPanel{


    private List<RoadComponent> roadComponentList;

    public GamePanel(){
        setLayout(null);

        roadComponentList = new ArrayList<RoadComponent>();

        RoadComponent roadComponentExample = new RoadComponent();
        int bottomLane = 460;
        int topLane = 80;
        int left = 190;
        int right = left + (7 * roadComponentExample.getWidth());
        int delta=0;

        //Bottom Lane
        delta = addRoadComponentHorizontal(left, bottomLane);
        for (int i =0; i < 7; i++){
            delta = addRoadComponentHorizontal(delta, bottomLane);
        }
        //Top Lane
        delta = addRoadComponentHorizontal(left, topLane);
        for (int i =0; i < 7; i++){
            delta = addRoadComponentHorizontal(delta, topLane);
        }

        //Left Corner
        int newLeft = left - roadComponentExample.getWidth(),newTop = topLane;
        for(int i =0; i < 15; i ++){
            addRoadComponentVertical(newLeft,newTop);
            newLeft -= 5;
            newTop +=  5;
        }

        //Left Lane
        delta = addRoadComponentVertical(newLeft + 5,newTop -5 + roadComponentExample.getHeight());
        delta = addRoadComponentVertical(newLeft + 5,delta);

        newLeft = newLeft + 5 ; newTop = delta;

        for(int i =0; i < 15; i ++){
            addRoadComponentVertical(newLeft,newTop);
            newLeft += 5;
            newTop +=  5;
        }

        //Right Corner
        int newRight = right + roadComponentExample.getWidth();
        newTop = topLane;
        for(int i =0; i < 15; i ++){
            delta = addRoadComponentVertical(newRight,newTop);
            newRight += 5;
            newTop +=  5;
        }

        //Right Lane
        delta = addRoadComponentVertical(newRight - 5,newTop -5 + roadComponentExample.getHeight());
        delta = addRoadComponentVertical(newRight - 5,delta);

        newRight = newRight -5;
        newTop = delta;
        for(int i =0; i < 15; i ++){
            delta = addRoadComponentVertical(newRight,newTop);
            newRight -= 5;
            newTop +=  5;
        }

        add(new BackgroundPanel());
    }

    private int addRoadComponentHorizontal(int x, int y){
        RoadComponent roadComponent = addRoadComponent(x, y);
        return x + roadComponent.getWidth();
    }

    private int addRoadComponentVertical(int x, int y){
        RoadComponent roadComponent = addRoadComponent(x, y);
        return y + roadComponent.getHeight();
    }

    private RoadComponent addRoadComponent(int x, int y) {
        RoadComponent roadComponent = new RoadComponent();
        roadComponent.setBounds(x,y,roadComponent.getWidth(),roadComponent.getHeight());
        add(roadComponent);
        roadComponentList.add(roadComponent);
        return roadComponent;
    }


}

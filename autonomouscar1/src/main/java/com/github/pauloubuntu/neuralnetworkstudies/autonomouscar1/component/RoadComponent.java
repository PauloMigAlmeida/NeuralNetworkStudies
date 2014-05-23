package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paulo.rodenas
 * Date: 5/23/14
 * Time: 5:16 PM
 */

public class RoadComponent {

    private List<RoadPieceComponent> roadPieceComponentList;
    private RoadPieceComponent roadPieceComponentExample;


    public RoadComponent(){
        roadPieceComponentList = new ArrayList<RoadPieceComponent>();

        roadPieceComponentExample = new RoadPieceComponent();

        int bottomLane = getInitialBottomLane();
        int topLane = getInitialTopLane();
        int left = getInitialLeftLane();
        int right = left + (7 * roadPieceComponentExample.getWidth());
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
        int newLeft = left - roadPieceComponentExample.getWidth(),newTop = topLane;
        for(int i =0; i < 15; i ++){
            addRoadComponentVertical(newLeft,newTop);
            newLeft -= 5;
            newTop +=  5;
        }

        //Left Lane
        delta = addRoadComponentVertical(newLeft + 5,newTop -5 + roadPieceComponentExample.getHeight());
        delta = addRoadComponentVertical(newLeft + 5,delta);

        newLeft = newLeft + 5 ; newTop = delta;

        for(int i =0; i < 15; i ++){
            addRoadComponentVertical(newLeft,newTop);
            newLeft += 5;
            newTop +=  5;
        }

        //Right Corner
        int newRight = right + roadPieceComponentExample.getWidth();
        newTop = topLane;
        for(int i =0; i < 15; i ++){
            addRoadComponentVertical(newRight,newTop);
            newRight += 5;
            newTop +=  5;
        }

        //Right Lane
        delta = addRoadComponentVertical(newRight - 5,newTop -5 + roadPieceComponentExample.getHeight());
        delta = addRoadComponentVertical(newRight - 5,delta);

        newRight = newRight -5;
        newTop = delta;
        for(int i =0; i < 15; i ++){
            addRoadComponentVertical(newRight,newTop);
            newRight -= 5;
            newTop +=  5;
        }
    }

    public int getInitialBottomLane(){
        return 460;
    }

    public int getInitialTopLane(){
        return 80;
    }

    public int getInitialLeftLane(){
        return 190;
    }


    private int addRoadComponentHorizontal(int x, int y){
        RoadPieceComponent roadPieceComponent = addRoadComponent(x, y);
        return x + roadPieceComponent.getWidth();
    }

    private int addRoadComponentVertical(int x, int y){
        RoadPieceComponent roadPieceComponent = addRoadComponent(x, y);
        return y + roadPieceComponent.getHeight();
    }

    private RoadPieceComponent addRoadComponent(int x, int y) {
        RoadPieceComponent roadPieceComponent = new RoadPieceComponent();
        roadPieceComponent.setBounds(x,y, roadPieceComponent.getWidth(), roadPieceComponent.getHeight());
        roadPieceComponentList.add(roadPieceComponent);
        return roadPieceComponent;
    }

    public void addToContentPanel(JPanel panel){
        for(RoadPieceComponent roadPieceComponent : roadPieceComponentList){
            panel.add(roadPieceComponent);
        }
    }

    public int getRoadPieceWidth(){
        return this.roadPieceComponentExample.getWidth();
    }

    public int getRoadPieceHeight(){
        return this.roadPieceComponentExample.getHeight();
    }
}

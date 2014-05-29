package com.github.pauloubuntu.neuralnetworkstudies.autonomouscar1.component;

import javax.swing.*;
import java.io.IOException;
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


    public RoadComponent() throws IOException {
        roadPieceComponentList = new ArrayList<RoadPieceComponent>();

        roadPieceComponentExample = new RoadPieceComponent(0);

        int bottomLane = getInitialBottomLane();
        int topLane = getInitialTopLane();
        int left = getInitialLeftLane();
        int right = left + (7 * roadPieceComponentExample.getWidth());
        int delta=0;
        int bottomLaneAngle = 0;
        int topLaneAngle = 0;
        int leftCornerAngle = -20;



        //Left Corner
        int newLeft = left - roadPieceComponentExample.getWidth() + 5,newTop = topLane;

        addRoadComponentVertical(newLeft,newTop, leftCornerAngle);

        newLeft -= 45;
        newTop +=  30;
        leftCornerAngle -=35;
        addRoadComponentVertical(newLeft,newTop, leftCornerAngle);
//        for(int i =0; i < 1; i ++){
//            addRoadComponentVertical(newLeft,newTop, leftCornerAngle);
//            newLeft -= 5;
//            newTop +=  40;
//            leftCornerAngle -=5;
//        }
//
//        //Left Lane
//        delta = addRoadComponentVertical(newLeft + 5,newTop -5 + roadPieceComponentExample.getHeight(), angle);
//        delta = addRoadComponentVertical(newLeft + 5,delta, angle);
//
//        newLeft = newLeft + 5 ; newTop = delta;
//
//        for(int i =0; i < 15; i ++){
//            addRoadComponentVertical(newLeft,newTop, angle);
//            newLeft += 5;
//            newTop +=  5;
//        }
//
//        //Right Corner
//        int newRight = right + roadPieceComponentExample.getWidth();
//        newTop = topLane;
//        for(int i =0; i < 15; i ++){
//            addRoadComponentVertical(newRight,newTop, angle);
//            newRight += 5;
//            newTop +=  5;
//        }
//
//        //Right Lane
//        delta = addRoadComponentVertical(newRight - 5,newTop -5 + roadPieceComponentExample.getHeight(), angle);
//        delta = addRoadComponentVertical(newRight - 5,delta, angle);
//
//        newRight = newRight -5;
//        newTop = delta;
//        for(int i =0; i < 15; i ++){
//            addRoadComponentVertical(newRight,newTop, angle);
//            newRight -= 5;
//            newTop +=  5;
//        }


        //Bottom Lane
        delta = addRoadComponentHorizontal(left, bottomLane, bottomLaneAngle);
        for (int i =0; i < 7; i++){
            delta = addRoadComponentHorizontal(delta, bottomLane, bottomLaneAngle);
        }
        //Top Lane
        delta = addRoadComponentHorizontal(left, topLane, topLaneAngle);
        for (int i =0; i < 7; i++){
            delta = addRoadComponentHorizontal(delta, topLane, topLaneAngle);
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


    private int addRoadComponentHorizontal(int x, int y, int angle) throws IOException {
        RoadPieceComponent roadPieceComponent = addRoadComponent(x, y, angle);
        return x + roadPieceComponent.getWidth();
    }

    private int addRoadComponentVertical(int x, int y, int angle) throws IOException {
        RoadPieceComponent roadPieceComponent = addRoadComponent(x, y, angle);
        return y + roadPieceComponent.getHeight();
    }

    private RoadPieceComponent addRoadComponent(int x, int y, int angle) throws IOException {
        RoadPieceComponent roadPieceComponent = new RoadPieceComponent(angle);
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

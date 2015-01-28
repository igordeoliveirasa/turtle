/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igor
 */
public class Codility {
    
    public class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {return x;}
        public int getY() {return y;}

        @Override
        public boolean equals(Object obj) {
            return x == ((Position)obj).getX() && y == ((Position)obj).getY();
        }
        
        
    }
    
    public class Turtle {
        private List<Position> places = new ArrayList<>();
        private List<Integer> repeatedMovements = new ArrayList<>();
        public List<Integer> getRepeatedPlaces() { return repeatedMovements;}
        private Position position;
        private int NORTH = 1;
        private int EAST = 2;
        private int SOUTH = 3;
        private int WEST = 4;
        private int direction = 0;
        private int movement = 0;
        public Turtle(Position position) {
            this.position = position;
            places.add(position);
        }
        
        public void walk(int steps) {
            direction = (direction == 4 || direction == 0) ? 1 : direction + 1;

            movement++;
            
            int sumX = 0;
            int sumY = 0;
            
            if (direction==NORTH) {
                sumY = 1;
                sumX = 0;
            }
            else if (direction==EAST) {
                sumY = 0;
                sumX = 1;
            }            
            else if (direction==SOUTH) {
                sumY = -1;
                sumX = 0;
            }
            else if (direction==WEST) {
                sumY = 0;
                sumX = -1;
            }
            boolean repeatedMovement = false;
            for (int i=0; i<steps; i++) {
                Position newPosition = new Position(position.getX()+sumX, position.getY()+sumY);
                if ( !repeatedMovement && places.contains(newPosition)) {
                    repeatedMovement = true;
                }
                places.add(newPosition);
                position = newPosition;
                System.out.println("Position: (" + position.getX() + ","+position.getY()+")");
            }
            if (repeatedMovement) {
                repeatedMovements.add(movement);
            }
        }
    }
        
    public int solution(int[] A) {
        Turtle turtle = new Turtle(new Position(0,0));
        for (int i=0; i<A.length; i++) {
            turtle.walk(A[i]);
        }
        return turtle.getRepeatedPlaces().size() == 0 ? 0 : turtle.getRepeatedPlaces().get(0);
    }
}

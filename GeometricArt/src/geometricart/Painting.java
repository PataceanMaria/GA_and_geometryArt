/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricart;

import java.util.Random;

/**
 *
 * @author maria
 */
public class Painting {
    private Individual[] shapes;
    Painting[] paintings = new Painting[10];
    
    public Painting() {
        // Create 6 random shapes
        Random rand = new Random();
        shapes = new Individual[6];
        for (int i = 0; i < 6; i++) {
            int height = rand.nextInt(100) + 1; // height between 1 and 20
            int length = rand.nextInt(100) + 1; // length between 1 and 20
              int x = rand.nextInt(100) + 1; // length between 1 and 20
                int y= rand.nextInt(100) + 1; // length between 1 and 20
           // String color = new String[] {"red", "blue", "green", "yellow", "orange", "purple"}[rand.nextInt(6)];
            shapes[i] = new Individual(x,y,height, length);
        }
    }
    
    public Individual[] getShapes() {
        return shapes;
    }
    
    public void createGeneration (){
        Painting[] paintings = new Painting[10];
        for (int i = 0; i < 10; i++) {
            paintings[i] = new Painting();
        }
        
        // Print the attributes of each shape in each painting
       
            for (int j = 0; j < 6; j++) {
                System.out.println("Shape " + (j+1) + " - Height: " + shapes[j].getHeight() + ", Length: " + shapes[j].getLenght() );
            
        }
    }
}
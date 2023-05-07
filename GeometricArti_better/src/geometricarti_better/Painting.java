/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricarti_better;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author maria
 */
public class Painting {
     Random random = new Random();
    private ArrayList<Individual> shapes;
    public Painting()
    {
        shapes=new ArrayList<Individual>(6);
        for(int i=0;i<6;i++)
        {
            int height=random.nextInt(100)+1;
            int length=random.nextInt(100)+1;
            int x=random.nextInt(100)+1;
            int y=random.nextInt(100)+1;
            int selector=random.nextInt(3);
            shapes.add(new Individual(height, length,  x,  y,selector));
        }
    }
    public ArrayList<Individual> getShapes()
    {
        return shapes;
    }
    public void setShapes (ArrayList<Individual>shapes)
    {
        this.shapes=shapes;
    }
}

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
    int grades;
    public Painting(int grades)
    {
        this.grades=grades;
        shapes=new ArrayList<Individual>(6);
        for(int i=0;i<6;i++)
        {
            int height=random.nextInt(1000)+1;
            int length=random.nextInt(1000)+1;
            int x=random.nextInt(2000)+1;
            int y=random.nextInt(2000)+1;
            float thickness=random.nextFloat()*5.0f;
            int selector=random.nextInt(3);
            int color=random.nextInt(8);
            shapes.add(new Individual(height, length,  x,  y,selector,thickness,color));
        }
    }
    
    
    public Painting()
    {
        
    }
    public ArrayList<Individual> getShapes()
    {
        return shapes;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
    
    public void setShapes (ArrayList<Individual>shapes)
    {
        this.shapes=shapes;
    }
}

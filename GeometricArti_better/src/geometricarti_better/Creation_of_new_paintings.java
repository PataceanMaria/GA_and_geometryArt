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
public class Creation_of_new_paintings {

    Random rand = new Random();
    int position;
    int shape;

    public void crossover(ArrayList<Individual> firstparent, ArrayList<Individual> secondparent, ArrayList<Individual> child) {
        child.clear();
        position = rand.nextInt(4) + 1;
       
       for (int i = 0; i < position; i++) {
        child.add(new Individual(firstparent.get(i).getHeight(), firstparent.get(i).getLength(), firstparent.get(i).getX(), firstparent.get(i).getY(), firstparent.get(i).getSelector()));
    }
    for (int i = position; i < 6; i++) {
        child.add(new Individual(secondparent.get(i).getHeight(), secondparent.get(i).getLength(), secondparent.get(i).getX(), secondparent.get(i).getY(), secondparent.get(i).getSelector()));
    }
    

    }
  
    public void crossover2(ArrayList<Individual> firstparent, ArrayList<Individual> secondparent, ArrayList<Individual> child) {
        
       child.clear();
      
      for (int i = 0; i < position; i++) {
        child.add(new Individual(secondparent.get(i).getHeight(), secondparent.get(i).getLength(), secondparent.get(i).getX(), secondparent.get(i).getY(), secondparent.get(i).getSelector()));
    }
    for (int i = position; i < 6; i++) {
        child.add(new Individual(firstparent.get(i).getHeight(), firstparent.get(i).getLength(), firstparent.get(i).getX(), firstparent.get(i).getY(), firstparent.get(i).getSelector()));
    }
   

    }
    public ArrayList<Individual> selection(ArrayList<Painting> paintings) {
    int max = 0;
    int bestindex = 0;
    for (int j = 0; j < 5; j++) {
        int select = rand.nextInt(100);
        System.out.println("select "+select +"with garde "+paintings.get(select).getGrades());
       
        if (max < paintings.get(select).getGrades()) {
            max = paintings.get(select).getGrades();
            bestindex = select;
        }
    }
    System.out.println("index "+bestindex);
    return paintings.get(bestindex).getShapes();
}


    public void mutation(ArrayList<Individual> child) {
        shape = rand.nextInt(6);
        switch (rand.nextInt(5)) {
            case 0:
                child.get(shape).setHeight(rand.nextInt(100));
                break;
            case 1:
                child.get(shape).setLength(rand.nextInt(100));
                break;
            case 2:
                child.get(shape).setX(rand.nextInt(100));
                break;
            case 3:
                child.get(shape).setY(rand.nextInt(100));
                break;
            case 4:
                child.get(shape).setSelector(rand.nextInt(3));
                break;

        }
    }

    public int fittness(ArrayList<Individual> shapes) {
        
        int grade = 0;
        int g=0;
        int patrat=0,triunghi=0,oval=0;
        int k = 0;
        for (int i = 0; i < 6; i++) {
            if (shapes.get(i).getHeight() > 80) {
                k++;
            }
            if (shapes.get(i).getSelector() == 1) {
                grade++;
            }
        }
        for(int i=0;i<6;i++)
        {
            g=shapes.get(i).getHeight();
            if(shapes.get(i).getX()>shapes.get(i).getY())
            {
                grade++;
            }
            if(shapes.get(i).getLength()>30)
            {
                grade++;
            }
            if(shapes.get(i).getSelector()==0)
            {
                patrat++;
            }
            else if(shapes.get(i).getSelector()==1)
            {
                oval++;
            }
            else
            {
                triunghi++;
            }
        }
        if(triunghi<=2 || oval<=2||patrat<=2)
        {
            grade++;
        }
        if (k > 2 || k == 0) {
            if (grade == 0) {
                grade = 0;

            } else {
                grade--;
            }
        } else {
            grade++;
        }

        return grade;

    }
    public void bubbleSort(ArrayList<Painting>paintings) {
    int n = paintings.size();
      System.out.println("SIZE OF ARRAY "+n);
    int k=0;
    for (int i = 0; i < 100 - 1; i++) {
        k++;
       
        for (int j = 0; j < 100 - i - 1; j++) {
            if (paintings.get(j).getGrades() < paintings.get(j+1).getGrades()) {
                
                int temp = paintings.get(j).getGrades();
                paintings.get(j).setGrades(paintings.get(j+1).getGrades());
                paintings.get(j+1).setGrades(temp);
                ArrayList<Individual> aux=paintings.get(j).getShapes();
                paintings.get(j).setShapes(paintings.get(j+1).getShapes());
                paintings.get(j+1).setShapes(aux);
            }
        }
    }
}

}

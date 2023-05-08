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
        position = rand.nextInt(4) + 1;
        System.out.println("positon" + position);
        for (int i = 0; i < position; i++) {

            child.get(i).setHeight(firstparent.get(i).getHeight());

        }
        for (int i = position; i < 6; i++) {

            child.get(i).setHeight(secondparent.get(i).getHeight());

        }

    }

    public void crossover2(ArrayList<Individual> firstparent, ArrayList<Individual> secondparent, ArrayList<Individual> child) {
        System.out.println("positon" + position);

        for (int i = 0; i < position; i++) {

            child.get(i).setHeight(secondparent.get(i).getHeight());

        }
        for (int i = position; i < 6; i++) {

            child.get(i).setHeight(firstparent.get(i).getHeight());

        }

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

}

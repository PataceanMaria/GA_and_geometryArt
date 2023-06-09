/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricarti_better;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author maria
 */
public class Creation_of_new_paintings extends JPanel {

    Random rand = new Random();
    int position;
    int shape;

    public void crossover(ArrayList<Individual> firstparent, ArrayList<Individual> secondparent, ArrayList<Individual> child) {
        child.clear();
        position = rand.nextInt(4) + 1;

        for (int i = 0; i < position; i++) {
            child.add(new Individual(firstparent.get(i).getHeight(), firstparent.get(i).getLength(), firstparent.get(i).getX(), firstparent.get(i).getY(), firstparent.get(i).getSelector(), firstparent.get(i).getThickness(),firstparent.get(i).getColor()));
        }
        for (int i = position; i < 6; i++) {
            child.add(new Individual(secondparent.get(i).getHeight(), secondparent.get(i).getLength(), secondparent.get(i).getX(), secondparent.get(i).getY(), secondparent.get(i).getSelector(), secondparent.get(i).getThickness(),secondparent.get(i).getColor()));
        }

    }

    public void crossover2(ArrayList<Individual> firstparent, ArrayList<Individual> secondparent, ArrayList<Individual> child) {

        child.clear();

        for (int i = 0; i < position; i++) {
            child.add(new Individual(secondparent.get(i).getHeight(), secondparent.get(i).getLength(), secondparent.get(i).getX(), secondparent.get(i).getY(), secondparent.get(i).getSelector(), secondparent.get(i).getThickness(),secondparent.get(i).getColor()));
        }
        for (int i = position; i < 6; i++) {
            child.add(new Individual(firstparent.get(i).getHeight(), firstparent.get(i).getLength(), firstparent.get(i).getX(), firstparent.get(i).getY(), firstparent.get(i).getSelector(), firstparent.get(i).getThickness(),firstparent.get(i).getColor()));
        }

    }

    public ArrayList<Individual> selection(ArrayList<Painting> paintings) {
        int max = 0;
        int bestindex = 0;
        for (int j = 0; j < 5; j++) {
            int select = rand.nextInt(100);

            if (max < paintings.get(select).getGrades()) {
                max = paintings.get(select).getGrades();
                bestindex = select;
            }
        }
        // System.out.println("index "+bestindex);
        return paintings.get(bestindex).getShapes();
    }

    public void mutation(ArrayList<Individual> child) {
        shape = rand.nextInt(6);
        switch (rand.nextInt(7)) {
            case 0:
                child.get(shape).setHeight(rand.nextInt(100));
                break;
            case 1:
                child.get(shape).setLength(rand.nextInt(100));
                break;
            case 2:
                child.get(shape).setX(rand.nextInt(200));
                break;
            case 3:
                child.get(shape).setY(rand.nextInt(200));
                break;
            case 4:
                child.get(shape).setSelector(rand.nextInt(3));
                break;
            case 5:
                child.get(shape).setThickness(rand.nextFloat()+10.0f);
                break;
            case 6:
                child.get(shape).setColor(rand.nextInt(8));
                break;

        }
    }

    public int fittness(ArrayList<Individual> shapes) {

        int grade=0;
        int k=0,k2=0,k3=0,k4=0;
         double centerofGravityX=shapes.get(5).getX()+shapes.get(5).getHeight()/2;
          double centerofGravityY=shapes.get(5).getY()+shapes.get(5).getLength()/2;
        for(int i=0;i<6;i++)
        {
            
            
            if(shapes.get(i).getColor()==7)
               k++;
            if(shapes.get(i).getColor()==5)
               k2++;
            if(shapes.get(i).getColor()==3)
               k3++;
            if(shapes.get(i).getX() +shapes.get(i).getHeight()<=300&& shapes.get(i).getY()+shapes.get(i).getLength()<=215)
                grade++;
            else
            {
                if(grade==0)
                    grade=0;
                else grade--;
            }
            if(shapes.get(i).getHeight()>20&&shapes.get(i).getLength()>20)
                grade++;
            else
            {
                if(grade==0)
                    grade=0;
                else
                    grade--;
            }
            
          // int ovalCenterX = ovalUpperLeftX + ovalWidth / 2;
           // int ovalCenterY = ovalUpperLeftY + ovalHeight / 2;
          
            
            

           
        }
         

        for(int i=0;i<5;i++)
            
        {
            double individualGravityX=shapes.get(i).getX()+shapes.get(i).getHeight()/2;
            double individualGravityY=shapes.get(i).getY()+shapes.get(i).getLength()/2;
            double gravityDifferenceX= centerofGravityX-individualGravityX;
            double gravityDifferenceY=centerofGravityY-individualGravityY;
            double reversedGravityX=individualGravityX-centerofGravityX;
            double reversedGravityY=individualGravityY-centerofGravityY;
            
            
            if(shapes.get(5).getThickness()>shapes.get(i).getThickness()*2)
                grade=grade+10;
            else
                if(grade>=10)
                    grade=grade-10;
            else if(grade<=10)
                    grade=0;
            
            if(shapes.get(5).getHeight()<shapes.get(i).getHeight()&&shapes.get(5).getLength()<shapes.get(i).getLength())
            {
                 grade=grade++;
            } 
            else if(shapes.get(5).getHeight()>shapes.get(i).getHeight()&&shapes.get(5).getLength()>shapes.get(i).getLength())
            {
                 grade=grade++;
            } 
               
         
          else if(grade==0)
              grade=0;
            else
              grade--;
            
            if(gravityDifferenceX>=0.5&&gravityDifferenceY>=0.5)
            
                grade=grade+10;
            else if(reversedGravityX>=0.5&&reversedGravityY>=0.5)
                grade=grade+10;
            else grade=grade-grade;
          
    

          
        }
            
        if(k==1&&shapes.get(5).getColor()==7&&k2==0&&k3==0)
            grade=grade+5;
        else if(k2==1&&shapes.get(5).getColor()==5&&k==0&&k3==0)
            grade=grade+5;
        else if(k3==1&&shapes.get(5).getColor()==3&&k2==0&&k==0)
            grade=grade+5;
        
       
        
            
//                if(centerofGravityX-85<=5&&centerofGravityY-53<=5||85-centerofGravityX<=5&&53-centerofGravityY<=5)
//                    grade++;
//                else if(centerofGravityX-85<=3&&centerofGravityY-53<=3||85-centerofGravityX<=3&&53-centerofGravityY<=3)
//                    grade=grade+3;
//                else if(centerofGravityX-85<=1&&centerofGravityY-53<=1||85-centerofGravityX<=1&&53-centerofGravityY<=1)
//                    grade=grade+5;
                if(centerofGravityX-85<=5&&centerofGravityY-53<=5||85-centerofGravityX<=5&&53-centerofGravityY<=5)
                    grade=grade+10;
             
                else if(centerofGravityX-85==0&&centerofGravityY-53==0||85-centerofGravityX==0&&53-centerofGravityY==0)
                    grade=grade+20;
//                else if(centerofGravityX-85<=5&&centerofGravityY-106<=5||85-centerofGravityX<=5&&106-centerofGravityY<=5)
//                    grade++;
//                else if(centerofGravityX-85<=3&&centerofGravityY-106<=3||85-centerofGravityX<=3&&106-centerofGravityY<=3)
//                    grade=grade+3;
//                else if(centerofGravityX-85<=1&&centerofGravityY-106<=1||85-centerofGravityX<=1&&106-centerofGravityY<=1)
//                    grade=grade+5;
                else if(centerofGravityX-85<=5&&centerofGravityY-106<=5||85-centerofGravityX<=5&&106-centerofGravityY<=5)
                    grade=grade+10;
                
                 else if(centerofGravityX-85==0&&centerofGravityY-106==0||85-centerofGravityX==0&&106-centerofGravityY==0)
                    grade=grade+20;
                
//                else if(centerofGravityX-170<=5&&centerofGravityY-53<=5||170-centerofGravityX<=5&&53-centerofGravityY<=5)
//                    grade++;
//                else if(centerofGravityX-170<=3&&centerofGravityY-53<=3||170-centerofGravityX<=3&&53-centerofGravityY<=3)
//                    grade=grade+3;
//                else if(centerofGravityX-170<=1&&centerofGravityY-53<=1||170-centerofGravityX<=1&&53-centerofGravityY<=1)
//                    grade=grade+5;
                else if(centerofGravityX-170<=5&&centerofGravityY-53<=5||170-centerofGravityX<=5&&53-centerofGravityY<=5)
                    grade=grade+10;
                 
                 else if(centerofGravityX-170==0&&centerofGravityY-53==0||170-centerofGravityX==0&&53-centerofGravityY==0)
                    grade=grade+20;
//                 else if(centerofGravityX-170<=5&&centerofGravityY-106<=5||170-centerofGravityX<=5&&106-centerofGravityY<=5)
//                    grade++;
//                else if(centerofGravityX-170<=3&&centerofGravityY-106<=3||170-centerofGravityX<=3&&106-centerofGravityY<=3)
//                    grade=grade+3;
//                else if(centerofGravityX-170<=1&&centerofGravityY-106<=1||170-centerofGravityX<=1&&106-centerofGravityY<=1)
//                    grade=grade+5;
                else if(centerofGravityX-170<=5&&centerofGravityY-106<=5||170-centerofGravityX<=5&&106-centerofGravityY<=5)
                    grade=grade+10;
                
                else if(centerofGravityX-170==0&&centerofGravityY-106==0||170-centerofGravityX==0&&106-centerofGravityY==0)
                    grade=grade+20;
                else grade=grade-grade;
            
       
           
        return grade;

    }

    public void colorCenerator(Graphics g, int color) {
        switch (color) {
        case 0:
            g.setColor(Color.BLUE);
            break;
        case 1:
            g.setColor(Color.CYAN);
            break;
        case 2:
            g.setColor(Color.GREEN);
            break;
        case 3:
            g.setColor(Color.YELLOW);
            break;
        case 4:
            g.setColor(Color.ORANGE);
            break;
        case 5:
            g.setColor(Color.MAGENTA);
            break;
        case 6:
            g.setColor(Color.PINK);
            break;
        case 7:
            g.setColor(Color.RED);
            break;
        default:
            g.setColor(Color.BLACK); // Default color if index is out of range
            break;
        }
    }

    public void bubbleSort(ArrayList<Painting> paintings) {
        int n = paintings.size();
        //  System.out.println("SIZE OF ARRAY "+n);
        int k = 0;
        for (int i = 0; i < 100 - 1; i++) {
            k++;

            for (int j = 0; j < 100 - i - 1; j++) {
                if (paintings.get(j).getGrades() < paintings.get(j + 1).getGrades()) {

                    int temp = paintings.get(j).getGrades();
                    paintings.get(j).setGrades(paintings.get(j + 1).getGrades());
                    paintings.get(j + 1).setGrades(temp);
                    ArrayList<Individual> aux = paintings.get(j).getShapes();
                    paintings.get(j).setShapes(paintings.get(j + 1).getShapes());
                    paintings.get(j + 1).setShapes(aux);
                }
            }
        }
    }

}

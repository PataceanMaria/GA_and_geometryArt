/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricart;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author maria
 */
public class Shape_method extends JPanel{
    Random random=new Random();

  

         int height;
        int lenght;
        int x;
        int y;
         int height2=random.nextInt(100);
        int lenght2=random.nextInt(100);
        int x2=random.nextInt(100);
        int y2=random.nextInt(100);
        
        
        
//    public void drawTraingle(Graphics g)
//    {
//        super.paintComponent(g);
//        Random random=new Random();
//      int coordinatex=random.nextInt(100);
//      int coordinatey=random.nextInt(100);
//      int height=random.nextInt(100);
//      int length=random.nextInt(100);
//      int additonal=random.nextInt(100);
//      int additonal2=random.nextInt(100);
//      
//      
//      g.drawLine(coordinatex, coordinatey, coordinatex+additonal, coordinatey+additonal2);
//      g.drawLine(coordinatex+additonal, coordinatey+additonal2, height,length);
//      g.drawLine( height,length, coordinatex, coordinatey);
//      
//    
//    }
    public void dRectangle(Graphics g)
    {
           height=random.nextInt(100);
         lenght=random.nextInt(100);
        x=random.nextInt(100);
         y=random.nextInt(100);
        
         g.drawRect(x, y,lenght, height);
       // System.out.println( "this is the height rectangle :"+height);
    }
     public void dOval(Graphics g)
    {
           height=random.nextInt(100);
         lenght=random.nextInt(100);
         x=random.nextInt(100);
         y=random.nextInt(100);
         g.drawOval(x, y,lenght, height);
           // System.out.println("this is the height oval: " +height);
    }

    public int getHeight() {
        return height;
    }

    public int getLenght() {
        return lenght;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

   

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   
     

    
}

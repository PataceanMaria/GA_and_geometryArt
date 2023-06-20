/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricarti_better;

import java.awt.Graphics;
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
        public void drawTraingle(Graphics g,int coordinatex,int coordinatey,int height,int length)
    {
        super.paintComponent(g);
        Random random=new Random(); 
      int additonal=random.nextInt(50);
      int additonal2=random.nextInt(50);
      
      
      g.drawLine(coordinatex, coordinatey, coordinatex+height, coordinatey+height);
      g.drawLine(coordinatex+height, coordinatey+height, height,length);
      g.drawLine( height,length, coordinatex, coordinatey);
      
    
    }
        
      
        
}

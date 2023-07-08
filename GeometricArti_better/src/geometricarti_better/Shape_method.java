/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricarti_better;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author maria
 */
public class Shape_method extends JPanel {

    Random random = new Random();

    int height;
    int lenght;
    int x;
    int y;
    int height2 = random.nextInt(100);
    int lenght2 = random.nextInt(100);
    int x2 = random.nextInt(100);
    int y2 = random.nextInt(100);

    public void drawTraingle(Graphics g, int x, int y, int width, int height) {
      int x1 = x;
    int y1 = y + height;
    int x2 = x + width / 2;
    int y2 = y;
    int x3 = x + width;
    int y3 = y + height;
    // Draw the triangle
   
    g.drawLine(x1, y1, x2, y2);
    g.drawLine(x2, y2, x3, y3);
    g.drawLine(x3, y3, x1, y1);

    }

    public  void intersetcion(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {

        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y4 - y3) / (x4 - x3);
        double yIntercept1 = y1 - slope1 * x1;
        double yIntercept2 = y3 - slope2 * x3;

        double x;
        double y;

        if (Double.isInfinite(slope1)) {
            x = x1;
            y = slope2 * x1 + yIntercept2;
        } else if (Double.isInfinite(slope2)) {
            x = x3;
            y = slope1 * x3 + yIntercept1;
        } else {
            x = (yIntercept2 - yIntercept1) / (slope1 - slope2);
            y = slope1 * x + yIntercept1;
        }
        System.out.println("Intersection point (x, y): (" + x + ", " + y + ")");

    }
    
    public double calculateMean(ArrayList<Painting> paintings) {
        double sum = 0;
        for (int i=0;i<100;i++) {
            sum += paintings.get(i).getGrades();
        }
        return sum / 100;
    }
    
     public double calculateStandardDeviation(ArrayList<Painting> paintings) {
        double mean = calculateMean(paintings);
        double sumSquaredDiff = 0;
        for (int i=0;i<100;i++) {
            double diff = paintings.get(i).getGrades() - mean;
            sumSquaredDiff += diff * diff;
        }
        return Math.sqrt(sumSquaredDiff / 100);
    }
     public double gaussian(double x, double mean, double amplitude, double standardDeviation) {
        double exponent = -(Math.pow(x - mean, 2) / (2 * Math.pow(standardDeviation, 2)));
        return amplitude * Math.exp(exponent);
    }

    
    
}

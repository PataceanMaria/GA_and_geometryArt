/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricart;

/**
 *
 * @author maria
 */
public class Creation_of_the_individual {
    
    
    
    public void Crossover(Individual[] shapes,Individual [] second)
{
    for(int i=0;i<6;i++)
    {
        int aux=shapes[i].getHeight();
        shapes[i].setHeight(second[i].getHeight());
        second[i].setHeight(aux);
        
    }
}
    
    
}

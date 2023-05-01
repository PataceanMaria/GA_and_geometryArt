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
public class Individual {

    int lenght, height, x, y,selector,color;

    public Individual(int x, int y, int height, int lenght,int selector) {
        this.height = height;
        this.lenght = lenght;
        this.x = x;
        this.y = y;
        this.selector=selector;

    }

    public int getSelector() {
        return selector;
    }

    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

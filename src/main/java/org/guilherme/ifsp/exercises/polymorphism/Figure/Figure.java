package org.guilherme.ifsp.exercises.polymorphism.Figure;

public abstract class  Figure {
    public static int area;
    static double x;
    static double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public boolean isArgumentValid(double arg) {
        return arg >= 0;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }


}

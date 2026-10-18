package org.guilherme.ifsp.exercises.polymorphism.Figure;

public abstract class  Figure {
    private double x;
    private double y;

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

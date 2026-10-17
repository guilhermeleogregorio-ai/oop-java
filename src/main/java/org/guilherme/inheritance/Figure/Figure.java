package org.guilherme.inheritance.Figure;

public abstract class  Figure {
    double x;
    double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}

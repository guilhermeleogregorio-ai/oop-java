package org.guilherme.inheritance;

public class  Figure {
    double x;
    double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double area() {
        return x * y;
    }
}

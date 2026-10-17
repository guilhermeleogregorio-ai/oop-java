package org.guilherme.inheritance;

public class Circle extends Figure {
    double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
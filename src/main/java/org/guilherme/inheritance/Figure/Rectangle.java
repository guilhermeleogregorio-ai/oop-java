package org.guilherme.inheritance.Figure;

public class Rectangle extends Figure {
    double width;
    double length;

    public Rectangle(double x, double y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }
    @Override
    public double area() {
        return width * length;
    }
}

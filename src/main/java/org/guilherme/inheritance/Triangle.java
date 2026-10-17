package org.guilherme.inheritance;

public class Triangle extends Figure{
    double a;
    double b;
    double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double area(){
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

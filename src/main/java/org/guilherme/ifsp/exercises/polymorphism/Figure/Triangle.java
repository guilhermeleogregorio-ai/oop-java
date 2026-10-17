package org.guilherme.ifsp.exercises.polymorphism.Figure;

public class Triangle extends Figure {
    double a;
    double b;
    double c;

    private Triangle(double x, double y, double a, double b, double c) {
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

    public static Triangle create(double x, double y, double a, double b, double c){
        return new Triangle(x, y, a, b,c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

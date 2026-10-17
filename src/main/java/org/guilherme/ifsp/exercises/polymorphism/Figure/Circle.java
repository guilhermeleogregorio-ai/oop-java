package org.guilherme.ifsp.exercises.polymorphism.Figure;

public class Circle extends Figure {
    double radius;

    private Circle(double x, double y, double radius) {
        super(x, y);
        if(isArgumentValid(radius)) {
            this.radius = radius;
        }else{
            throw new IllegalArgumentException("Valor de raio invalido");
        }
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    public static Circle create(double x, double y, double radius) {
        return new Circle(x, y, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
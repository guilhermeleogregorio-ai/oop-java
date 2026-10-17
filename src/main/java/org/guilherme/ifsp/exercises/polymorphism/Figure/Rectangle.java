package org.guilherme.ifsp.exercises.polymorphism.Figure;

public class Rectangle extends Figure {
    double width;
    double length;

    private Rectangle(double x, double y, double width, double length) {
        super(x, y);
        if(isArgumentValid(width) && isArgumentValid(length)) {
            this.width = width;
            this.length = length;
        } else{
            throw new IllegalArgumentException("Valor de width e/ou length invalido");
        }
    }


    @Override
    public double area() {
        return width * length;
    }
    public static Rectangle create(double x, double y, double width, double length){
        return new Rectangle(x,y,width,length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}

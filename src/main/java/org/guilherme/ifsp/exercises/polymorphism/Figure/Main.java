package org.guilherme.ifsp.exercises.polymorphism.Figure;

public class Main {
    public static void main(String[] args) {

        Figure[] figures = new Figure[150];

        for(int i = 0; i < 150 ; i++){
            if(i < 50){
                figures[i] = Circle.create(i,i,i);
            } else if (i < 100) {
                figures[i] = Rectangle.create(i,i,i,i);
            }else {
                figures[i] = Triangle.create(i,i,i,i,i);
            }
        }

        for(Figure f : figures){
            System.out.println(f);
        }

        double somaArea = 0;

        for(Figure figure : figures){
            somaArea += figure.area();
        }

        System.out.printf("%.3f",somaArea);

    }
}

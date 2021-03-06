package ru.stqa.pft.sandbox.old;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("World");
        hello("user");
        hello("Alexej");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());


        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 2);
        System.out.println("Расстояние между точками равно: " + p1.distance(p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}
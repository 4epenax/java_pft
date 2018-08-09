import java.awt.geom.Point2D;

public class Point {
    public static void main(String[] args) {

        double x;

        x = Point2D.distance(1.0, 2.0, 3.0, 5.0);
        System.out.println("Росстояние между точками равно: " + x);
    }
}
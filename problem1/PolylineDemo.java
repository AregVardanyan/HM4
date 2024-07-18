package HM4.problem1;

import HM4.problem1.Point;
import HM4.problem1.Polyline;

public class PolylineDemo {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);

        System.out.println("Points");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        Polyline polyline = new Polyline();
        polyline.add(p1);
        polyline.add(p2);
        polyline.add(p3);

        System.out.println("\nPolyline Points");
        for (Point p : polyline.get()) {
            System.out.println(p);
        }

        System.out.println("\nTotal Length of Polyline");
        System.out.println(polyline.lengthPolyline());

        Polyline copiedPolyline = new Polyline(polyline);

        System.out.println("\nCopied Polyline Points");
        for (Point p : copiedPolyline.get()) {
            System.out.println(p);
        }

        Point[] newPoints = {p3, p4};
        polyline.set(newPoints);

        System.out.println("\nUpdated Polyline Points");
        for (Point p : polyline.get()) {
            System.out.println(p);
        }

        System.out.println("\nTotal Length of Updated Polyline");
        System.out.println(polyline.lengthPolyline());

        System.out.println("\nString Representation of Polyline");
        System.out.println(polyline.toString());
    }
}
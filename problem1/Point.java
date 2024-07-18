package HM4.problem1;

public class Point {
    private final float x;
    private final float y;

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    public static double distance(Point p1, Point p2){
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceFrom(Point other) {
        return distance(this, other);
    }
}

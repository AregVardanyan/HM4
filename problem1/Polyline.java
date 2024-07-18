package HM4.problem1;

public class Polyline {
    private Point[] points;
    private int index;

    public Polyline() {
        this.points = new Point[100];
        this.index = 0;
    }

    public Polyline(Polyline other) {
        this.points = new Point[100];
        this.index = other.index;
        for (int i = 0; i < other.index; i++) {
            this.points[i] = other.points[i];
        }
    }

    public void add(Point point){
        if (index < points.length) {
            points[index++] = point;
        } else {
            throw new ArrayIndexOutOfBoundsException("Polyline can only hold 100 point");
        }
    }

    public Point[] get(){
        Point[] points1 = new Point[index];
        for (int i = 0; i < index; i++) {
            points1[i] = this.points[i];
        }
        return points1;
    }

    public void set(Point[] p){
        if (p.length > 100) {
            throw new IllegalArgumentException("Polyline can only hold 100 points.");
        }
        this.points = new Point[100];
        this.index = p.length;
        for (int i = 0; i < p.length; i++) {
            this.points[i] = p[i];
        }
    }

    public double lengthPolyline(){
        double length = 0;
        if (index < 2) {
            return 0;
        }
        for (int i = 0; i < this.index - 1; i++){
            length += Point.distance(this.points[i], this.points[i+1]);
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(points[i].toString());
        }
        return sb.toString();
    }
}

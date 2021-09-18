package task3;

public class Polygon {
    private Point[] points;

    private Polygon(int n) {
        this.points = new Point[n/2];
    }

    public Polygon(float[] pts) {
        this(pts.length);

        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point();
            this.points[i].changeCoords(pts[i*2], pts[i*2+1]);
        }
    }

    public void show() {
        for (Point p : points) {
            p.show();
        }
    }
}

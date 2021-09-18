package task3;

public class Main {
    public static void main(String[] args) {
        Point p = new Point();
        p.changeCoords(2.1f, 3.2f);
        p.show();

        float[] f = {1.2f, 2.4f, 4.2f, 5.1f};
        Polygon triangle = new Polygon(f);
        triangle.show();
    }
}

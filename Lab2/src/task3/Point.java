package task3;

public class Point {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void show() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }



}

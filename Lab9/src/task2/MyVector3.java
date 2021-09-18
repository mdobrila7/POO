package task2;

public class MyVector3 implements Sumabil{
        int x;
        int y;

    @Override
    public String toString() {
        return "MyVector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    MyVector3(int a, int b, int c) {
            x = a;
            y = b;
            z = c;
        }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    int z;
    public void addValue(Sumabil value) {
        if(value instanceof MyVector3) {
            MyVector3 aux = (MyVector3) value;
            this.x = this.x + aux.getX();
            this.y = this.y + aux.getY();
            this.z = this.z + aux.getZ();
        }
    }
}

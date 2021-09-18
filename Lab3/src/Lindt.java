public class Lindt extends CandyBox {
    private float length;
    private float width;
    private float height;

    public Lindt() {};
    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

//    public void printLindtDim() {
//        System.out.println("L: " + length + ", W: " + width + ", H: " + height);
//    }


    @Override
    public void printDim() {
        System.out.println("L: " + length + ", W: " + width + ", H: " + height);
    }

    @Override
    public float getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return this.getFlavor() + " " + this.getOrigin() + " has volume " + this.getVolume();
    }
}

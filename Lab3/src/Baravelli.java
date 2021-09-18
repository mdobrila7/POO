public class Baravelli extends CandyBox {
    private float radius;
    private float height;

    public Baravelli() {}
    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

//    public void printBaravelliDim() {
//        System.out.println("R: " + radius + ", H: " + height);
//    }


    @Override
    public void printDim() {
        System.out.println("R: " + radius + ", H: " + height);
    }

    @Override
    public float getVolume() {
        return radius * height;
    }

    @Override
    public String toString() {
        return this.getFlavor() + " " + this.getOrigin() + " has volume " + this.getVolume();
    }
}

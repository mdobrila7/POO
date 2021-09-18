public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {}
    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getVolume() {
        return 0f;
    }

    public void printDim() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyBox candyBox = (CandyBox) o;
        return flavor.equals(candyBox.flavor) &&
                origin.equals(candyBox.origin);
    }

    @Override
    public String toString() {
        return this.flavor + " " + this.origin;
    }
}

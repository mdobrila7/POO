import java.util.*;

public class CandyBag {
    private ArrayList<CandyBox> boxes;

    public CandyBag() {
        boxes = new ArrayList<CandyBox>();
    };

    public CandyBag(ArrayList<CandyBox> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<CandyBox> getBoxes() {
        return boxes;
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int testSize = 5;
        ArrayList<CandyBox> boxes = new ArrayList<CandyBox>();

        // Create the bag of boxes
        for(int i = 0 ; i < testSize; i++) {
            if(i % 3 == 0) {
                boxes.add(new Lindt("Chocolate", "Austria", i + 1, i + 2, i + 3));
            } else if ( i % 3 == 1) {
                boxes.add(new Baravelli("Vanilla", "France", i + 1, i + 2));
            } else {
                boxes.add(new ChocAmor("Caramel", "Germany", i + 1));
            }
        }

        // Check equality
        System.out.println(boxes.get(0).equals(boxes.get(3)));
        System.out.println(boxes.get(0).equals(boxes.get(2)));

        CandyBag bag = new CandyBag(boxes);

        Area delivery = new Area(bag, "Bulevardul Iuliu Maniu", 1);
        delivery.getBirthdayCard();
    }
}
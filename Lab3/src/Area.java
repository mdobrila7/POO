public class Area {
    private CandyBag bag;
    private int number;
    private String street;

    public Area() {
        bag = new CandyBag();
    }

    public Area(CandyBag bag, String street, int number) {
        this.bag = bag;
        this.street = street;
        this.number = number;
    }

    public void getBirthdayCard() {
        System.out.println(street + ", number " + number);
        System.out.println("La multi ani !");

        for (CandyBox box : bag.getBoxes()) {
            System.out.println(box.toString());
        }

//        for (CandyBox box : bag.getBoxes()) {
//            if(box instanceof Baravelli) {
//                ((Baravelli)box).printBaravelliDim();
//            } else if(box instanceof ChocAmor) {
//                ((ChocAmor)box).printChocAmorDim();
//            } else if(box instanceof Lindt) {
//                ((Lindt)box).printLindtDim();
//            }
//        }

        for (CandyBox box : bag.getBoxes()) {
            box.printDim();
        }
    }
}

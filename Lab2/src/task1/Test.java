package task1;

public class Test {
    public static void main(String[] args) {
        Complex a = new Complex(1,2 );
        Complex b = new Complex();
        b.setImaginary(1);
        b.setReal(2);

        Complex c = new Complex(a);

        c.addWithComplex(b);
        a.addWithComplex(b);

        a.showNumber();
        b.showNumber();
        c.showNumber();
    }
}

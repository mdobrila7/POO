package task2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Course c = new Course();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();

        s1.setName("1");
        s1.setYear(1);
        s2.setName("2");
        s2.setYear(2);
        s3.setName("21");
        s3.setYear(2);
        s4.setName("4");
        s4.setYear(4);

        c.setStudents(new Student[]{s1, s2, s3, s4});
        c.setTitle("POO");
        c.setDescription("OOP");

        int year = Integer.parseInt(args[0]);
        System.out.println(Arrays.toString(c.filterYear(year)));

        // Make two students identical
        s2.setName("1");
        s2.setYear(1);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s1.equals(s2));

    }
}

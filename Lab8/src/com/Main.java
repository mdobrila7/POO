package com;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student(1, "Nicolae", "Grama", 9);
        Student s2 = new Student(4, "Bogdan", "Botea", 10);
        Student s3 = new Student(2, "Gabriel", "Sofrone", 6);
        Student s4 = new Student(3, "Alexandru", "Stefanita", 7);
        Student s5 = new Student(5, "Adrian", "Negoita", 7);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        for (Student s : list) {
            System.out.println(s);
        }

        Collections.sort(list);
        System.out.println();

        for (Student s : list) {
            System.out.println(s);
        }

        Comparator<Student> idComparator = (o1, o2) -> (int) (o1.getId() - o2.getId());
        PriorityQueue<Student> queue = new PriorityQueue<>(idComparator);
        queue.addAll(list);

        System.out.println();
        for (Student s : queue) {
            System.out.println(s);
        }

        HashMap<Student, LinkedList<String>> map = new HashMap<>();

        LinkedList<String> subjects = new LinkedList<>();
        subjects.add("Mate");
        subjects.add("Romana");
        subjects.add("Info");
        subjects.add("Fizik");

        for (Student s : queue) {
            map.put(s, subjects);
        }

        System.out.println();
        for (Map.Entry<Student, LinkedList<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println(s);
            }
            System.out.println();
        }

        CustomHashSet hashSet = new CustomHashSet();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        hashSet.addAll(integerLinkedList);
        System.out.println(hashSet);
    }
}

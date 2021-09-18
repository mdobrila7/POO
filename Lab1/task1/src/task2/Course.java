package task2;

import java.util.ArrayList;

public class Course {
    private String title;
    private String description;
    private Student[] students;

    public Student[] filterYear(int year) {
        ArrayList<Student> list = new ArrayList<Student>();

        for(Student curr : students) {
            if(curr.getYear() == year) {
                list.add(curr);
            }
        }

        Student[] s = new Student[list.size()];
        s = list.toArray(s);
        return s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}

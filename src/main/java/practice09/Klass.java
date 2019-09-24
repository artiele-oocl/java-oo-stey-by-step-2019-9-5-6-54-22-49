package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }
    public Student getLeader() {
        return leader;
    }
    public void assignLeader(Student leader) {
        if (isMember(leader)) this.leader = leader;
        else System.out.println("It is not one of us.\n");

    }
    public int getNumber() {
        return number;
    }
    public String getDisplayName() {
        return "Class "+getNumber();
    }
    protected void appendMember(Student student) {
        students.add(student);
    }
    private boolean isMember(Student student) {
        return student.getKlass().number == this.number;
    }
}

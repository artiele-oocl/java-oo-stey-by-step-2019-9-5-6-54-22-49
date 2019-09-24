package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Klass extends Observable {
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
        else System.out.append("It is not one of us.\n");
    }
    public int getNumber() {
        return number;
    }
    public String getDisplayName() {
        return "Class "+getNumber();
    }
    protected void appendMember(Student student) {
        students.add(student);
        news();
    }
    private boolean isMember(Student student) {
        return student.getKlass().number == this.number;
    }
    void news() {
        for(Student s: students){
            //set change
            setChanged();
            //notify observers for change
            notifyObservers(s);
        }
    }
}

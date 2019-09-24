package practice11;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Teacher extends Person implements Observer {
    private LinkedList<Klass> classes;
    private String subIntro = " I am a Teacher. I teach ";

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }
    @Override
    public String introduce() {
        if (getClasses() != null && !getClasses().isEmpty()) {
            String myClasses = "";
            for (Klass klass: getClasses()) {
                myClasses +=Integer.toString(klass.getNumber()).concat(", ");
            }
            return super.introduce().concat(subIntro+"Class "+myClasses.substring(0,myClasses.length()-2)+".");
        }
        else return super.introduce().concat(subIntro+"No Class.");
    }
    public LinkedList<Klass> getClasses() {
        return classes;
    }
    public boolean isTeaching(Student student) {
        for (Klass klass: getClasses()) {
            if (klass.getNumber() == student.isIn()) return true;
        }
        return false;
    }
    public String introduceWith(Student student) {
        return isTeaching(student) ? super.introduce().concat(subIntro+student.getName()+".") : super.introduce().concat(" I am a Teacher. I don't teach "+student.getName()+".");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.append("I am "+getName()+". I know LESTER has joined Class ITERATE OVER CLASS TO GET CLASS# WHERE LESTER BELONG.\n");
    }
}
package practice08;

public class Student extends Person {
    private Klass klass;
    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }
    public Klass getKlass() {
        return klass;
    }
    @Override
    public String introduce() {
        if (getKlass() != null && klass.getLeader() != null && klass.getLeader().getName().equals(this.getName())) {
            return super.introduce().concat(" I am a Student. I am Leader of "+klass.getDisplayName()+".");
        } else {
            return super.introduce().concat(" I am a Student. I am at "+klass.getDisplayName()+".");
        }
    }
}

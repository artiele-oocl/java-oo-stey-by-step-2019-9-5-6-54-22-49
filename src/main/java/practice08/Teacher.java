package practice08;

public class Teacher extends Person {
    private Klass klass;
    private String subIntro = " I am a Teacher. I teach ";

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }
    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }
    public Klass getKlass() {
        return klass;
    }
    @Override
    public String introduce() {
        if (getKlass() != null) return super.introduce().concat(subIntro+klass.getDisplayName()+".");
        else return super.introduce().concat(subIntro+"No Class.");
    }
    public String introduceWith(Student student) {
        return isMyStudent(student) ? super.introduce().concat(subIntro+student.getName()+".") : super.introduce().concat(" I am a Teacher. I don't teach "+student.getName()+".");
    }
    private boolean isMyStudent(Student student) {
        return klass.getNumber() == student.getKlass().getNumber();
    }
}

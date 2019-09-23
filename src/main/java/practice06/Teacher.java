package practice06;

public class Teacher extends Person {
    private int klass;

    public Teacher(String name, int age) {
        super(name, age);
    }
    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }
    public int getKlass() {
        return klass;
    }
    @Override
    public String introduce() {
        String withKlass = super.introduce().concat(" I am a Teacher. I teach Class "+getKlass()+".");
        String withoutKlass = super.introduce().concat(" I am a Teacher. I teach No Class.");
        return getKlass() != 0 ? withKlass : withoutKlass;
    }
}

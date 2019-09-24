package practice09;

import java.util.Objects;

public class Person {
    private int id, age;
    private String name;

    public Person(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    public String introduce() {
        return "My name is " + getName() + ". I am " + getAge() + " years old.";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                getAge() == person.getAge() &&
                getName().equals(person.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getAge());
    }
}

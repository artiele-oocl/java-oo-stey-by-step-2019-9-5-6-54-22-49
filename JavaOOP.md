# Four Pillar of Object Oriented Programming
Simply using classes or saving a file in *.java does not mean that you are doing Object Oriented Programming.
At the same time, Object Oriented Programming is a programming paradigm that is used by Java, C# and other languages
that uses the paradigm. The heart of OOP lies in projecting the abstract concepts of your system as objects in real world.
Object that have both fields and behavior. 
<hr/>

#### Abstraction:
In simple terms, it is dealing with abstract, not concrete, things such as ideas. An example is remote control wherein you know what services or functionality it can offer you but you do not have to know the inner workings of it. Abstraction then serves as an interface between objects; Application Programming Interface is one good application where you only need to know the services it offers. It programming, it is achieved thru the use of Interfaces and Abstract classes.

#### Encapsulation:
Aside from Interfaces and Abstract classes, you use encapsulation to achieve abstraction. You determine properties and behaviors, and then encapsulate or contain them in a class. It i essentially hiding these properties from other objects and thus protecting them from unrelated classes that are trying to directly change their properties. For Abstraction and Encapsulation, I will be using one example only because "Encapsulation is realization of your desired abstraction.".

**Example:**
BuildCSV has implementation build() that is abstracted away from all of its children classes such as class EDIFACT2DSCSV. Class EDIFACT2DSCSV does not need to know implementation of build(), it only needs to know that this method builds CSV and return true for successful build.
```
public abstract class BuildCSV {
    public boolean build() { ... }
}

public class EDIFACT2DSCSV extends BuildCSV{
    public static void main(String[] args) throws Exception{
       EDIFACT2DSCSV objtest=new EDIFACT2DSCSV("d:\\westim003.edi");
       objtest.build();
    }
}
```

#### Inheritance:
Because of abstraction and encapsulation, these object blueprints or classes starts to achieve lose coupling, and separation of concerns.
Thus, avoiding repetitive code implementation. This is good because code becomes more manageable. However, sometimes class need to use an already existing method.
You can do this by using the _extends_ keywords which essentially mean extending the fields and method of the current class.
The fields and methods that are extended comes from parent class.

**Example:**
I want to use the same example from above, wherein build() is inherited from parent class BuildCSV.
This method build() is not overriden in child class because implementation is the same for any child class of BuildCSV,
then all child class just invoke build().
```
public abstract class BuildCSV {
    public boolean build() throws java.lang.Exception {//implementation}
}

public class EDIFACT2DSCSV extends BuildCSV{
    public static void main(String[] args) throws Exception{
       EDIFACT2DSCSV objtest=new EDIFACT2DSCSV("d:\\westim003.edi");
       objtest.build();
    }
}
```

#### Polymorphism:
It is when an object is able to take more than one type. The type may refer to class type or interface.
Below example, Person and Doh implements walk() which is required since they interfaced with Animal.
MyMainClass demonstrates that person and dog are both referencing to Animal but each objects are instantiated or owned
by Person and Dog, respectively. Thus, their corresponding different implementation will take effect. 

**Example:**
```
public interface Animal {
   public String walk();
}
public class Person implements Animal {
    public String walk() { //implementation }
}
public class Dog implements Animal {
    public String walk() { //implementation }
}

class MyMainClass {
  public static void main(String[] args) {
    Animal person = new Person();  // Create a Pig object
    Animal dog = new Dog();  // Create a Dog object

    person.animalSound();
    dog.animalSound();
  }
}
```

# SOLID Principles
SOLID principles are important as they are to achieve readability, maintainability, and future code modification.
SOLID Principles guide you in designing your system. When a legacy system does not prioritize readability and maintainability,
then it is going to be difficult for new features to be added and potential bugs might be introduced.
The four pillars of OOP is important to understand because SOLID principle extensively use above concepts to achieve its goals.
The goals can be put into simpler words: High Cohesion and Low Coupling.
Cohesion is putting similar things together encapsulating them in a class.
Coupling is that two modules should not depend so much on each other; a change in one class should, as much as possible,
not initiate a change in another class.
<hr/>

#### Single Responsibility
>A class should do one and only one job. 

This principle revolves around separation of concerns. In real world example, you have a class Director.
But this class is able to do a lot of things totally unrelated to what is expected of him:
Director is able to direct managers, supports and develops systems for the company, cleans the pantry and the office,
and responsible for computing salaries and taxes of the company's employees. That example is called a God class
because that class is responsible of so much that is even out of its scope. It is a bad practice, and this principle want to resolve it.
Classes should be simple enough that it can stand on its own and be the best in executing a responsibility that is expected from it.
 
Below example shows that director is responsible only for company-wide policies and binding contracts with stakeholder. These responsibilities are not shared
and can only be performed by a Director of a company.

**Example:**
```
public class Director extends Employee {
    super();
    void determinePolicies(){}
    void implementPolicies(){}
    void bindContractWithStakeholders(){}
}
```

#### Open for Extension/Closed for Modification
>Software entities should be Open for extension, but closed for modification. 

When executed properly this principle helps you achieve Low Coupling between classes.
For clarification, software entities refer to classes and modules. Applications of new features should be allowed
to be added in the system but already existing ones should, as much as possible, not be altered. This is important so that
you do not have to test again an already working implementation. From above discussion, you know about Polymorphism as objects taking many forms.
To check object relationships, you also use IS-A to determine the type that is common for two different objects.

Below example, Teacher and Janitor IS-A Employee. Employee is the interface type of both objects therefore you can refer to these objects via Employee.
Class Principal uses constructor injection to inject the object employee dependency to reviewPerformance().
Now, in the future even if you need to add another employee SecurityGuard, you only have to create class SecurityGuard implementing Employee
without the need to update and invoke these objects inside Principal. In other words, you did not change already existing code, you just added SecurityGuard.

**Example:**
```
// previous
public interface Employee {...}
public class Teacher implements Employee {...}
public class Janitor implements Employee {...}
public class Principal {
    void reviewPerformance(Employee employee){...}
}

// new feature SecurityGuard added
public interface Employee {...}
public class Teacher implements Employee {...}
public class Janitor implements Employee {...}
public class SecurityGuard implements Employee {...}
public class Principal {
    void reviewPerformance(Employee employee){...}
}
```

#### Liskov Substitution Principle
>A child class must be able to completely substitute and act-in for it’s base(parent) class.

This means that subclass objects should be able to behave like the parent class without breaking your application.
This principle focuses on the behavior of your methods rather than the structure. 

Our requirement is that management staff should be able to create policies. Below is the correct way of LSP.

**Example:**
```
// previous
public interface Employee {...}
public class Teacher implements Employee {...}
public class Janitor implements Employee {...}
public class SecurityGuard implements Employee {...}
public class Principal implements Employee {
    void reviewPerformance(Employee employee){...}
}

// new feature management are responsible for creating school-wide policies
public interface Employee {...}
public interface ManagementStaff implements Employee {
    void createPolicies();
}
public class Teacher implements Employee {...}
public class Janitor implements Employee {...}
public class SecurityGuard implements Employee {...}
public class Principal extends ManagementStaff {
    void reviewPerformance(Employee employee){...}
    void createPolicies() {//implementation}
}
```

#### Interface Segregation Principle
>Clients should not be forced to depend upon interfaces that they do not use.

In simple terms, your classes should not have methods in it that it does not use.
When executed properly this principle helps you achieve High Cohesion which is encapsulating very related properties and behavior in a single class.

Below demonstrate bad practice and implementing using ISP. Note that all Animals breathe but not all Animals fly. 
By Java naming conventions, action interfaces are named <action>able.
Also, interfaces are contracts and any class implementing are required to provide implementation of the behaviors.

**Example:**
```
// bad practice
public interface Animal {
   void breathe();
   void fly();
}
public class Person implements Animal {
    void breathe() { //implementation }
    void fly() { //no implementation since Person cannot fly }
}
public class Bird implements Animal {
   void breathe() { //implementation }
   void fly() { //implementation }
}

// good practice segrating behavior using interfaces
public interface Animal {
   void breathe();
}
public interface Flyable {
    void fly();
}
public class Person implements Animal {
    void breathe() { //implementation }
}
public class Bird implements Animal, Flyable {
   void breathe() { //implementation }
   void fly() { //implementation }
}
```

#### Dependency Inversion Principle
>Entities must depend on abstractions instead of concretions. Instead of using direct references from a high-level module to a low-level module, use abstractions.

From above definition, abstraction refers to ideas and contracts such as interfaces while concretion refers to implementation of behaviors.
Classes must depend on interfaces, and not on concrete implementations.
Below is a bad implementation because it does not cater other file formats aside from XML.
If you see code below, DIP Implementation, BuildCSVFile now depends on abstraction which is in our case interface File. It does not matter
what file format it is or if you plan to add more formats in the future, as long as it implements File, then our application will not break.

**Example:**
```
// DIP Violation
public class XMLFile {
   void parse() {...};
   void writeCSV() {...}
}
public class BuildCSVFile {
    XMLFile xmlFile;
    void build(XMLFile xmlFile){
        xmlfile.writeCSV();
    }
}

// DIP Implementation
public interface File {
   void parse();
   void write();
}
public class XMLFile implements File {
   void parse() { // XML implementation};
   void write() { // XML implementation};
}
public class EDIFile implements File {
   void parse() { // EDI implementation};
   void write() { // EDI implementation};
}
public class JSONFile implements File {
   void parse() { // JSON implementation};
   void write() { // JSON implementation};
}
public class BuildCSVFile {
    File file;
    void build(File file){
        file.write();
    }
}
```



























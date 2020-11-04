package sample.designpatterns.prototype;

public class Person implements  Prototype{

    private String personName;

    public Person(String personName){
        this.personName  =  personName;
    }

    @Override
    public Prototype doClone() {
        return new Person(personName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                '}';
    }
}

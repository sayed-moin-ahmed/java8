package sample.designpatterns.prototype;

public class Appliction {
    public static void main(String[] args){
        Person p = new Person("test");
        Person pc= (Person) p.doClone();
        System.out.println("Origional::"+p);
        System.out.println("Cloned::"+pc);
        Cat c = new Cat("meaow");
        Cat cp = (Cat) c.doClone();
        System.out.println(cp);
    }
}

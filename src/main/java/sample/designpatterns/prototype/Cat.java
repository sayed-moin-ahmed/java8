package sample.designpatterns.prototype;

public class Cat implements Prototype{

    private String sound;

    public Cat(String sound) {
        this.sound = sound;
    }

    @Override
    public Prototype doClone() {
        return new Cat(sound);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "sound='" + sound + '\'' +
                '}';
    }
}

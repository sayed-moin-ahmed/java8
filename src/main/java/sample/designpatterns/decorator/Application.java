package sample.designpatterns.decorator;

public class Application {
    public static void main(String[] args){
        MessageComponent mcd = new ConcreteMessageDecorator(new ConcreteMessageComponent(),"World");
        System.out.println(mcd.getMessage());
    }
}

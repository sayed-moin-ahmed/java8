package sample.designpatterns.decorator;

public class ConcreteMessageComponent implements MessageComponent {

    @Override
    public String getMessage() {
        return "Hello %s";
    }
}

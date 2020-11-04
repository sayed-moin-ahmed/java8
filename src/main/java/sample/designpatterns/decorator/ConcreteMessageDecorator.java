package sample.designpatterns.decorator;

public class ConcreteMessageDecorator extends  AbstractMessageDecorator{
    private String message;


    public ConcreteMessageDecorator(MessageComponent messageComponent, String msg) {
        this.messageDecorator = messageComponent;
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return String.format(messageDecorator.getMessage(),message);
    }
}

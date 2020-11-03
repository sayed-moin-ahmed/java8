package sample.designpatterns.bridge;

public class Application {
    public static void main(String[] args){
        GenericRemote remote = new GenericRemote(new Sony());
        remote.on();
        remote.incrementChannel();
        remote.decrementChannel();
        remote.off();
    }
}

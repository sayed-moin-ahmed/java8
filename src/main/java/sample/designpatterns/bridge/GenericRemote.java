package sample.designpatterns.bridge;

public class GenericRemote extends Remote{

    private int cid=1;

    public void incrementChannel(){
        setChannel(cid++);
    }

    public void decrementChannel(){
        setChannel(cid--);
    }

    public GenericRemote(TV tv) {
        super(tv);
    }

}

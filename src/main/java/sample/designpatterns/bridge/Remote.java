package sample.designpatterns.bridge;

public abstract class Remote {
    private TV tv;

    public Remote(final TV tv){
        this.tv = tv;
    }

    public boolean on(){
        return  tv.on();
    }

    public boolean off(){
        return tv.off();
    }

    public int setChannel(int no){
        return tv.setChannel(no);
    }

}

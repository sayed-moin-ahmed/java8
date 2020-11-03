package sample.designpatterns.bridge;

public class Sony implements TV {
    @Override
    public boolean on() {
        System.out.println("Sony On");
        return true;
    }

    @Override
    public boolean off() {
        System.out.println("Sony Off");
        return true;
    }

    @Override
    public int setChannel(int no) {
        System.out.println("Sony On::Channel::"+no);
        return no;
    }
}

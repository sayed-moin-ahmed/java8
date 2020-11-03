package sample.designpatterns.bridge;

public class Toshiba  implements TV{
    @Override
    public boolean on() {
        System.out.println("Toshiba On");
        return true;
    }

    @Override
    public boolean off() {
        System.out.println("Toshiba Off");
        return true;
    }

    @Override
    public int setChannel(int no) {
        System.out.println("Toshiba On::Channel::"+no);
        return no;
    }
}

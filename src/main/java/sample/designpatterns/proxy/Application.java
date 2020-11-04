package sample.designpatterns.proxy;

public class Application {
    public static void main(String[] args){
        Image image = new ProxyImage("proxyUrl");
        System.out.println(image.displayImage());
    }
}

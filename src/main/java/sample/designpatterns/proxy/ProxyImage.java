package sample.designpatterns.proxy;

public class ProxyImage  implements  Image{

    private final String url;

    public ProxyImage(String url){
        this.url = url;
    }

    @Override
    public String displayImage() {
        Image image =  new RealImageImpl(url);
        return image.displayImage();
    }
}

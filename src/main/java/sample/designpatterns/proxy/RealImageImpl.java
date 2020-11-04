package sample.designpatterns.proxy;

public class RealImageImpl implements Image{

    private final String url;

    public RealImageImpl(String url){
        this.url = url;
    }

    @Override
    public String displayImage() {
        return url+" displayed";
    }
}

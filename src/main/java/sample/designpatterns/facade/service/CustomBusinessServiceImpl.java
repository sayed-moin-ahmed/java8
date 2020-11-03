package sample.designpatterns.facade.service;

public class CustomBusinessServiceImpl implements BusinessService {
    @Override
    public String show() {
        return "World!";
    }
}

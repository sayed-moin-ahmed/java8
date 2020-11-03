package sample.designpatterns.facade;

import sample.designpatterns.facade.controller.CustomController;

public class Application {
    public static void main(String[] args){
        CustomController cc = new CustomController();
        System.out.println(cc.show());
    }
}

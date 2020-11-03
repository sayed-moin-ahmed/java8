package sample.designpatterns.facade.controller;

import sample.designpatterns.facade.facade.CustomerFacade;
import sample.designpatterns.facade.facade.CustomerFacadeImpl;

public class CustomController {

    public String show(){
        CustomerFacade cf  = new CustomerFacadeImpl();
        return cf.show();
    }


}

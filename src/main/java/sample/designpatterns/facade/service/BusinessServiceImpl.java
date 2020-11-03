package sample.designpatterns.facade.service;

import sample.designpatterns.facade.remote.CustomRest;
import sample.designpatterns.remote.CustomRestImpl;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public String show() {
        CustomRest cr = new CustomRestImpl();
        return "Hello "+ cr.restResult();
    }
}

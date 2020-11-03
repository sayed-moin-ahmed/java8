package sample.designpatterns.remote;

import sample.designpatterns.facade.remote.CustomRest;

public class CustomRestImpl implements CustomRest {
    @Override
    public String restResult() {
        return "remote ";
    }
}

package sample.designpatterns.facade.facade;

import sample.designpatterns.facade.service.BusinessService;
import sample.designpatterns.facade.service.BusinessServiceImpl;
import sample.designpatterns.facade.service.CustomBusinessServiceImpl;

public class CustomerFacadeImpl implements CustomerFacade {
    @Override
    public String show() {
        BusinessService bs1 = new BusinessServiceImpl();
        BusinessService bs2 = new CustomBusinessServiceImpl();
        return bs1.show()+bs2.show();
    }
}

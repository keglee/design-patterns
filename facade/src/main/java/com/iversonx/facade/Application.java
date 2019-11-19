package com.iversonx.facade;

import com.iversonx.facade.model.Business;
import com.iversonx.facade.model.Facade;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/19 20:09
 */
public class Application {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.generate();
    }
}

package com.iversonx.facade.model;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/19 20:09
 */
public class Facade {
    private Presentation presentation;
    private Business business;
    private Dao dao;

    public Facade() {
        presentation = new Presentation();
        business = new Business();
        dao = new Dao();
    }

    public void generate() {
        presentation.generate();
        business.generate();
        dao.generate();
    }
}

package com.iversonx.facade.model;

/**
 * 配置类，仅做示意
 * @author Lijie
 * @version 1.0
 * @date 2019/11/19 20:10
 */
public class ConfigModel {
    private boolean needPresentation = true;
    private boolean needBusiness = true;
    private boolean needDAO = true;

    public boolean isNeedPresentation() {
        return needPresentation;
    }

    public boolean isNeedBusiness() {
        return needBusiness;
    }

    public boolean isNeedDAO() {
        return needDAO;
    }

    public void setNeedPresentation(boolean needPresentation) {
        this.needPresentation = needPresentation;
    }

    public void setNeedBusiness(boolean needBusiness) {
        this.needBusiness = needBusiness;
    }

    public void setNeedDAO(boolean needDAO) {
        this.needDAO = needDAO;
    }
}

package com.iversonx.iterator.old;

import com.iversonx.iterator.Aggregate;
import com.iversonx.iterator.CollectionIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/6 16:37
 */
public class PayManager extends Aggregate<PayModel>{
    private List<PayModel> list = new ArrayList<>();
    /**
     * 计算工资
     */
    public void calcPay() {
        PayModel pm = new PayModel();
        pm.setPay(3800);
        pm.setUserName("张山");

        PayModel m2 = new PayModel();
        m2.setPay(5400);
        m2.setUserName("李四");

        list.add(pm);
        list.add(m2);
    }

    @Override
    public Iterator<PayModel> createIterator() {
        return new CollectionIterator(this);
    }

    public PayModel get(int index) {
        PayModel model = null;
        if(index < list.size()) {
            model = list.get(index);
        }
        return model;
    }

    public int size() {
        return list.size();
    }
}

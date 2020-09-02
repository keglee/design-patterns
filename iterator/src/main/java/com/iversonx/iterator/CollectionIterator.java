package com.iversonx.iterator;

import com.iversonx.iterator.old.PayManager;
import com.iversonx.iterator.old.PayModel;

import java.util.Iterator;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/6 17:14
 */
public class CollectionIterator implements Iterator<PayModel> {
    private PayManager payManager;
    private int index = -1;

    public CollectionIterator(PayManager payManager) {
        this.payManager = payManager;
    }

    @Override
    public PayModel next() {

        if(index == -1) {
            index = 0;
        }

        PayModel model = payManager.get(index);
        if(index < payManager.size()) {
            index = index + 1;
        }
        return model;
    }

    @Override
    public boolean hasNext() {
        return index < payManager.size() ;
    }
}

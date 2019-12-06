package com.iversonx.iterator;

import com.iversonx.iterator.now.SalaryManager;
import com.iversonx.iterator.old.PayModel;

import java.util.Iterator;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/6 16:45
 */
public class ArrayIterator implements Iterator<PayModel> {

    private SalaryManager aggregate;

    private int index = -1;

    public ArrayIterator(SalaryManager aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public PayModel next() {
        if(index == -1) {
            index = 0;
        }
        PayModel model = aggregate.get(index);
        if(index < this.aggregate.size()) {
            index = index + 1;
        }
        return model;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.size();
    }
}

package com.iversonx.iterator.now;

import com.iversonx.iterator.Aggregate;
import com.iversonx.iterator.ArrayIterator;
import com.iversonx.iterator.old.PayModel;

import java.util.Iterator;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/6 16:41
 */
public class SalaryManager extends Aggregate<PayModel> {
    private PayModel[] pms = null;

    public void calcSalary() {
        PayModel pm1 = new PayModel();
        pm1.setPay(3200);
        pm1.setUserName("万五");

        PayModel pm2 = new PayModel();
        pm2.setPay(4100);
        pm2.setUserName("赵六");

        pms = new PayModel[]{pm1, pm2};

    }

    @Override
    public Iterator<PayModel> createIterator() {
        return new ArrayIterator(this);
    }

    public PayModel get(int index) {
        PayModel model = null;
        if(index < pms.length) {
            model = pms[index];
        }
        return model;
    }

    public int size() {
        return pms.length;
    }
}

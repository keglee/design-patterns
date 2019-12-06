package com.iversonx.iterator;

import com.iversonx.iterator.now.SalaryManager;
import com.iversonx.iterator.old.PayManager;
import com.iversonx.iterator.old.PayModel;

import java.util.Iterator;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/12/6 17:17
 */
public class Application {
    public static void main(String[] args) {
        PayManager payManager = new PayManager();
        payManager.calcPay();

        Iterator<PayModel> iterator = payManager.createIterator();
        while (iterator.hasNext()) {
            PayModel model = iterator.next();
            System.out.println(model);
        }

        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        iterator = salaryManager.createIterator();
        while (iterator.hasNext()) {
            PayModel model = iterator.next();
            System.out.println(model);
        }

    }
}

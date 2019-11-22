package com.iversonx.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/22 18:30
 */
public class TempDB {
    private TempDB() {}

    public static Map<String, Double> MONTH_SALE_MONTY = new HashMap<>();
    static {
        MONTH_SALE_MONTY.put("张三", 10000.0);
        MONTH_SALE_MONTY.put("李四", 23000.0);
        MONTH_SALE_MONTY.put("王五", 45000.0);
    }
}

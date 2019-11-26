package com.iversonx.flyweight;

import java.util.ArrayList;
import java.util.List;

public class TestDB {
    public static List<String> data = new ArrayList<>();

    static {
        data.add("张三,人员列表,查看");
        data.add("李四,人员列表,查看");
        data.add("李四,薪资数据,查看");
        data.add("李四,薪资数据,修改");
        for (int i = 0; i < 3; i++) {
            data.add("用户" + i + ",人员列表,查看");
        }
    }
}

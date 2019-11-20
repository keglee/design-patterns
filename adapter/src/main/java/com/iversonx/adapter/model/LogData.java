package com.iversonx.adapter.model;

import java.util.*;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/20 19:22
 */
public class LogData {
    public static Map<String, LogModel> DATA = new HashMap<>();

    // 模拟数据
    static  {
        LogModel model = new LogModel();
        model.setLogId(UUID.randomUUID().toString());
        model.setOperateUser("张三");
        model.setOperateTime("2019-11-20 18:36");
        DATA.put(model.getLogId(),model);

        model = new LogModel();
        model.setLogId(UUID.randomUUID().toString());
        model.setOperateUser("李四");
        model.setOperateTime("2019-11-19 18:36");
        DATA.put(model.getLogId(),model);

        model = new LogModel();
        model.setLogId(UUID.randomUUID().toString());
        model.setOperateUser("赵柳");
        model.setOperateTime("2019-101-20 18:36");
        DATA.put(model.getLogId(),model);
    }
}

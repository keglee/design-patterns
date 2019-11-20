package com.iversonx.adapter;

import com.iversonx.adapter.db.LogDbOperate;
import com.iversonx.adapter.db.LogDbOperateApi;
import com.iversonx.adapter.file.LogFileOperate;
import com.iversonx.adapter.file.LogFileOperateApi;
import com.iversonx.adapter.model.LogModel;

import java.util.*;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/20 18:42
 */
public class Application {
    public static void main(String[] args) {
        LogModel m = new LogModel();
        String uuid = UUID.randomUUID().toString();
        m.setLogId(uuid);
        m.setOperateTime("2019-10-14 00:12:45");
        m.setOperateUser("admin");
        Map<String, LogModel> map = new HashMap<>();
        map.put(m.getLogId(), m);

        LogDbOperateApi api = new LogDbOperate();
        api.insertLog(m);
        Map<String, LogModel> logs = api.mapLog();
        System.out.println(logs);

        System.out.println(api.get(uuid));
    }
}

package com.iversonx.adapter;

import com.iversonx.adapter.db.LogDbOperateApi;
import com.iversonx.adapter.file.LogFileOperate;
import com.iversonx.adapter.file.LogFileOperateApi;
import com.iversonx.adapter.model.LogModel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        // 创建操作日志文件的对象
        LogFileOperateApi fileApi = new LogFileOperate();
        // 创建新版操作日志的接口对象
        LogDbOperateApi api = new Adapter(fileApi);
        // 保存日志
        api.insertLog(m);
        // 读取日志内容
        Map<String, LogModel> logs = api.mapLog();
        System.out.println(logs);
        // 根据logid获取日志信息
        System.out.println(api.get(uuid));
    }
}

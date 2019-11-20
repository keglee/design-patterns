package com.iversonx.adapter.file;

import com.iversonx.adapter.model.LogData;
import com.iversonx.adapter.model.LogModel;

import java.util.Map;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/20 18:44
 */
public class LogFileOperate implements LogFileOperateApi {


    public Map<String, LogModel> readLog() {
        // 模拟从文件中读取日志
        System.out.println("从文件中读取日志");
        return LogData.DATA;
    }

    public void writeLog(Map<String, LogModel> data) {
        System.out.println("写入日志到文件");
        LogData.DATA.putAll(data);
    }
}

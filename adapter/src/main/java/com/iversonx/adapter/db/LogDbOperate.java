package com.iversonx.adapter.db;

import com.iversonx.adapter.model.LogData;
import com.iversonx.adapter.model.LogModel;

import java.util.Map;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/20 19:20
 */
public class LogDbOperate implements LogDbOperateApi {
    public void insertLog(LogModel log) {
        System.out.println("记录日志到数据库");
        LogData.DATA.put(log.getLogId(), log);
    }

    public Map<String, LogModel> mapLog() {
        System.out.println("从数据库中读取日志列表");
        return LogData.DATA;
    }

    public LogModel get(String logId) {
        System.out.println("从数据库读取单条日志");
        return LogData.DATA.get(logId);
    }
}

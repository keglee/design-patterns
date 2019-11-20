package com.iversonx.adapter;

import com.iversonx.adapter.db.LogDbOperateApi;
import com.iversonx.adapter.file.LogFileOperateApi;
import com.iversonx.adapter.model.LogModel;

import java.util.Map;

public class Adapter implements LogDbOperateApi {
    private LogFileOperateApi apdatee;
    public Adapter(LogFileOperateApi apdatee) {
        this.apdatee = apdatee;
    }

    @Override
    public void insertLog(LogModel log) {
        // 模拟从文件中读取内容
        Map<String, LogModel> data = apdatee.readLog();
        // 加入新的日志对象
        data.put(log.getLogId(), log);
        // 重新写入文件
        apdatee.writeLog(data);
    }

    @Override
    public Map<String, LogModel> mapLog() {
        return apdatee.readLog();
    }

    @Override
    public LogModel get(String logId) {
        Map<String, LogModel> data = apdatee.readLog();
        return data.get(logId);
    }
}

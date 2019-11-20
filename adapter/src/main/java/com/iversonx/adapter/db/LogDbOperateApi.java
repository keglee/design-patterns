package com.iversonx.adapter.db;

import com.iversonx.adapter.model.LogModel;

import java.util.List;
import java.util.Map;

public interface LogDbOperateApi {
    void insertLog(LogModel log);
    Map<String, LogModel> mapLog();
    LogModel get(String logId);
}

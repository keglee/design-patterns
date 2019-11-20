package com.iversonx.adapter.file;

import com.iversonx.adapter.model.LogModel;

import java.util.List;
import java.util.Map;

/**
 * 操作日志文件接口
 */
public interface LogFileOperateApi {
    Map<String, LogModel> readLog();
    void writeLog(Map<String, LogModel> data);
}

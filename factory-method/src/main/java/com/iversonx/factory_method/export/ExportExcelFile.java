package com.iversonx.factory_method.export;

public class ExportExcelFile implements ExportFile {
    public boolean export(String data) {
        // 此处示意，不做真的文件导出实现
        System.out.println("导出数据[" + data + "]到Excel文件");
        return true;
    }
}

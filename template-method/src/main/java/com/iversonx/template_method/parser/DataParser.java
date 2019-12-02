package com.iversonx.template_method.parser;

public abstract class DataParser {

    public final void process() {
        readData();
        analysisData();
        processData();
        writeData();
    }

    protected void analysisData() {
        System.out.println("使用缺省的分析数据步骤");
    }

    protected abstract void readData();
    protected abstract void processData();
    protected abstract void writeData();
}

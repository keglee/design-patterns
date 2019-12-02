package com.iversonx.template_method.parser;

public class FileDataParser extends DataParser {
    protected void analysisData() {
        System.out.println("对文件中的数据进行分析");
    }

    protected void readData() {
        System.out.println("从文件中读取数据");
    }

    protected void processData() {
        System.out.println("处理文件中的数据");
    }
    protected void writeData() {
        System.out.println("将处理后的数据写入文件");
    }
}

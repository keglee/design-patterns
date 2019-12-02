package com.iversonx.template_method.parser;

public class DatabaseDataParser extends DataParser {

    protected void readData() {
        System.out.println("从数据库中读取数据");
    }

    protected void processData() {
        System.out.println("处理数据库中的数据");
    }
    protected void writeData() {
        System.out.println("将处理后的数据写入数据库");
    }

}

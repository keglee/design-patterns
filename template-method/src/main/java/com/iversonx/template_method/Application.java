package com.iversonx.template_method;

import com.iversonx.template_method.parser.DataParser;
import com.iversonx.template_method.parser.DatabaseDataParser;
import com.iversonx.template_method.parser.FileDataParser;

public class Application {

    public static void main(String[] args) {
        DataParser parser = new FileDataParser();
        parser.process();
        System.out.println("=============================");
        parser = new DatabaseDataParser();
        parser.process();
    }
}

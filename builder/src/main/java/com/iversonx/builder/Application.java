package com.iversonx.builder;

import com.iversonx.builder.model.Body;
import com.iversonx.builder.model.Footer;
import com.iversonx.builder.model.Header;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {
    public static void main(String[] args) {
        String result = build(new XmlBuilder());
        System.out.println(result);

        result = build(new TxtBuilder());
        System.out.println(result);
    }

    private static String build(Builder builder) {
        Header header = new Header(UUID.randomUUID().toString(), "测试");

        List<Body> data = new ArrayList<>(3);
        data.add(new Body("测试数据1","51.4", "10"));
        data.add(new Body("测试数据2","67.5", "5"));
        data.add(new Body("测试数据3","78.9", "3"));

        Footer footer = new Footer("张三", "2019-11-16");
        Director director = new Director(builder);
        director.construct(header, data, footer);
        return builder.getExportFile();
    }
}

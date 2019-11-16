package com.iversonx.factory_method;


import com.iversonx.factory_method.cretor.ExportExcelOperate;
import com.iversonx.factory_method.cretor.ExportOperate;
import com.iversonx.factory_method.cretor.ExportTxtOperate;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/15 17:32
 */
public class Application {

    public static void main(String[] args) {
        String data = "测试数据";
        ExportOperate operate = new ExportExcelOperate();
        operate.export(data);

        operate = new ExportTxtOperate();
        operate.export(data);
    }
}

package com.iversonx.factory_method.cretor;

import com.iversonx.factory_method.export.ExportExcelFile;
import com.iversonx.factory_method.export.ExportFile;

public class ExportExcelOperate extends ExportOperate {
    protected ExportFile factoryMethod() {
        return new ExportExcelFile();
    }
}
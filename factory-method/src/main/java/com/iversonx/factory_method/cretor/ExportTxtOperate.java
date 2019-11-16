package com.iversonx.factory_method.cretor;

import com.iversonx.factory_method.export.ExportFile;
import com.iversonx.factory_method.export.ExportTxtFile;

public class ExportTxtOperate extends ExportOperate {
    protected ExportFile factoryMethod() {
        return new ExportTxtFile();
    }
}

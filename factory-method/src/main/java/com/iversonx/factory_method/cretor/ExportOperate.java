package com.iversonx.factory_method.cretor;

import com.iversonx.factory_method.export.ExportFile;

public abstract class ExportOperate {
    public boolean export(String data) {
        ExportFile e = factoryMethod();
        return e.export(data);
    }

    protected abstract ExportFile factoryMethod();
}

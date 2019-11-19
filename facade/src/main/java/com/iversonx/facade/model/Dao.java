package com.iversonx.facade.model;

/**
 * 示意生成表现层的模块
 * @author Lijie
 * @version 1.0
 * @date 2019/11/19 20:14
 */
public class Dao {
    protected void generate() {
        // 从配置管理中获取配置
        ConfigModel config = ConfigManager.getInstance().getConfig();
        if(config.isNeedDAO()) {
            // 按照要求生成代码,并保存文件，这里仅做示意
            System.out.println("正在生成DAO层代码文件");
        }
    }
}

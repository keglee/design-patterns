package com.iversonx.facade.model;

/**
 * @author Lijie
 * @version 1.0
 * @date 2019/11/19 20:10
 */
public class ConfigManager {
    private static ConfigManager manager = new ConfigManager();
    private static ConfigModel config;

    private ConfigManager() {
        config = new ConfigModel();
    }

    public static ConfigManager getInstance() {
        return manager;
    }

    public ConfigModel getConfig() {
        return config;
    }
}

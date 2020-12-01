package com.design.behavior.memorandum.design;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class ConfigOriginator {
    private ConfigFile configFile;

    public ConfigOriginator() {
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento saveMemento() {
        return new ConfigMemento(configFile);
    }

    public void getMemento(ConfigMemento configMemento) {
        configFile = configMemento.getConfigFile();
    }
}

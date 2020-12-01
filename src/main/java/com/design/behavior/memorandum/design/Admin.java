package com.design.behavior.memorandum.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class Admin {
    private int cursorIdx = 0;
    private List<ConfigMemento> configMementoList = new ArrayList<>();
    private Map<String,ConfigMemento> configMementoMap = new ConcurrentHashMap<>();

    public void append(ConfigMemento configMemento) {
        configMementoList.add(configMemento);
        configMementoMap.put(configMemento.getConfigFile().getVersionNo(), configMemento);
        cursorIdx++;
    }

    public ConfigMemento undo() {
        if (--cursorIdx <= 0) {
            return configMementoList.get(0);
        }
        return configMementoList.get(cursorIdx);
    }

    public ConfigMemento redo() {
        if (++cursorIdx >= configMementoList.size()) {
            return configMementoList.get(configMementoList.size() - 1);
        }
        return configMementoList.get(cursorIdx);
    }

    public ConfigMemento get(String versionNo) {
        return configMementoMap.get(versionNo);
    }
}

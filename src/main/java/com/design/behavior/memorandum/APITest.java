package com.design.behavior.memorandum;

import com.alibaba.fastjson.JSON;
import com.design.behavior.memorandum.design.Admin;
import com.design.behavior.memorandum.design.ConfigFile;
import com.design.behavior.memorandum.design.ConfigOriginator;

import java.util.Date;

/**
 * 备忘录模式是以可以恢复或者说回滚，配置、版本、悔棋为核心功能的设计模式，而这种设计模式属于行为模式。
 * 在功能实现上是以不破坏原对象为基础增加备忘录操作类，记录原对象的行为从而实现备忘录模式。
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {

            Admin admin = new Admin();

            ConfigOriginator configOriginator = new ConfigOriginator();

            configOriginator.setConfigFile(new ConfigFile("1000001", "配置内容A=哈哈", new Date(), "小傅哥"));
            admin.append(configOriginator.saveMemento()); // 保存配置

            configOriginator.setConfigFile(new ConfigFile("1000002", "配置内容A=嘻嘻", new Date(), "小傅哥"));
            admin.append(configOriginator.saveMemento()); // 保存配置

            configOriginator.setConfigFile(new ConfigFile("1000003", "配置内容A=么么", new Date(), "小傅哥"));
            admin.append(configOriginator.saveMemento()); // 保存配置

            configOriginator.setConfigFile(new ConfigFile("1000004", "配置内容A=嘿嘿", new Date(), "小傅哥"));
            admin.append(configOriginator.saveMemento()); // 保存配置

            // 历史配置(回滚)
            configOriginator.getMemento(admin.undo());
            System.out.println("历史配置(回滚)undo：{}"+ JSON.toJSONString(configOriginator.getConfigFile()));

            // 历史配置(回滚)
            configOriginator.getMemento(admin.undo());
            System.out.println("历史配置(回滚)undo：{}"+ JSON.toJSONString(configOriginator.getConfigFile()));

            // 历史配置(前进)
            configOriginator.getMemento(admin.redo());
            System.out.println("历史配置(前进)redo：{}"+ JSON.toJSONString(configOriginator.getConfigFile()));

            // 历史配置(获取)
            configOriginator.getMemento(admin.get("1000002"));
            System.out.println("历史配置(获取)get：{}"+ JSON.toJSONString(configOriginator.getConfigFile()));

    }
}

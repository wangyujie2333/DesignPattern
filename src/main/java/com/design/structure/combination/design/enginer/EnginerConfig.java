package com.design.structure.combination.design.enginer;

import com.design.structure.combination.design.filter.LogicFilter;
import com.design.structure.combination.design.filter.impl.AgeLogicFilter;
import com.design.structure.combination.design.filter.impl.SexLogicFilter;

import java.util.HashMap;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public class EnginerConfig {

    static HashMap<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new HashMap<>();
        logicFilterMap.put("userGender", new SexLogicFilter());
        logicFilterMap.put("userAge", new AgeLogicFilter());
    }

    public static HashMap<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }
}

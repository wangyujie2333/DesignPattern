package com.design.structure.combination.design.filter.impl;

import com.design.structure.combination.design.filter.BasicFilter;

import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public class SexLogicFilter extends BasicFilter {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("userGender");
    }
}

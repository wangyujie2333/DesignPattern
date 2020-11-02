package com.design.structure.combination.design.filter;

import com.design.structure.combination.model.vo.TreeNode;
import com.design.structure.combination.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 决策过滤器
 * @author wangyuj
 * @date 2020/10/30
 **/
public interface LogicFilter {

    /**
     * 树节点过滤逻辑
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     * @return
     */
    String matterValue(Long treeId, String userId, Map<String,String> decisionMatter);
}

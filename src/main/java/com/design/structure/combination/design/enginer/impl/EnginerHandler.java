package com.design.structure.combination.design.enginer.impl;

import com.design.structure.combination.design.enginer.EnginerBase;
import com.design.structure.combination.model.aggregates.TreeRich;
import com.design.structure.combination.model.vo.EngineResult;
import com.design.structure.combination.model.vo.TreeNode;

import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public class EnginerHandler extends EnginerBase {
    @Override
    public EngineResult doProcess(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}

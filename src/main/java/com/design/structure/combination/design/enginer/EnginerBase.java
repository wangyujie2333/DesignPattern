package com.design.structure.combination.design.enginer;

import com.design.structure.combination.design.filter.LogicFilter;
import com.design.structure.combination.model.aggregates.TreeRich;
import com.design.structure.combination.model.vo.EngineResult;
import com.design.structure.combination.model.vo.TreeNode;
import com.design.structure.combination.model.vo.TreeNodeLink;
import com.design.structure.combination.model.vo.TreeRoot;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.List;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public abstract class EnginerBase extends EnginerConfig implements IEnginer {

    public abstract EngineResult doProcess(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Long treeRootNodeId = treeRoot.getTreeRootNodeId();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        TreeNode treeNode = treeNodeMap.get(treeRootNodeId);
        while (treeNode.getNodeType().equals(1)) {
            LogicFilter logicFilter = logicFilterMap.get(treeNode.getRuleKey());
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNodeId = logicFilter.filter(matterValue, treeNode.getTreeNodeLinkList());
            treeNode = treeNodeMap.get(nextNodeId);
        }
        return treeNode;
    }


}

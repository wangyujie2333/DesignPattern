package com.design.structure.combination.design.enginer;

import com.design.structure.combination.model.aggregates.TreeRich;
import com.design.structure.combination.model.vo.EngineResult;
import com.design.structure.combination.model.vo.TreeNode;

import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public interface IEnginer {

    EngineResult doProcess(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);
}

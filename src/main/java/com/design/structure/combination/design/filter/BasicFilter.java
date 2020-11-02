package com.design.structure.combination.design.filter;

import com.design.structure.combination.model.vo.TreeNodeLink;

import java.util.List;

/**
 * @author wangyuj
 * @date 2020/10/30
 **/
public abstract class BasicFilter implements LogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for (TreeNodeLink treeNodeLink : treeNodeLinkList) {
            if (decisionLogic(matterValue, treeNodeLink)) return treeNodeLink.getNodeIdTo();
        }
        return 0L;
    }

    private boolean decisionLogic(String matterValue, TreeNodeLink treeNodeLink) {
        Integer ruleLimitType = treeNodeLink.getRuleLimitType();
        switch (ruleLimitType) {
            case 1:
                return treeNodeLink.getRuleLimitValue().equals(matterValue);
            case 2:
                return Double.parseDouble(treeNodeLink.getRuleLimitValue()) < Double.parseDouble(matterValue);
            case 3:
                return Double.parseDouble(treeNodeLink.getRuleLimitValue()) > Double.parseDouble(matterValue);
            case 4:
                return Double.parseDouble(treeNodeLink.getRuleLimitValue()) >= Double.parseDouble(matterValue);
            case 5:
                return Double.parseDouble(treeNodeLink.getRuleLimitValue()) <= Double.parseDouble(matterValue);
            default:
                break;
        }
        return false;
    }

}

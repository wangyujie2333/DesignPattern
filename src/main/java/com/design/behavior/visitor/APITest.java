package com.design.behavior.visitor;

import com.design.behavior.visitor.design.visitor.DataView;
import com.design.behavior.visitor.design.visitor.impl.Parent;

/**
 * 访问者要解决的核心事项是，在一个稳定的数据结构下，
 * 例如用户信息、雇员信息等，增加易变的业务访问逻辑。
 * 为了增强扩展性，将这两部分的业务解耦的一种设计模式。
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        DataView dataView = new DataView();
        dataView.visitor(new Parent());

    }
}

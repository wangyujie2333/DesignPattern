package com.design.behavior.intermediary.design.mediator;

/**
 * @author wangyuj
 * @date 2020/11/27
 **/
public interface SqlSessionFactory {

    SqlSession openSession();
}

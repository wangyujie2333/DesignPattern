package com.design.behavior.intermediary.design.mediator;

import java.sql.SQLException;

/**
 * @author wangyuj
 * @date 2020/11/27
 **/
public interface SqlSession {
    <T> T selectOne(String id) throws SQLException;
}

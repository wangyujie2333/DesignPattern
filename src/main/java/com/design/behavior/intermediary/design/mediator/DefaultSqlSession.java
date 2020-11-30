package com.design.behavior.intermediary.design.mediator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/11/27
 **/
public class DefaultSqlSession implements SqlSession {
    protected Connection connection;
    protected Map<String, XNode> mapperElement;

    public DefaultSqlSession() {
    }

    public DefaultSqlSession(Connection connection, Map<String, XNode> mapperElement) {
        this.connection = connection;
        this.mapperElement = mapperElement;
    }

    @Override
    public <T> T selectOne(String statement) throws SQLException {
        XNode xNode = mapperElement.get(statement);
        PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
        ResultSet resultSet = preparedStatement.executeQuery();
        return (T) resultSet.getObject(1, String.class);
    }

}

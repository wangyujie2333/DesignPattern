package com.design.behavior.intermediary.design.mediator;

/**
 * @author wangyuj
 * @date 2020/11/27
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection,configuration.mapperElement);
    }
}

package com.orm.frame.core.factory;

import com.orm.frame.core.pojo.Configuration;
import com.orm.frame.openApi.SqlSession;
import com.orm.frame.openApi.SqlSessionImpl;

/**
 * SqlSession工厂类，负责创建SqlSession接口实现类
 */
public class SqlSessionFactory {

    private Configuration configuration;

    public SqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 创建SqlSession会话
     */
    public SqlSession openSession(){
        return new SqlSessionImpl(configuration);
    }
}

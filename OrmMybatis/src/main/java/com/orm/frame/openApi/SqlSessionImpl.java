package com.orm.frame.openApi;

import com.orm.frame.core.Executor;
import com.orm.frame.core.pojo.Configuration;

import java.util.List;

public class SqlSessionImpl implements SqlSession {

    //每次Sql会话连接，必须要有数据库配置信息
    private Configuration configuration;

    public SqlSessionImpl(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> List<T> selectList(String statement) throws Exception{
        Executor executor = new Executor(configuration);

        return (List<T>) executor.executeQuery(statement);
    }

    public int deleteById(String sql, Integer id) throws Exception{
        Executor executor = new Executor(configuration);
        return executor.executeUpdate(sql, id, "delete");
    }

    public int save(String sql, Object param) throws Exception{
        Executor executor = new Executor(configuration);
        return executor.executeUpdate(sql, param, "save");
    }

    public int update(String sql, Object param) throws Exception {
        Executor executor = new Executor(configuration);
        return executor.executeUpdate(sql, param, "update");
    }

}

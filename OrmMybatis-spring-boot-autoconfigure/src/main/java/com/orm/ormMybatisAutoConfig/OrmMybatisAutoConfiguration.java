package com.orm.ormMybatisAutoConfig;

import com.orm.frame.core.factory.SqlSessionFactory;
import com.orm.frame.core.factory.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
@ConditionalOnClass(name = "com.orm.frame.core.factory.SqlSessionFactory")
public class OrmMybatisAutoConfiguration {

    @Bean
    @ConditionalOnProperty(name = "ormMybatis.frame.enable", havingValue = "true", matchIfMissing = true)
    public SqlSessionFactory initFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            //1.创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //2.builder对象构建工厂对象
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
            sqlSessionFactory = builder.build(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

}

package com.example;

import com.example.pojo.User;
import com.orm.frame.core.factory.SqlSessionFactory;
import com.orm.frame.openApi.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = OrmMybatisApplication.class)
public class OrmMybatisFrameTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void init(){
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testQuery() throws Exception {
        //4.执行查询Sql语句
        List<User> users = sqlSession.selectList("com.example.dao.UserMapper.findAll");
        //5.循环打印
        for (User u : users) {
            System.out.println(u);
        }
    }


    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setId(3);
        user.setName("张三");
        user.setAge(10);
        user.setAddress("南京");
        int res = sqlSession.save("com.example.dao.UserMapper.save",user);
        if (res > 0){
            System.out.println("插入成功");
        }
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(3);
        user.setName("张三");
        user.setAge(18);
        user.setAddress("江苏");
        int res = sqlSession.update("com.example.dao.UserMapper.update",user);
        if (res > 0){
            System.out.println("修改成功");
        }
    }

    @Test
    public void testDelete() throws Exception {
        int res = sqlSession.deleteById("com.example.dao.UserMapper.deleteById",3);
        System.out.println(res);
    }

}

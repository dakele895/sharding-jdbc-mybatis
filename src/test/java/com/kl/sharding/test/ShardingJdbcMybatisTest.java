
package com.kl.sharding.test;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.kl.sharding.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kl.sharding.entity.Student;
import com.kl.sharding.entity.User;
import com.kl.sharding.service.StudentService;
import com.kl.sharding.service.UserService;

/**
 * 测试分库分表规则
 * @author liuyazhuang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:config/spring/spring-database.xml", "classpath*:config/spring/spring-sharding.xml" })  
public class ShardingJdbcMybatisTest {  

    @Resource  
    public UserService userService;  
      
    @Resource  
    public StudentService studentService;  

    @Test  
    public void testUserInsert() {  
        User u = new User();
        u.setId(UUID.getUUID());
        u.setUserId(UUID.getUUID());
        u.setAge(26);
        u.setName("githubs");
        Assert.assertEquals(userService.insert(u), true);  
    }  
      
    @Test  
    public void testStudentInsert() {  
        Student student = new Student();
        student.setId(UUID.getUUID());
        student.setStudentId(UUID.getUUID());
        student.setAge(21);  
        student.setName("hehe");  
        Assert.assertEquals(studentService.insert(student), true);  
    }  

    @Test  
    public void testFindAll(){  
        List<User> users = userService.findAll();  
        if(null != users && !users.isEmpty()){  
            for(User u :users){  
                System.out.println(u);  
            }  
        }  
    }  
      
    @Test  
    public void testSQLIN(){  
        List<User> users = userService.findByUserIds(Arrays.asList("1486095201"));
        if(null != users && !users.isEmpty()){  
            for(User u :users){  
                System.out.println(u);  
            }  
        }  
    }  
      
    @Test  
    public void testTransactionTestSucess(){  
        userService.transactionTestSucess();  
    }  
      
    @Test(expected = IllegalAccessException.class)  
    public void testTransactionTestFailure() throws IllegalAccessException{  
        userService.transactionTestFailure();  
    }  
}  
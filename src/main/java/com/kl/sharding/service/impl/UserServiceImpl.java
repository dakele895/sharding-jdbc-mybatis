package com.kl.sharding.service.impl;
 import java.util.List;

import javax.annotation.Resource;

 import com.kl.sharding.util.UUID;
 import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kl.sharding.entity.Student;
import com.kl.sharding.entity.User;
import com.kl.sharding.mapper.StudentMapper;
import com.kl.sharding.mapper.UserMapper;
import com.kl.sharding.service.UserService;
  
@Service  
@Transactional  
public class UserServiceImpl implements UserService {  
  
    @Resource  
    public UserMapper userMapper;  
      
    @Resource  
    public StudentMapper studentMapper;  
  
    public boolean insert(User u) {  
        return userMapper.insert(u) > 0 ? true :false;  
    }  
  
    public List<User> findAll() {  
        return userMapper.findAll();  
    }  
  
    public List<User> findByUserIds(List<String> ids) {
        return userMapper.findByUserIds(ids);  
    }  
  
    @Transactional(propagation=Propagation.REQUIRED)  
    public void transactionTestSucess() {  
        User u = new User();  
        u.setUserId(UUID.getUUID());
        u.setAge(25);  
        u.setName("war3 1.27");  
        userMapper.insert(u);  
          
        Student student = new Student();  
        student.setStudentId(UUID.getUUID());
        student.setAge(21);  
        student.setName("hehe");  
        studentMapper.insert(student);  
    }  
  
    @Transactional(propagation=Propagation.REQUIRED)  
    public void transactionTestFailure() throws IllegalAccessException {  
        User u = new User();  
        u.setUserId(UUID.getUUID());
        u.setAge(25);  
        u.setName("war3 1.27 good");  
        userMapper.insert(u);  
          
        Student student = new Student();  
        student.setStudentId(UUID.getUUID());
        student.setAge(21);  
        student.setName("hehe1");  
        studentMapper.insert(student);  
        throw new IllegalAccessException();  
    }  
      
}  
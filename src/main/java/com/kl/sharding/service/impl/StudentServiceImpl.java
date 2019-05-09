package com.kl.sharding.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kl.sharding.entity.Student;
import com.kl.sharding.mapper.StudentMapper;
import com.kl.sharding.service.StudentService;
  
@Service  
public class StudentServiceImpl implements StudentService{  
      
    @Resource  
    public StudentMapper studentMapper;  
  
    public boolean insert(Student student) {  
        return studentMapper.insert(student) > 0 ? true : false;  
    }  
  
}  
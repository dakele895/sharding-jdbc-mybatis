package com.kl.sharding.mapper;

import java.util.List;
import com.kl.sharding.entity.Student;

/**
 * 处理学生的数据操作接口
 */
public interface StudentMapper {  
      
    Integer insert(Student s);  
      
    List<Student> findAll();  
      
    List<Student> findByStudentIds(List<String> studentIds);

}  


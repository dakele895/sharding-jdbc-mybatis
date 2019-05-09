package com.kl.sharding.service;

import java.util.List;
import com.kl.sharding.entity.User;

/**
 * 处理用户的Service
 */
public interface UserService {  
      
    public boolean insert(User u);  
      
    public List<User> findAll();  
      
    public List<User> findByUserIds(List<String> ids);
      
    public void transactionTestSucess();  
      
    public void transactionTestFailure() throws IllegalAccessException;  

}  
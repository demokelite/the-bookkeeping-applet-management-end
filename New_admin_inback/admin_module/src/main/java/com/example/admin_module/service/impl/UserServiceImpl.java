package com.example.admin_module.service.impl;

import com.example.admin_module.service.UserService;
import com.example.admin_module.mapper.UserMapper;
import com.example.admin_module.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User selectUserById(Integer id){
        return userMapper.selectUserById(id);
    }

    @Override
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

}

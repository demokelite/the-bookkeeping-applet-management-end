package com.example.admin_module.service;

import com.example.admin_module.entity.User;
import java.util.List;

public interface UserService {
    //查询全部 user 数据
    List<User> listUser();

    //根据 id 查询一条 user 数据
    User selectUserById(Integer id);

    //新增一条 user 数据
    int insertUser(User user);

    //更新一条 user 数据
    int updateUser(User user);

    //根据 id 删除一条 user 数据
    int deleteUserById(Integer id);
}

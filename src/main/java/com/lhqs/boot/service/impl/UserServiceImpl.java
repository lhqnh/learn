package com.lhqs.boot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhqs.boot.bean.User;
import com.lhqs.boot.mapper.UserMapper;
import com.lhqs.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    UserMapper userMapper;

    public User findUser(String userName){
        return userMapper.findUser(userName);
    }

    public boolean deleteUserById(Integer userId){
        return userMapper.deleteUserById(userId);
    }


}

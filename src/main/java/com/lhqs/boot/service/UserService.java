package com.lhqs.boot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lhqs.boot.bean.User;



public interface UserService extends IService<User> {
    User findUser(String userName);
    public boolean deleteUserById(Integer userId);
}

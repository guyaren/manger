package com.cxcs.manger.service.impl;

import com.cxcs.manger.entity.User;
import com.cxcs.manger.mapper.UserMapper;
import com.cxcs.manger.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}

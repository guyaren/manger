package com.cxcs.manger.service.impl;

import com.cxcs.manger.entity.User;
import com.cxcs.manger.dao.UserDao;
import com.cxcs.manger.service.IUserService;
import com.cxcs.manger.vo.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;


    @Override
    public CommonResponse<List<User>> getAllUsers() {
        return CommonResponse.buildSuccess(userDao.getAllUsers());
    }

    @Override
    public CommonResponse<List<User>> query(User user) {
        return CommonResponse.buildSuccess(userDao.query(user));
    }

    @Override
    public CommonResponse<Integer> addtUser(User user) {
        return CommonResponse.buildSuccess(userDao.addUser(user));
    }

    @Override
    public CommonResponse<Integer> updateUser(User user) {
        return CommonResponse.buildSuccess(userDao.updateUser(user));
    }

    @Override
    public CommonResponse<Integer> deleteUser(Integer id) {
        return CommonResponse.buildSuccess(userDao.deleteUser(id));
    }
}

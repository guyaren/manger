package com.cxcs.manger.mapper;

import com.cxcs.manger.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "username", column = "name"),
//            @Result(property = "password", column = "pwd")
//    })
    @Select("select id as id,name as username,pwd as password from user_t")
    List<User> getAllUsers();


}

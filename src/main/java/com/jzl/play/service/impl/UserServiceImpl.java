package com.jzl.play.service.impl;

import com.jzl.play.mapper.UserMapper;
import com.jzl.play.model.User;
import com.jzl.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zalej
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUsers(User user) {
        if (user == null) {
            return null;
        }
        Example example = new Example(User.class);
        example.and().andEqualTo("name", user.getName());
        example.and().andEqualTo("password", user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public int updateUser(User user) {
        int effectRows = userMapper.updateUser(user);
        return effectRows;
    }
}

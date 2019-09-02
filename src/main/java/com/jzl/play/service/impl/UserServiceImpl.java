package com.jzl.play.service.impl;

import com.jzl.play.mapper.UserMapper;
import com.jzl.play.model.User;
import com.jzl.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zalej
 */
@Service("UserService")
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Override
//    @Cacheable(key = "#user.name")
    public List<User> selectUsers(User user) {
        Example example = new Example(User.class);
        example.and().andEqualTo("name", user.getName());
        example.and().andEqualTo("password", user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public Integer save(User user) {
        return null;
    }

    @Override
//    @Cacheable(key = "#id")
    public User selectById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
//    @Cacheable(key = "#name")
    public List<User> selectByName(String name) {
        Example example = new Example(User.class);
        example.and().andEqualTo("name", name);

        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public int updateUser(User user) {
        int effectRows = userMapper.updateUser(user);
        return effectRows;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}

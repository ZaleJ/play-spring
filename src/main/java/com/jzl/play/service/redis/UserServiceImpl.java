package com.jzl.play.service.redis;

import com.jzl.play.model.User;
import com.jzl.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zalej
 */
@Service("UserServiceRedis")
public class UserServiceImpl implements UserService {
    @Autowired
    RedisTemplate<Integer, Object> redisTemplate;

    @Override
//    @Cacheable(key = "#user.name")
    public List<User> selectUsers(User user) {

        return null;
    }

    @Override
    public Integer save(User user) {
        Integer id = user.getId();
        redisTemplate.opsForValue().set(id, user);
        return id;
    }

    @Override
//    @Cacheable(key = "#id")
    public User selectById(Integer id) {
        Object o = redisTemplate.opsForValue().get(id);
        return (User) o;
    }

    @Override
//    @Cacheable(key = "#name")
    public List<User> selectByName(String name) {
//        Example example = new Example(User.class);
//        example.and().andEqualTo("name", name);
//
//        List<User> userList = userMapper.selectByExample(example);
//        return userList;
        return null;
    }

    @Override
    public int updateUser(User user) {
        Integer id = user.getId();
        redisTemplate.opsForValue().set(id, user);
        return id;
    }

    @Override
    public int delete(Integer id) {
        redisTemplate.opsForValue().getOperations().delete(id);
        return id;
    }
}

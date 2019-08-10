package com.jzl.play.mapper;

import com.jzl.play.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zalej
 */
public interface UserMapper extends Mapper<User> {

    int updateUser(User user);
}
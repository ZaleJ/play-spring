package com.jzl.play.controller;

import com.jzl.play.common.Result;
import com.jzl.play.model.User;
import com.jzl.play.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zalej
 */
@RestController
@RequestMapping("/jzl/user")
@Api(tags = "用户api")
public class UserController {
    @Autowired
    @Qualifier("UserServiceRedis")
    private UserService userService;

    @GetMapping("selectById")
    @ApiOperation("根据id查询用户")
    public Result<User> selectById(Integer id) {
        User user = userService.selectById(id);
        return Result.success(user);
    }

    @GetMapping("selectByName")
    @ApiOperation("根据name查询用户")
    public Result<List<User>> selectByName(String name) {
        return Result.success(userService.selectByName(name));
    }

    @GetMapping("selectUser")
    @ApiOperation("查询用户")
    public Result<List<User>> selectUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return Result.success(userService.selectUsers(user));
    }


    @PutMapping("save")
    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query", required = false),
    })
    public Result<Integer> save(User user) {
        int effectRows = userService.save(user);
        return Result.success(effectRows);
    }

    @PostMapping("updateUser")
    @ApiOperation("更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query", required = false),
    })
    public Result<Integer> updateUser(User user) {
        int effectRows = userService.updateUser(user);
        return Result.success(effectRows);
    }

    @DeleteMapping("delete")
    @ApiOperation("更新用户")
    public Result<Integer> delete(Integer id) {
        int effectRows = userService.delete(id);
        return Result.success(effectRows);
    }
}

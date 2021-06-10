package com.fung.controller;

import com.fung.common.PageResult;
import com.fung.common.ResponseResult;
import com.fung.domain.User;
import com.fung.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/user/{id}")
    public ResponseResult findById(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        if (user==null){
            //説明沒有對應用戶
            return new ResponseResult(500,"Can't find a user",null);
        }
        return new ResponseResult(200,"success",user);
    }

    @GetMapping("/user")
    public ResponseResult findAll(){
        List<User> list = userService.findAll();
        return new ResponseResult(200,"success",list);
    }

    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize,@PathVariable("pageNum") Integer pageNum){
        PageResult pageResult = userService.findByPage(pageSize,pageNum);
        return new ResponseResult(200,"success",pageResult);
    }

    @PostMapping("/user")
    public ResponseResult insertUser(@RequestBody User user){
        userService.insertUser(user);
        return new ResponseResult(200,"success",null);
    }

    @DeleteMapping("/user/{id}")
    public ResponseResult deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseResult(200,"success",null);
    }

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseResult(200,"success",null);
    }

    @RequestMapping("/user/test")
    public ResponseResult test(){
        userService.test();
        return new ResponseResult(200,"success",null);
    }
}

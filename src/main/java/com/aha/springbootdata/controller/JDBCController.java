package com.aha.springbootdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Aha
 * @create 2022-07-22  16:56
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userInfo")
    public List<Map<String,Object>> userList(){

        String sql = "select * from t_user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.t_user(id,username,password,age,sex,email) values(11,'刘祥军','sadfha',23,'男','asfha@qq.com')";
        jdbcTemplate.update(sql);
        return "insert-OK";

    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        String sql = "update mybatis.t_user set username=?,password=? where id ="+id;
        Object[] objects = new Object[2];
        objects[0]="sdhgo";
        objects[1]="zzzzzzz";
        jdbcTemplate.update(sql,objects);
        return "update-OK";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        String sql = " delete from mybatis.t_user where id = ?";
        jdbcTemplate.update(sql,id);
        return "delete-OK";
    }
}

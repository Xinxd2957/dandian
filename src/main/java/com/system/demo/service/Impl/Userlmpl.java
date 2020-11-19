package com.system.demo.service.Impl;


import com.system.demo.model.User;
import com.system.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.system.demo.service.IUserService;

import java.util.List;


@Service
@Repository
public class Userlmpl  implements IUserService   {


    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public Userlmpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public User login(User user) {
//        String sql = "select * from  t_user where name =? and password = ?";
//
//        return jdbcTemplate.query(sql,new Object[]{user.getName(),user.getPassWord()},new BeanPropertyRowMapper<>(User.class));
//    }

    @Override
    public List<User> listUserName(String name) {
        String sql = "select * from  t_user where nick_name =?";

        User u = new User();
        u.setNickName(name);
        return jdbcTemplate.query(sql,new Object[]{u.getNickName()},new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> listUser() {
        String sql = "select * from  t_user where 1=1";

        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user (name, password,nick_name) values(?, ?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getPassWord(),user.getNickName());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update  t_user set password = ?,nick_name = ?  where name = ?";
        return jdbcTemplate.update(sql,user.getPassWord(),user.getNickName(), user.getName());
    }

    @Override
    public int delUser(Long id) {
        String sql = "delete  from t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}

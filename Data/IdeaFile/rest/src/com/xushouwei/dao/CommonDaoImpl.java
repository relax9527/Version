package com.xushouwei.dao;

/**
 * Created by Administrator on 2018/7/23.
 */
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xushouwei.bean.Page;
import com.xushouwei.bean.User;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

@Component(value = "commonDao")
public class CommonDaoImpl extends  UserDao{




    @Override
    public void insertUser(User user) {
        getSqlMapClientTemplate().insert("User.insertUser",user);
    }

    @Override
    public void updateUser(User user) {
        getSqlMapClientTemplate().update("User.updateUser",user);
    }

    @Override
    public void deleteUser(Integer id) {
        getSqlMapClientTemplate().delete("User.deleteUser",id);
    }

    @Override
    public User findUserById(Integer id) {
        return (User) getSqlMapClientTemplate().queryForObject("User.findUserById",id);
    }

    @Override
    public List<User> selectAllUser(Page page) {

        return (List<User>) getSqlMapClientTemplate().queryForList("User.selectAllUser",page);
    }

    @Override
    public User userLogin(User user) {
        return (User) getSqlMapClientTemplate().queryForObject("User.userLogin",user);
    }



    @Override
    public Integer select(String name) {

        return (Integer)getSqlMapClientTemplate().queryForObject("User.select",name);
    }

    @Override
    public List<User> selectList(String name ,Page page) {
        Map map = new HashMap();
        map.put("name",name);
        map.put("start",page.getStart());
        map.put("size",page.getSize());
        return (List<User>)getSqlMapClientTemplate().queryForList("User.selectList",map);
    }

}
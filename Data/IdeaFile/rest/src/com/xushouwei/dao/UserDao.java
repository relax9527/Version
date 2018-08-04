package com.xushouwei.dao;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.xushouwei.bean.Page;
import com.xushouwei.bean.User;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public abstract class UserDao  extends SqlMapClientDaoSupport {

	//通过bean名称注入
	@Resource(name="sqlMapClient")
	private SqlMapClient sqlMapClient;

	//完成sqlMapClient初始化工作
	@PostConstruct
	public void initSqlMapClient(){

		super.setSqlMapClient(sqlMapClient);
	}
	public abstract void insertUser(User user);
	public abstract void updateUser(User user);
	public abstract void deleteUser(Integer userId);
	public abstract User findUserById(Integer userId);
	public abstract List<User> selectAllUser(Page page);
	public abstract User userLogin(User user);
	public  abstract  Integer select(String name);
	public  abstract  List<User> selectList(String name,Page page);

}

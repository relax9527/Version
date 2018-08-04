package com.xushouwei.service;

import java.util.List;

import com.xushouwei.bean.Page;
import com.xushouwei.bean.User;

public interface UserService {
	public  void insertUser(User user);
	public  void updateUser(User user);
	public  void deleteUser(Integer userId);
	public  User findUserById(Integer userId);
	public  List<User> selectAllUser(Page page);
	public  User userLogin(User user);
	public  Integer select(String name);
	public Page getPage();
	public List selectList(String name,Page page);
}

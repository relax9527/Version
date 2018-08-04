package com.xushouwei.service;

import java.util.List;

import com.xushouwei.bean.Page;
import com.xushouwei.dao.CommonDaoImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xushouwei.bean.User;
import com.xushouwei.dao.UserDao;

import javax.annotation.Resource;

@Service(value = "userService")
@Transactional
public class UserServiceImp implements UserService{
	private Page page;
	Logger logger = Logger.getLogger(UserServiceImp.class);
	@Resource(name = "commonDao")
	private UserDao userDao;
	private CommonDaoImpl dao;

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public User findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public List<User> selectAllUser(Page page) {
		judgePage(page,"");
		return userDao.selectAllUser(this.page);
	}

	@Override
	public User userLogin(User user) {
		logger.info(userDao.userLogin(user));
		return userDao.userLogin(user);
	}



	@Override
	public Integer select(String name) {
		return userDao.select(name);
	}

	public void setDao(CommonDaoImpl dao) {
		this.dao = dao;
	}

	public CommonDaoImpl getDao() {
		return dao;
	}
	@Override
	public Page getPage() {
		return page;
	}



	@Override
	public List selectList(String name, Page page) {
		judgePage(page,name);
		return userDao.selectList(name,this.page);
	}
	private void  judgePage(Page page,String name){
		if (page==null) page = new Page();
		page.setSize(5);
		page.setCount(select(name)%page.getSize()==0?select( name)/page.getSize():select(name)/page.getSize()+1);
		System.out.println("+++++++++++"+page);
		if(page.getPage()==null){
			page.setPage(1);
		}
		if(page.getPage()==null||page.getPage()==0){
			page.setStart(0);
		}else{
			page.setStart((page.getPage()-1)*page.getSize());
		}
		this.page=page;
	}
}

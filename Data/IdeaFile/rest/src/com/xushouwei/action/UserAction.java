package com.xushouwei.action;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xushouwei.bean.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.xushouwei.bean.User;
import com.xushouwei.service.UserService;

import javax.annotation.PostConstruct;


@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{
	Logger logger = Logger.getLogger(UserAction.class);
	@Autowired
	private UserService userService;
	private User user;
	private List<User> userList;
	private Page page ;
	String jsonData;

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String login()
	{
		
		if(user!=null)
		{
			User user2=userService.userLogin(user);
			if(user2!=null)
			{
				return SUCCESS;
			}
		}
		this.addFieldError("user.username", "用户名或密码错误！");
		return INPUT;
	}
	public String addUI()
	{
		return "addUser";
	}
	public String selectByName(){

		userList=userService.selectList(user.getUsername(),page);
		jsonData = JSONObject.toJSONString(userList);
		page = userService.getPage();
		return "userList";
	}
	public String updateUI()
	{
		System.out.println("--------updateUI----------");
		user=userService.findUserById(user.getId());
		return "updateUser";
	}
	
	
	public String add()
	{
		userService.insertUser(user);
		return SUCCESS; 
	}
	
	public String delete()
	{
		userService.deleteUser(user.getId());
		return SUCCESS; 
	}
	
	public String update() {  
        userService.updateUser(user);  
        return SUCCESS;  
    } 
	
	public String selectAllUser()
	{
		userList = userService.selectAllUser(page);
		page = userService.getPage();
		jsonData = JSONObject.toJSONString(userList);
		return "userList";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}


	
	

}

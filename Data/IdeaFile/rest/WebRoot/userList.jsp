<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <script type="text/javascript" src="/js/case.js"> </script>
      <script type="text/javascript" src="/js/vue.js"> </script>

  </head>
  
  <body>
    <div id="app">
        <h2>用户列表</h2>  
        <h3><s:a action="user_addUI" namespace="/user">添加新用户</s:a> </h3>
        <s:form action="user_selectByName" namespace="/user" method="post">
            <s:textfield label="用户名" name="user.username"></s:textfield>

            <s:submit value="搜索"></s:submit>
        </s:form>
        <s:a action="user_selectAllUser" namespace="/user"><s:param name="page.page">1</s:param>回首页</s:a>
        <table width="90%" border="1" >
            <tr>
                <th>用户id</th>
                <th>用户名称</th>
                <th>用户密码</th>
                <th>操作</th>
            </tr>
            <%--<s:iterator  value="userList">  --%>
                <tr v-for="value in object">
                    <td>{{ value.id }}</td>
                    <td>{{ value.username }}</td>
                    <td>{{ value.password }} </td>
                    <td><a style="cursor:pointer;" v-on:click="updateUser"  :user="value.id">修改</a>
                        <a style="cursor:pointer;" v-on:click="deleteUser" :user="value.id">删除</a>
                        <%--<s:a action="user_updateUI" namespace="/user"><s:param name="user.id">{{ value.id }}</s:param>修改</s:a>--%>
                      <%--<s:a action="user_delete" namespace="/user"><s:param name="user.id">{{ value.id }}</s:param>删除</s:a>--%>
                    </td>
                </tr>  
            <%--</s:iterator>--%>
            <s:div value="page" >

               <p id ="count" name="count" :count="count">共{{count}}页</p> <p id="up" name="page" :page="page" v-on:click="reverseMessage" >上一页</p><p  v-on:click="revers">下一页</p>
            </s:div>
            <!---->
        </table>
    </div>
  <script type="text/javascript">
      new Vue({
          el: '#app',
          data: {
              object: ${jsonData},
              count:${page.count},
              page:${page.page},
          },
          methods: {
              reverseMessage: function () {
                  var up = document.getElementById("up");
                  var page =up.getAttribute("page");
                  if(page==1){
                      alert("已经是第一页了！");
                      return;
                  }
                  console.log(page)
                  var pages= parseInt(page);
                  pages=pages-1;
                  console.log(pages)
                  up.setAttribute("page",page);
                  var url = "user_selectAllUser.action?page.page="+pages;
                  window.location=url;
              },
              revers: function () {
                  var up = document.getElementById("up");
                  var count = document.getElementById("count").getAttribute("count");
                  var page =up.getAttribute("page");
                  if(page>=count){
                      alert("已经是最后一页了！");
                      return;
                  }
                  var pages= parseInt(page);
                  pages=pages+1;
                  up.setAttribute("page",pages);
                  var url = "user_selectAllUser.action?page.page="+pages;
                  window.location=url;
                  var test = 2;
                  console.log("++++++++"+test);
              },
              updateUser:function () {
                  var  a = event.currentTarget;
                  var url = "user_updateUI?user.id="+a.getAttribute("user");
                  window.location=url;
              },
              deleteUser:function () {
                  var  a = event.currentTarget;
                  var url = "user_delete?user.id="+a.getAttribute("user");
                  window.location=url;
              }
          }
      })
  </script>  </body>
</html>

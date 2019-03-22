<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'downtype.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/tribune/static/layui/css/layui.css"/>
  <script type="text/javascript" src="/tribune/static/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="/tribune/static/layui/layui.js"></script>
	
  </head>
  
  <body>
    	<table id="downtype"></table>
  </body>
  <script type="text/javascript">
  layui.use(['table'], function() {
	  table = layui.table;
	  table.render({
		  elem:'#downtype',
		  url:'zxhdowntype/querydowntype',
		  cols: [
	              [ 
	                  {field: 'downtypeid', title: '下载类型编号', width: 240,align:'center'}
	                 ,{field: 'downtypeName', title: '下载类型名称', width: 170,align:'center'}
	                 ,{fixed: 'right', width:265, align:'center', toolbar: '#barDemo'}
	              ]
	          ]
	  });
  });
  </script>
  <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs">修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="about">删除</a>
  </script>
</html>

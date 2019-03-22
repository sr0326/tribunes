<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bbstype.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/tribune/static/layui/css/layui.css"/>
  <script type="text/javascript" src="/tribune/static/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="/tribune/static/layui/layui.js"></script>
	

  </head>
  
  <body>
     <table id="blogtype" lay-filter="demo"></table>
     <form class="layui-form" style="display:none" id="about">
     	<div class="layui-form-item">
	    <label class="layui-form-label">类型编号</label>
	    <div class="layui-input-inline">
	      <input type="text" name="typeid" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	    </div>
	    </div>
     	<div class="layui-form-item">
	    <label class="layui-form-label">类型名称</label>
	    <div class="layui-input-inline">
	      <input type="text" name="typeName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	    </div>
  		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
  </body>
  <script type="text/javascript">
  layui.use(['table'], function() {
	  table = layui.table;
	  table.render({
		  elem:'#blogtype',
		  url:'zxhblogtype/blogtype',
		  toolbar: '#add'
		  ,cols: [
	              [ 
	                  {field: 'typeid', title: '博客类型编号', width: 240,align:'center'}
	                 ,{field: 'typeName', title: '博客类型名称', width: 170,align:'center'}
	                 ,{fixed: 'right', width:265, align:'center', toolbar: '#barDemo'}
	              ]
	          ]
	  });
	  table.on('tool(demo)',function(obj){
		  //alert(77777);
		  if(obj.event=="update"){
			  //alert(222); 
			  $("input[name='typeid']").val(obj.data.typeid);
			  $("input[name='typeName']").val(obj.data.typeName);
			  $("input[name='typeid']").attr("readonly","readonly");
			  layer.open({
				   type: 1,
			       area: ['600px','250px'],
			       fix: false, //不固定
			       offset: '20px',
			       maxmin: true,
			       shade:0.4,
			       title:'修改',
			       content:$("#about"),
			       
			  });
			  
		  }else if(obj.event=="del"){
			  //alert(333);
			  $("input[name='typeid']").val(obj.data.typeid);
			  $("input[name='typeName']").val(obj.data.typeName);
		  }
		  
	  });
	  table.on('toolbar(demo)',function(obj){
		  //alert(111);
		   $("input[name='typeid']").val("");
		   $("input[name='typeName']").val("");
		  layer.open({
			   type: 1,
		       area: ['600px','250px'],
		       fix: false, //不固定
		       offset: '20px',
		       maxmin: true,
		       shade:0.4,
		       title:'添加',
		       content:$("#about"),
		  });
	  });
  });
  </script>
  <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
  <script type="text/html" id="add">
  		<a class="layui-btn layui-btn-xs" lay-event="add">添加</a>
  </script>
</html>

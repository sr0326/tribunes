<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="layui/layui.js"></script>
	
  <body>
    	<table id="userinfo" class="layui-table" lay-filter="demo"></table>
    	<div id="about" style="display:none">
    		
    		<div class="layui-collapse" lay-accordion lay-filter="filter">
			  <div class="layui-colla-item">
			    <h2 class="layui-colla-title" id="blog">他的博客</h2>
			    <div class="layui-colla-content" id="blogcontent">内容区域</div>
			  </div>
			  <div class="layui-colla-item">
			    <h2 class="layui-colla-title" id="bbs">他的论坛</h2>
			    <div class="layui-colla-content" id="bbscontent">内容区域</div>
			  </div>
			  <div class="layui-colla-item">
			    <h2 class="layui-colla-title" id="download">他的下载</h2>
			    <div class="layui-colla-content" id="downloadcontent">内容区域</div>
			  </div>
			</div>
    	</div>
  </body>
  <script type="text/javascript">
  
  layui.use(['table'], function() {
	  table = layui.table;
	  table.render({
		  elem:'#userinfo',
		  url:'zxhuserinfo/queryuser',
		  cols: [
	              [ 
	                  {field: 'userId', title: '用户编号', width: 240,align:'center'}
	                  ,{field: 'nickname', title: '用户昵称', width: 170,align:'center'}
	                  ,{field: 'realName', title: '真实姓名', width: 235,align:'center'}
	                  ,{field: 'sex', title: '性别', width: 100,align:'center',templet:function(d){
	                	if(0==d.sex){
	                		return "男";
	                	}else{
	                		return "女";
	                	}
	                  }
	                  }
	                  ,{fixed: 'right', width:265, align:'center', toolbar: '#barDemo'}
	                  
	              ]
	          ]
	  });
	  table.on('tool(demo)',function(obj){
		  var data = obj.data;
		  if(obj.event=="about"){
			  layer.open({
				   type: 1,
			       area: ['800px','400px'],
			       fix: false, //不固定
			       offset: '20px',
			       maxmin: true,
			       shade:0.4,
			       title:'和'+data.nickname+'相关',
			       content:$("#about").append("<input type='hidden' id='finduserid' value="+data.userId+">"),
			  });
		  }
	  });
  });
  </script>
  <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs">基本信息展示</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="about">和他/她相关</a>
  </script>
  <script type="text/javascript">
  layui.use(['element', 'layer'], function () {
	  var element = layui.element;
	  var layer = layui.layer;
	  element.on('collapse(filter)', function(data){
		  console.log(); //得到当前面板的展开状态，true或者false
		  /*console.log(data.title); //得到当前点击面板的标题区域DOM对象
		  console.log(data.content); //得到当前点击面板的内容区域DOM对象 */
		  var name=data.title[0].id;
		  console.log(name)
		  var finduserid=$("#finduserid").val();
		  if(name=="blog"){
			 $.ajax({
				url:"zxhblog/findsomething",
				data:"",
				success:function(data){
					console.log(data);
					if(""==data & null == data){
						$("#blogcontent").html("暂时没有相关博客");
					}
				},
				error:function(data){
					$("#blogcontent").html("暂时没有相关博客");
				}
			 });
		  }else if(name=="bbs"){
			  $.ajax({
					url:"zxhblog/findsomething",
					data:"",
					success:function(data){
						console.log(data);
						if(""==data & null == data){
							$("#bbscontent").html("暂时没有相关博客");
						}
					},
					error:function(data){
						$("#bbscontent").html("暂时没有相关博客");
					}
				 });
		  }else if(name="download"){
			  $.ajax({
					url:"zxhblog/findsomething",
					data:"",
					success:function(data){
						console.log(data);
						if(""==data & null == data){
							$("#downloadcontent").html("暂时没有相关博客");
						}
					},
					error:function(data){
						$("#downloadcontent").html("暂时没有相关博客");
					}
				 });
		  }
	  });
	 });
  </script>
</html>

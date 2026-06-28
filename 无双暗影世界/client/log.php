<?php
	//暗影世界用户帐号判断程序
	//此程序使用ucenter home数据库模板

	//判断来访者的IP合法性
	$allowedIPArray=array('127.0.0.1');
	$clientIP=$_SERVER['REMOTE_ADDR'];
	if(!in_array($clientIP,$allowedIPArray))
	{
		exit("103");
	}

    $mysql_server_name="localhost"; //数据库服务器名称
    $mysql_username="root"; // 连接数据库用户名
    $mysql_password="123456"; // 连接数据库密码
    $mysql_dbname="anying"; // 数据库的名字
	$mysql_dbtable_name="uc_members";	//存放用户的表的名字
	
	$username=$_GET["user_account"];
	$password=$_GET["user_password"];

	if(strlen($password)!=32)
	{
		$password=md5($password);
	}

    //连接到数据库
    $conn=mysql_connect($mysql_server_name, $mysql_username, $mysql_password);
	if(!$conn)
	{
		echo("100,database connection error");
		exit();
	}
    mysql_select_db("anying",$conn);
	mysql_query("set names gb2312"); 
    //从表中提取信息的sql语句
    $strsql="select password,salt from uc_members where username='$username'";
	// 执行sql查询
    $result=mysql_query($strsql, $conn);
	if(!$result)
	{
		echo("100,database selection error");
	}
	else
	{
		$rows=mysql_fetch_row($result);
		if(!$rows)
		{
			echo("1101");//不存在此用户
		}
		else if($rows[0]!=md5($password.$rows[1]))
		{
			echo("1102");//密码错误
		}
		else
		{
			echo("10");
		}
	}
    // 释放资源
	if($result)
	{
		mysql_free_result($result);
	}
    // 关闭连接
    mysql_close();
?>
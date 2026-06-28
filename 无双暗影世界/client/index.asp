<%


'推广员名字
Dim adOwner
If session("ad")<>"" Then
	adOwner=session("ad")
End If
If adOwner="" Then
	adOwner=Request("ad")
End If
If adOwner="" Then
	adOwner=Request("tg")
End If

%>

<html>
<head>
<title>暗影世界Onweb(官方电信一服) - 国内首款即时PK的2D网页游戏 - 无GM在线管理 - 20倍经验</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="keywords" content="暗影世界,网页游戏,web游戏,webgame,易游网络,浙江游戏,网页版传奇,web版传奇,50倍经验" />
<meta name="description" content="暗影世界网页版传奇,web版传奇,是一个以西方中世界奇幻题材为背景的网页RPG游戏。在这个游戏中，你可以与来自世界各地的朋友结成伙伴，一起经历探险、建设城市、体会团队协作的乐趣！">
<style type="text/css">
<!--
body {
	background-image: url(image/ui/webbg.jpg);
	margin-left: 0px;
	margin-top: 0px;
}
body,td,th {
	background:#000000;
	color: #ffffff;
	font-size: 12px;
}
A.linkblank1:link {
	FONT-SIZE: 12px; COLOR: #FFFFFF; TEXT-DECORATION: none
}
A.linkblank1:visited {
	FONT-SIZE: 12px; COLOR: #FFFFFF; TEXT-DECORATION: none
}
A.linkblank1:hover {
	FONT-SIZE: 12px; COLOR: #FFFFFF; TEXT-DECORATION: underline
}

A.linkblank2:link {
	FONT-SIZE: 12px; COLOR: #FFFF00; TEXT-DECORATION: none
}
A.linkblank2:visited {
	FONT-SIZE: 12px; COLOR: #FFFF00; TEXT-DECORATION: none
}
A.linkblank2:hover {
	FONT-SIZE: 12px; COLOR: #FFFF00; TEXT-DECORATION: underline
}
-->
</style>
<script type="text/javascript">
	//虚拟机检测函数
	function CheckJvm()
	{
		try
		{
			var jvm_ver=game.getAppletInfo();
		}
		catch(e)
		{
			alert("很抱歉的通知您，加载游戏失败！\n这可能是您的系统没有安装Java虚拟机或者Java虚拟机版本太低。\n网页会自动为您安装Java虚拟机，请您接受即将弹出的提示窗口。");
			var autoInstallJavaTag="%3Cobject%0D%0A%20%20%20%20classid%20%3D%20%22clsid%3ACAFEEFAC-0016-0000-0010-ABCDEFFEDCBA%22%0D%0A%20%20%20%20codebase%20%3D%20%22http%3A//java.sun.com/update/1.6.0/jinstall-6u12-windows-i586.cab%23Version%3D6%2C0%2C100%2C25%22%0D%0A%20%20%20%20WIDTH%20%3D%20%221000%22%20HEIGHT%20%3D%20%22530%22%20NAME%20%3D%20%22game%22%20%3E%0D%0A%20%20%20%20%3Cparam%20name%20%3D%20CODE%20value%20%3D%20%22game.GameApplet.class%22%20%3E%0D%0A%20%20%20%20%3Cparam%20name%20%3D%20ARCHIVE%20value%20%3D%20%22client.zip%22%20%3E%0D%0A%20%20%20%20%3Cparam%20name%20%3D%20%22name%22%20value%20%3D%20%22game%22%20%3E%0D%0A%20%20%20%20%3Cparam%20name%20%3D%20%22type%22%20value%20%3D%20%22application/x-java-applet%3Bjpi-version%3D1.6.0_12%22%3E%0D%0A%20%20%20%20%3Cparam%20name%20%3D%20%22java_arguments%22%20value%3D%22-Xmx256M%20-XX%3A+ForceTimeHighResolution%22%3E%0D%0A%3C/object%3E";
			appletDiv.innerHTML=unescape(autoInstallJavaTag);
		}
		appletDiv.style.display="";
		infoDiv.style.display="none";
	}
	//这个三个函数会被游戏调用，需要根据情况设置它们的返回值
	//返回配置文件的名字
	function getConfigFile()
	{
		return "client.cfg";
	}
	//如果需要自动登录，网页的调用者需要在网页后面传入用户名和临时密码的参数
	var username="";
	var password="";
	var args=location.href.substring(location.href.indexOf('?')+1);
	if(args.length>1)
	{
		var array=args.split("&");
		for(var i=0;i<array.length;i++)
		{
			var subArray=array[i].split("=");
			if(subArray[0]=="name"||subArray[0]=="username")
			{
				username=subArray[1];
			}
			else if(subArray[0]=="pwd"||subArray[0]=="password")
			{
				password=subArray[1];
			}
		}
	}
	//如果游戏设置为自动登录，调用此方法，获取登录帐号
	function getUsername()
	{
		return username;
	}
	//如果游戏设置为自动登录，调用此方法，获取登录密码
	function getPassword()
	{
		return password;
	}
	//退出游戏时候调用的JS脚本
	function exitGame()
	{
		//关闭窗口或者转向主页
	}
	function GetMusicVolume(value)
	{
		return player.settings.volume;
	}
	function SetMusicVolume(value)
	{
		player.settings.volume=value;
	}
	function PlayMusic(url)
	{
		player.url=url;
		player.settings.autoStart = false ;
		play();
	}
	function PauseMusic()
	{
		if (player.controls.isavailable('pause'))
		{
			player.controls.pause();
		}
	}
	function ResumeMusic()
	{
		if (player.controls.isavailable('resume'))
		{
			player.controls.resume();
		}
	}
	function play()
	{
		if (player.controls.isavailable('play'))
		{
			player.controls.play();
		}
	}
	function StopMusic()	
	{		
		if (player.controls.isavailable('stop'))
		{
			player.controls.stop();
		}
	}
	function PlaySound()
	{
	}
</script>

</head>

<body onLoad="javascript:CheckJvm();" scroll="no" onContextMenu="return false" onSelectStart="return false">

<object id="player" name="player" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" type="application/x-oleobject" width="0" height="0">
      <param name="autoStart" value="false">
      <param name="balance" value="0">
      <param name="currentPosition" value="0">
      <param name="currentMarker" value="0">
      <param name="enableContextMenu" value="true">
      <param name="enableErrorDialogs" value="false">
      <param name="enabled" value="true">
      <param name="fullScreen" value="false">
      <param name="invokeURLs" value="false">
      <param name="mute" value="true">
      <param name="playCount" value="100">
      <param name="rate" value="1">
      <param name="uiMode" value="none">
      <param name="volume" value="80">
</object>

<div align="center">
	<BR>
	<a href="http://javadl.sun.com/webapps/download/AutoDL?BundleId=36665" target="_blank" class="linkblank1">下载客户端</a> | <a href="http://xxxx.xxxx.com/" target="_blank" class="linkblank1">官方网站</a> | <a href="http://xxxx.xxxx.com" target="_blank" class="linkblank1">注册账号</a> | <a href="http://xxxx.xxxx.com" target="_blank" class="linkblank1">游戏论坛</a> | <a href="http://xxxx.xxxx.com/anzhanpay" target="_blank" class="linkblank1">充值元宝</a> | <a href="http://xxxx.xxxx.com" target="_blank" class="linkblank2">免费领元宝</a> | 官方玩家①群：XXXXXXX&nbsp;&nbsp;②群：XXXXXXX&nbsp;&nbsp;③群：XXXXXXX
	<br >
	<br>
</div>

<div id="infoDiv">
	<BR><BR>
	<table width=770 align="center">
		<tr>
		<td>
			<BR>
			欢迎来到暗影世界！		
		</td>
		</tr>
		<tr>
		<td>
			<BR>
			《暗影世界》是一个以西方中世界奇幻故事为背景的大型网页RPG游戏，在这个游戏中，你可以与来自世界各地的朋友结成伙伴，一起经历探险、建设城市、公会竞技和PK、体会团队协作的乐趣！ 
		</td></tr>
		<tr><td>
			<BR>
			《暗影世界》——全球领先的webgame，应用java技术，实现真正通过网页浏览器就可以进行即时战斗的大型多人在线角色扮演游戏，一款革命性的java游戏。 
		</td></tr>
		<tr><td>
			<BR>
			 游戏最新更新系统：师徒系统、推广员系统
		</td>
		</tr>
		<tr>
		</tr>
		<tr><td align="center">
			<BR><BR>
			<h1 color="FFFFF">请等待，正在加载游戏...</h1>
		</td></tr>
	</table>
	<BR><BR><BR><BR>
</div>

<div align="center" id="appletDiv" style="display:none">
	<APPLET archive="client.zip" code ="game.GameApplet.class" width="1000" height="530" name="game">
		<param name="java_arguments" value="-Xmx256M -XX:+ForceTimeHighResolution">
		<param name="adOwner" value="<%=adOwner%>">
	</APPLET>
</div>

<div align="center">
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>

</div>

</body>
</html>

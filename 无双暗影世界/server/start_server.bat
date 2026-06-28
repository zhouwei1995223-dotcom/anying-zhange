@echo off
setlocal
set "JAVA_EXE=C:\Program Files\Android\jdk\jdk-8.0.302.8-hotspot\jdk8u302-b08\bin\java.exe"
cd /d "%~dp0"
title GameServer
set "SERVER_ZIP=server.zip"
if exist "server_store64.zip" set "SERVER_ZIP=server_store64.zip"
if exist "server_bag64.zip" set "SERVER_ZIP=server_bag64.zip"
if exist "server_bag96.zip" set "SERVER_ZIP=server_bag96.zip"
rem -Xint avoids a HotSpot JIT crash seen while compiling app.island.gs.t::if on this old server.
"%JAVA_EXE%" -Xint -Xmx512M -XX:+ForceTimeHighResolution -cp "%SERVER_ZIP%;lib/mysql-connector-java-5.0.4-bin.jar;." app.island.gs.GameServer
pause

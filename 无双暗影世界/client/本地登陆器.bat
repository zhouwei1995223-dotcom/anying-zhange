@echo off
title 暗影世界登入器
setlocal
set "JAVA_EXE=C:\Program Files\Android\jdk\jdk-8.0.302.8-hotspot\jdk8u302-b08\bin\java.exe"
cd /d "%~dp0"
if exist "client_bag96_halo.zip" (
  "%JAVA_EXE%" -cp "client_bag96_halo.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
) else if exist "client_bag96.zip" (
  "%JAVA_EXE%" -cp "client_bag96.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
) else (
  "%JAVA_EXE%" -cp "client.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
)
pause

@echo off
setlocal

set "JAVA_DIR=C:\Program Files\Android\jdk\jdk-8.0.302.8-hotspot\jdk8u302-b08\bin"
set "JAVA_EXE=%JAVA_DIR%\javaw.exe"
set "CLIENT_DIR=%~dp0"

reg add "HKCU\Software\Microsoft\Windows NT\CurrentVersion\AppCompatFlags\Layers" /v "%JAVA_EXE%" /t REG_SZ /d "~ DPIUNAWARE" /f >nul

cd /d "%CLIENT_DIR%"
if exist "client_bag96_halo.zip" (
  start "" "%JAVA_EXE%" -cp "client_bag96_halo.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
) else if exist "client_bag96.zip" (
  start "" "%JAVA_EXE%" -cp "client_bag96.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
) else if exist "client_bag64.zip" (
  start "" "%JAVA_EXE%" -cp "client_bag64.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
) else if exist "client_scale2x.zip" (
  start "" "%JAVA_EXE%" -cp "client_scale2x.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
) else (
  start "" "%JAVA_EXE%" -cp "client.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame host:127.0.0.1 port:12346 title:Client config:client.cfg
)

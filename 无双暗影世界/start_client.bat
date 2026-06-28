@echo off
setlocal
set "CLIENT_DIR=%~dp0client"
cd /d "%CLIENT_DIR%"
if exist "start_client_scaled.bat" (
  call "start_client_scaled.bat"
) else (
  "C:\Program Files\Android\jdk\jdk-8.0.302.8-hotspot\jdk8u302-b08\bin\javaw.exe" -cp "client.zip;." -Xmx512M -XX:+ForceTimeHighResolution game.GameFrame height=560
)

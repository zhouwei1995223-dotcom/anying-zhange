$root = Split-Path -Parent $MyInvocation.MyCommand.Path
Start-Process -FilePath (Join-Path $root 'server\start_server.bat')
Start-Sleep -Seconds 5
Start-Process -FilePath (Join-Path $root 'start_client.bat')

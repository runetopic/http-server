@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  http-server startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and HTTP_SERVER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\http-server-1.0-SNAPSHOT.jar;%APP_HOME%\lib\api-1.2.3-SNAPSHOT.jar;%APP_HOME%\lib\cache-1.4.19-SNAPSHOT.jar;%APP_HOME%\lib\cryptography-1.0.6-SNAPSHOT.jar;%APP_HOME%\lib\koin-core-jvm-3.1.3.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.5.1.jar;%APP_HOME%\lib\kotlin-inline-logger-jvm-1.0.3.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.5.30.jar;%APP_HOME%\lib\jackson-databind-2.13.0.jar;%APP_HOME%\lib\jackson-annotations-2.13.0.jar;%APP_HOME%\lib\jackson-core-2.13.0.jar;%APP_HOME%\lib\jackson-module-kotlin-2.13.0.jar;%APP_HOME%\lib\kotlin-reflect-1.5.30.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.5.30.jar;%APP_HOME%\lib\kotlin-stdlib-1.6.0.jar;%APP_HOME%\lib\netty-all-4.1.70.Final.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.6.0.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.70.Final-linux-x86_64.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.70.Final-linux-aarch_64.jar;%APP_HOME%\lib\netty-transport-native-kqueue-4.1.70.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-transport-native-kqueue-4.1.70.Final-osx-aarch_64.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.70.Final.jar;%APP_HOME%\lib\netty-transport-classes-kqueue-4.1.70.Final.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.70.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.70.Final-osx-aarch_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.70.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.70.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.70.Final.jar;%APP_HOME%\lib\netty-handler-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-4.1.70.Final.jar;%APP_HOME%\lib\netty-transport-4.1.70.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-haproxy-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-http2-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-memcache-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-mqtt-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-redis-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-smtp-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-stomp-4.1.70.Final.jar;%APP_HOME%\lib\netty-codec-xml-4.1.70.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.70.Final.jar;%APP_HOME%\lib\netty-common-4.1.70.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.70.Final.jar;%APP_HOME%\lib\netty-transport-rxtx-4.1.70.Final.jar;%APP_HOME%\lib\netty-transport-sctp-4.1.70.Final.jar;%APP_HOME%\lib\netty-transport-udt-4.1.70.Final.jar;%APP_HOME%\lib\commons-compress-1.21.jar;%APP_HOME%\lib\slf4j-simple-1.7.32.jar;%APP_HOME%\lib\slf4j-api-1.7.32.jar


@rem Execute http-server
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %HTTP_SERVER_OPTS%  -classpath "%CLASSPATH%" com.runetopic.ApplicationKt %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable HTTP_SERVER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%HTTP_SERVER_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

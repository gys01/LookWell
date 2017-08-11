<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
        <%@ include file="basic.jsp"%>
        <script type="text/javascript">
            function login(){
                $("#loginForm").submit();
            }
        </script>
    </head>
    <body>
        <div id="loginWin" class="easyui-window" title="登录" style="width: 300px;height: 200px"
             data-options="left:'30%',top:'30%'">
            <div>
                <form id="loginForm" action="login.controller" method="post">
                    <div style="text-align: center">
                        <p>用户名：<input type="text" name="username"></p>
                        <p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"></p>
                        <a href="#" class="easyui-linkbutton" icon="icon-ok" onclick="login()">登录</a>
                    </div>
                </form>
            </div>
            <div style="text-align: center">${msg}</div>
        </div>
    </body>
</html>

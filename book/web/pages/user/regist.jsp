<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--静态包含：base 、css样式、jquery引入
    --%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>

    <script type="text/javascript">

        //页面加载完成事件
        $(function () {

            //ajax请求验证用户名是否可用
            $("#username").blur(function () {
                var username = this.value;
                $.getJSON("http://localhost:8080/book/userServlet",{action:"ajaxTestUsername",username:username},function (data) {
                    console.log(data);
                    if(data.msg){
                        $("span.errorMsg").text("用户名已占用！");
                    }else {
                        $("span.errorMsg").text("用户名可用！");
                    }
                });
            });

            // 给验证码的图片，绑定单击事件
            $("#kaptcha_img").click(function () {
                // 在事件响应的function 函数中有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象
                // src 属性表示验证码img 标签的图片路径。它可读，可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });


            //给注册按钮绑定点击事件
            $("#sub_btn").click(function () {

                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1.获取用户名的值
                var username = $("#username").val();
                //2.定义正则表达式
                var userPatt = /^\w{5,12}$/;
                //3.对用户提示
                if (!userPatt.test(username)) {
                    $("span.errorMsg").text("用户名不合法！");
                    return false
                }

                //验证密码
                //1.验证密码
                var password = $("#password").val();
                //2.定义正则表达式
                var passPatt = /^\w{5,12}$/;
                //3.对用户进行提示
                if (!passPatt.test(password)) {
                    $("span.errorMsg").text("密码格式不对");
                    return false;
                }

                //确认密码验证
                var repwd = $("#repwd").val();
                if (repwd != password) {
                    $("span.errorMsg").text("两次输入密码不对");
                    return false;
                }

                //邮箱验证
                var email = $("#email").val();
                var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if (!emailPatt.test(email)) {
                    $("span.errorMsg").text("邮箱格式不对！");
                    return false;
                }

                //验证码
                var code = $("#code").val();
                code = $.trim(code);
                if (code == null || code == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");
                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");
            });
        });

    </script>

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
									<%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                        <%--value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>--%>
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                        <%--value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>--%>
                               value="${requestScope.email}"
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 80px;height: 30px;" id="code" name="code"/>
                        <img id="kaptcha_img" alt="" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px; width: 110px ;height: 30px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含底部信息--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
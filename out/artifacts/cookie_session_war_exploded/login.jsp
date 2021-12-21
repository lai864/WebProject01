<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
<!--
      form标签就是表单
                input type=txt 是文件输入框 value是设置默认显示内容
                input type=passworde 是密码输入框 value是设置默认显示内容
                input type=radio  是单选框  name属性可以对其进行分组，checked = check 是默认选择
                input type = checkbox 是复选框，checked = check 是默认选择
                input type=reset 是重置按钮 value属性修改按钮上的文字
                input type=submit是提交按钮 value属性修改按钮上的文字
                input type=button是按钮，value属性修改按钮上的文字
                input type=file 是文件上传域
                input type=hidden 是掩藏域 当我们要发送某些信息，而这些信息不需要用户参与，就可以使用掩藏域(提交的时候发送给服务器)


                select是下拉列表框
                option是下拉列表框里的选项

                textarea是多行文本输入框
                    rows属性设置可以显示几行的高度
                    cols属性设置每行可以显示几个字符宽度

                    form标签action属性设置提交的服务器地址
                    method属性设置提交的方式GET(默认值)或POST

                    表单提交的时候，数据没有发送给服务器的三种情况
                        1.表单选项没有name属性
                        2.单选 复选（下拉列表中的option标签） 都需要添加values属性，以便发送给服务器
                        3.表单项不在提交的form标签中

                     GET请求的特点是：
                        1.浏览器地址栏中的地址是：action属性[+?+请求参数]
                           请求参数的格式是：name=value&name=value
                        2.不安全
                        3.它有数据长度的限制

                      POST请求的特点是：
                        1.浏览器的地址栏中只有action属性
                        2.相对于GET属性要安全
                        3.理论上没有数据长度的限制
https://www.baidu.com/?action=login&user=%E7%90%9B&password=abcrter&sex=boy&hobby=JAVA&hobby=C%2B%2B&county=cn&desc=%E6%88%91%E6%89%8D%E6%98%AF%E9%BB%98%E8%AE%A4%E5%80%BC
                -->
    <form action="http://localhost:8080/cookie_session/loginServlet" method="get">
        <input type="hidden" name="action" value="saveLogin">
        <h1 align="center">用户注册</h1>
        <table align="center">
            <tr>
                <td> 用户名称:</td>
                <td><input type="text" value="${cookie.username.value}" name="username"/></td>
            </tr>
            <tr>
                <td>用户密码:</td>
                <td><input type="password" value="${cookie.password.value}" name="password"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="sex" value="boy" checked="checked"/>男
                    <input type="radio" name="sex" value="girl">女
                </td>
            </tr>
            <tr>
                <td>兴趣爱好:</td>
                <td><input type="checkbox" checked="checked" name="hobby" value="JAVA"/>JAVA
                    <input type="checkbox" name="hobby" value="C++"/>C++
                    <input type="checkbox" name="hobby" value="HTML"/>HTML
                </td>
            </tr>
            <tr>
                <td>国籍:</td>
                <td><select name="county" >
                    <option>请选择国籍</option>
                    <option selected="selected" value="cn">中国</option>
                    <option value="us">美国</option>
                    <option value="en">法国</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>自我评价:</td>
                <td><textarea rows="10" name="desc" cols="20">我才是默认值</textarea></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"/></td>
                <td align="center"><input type="submit" value="提交"/></td>
            </tr>


        </table>
    </form>
</body>
</html>
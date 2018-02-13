<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/8
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
		<title>add</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>  
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>

                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">添加学生</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                信息
            </h1>
            <form action="add" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">                     
                    <tr>
                        <td valign="middle" align="right">
                            姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            出生日期:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" name="birthday" class="inputgri" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            备注:
                        </td>
                        <td valign="middle" align="left">
                            <textarea rows="3" cols="6" name="description"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            平均分:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="avgscore" />
                        </td>
                    </tr>

                </table>
                <p>
                    <input type="submit" class="button" value=" 提交 &raquo;" />
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
           jian.lan@qq.com
        </div>
    </div>
</div>
</body>
</html>

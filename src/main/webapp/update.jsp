<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
                    <a href="#">修改学生</a>
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
            <form action="toUpdate" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                     <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="id" value="${student.id}" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${student.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            出生日期:
                        </td>
                        <td valign="middle" align="left">
                        	
                            <input type="text" name="birthday" class="inputgri" value="<fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            备注:
                        </td>
                        <td valign="middle" align="left">
                            <textarea rows="3" cols="6" name="description" value="${student.description}"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            平均分:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="avgscore" value="${student.avgscore}"/>
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

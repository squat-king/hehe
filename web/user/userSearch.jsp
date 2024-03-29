<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户管理</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });

        function ask(e_NO) {
            var res=confirm("确定要删除吗????");
            if(res==true){
                window.location.href="${pageContext.request.contextPath}/UserDeleteServlet?id="+e_NO;
            }
        }

        function update(e_NO) {
            window.location.href="${pageContext.request.contextPath}/getMessageServlet?id="+e_NO;
        }
    </script>
</head>

<body onload="">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">用户管理</a></li>
    </ul>
</div>

<!--查询条件-->
<br/>
<br/>

<ul class="seachform">

    <li><label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名</label><input name="" type="text" class="scinput"/></li>
    <li><label>部门</label>
        <div class="vocation">
            <select class="select3">
                <option>研发一部</option>
                <option>研发二部</option>
                <option>研发三部</option>
                <option>测试</option>
            </select>
        </div>
    </li>

    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>

</ul>

</div>

<div class="tools">

    <ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png"/></span><a href="userInsert.jsp"
                                                                        target="rightFrame">添加</a>
        </li>
        <li class="click"><img src="../images/t03.png"/></span><a href="#" target="rightFrame">删除</a></li>
    </ul>

</div>


<table class="tablelist">
    <tbody>
    <tr>
        <td>
            <table class="tablelist">
                <tbody>
                <tr>
                    <td>
                        <table class="tablelist">
                            <tbody>
                            <tr>
                                <td>
                                    <table class="tablelist">
                                        <thead>
                                        <tr>
                                            <th><input name="" type="checkbox" value="" checked="checked"/></th>
                                            <th width="7%">工号<i class="sort"><img src="../images/px.gif"/></i></th>
                                            <th width="11%">姓名</th>
                                            <th width="10%">部门</th>
                                            <th width="9%">职务</th>
                                            <th width="11%">注册时间</th>
                                            <th width="5%">性别</th>
                                            <th width="10%">手机</th>
                                            <th width="9%">出生日期</th>
                                            <th width="12%">邮箱</th>
                                            <th width="13%">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach items="${pb.list}" var="user">
                                            <tr>
                                                <td><input name="" type="checkbox" value=""/></td>
                                                <td>${user.e_NO}</td>
                                                <td>${user.e_NAME}</td>
                                                <td>${user.e_DEPT}</td>
                                                <td>${user.e_JOB}</td>
                                                <td>${user.e_REGISTTIME}</td>
                                                <td>${user.e_SEX}</td>
                                                <td>${user.e_PHONE}</td>
                                                <td>${user.e_BIRTHDAY}</td>
                                                <td>${user.e_EMAIL}</td>
                                                <td><span><a href="#" class="tablelink" onclick="update('${user.e_NO}')"><img
                                                        src="../images/t02.png"/>修改</a> <a href="#" class="tablelink"
                                                                                           onclick="ask('${user.e_NO}')"> <img
                                                        src="../images/t03.png"/>删除</a></span></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>


<div class="pagin">
    <div class="message">共<i class="blue">${pb.allRows}</i>条记录，共<i class="blue">${pb.totalPage}</i>页当前显示第&nbsp;<i class="blue">${pb.currentPage}&nbsp;</i>页</div>
    <ul class="paginList">
        <li class="paginItem"><a href="/UserListServlet?page=1">首页</a></li>
        <li class="paginItem"><a href="/UserListServlet?page=${pb.currentPage-1}"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="/UserListServlet?page=${pb.currentPage+1}"><span class="pagenxt"></span></a></li>
        <li class="paginItem"><a href="/UserListServlet?page=${pb.currentPage=totalPage}">尾页</a></li>
    </ul>
</div>


<div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>

    <div class="tipinfo">
        <span><img src="images/ticon.png"/></span>
        <div class="tipright">
            <p>是否确认对信息的修改 ？</p>
            <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
    </div>

    <div class="tipbtn">
        <input name="" type="button" class="sure" value="确定"/>&nbsp;
        <input name="" type="button" class="cancel" value="取消"/>
    </div>

</div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>

</html>
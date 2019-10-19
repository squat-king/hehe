<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>


<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户添加</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
    </script>

    <script language="javascript">
        function saveButton() {
            document.forms[0].action = "${pageContext.request.contextPath}/UserUpdateServlet";
            document.forms[0].submit();
        }
    </script>

</head>

<body>
<form action="userFrom">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">用户管理</a></li>
            <li><a href="#">修改用户</a></li>
        </ul>
    </div>

    <div class="formbody">

        <div class="formtitle"><span>基本信息</span></div>

        <ul class="forminfo">
            <li>
                <label>工号 <font color="red">*</font></label>
                </label><input name="userId" type="text" class="scinput" value="" readonly="readonly"/></li>
            <li>
                <label>密码 <font color="red">*</font></label>
                <input name="password" type="password" class="dfinput" value=""/>
            </li>
            <li>
                <label>确认密码 <font color="red">*</font></label><input name="passwordConfirm" type="password"
                                                                     class="dfinput"/>
            </li>
            <li>
                <label>姓名 <font color="red">*</font></label>
                </label><input name="userName" type="text" class="dfinput" value=""/>
            </li>
            <li><label>部门</label>
                <div class="vocation">
                    <select class="select3" name="dept">
                        <option>--请选择--</option>
                        <option selected="selected" value="研发一部">研发一部</option>
                        <option value="研发二部">研发二部</option>
                        <option value="研发三部">研发三部</option>
                        <option value="测试">测试</option>
                    </select>
                </div>
            </li>
            <li>
                <label>职务</label>
                <input name="job" type="text" class="dfinput" value=""/>
            </li>
            <li>
                <label>性别</label>
                <cite><input name="sex" type="radio" value="男" checked="checked"/>
                    男&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="sex" type="radio" value="女"/>
                    女</cite></li>
            <li><label>手机号码 <font color="red">*</font></label><input name="phone" type="text" class="dfinput"
                                                                     value=""/></li>
            <li><label>出生日期</label>
                <input name="birthday" type="text" class="dfinput" value=""
                       onClick="WdatePicker({work_date:'',dateFmt:'yyyy-MM-dd'})"/></li>
            <li><label>邮箱 <font color="red">*</font></label><input name="email" type="text" class="dfinput"
                                                                   value=""/></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="saveButton()"/></li>
        </ul>
    </div>
</form>
</body>

</html>
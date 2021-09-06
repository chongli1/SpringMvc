<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/2
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc 之 ajax 和 mvc 收参数 非常重要</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
    <div>
        <input type="button" value="ajax 的01 中传参 kv-结构" id="ajax01">
        <input type="button" value="ajax 的02 中传参 对象" id="ajax02">
        <input type="button" value="ajax 的03 中传参 传数组或集合" id="ajax03">
        <input type="button" value="ajax 的04 中传参 传json对象" id="ajax04">
        <input type="button" value="ajax 的05 中传参 传多个对象" id="ajax05">
        <input type="button" value="ajax 的06 中传参 传批量对象" id="ajax06">
        <input type="button" value="ajax 的07 中传参 传map集合对象" id="ajax07">
        <input type="button" value="ajax 的08 中传参 传对象+常用类型 混合，常用于带参数的分页查询" id="ajax08">
    </div>

    <script>
        $(function () {
            $("#ajax01").click(function () {
                $.ajax({
                    url:'/api/admin/regByBean',
                    type:'POST',
                    data:{
                        'adminName':'ali',
                        'adminPwd':'123456',
                        'adminTime':'2021-02-02 14:20:23'
                    },
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    }

                });
            });
            $("#ajax02").click(function () {
                var adminInfo={};
                    adminInfo.adminName='ali';
                    adminInfo.adminPwd='123456';
                    adminInfo.adminTime='2021-02-02 14:20:23';
                $.ajax({
                    url:'/api/admin/regByBean',
                    type:'POST',
                    data:adminInfo,
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    }

                });
            });
            //ajax 传数组、集合，应用的范围是 批量删除，比如 ids[] = {2,5,7,9}
            $("#ajax03").click(function () {
                var ids = new Array();
                    ids.push(3);
                    ids.push(6);
                    ids.push(8);
                    ids.push(80);
                //把数组 使用ajax 传递
                $.ajax({
                    url:'/api/admin/ajax03',
                    type:'POST',
                    data:{'ids':ids},
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    }
                });
            });
            $("#ajax04").click(function () {
                //json对象 就是浏览器中看到的请求是带颜色的
                var adminInfo={
                    adminName:'小陈',
                    adminPwd:'123456',
                    adminTime:"2021-09-02 11:11:11",
                    loverList:[
                        {
                        name:"小黑",
                        age:1
                        },
                        {
                            name:"小白",
                            age:2
                        },
                        {
                            name:"小花",
                            age:11
                        }
                    ],
                    aihao:[1,2,3]
                };
                //var 出来的对象，他是个对象，如果直接传输，www-urlxxx 传递的，黑色
                //因为普通的请求 是很多 kv 结构，后台收取特别麻烦，所以需要把复杂对象转换为json对象
                //然后 后台接收就方便多了，前后端项目 一般都用json传递
                $.ajax({
                    url:'/api/admin/ajax04',
                    type:'POST',
                    //data:adminInfo,   //普通的 kv 结构 请求方式是：Content-Type:application/x-www-form-urlencoded; charset=UTF-8
                    data:JSON.stringify(adminInfo),  //变为json对象后，就需要 Content-Type 更改为 application/json;charser=UTF-8
                    contentType:'application/json;charset=UTF-8',
                    dataType:'json',
                    success:function (res) {
                        console.log(res)
                    }
                })
            });
            $("#ajax05").click(function () {  //不常见，因为 发货单 上面是收货人对象，下面是产品对象
                $.ajax({
                    url:"/api/admin/ajax05",
                    type:'POST',
                    dataType:'JSON',
                    data:{
                        'lover.name':'小花',
                        'lover.age':1,
                        'dog.dogId':01,
                        'dog.dogSex':'man',
                    },
                    success:function (res) {
                        console.log(res)
                    }
                });
            });
            $("#ajax06").click(function () {
                var loverList=[];
                    for(var i = 0; i < 5; i++){
                        var lover={
                            name:"小哈"+i,
                            age:18
                        }
                        loverList.push(lover)
                    }
                    //多个对象，就属于复杂，复杂用json
                    $.ajax({
                        url:'/api/admin/ajax06',
                        //type:'GET',   //get请求没有方法体是无法 传输 json协议的 和 json数据的！！！
                        type:'POST',  //post请求在网页上很短 叫Form Date  get请求在网页上很长，直接放在浏览器上，不安全
                        data:JSON.stringify(loverList),    //json序列化
                        dataType:'JSON',
                        contentType:'application/json;charest=UTF-8',
                        success:function (res) {
                            console.log(res)
                        }
                    });
            });
            $("#ajax07").click(function () {
                var map = {
                    'adminName':'ali',
                    'adminPwd':'123456',
                    'adminTime':'2021-02-02 14:20:23'
                }
                $.ajax({
                    url:'/api/admin/ajax07',
                    type:'POST',
                    dataType:'JSON',
                    data:JSON.stringify(map),
                    success:function (res) {
                        console.log(res)
                    },
                    contentType:'application/json;charset=UTF-8'
                });
            });
            $("#ajax08").click(function () {
                $.ajax({
                    url:'/api/admin/ajax08',
                    type:'POST',
                    data:{  //4个kv 是3个参数，name和age 是 lover对象，剩下的都是单独的属性
                        'name':'小A',
                        'age':3,
                        'pageSize':5,
                        'page':2
                    },
                    dataType:'JSON',
                    success:function (res) {
                        console.log(res)
                    }
                });
            });
        });
    </script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="author" content="Yu Weiyi 于魏祎 yu_weiyi@outlook.com">

    <!-- Bootstrap -->
    <%--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">--%>
    <%--        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim" crossorigin="anonymous"></script>--%>

    <!-- Layui -->
    <link href="/layui/css/layui.css" rel="stylesheet">
    <script src="/layui/layui.js"></script>
    <%--        <!-- CDN引入 -->--%>
    <%--        <link rel="stylesheet" type="text/css" href="https://www.layuicdn.com/layui-v2.5.6/css/layui.css" />--%>
    <%--        <script src="https://www.layuicdn.com/layui-v2.5.6/layui.js"></script>--%>

    <!-- jQuery -->
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

    <title>邮易 YoE 仓储物流 首页</title>

    <script type="text/javascript" charset="UTF-8" src="/static/js/layui.js"></script>

    <style>
      html,body{
        height: 100%;
        width: 100%;
        margin:0;
        padding:0;
      }
    </style>
  </head>
  <body>
    <div id="header"></div>
    <script type="text/javascript">
      $('#header').load('component/header')
    </script>
<%--  <iframe src="component/header.jsp" scrolling="no" frameborder="0" height="100%" id="header" width="100%"></iframe>--%>
    <div class="layui-body" style="color: #dddddd; left: 0px;">
      test body
    </div>
    <div id="footer"></div>
    <script type="text/javascript">
      $('#footer').load('/component/footer')
    </script>
<%--    <div id="fixbar"></div>--%>
<%--    <script type="text/javascript">--%>
<%--      $('#fixbar').load('/component/fixbar')--%>
<%--    </script>--%>

<%--  <iframe src="/static/component/fixbar.html" scrolling="no" frameborder="0" height="100%" id="fixbar" width="100%"></iframe>--%>
  </body>
</html>

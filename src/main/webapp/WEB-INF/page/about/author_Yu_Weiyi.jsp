<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="author" content="Yu Weiyi 于魏祎 yu_weiyi@outlook.com">

    <!-- Layui -->
    <link href="/layui/css/layui.css" rel="stylesheet">
    <script src="/layui/layui.js"></script>
    <!-- jQuery -->
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

    <title>邮易 YoE 仓储物流 关于作者</title>
    <link rel="icon" href="/static/image/pure_logo_YoE.png">

    <script type="text/javascript" charset="UTF-8" src="/static/js/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/body.css">
    <link rel="stylesheet" type="text/css" href="/static/css/heimu.css">

    <script>
      $(function(){
        $(".header").load("/static/component/header.html");
        $(".footer").load("/static/component/footer.html");
      });
    </script>
  </head>
  <body>
    <div class="header"></div>
    <div class="layui-body" style="color: #dddddd; left: 0px;">
      <div class="layui-container" align="center">
        <div class="layui-row" style="height: 20px"></div>
        <hr class="layui-border-green">
        <div class="layui-row" style="width: 50%">
          <h2 class="layui-bg-blue">关于作者</h2>
        </div>
        <div class="layui-row" style="height: 60px"></div>
        <table class="layui-table">
          <colgroup>
            <col>
            <col>
            <col>
            <col>
          </colgroup>
          <thead>
            <tr>
              <th>姓名</th>
              <th>高校</th>
              <th>学号</th>
              <th>联系方式</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>于魏祎</td>
              <td>重庆邮电大学<br>CQUPT</td>
              <td>2020211464</td>
              <td>Email: yu_weiyi@outlook.com<br>QQ: 1360271510<br>Phone/WeChat: 13942377414</td>
            </tr>
          </tbody>
        </table>
        <div class="layui-row" style="height: 20px"></div>
        <blockquote class="layui-elem-quote layui-font-20 layui-font-black">衣带渐宽终不悔，为伊消得人憔悴。</blockquote>
        <div class="layui-row" style="height: 20px"></div>
        <hr class="layui-border-green">
        <div class="layui-row" style="height: 60px"></div>
      </div>
      <div class="layui-row" style="height: 10px"></div>
    </div>
    <div class="footer"></div>
  </body>
</html>

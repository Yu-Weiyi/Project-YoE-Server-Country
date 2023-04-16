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

        <title>邮易 YoE 仓储物流 国际空运邮寄</title>
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
            <div><img src="/static/image/international/air_mailing/top.jpg" style="width: 100%; height: auto;"/></div>
            <div class="layui-container" align="center">
                <div class="layui-row" style="height: 20px"></div>
                <hr class="layui-border-green">
                <div class="layui-row" style="width: 50%">
                    <h2 class="layui-bg-blue">国际空运邮寄</h2>
                </div>
                <div class="layui-row" style="height: 60px"></div>
                <div class="layui-row layui-font-black">
                    <div class="layui-col-md6">
                        <fieldset class="layui-elem-field layui-bg-gray layui-font-black" align="left" style="width: 80%">
                            <legend>服务介绍</legend>
                            <div class="layui-field-box">
                                国际空运邮寄是邮易YoE与各国（地区）邮政合作开办的我国与其他国家和地区寄递特快专递邮件的快速类直发寄递服务，可为用户快速传递各类文件资料和物品，同时提供多种形式的邮件跟踪查询服务。该业务与各国（地区）邮政、海关、航空等部门紧密合作，打通绿色便利邮寄通道。此外，邮易YoE还提供保价、代客包装、代客报关等一系列综合延伸服务。
                            </div>
                        </fieldset>
                    </div>
                    <div class="layui-col-md6">
                        <fieldset class="layui-elem-field layui-bg-gray layui-font-black" align="left" style="width: 80%">
                            <legend>服务优势</legend>
                            <div class="layui-field-box">
                                <bf>覆盖面广：</bf>揽收网点覆盖范围广，目的地投递网络覆盖能力强。<br>
                                <bf>收费简单：</bf>无燃油附加费、偏远附加费、个人地址投递费。<br>
                                <bf>全程跟踪：</bf>邮件信息全程跟踪，随时了解邮件状态。<br>
                                <bf>清关便捷：</bf>享受邮件便捷进出口清关服务。<br>
                                <br><br>
                            </div>
                        </fieldset>
                    </div>
                </div>
                <div class="layui-row" style="height: 20px"></div>
                <hr class="layui-border-green">
                <div class="layui-row" style="height: 60px"></div>
            </div>
            <div class="layui-row" style="height: 10px"></div>
        </div>
        <div class="footer"></div>
    </body>
</html>

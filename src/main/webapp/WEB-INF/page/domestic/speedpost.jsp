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

        <title>邮易 YoE 仓储物流 国内特快速递</title>
        <link rel="icon" href="/static/image/pure_logo_YoE.png">

        <script type="text/javascript" charset="UTF-8" src="/static/js/layui.js"></script>
        <link rel="stylesheet" type="text/css" href="/static/css/body.css">
        <link rel="stylesheet" type="text/css" href="/static/css/font.css">
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
        <div class="layui-body font-SmileySans" style="color: #dddddd; left: 0px;">
            <div class="layui-container" align="center">
                <div class="layui-row" style="height: 20px"></div>
                <hr class="layui-border-green">
                <div class="layui-row" style="width: 50%">
                    <h2 class="layui-bg-blue">国内特快速递</h2>
                </div>
                <div class="layui-row" style="height: 60px"></div>
                <div class="layui-row layui-font-black">
                    <div class="layui-col-md4">
                        <fieldset class="layui-elem-field layui-bg-gray layui-font-black" align="left" style="width: 80%">
                            <legend>服务介绍</legend>
                            <div class="layui-field-box">
                                <div class="layui-row">
                                    国内特快专递是邮易YoE主要开办的产品，主要依托自主立体运输网，提供高效、安全的国内城市间文件和物品寄递服务。
                                    <br><br><br>
                                </div>
                                <div class="layui-row" align="center">
                                    <button class="layui-btn layui-btn-radius layui=btn-lg">
                                        <a href="/YoE/order/place">
                                            <div class="layui-row">
                                                <div class="layui-font-20">马上下单</div>
                                            </div>
                                        </a>
                                    </button>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="layui-col-md6">
                        <fieldset class="layui-elem-field layui-bg-gray layui-font-black" align="left" style="width: 80%">
                            <legend>服务特性</legend>
                            <div class="layui-field-box">
                                1.在指定服务范围和时间内，提供快递服务。<br>
                                2.提供代收代领、现付到付等多项增值服务。<br>
                                3.提供核心区域1小时上门服务。<br>
                                4.提供包装服务。<br>
                                5.提供满足不同材质、大小的绿色环保包装材料。<br>
                                6.邮件全程追踪，提供多种查询方式。<br>
                                7.提供专业的线上、线下客户服务。<br>
                            </div>
                        </fieldset>
                    </div>
                    <div class="layui-col-md2">
                        <fieldset class="layui-elem-field layui-bg-gray layui-font-black" align="left" style="width: 80%">
                            <legend>服务时空</legend>
                            <div class="layui-field-box">
                                1.全国全省全市。<br>
                                2.全日全天全时。<br>
                                <br><br><br><br><br>
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

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

        <title>邮易 YoE 仓储物流 关于邮易</title>
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
                    <h2 class="layui-bg-blue">关于邮易</h2>
                </div>
                <div class="layui-row" style="height: 60px"></div>
                <div><img src="/static/image/logo_YoE.png" style="width: 100%; height: auto;"/></div>
                <blockquote class="layui-elem-quote layui-font-black" align="left">
                    <p>邮易YoE仓储物流项目是一个全流程、体系化、跨场景协作、跨平台、自动化、实时化的仓储物流系统项目。</p>
                    <p>项目建立在一个假设的名为“邮易YoE”的仓储物流公司。该假想公司主要经营国内物流业务，同时也外延一部分国际物流业务。其国内业务中，物流链可区分普通物流或冷链物流，付款方可支持现付或到付，并可支持中途取消订单、订单货件返回或当地销毁，另外，依法留存订单发起者进行实名认证，依法对订单详细信息留存至少一年时间。</p>
                    <p>本项目主营业务方向为智能化仓储物流，就是利用自建或租赁库房、场地，与信息系统深度结合，进行储存、保管、装卸搬运、配送货物。具有广阔的应用前景。</p>
                    <p>本项目的主要设计特色在于后端数据库的设计与前端官网的设计。后端数据库采用了一种NoSQL——基于图论的数据库，以此，除实现了基础的信息存储功能外，还实现了基于图论算法的订单实时跟踪、路径即时规划等特有功能。前端官网设计主要融合借鉴同行业公司官网与其它主流网站，并赋予个人风格，总体印象在符合假想公司设定的基础上增添了新一代公司的年轻活力，网页优雅美观且活泼可爱，界面方便易用且新奇清新。</p>
                    <p>在长期计划中，将逐步开发项目数据库、后端服务器、公司官网浏览器客户端、链条中各场景的嵌入式系统、Android客户端、各平台小程序等，目的在于构建全流程、自动化的运作体系与完善跨平台、实时化的用户体验。</p>
                    <p>在本次实践中，主要完成了该系统中的项目数据库、项目官网后端、项目官网前端浏览器客户端等体系流程中核心部分的开发进程。未来将继续按部就班进行开发体系中的其它部分。</p>
                </blockquote>
                <div class="layui-row" style="height: 20px"></div>
                <hr class="layui-border-green">
                <div class="layui-row" style="height: 60px"></div>
            </div>
            <div class="layui-row" style="height: 10px"></div>
        </div>
        <div class="footer"></div>
    </body>
</html>

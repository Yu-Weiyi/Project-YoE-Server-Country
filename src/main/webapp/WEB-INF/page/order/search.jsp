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

        <title>邮易 YoE 仓储物流 查询订单</title>
        <link rel="icon" href="/static/image/pure_logo_YoE.png">

        <script type="text/javascript" charset="UTF-8" src="/static/js/layui.js"></script>
        <link rel="stylesheet" type="text/css" href="/static/css/body.css">
        <link rel="stylesheet" type="text/css" href="/static/css/font.css">
        <link rel="stylesheet" type="text/css" href="/static/css/heimu.css">

        <script>
            $(function(){
                // $(".header").load("/static/component/header.html");
                $(".footer").load("/static/component/footer.html");
            });
        </script>

        <script type="text/javascript">
            layui.use(function () {
                var upload = layui.upload,
                    date = layui.date,
                    element = layui.element,
                    form = layui.form,
                    layer = layui.layer;

                form.on('submit(search_order_form_btn)', function(data){
                    var order_id = document.getElementsByName('order_id').item(0).value;

                    $.ajax({
                        type: 'GET',
                        // async: false,//改为同步请求
                        url: "/YoE/order/search_order/" + order_id,
                        dataType: 'text',//预期服务器返回的数据类型
                        // data: form_data,//表格数据序列化
                        // contentType: "application/json; charset=utf-8",
                        success: function(res){//res为响应体,function为回调函数
                            layer.alert('查询成功', {icon: 1});

                            var return_data = JSON.parse(res + '');

                            document.getElementById('search_order_form').style.display = 'none';
                            document.getElementById('result_block').style.display = 'block';
                            document.getElementById('search_order_progress_bar').style.display = 'block';

                            var num = return_data.length;
                            var one_record;
                            for (var i = 0; i < num; i++) {
                                one_record = return_data[i];

                                var new_datetime = new Date(eval(one_record.datetime));

                                if (
                                    i == num - 1 &&
                                    (
                                        one_record.type == "开始订单" ||
                                        one_record.type == "货物入站" ||
                                        one_record.type == "货物出站" ||
                                        one_record.type == "发生错误" ||
                                        one_record.type == "正在投递" ||
                                        one_record.type == "查无此人" ||
                                        one_record.type == "客户拒收"
                                    )
                                ) {
                                    var new_time_line_item = [
                                        '<li class="layui-timeline-item">',
                                        '<i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis layui-icon-loading-1"></i>',
                                        '<div class="layui-timeline-content layui-text">',
                                        '<h3 class="layui-timeline-title">' + new_datetime.toLocaleString() + ': ' + '</h3>',
                                        '<p><b>' + one_record.type + ':</b> ' + one_record.msg + '</p>',
                                        '</div>',
                                        '</li>'
                                    ].join(' ');
                                }
                                else {
                                    var new_time_line_item = [
                                        '<li class="layui-timeline-item">',
                                        '<i class="layui-icon layui-timeline-axis layui-icon-circle"></i>',
                                        '<div class="layui-timeline-content layui-text">',
                                        '<h3 class="layui-timeline-title">' + new_datetime.toLocaleString() + ': ' + '</h3>',
                                        '<p><b>' + one_record.type + ':</b> ' + one_record.msg + '</p>',
                                        '</div>',
                                        '</li>'
                                    ].join(' ');
                                }
                                document.getElementById("search_order_timeline").insertAdjacentHTML('afterbegin',new_time_line_item);
                            }
                        },
                        error: function(res){
                            layer.alert('查询失败', {icon: 5});
                        }
                    });
                    return false; //阻止表单跳转
                });
            });
        </script>
    </head>
    <body>
<%--        <div class="header"></div>--%>
    <div class="layui-header font-LXGWWenKai">
        <div class="layui-row">
            <div class="layui-col-md1 layui-col-md-offset1">
                <img src="/static/image/logo_YoE.png" height="30px"/>
            </div>
            <div class="layui-col-md2 layui-col-md-offset1 layui-font-20">
                邮易 YoE 仓储物流
            </div>
            <div class="layui-col-md4 layui-col-md-offset3 layui-font-20">
                力争上「邮」「易」览神州
            </div>
        </div>
        <div class="layui-row">
            <ul class="layui-nav layui-bg-green" lay-filter="">
                <li class="layui-nav-item layui-this">
                    <a href="/YoE/index.jsp"><i class="layui-icon layui-icon-home"></i> 首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-form"></i> 业务办理</a>
                    <dl class="layui-nav-child layui-bg-green">
                        <dd><a href="/YoE/order/place">我要寄件</a></dd>
                        <dd><a href="/YoE/order/search">我要查件</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-user"></i> 国内物流服务</a>
                    <dl class="layui-nav-child layui-bg-green">
                        <dd><a href="/YoE/domestic/speedpost">国内特快速递<span class="layui-badge layui-bg-orange">荐</span></a></dd>
                        <dd><a href="/YoE/domestic/cold_chain_logistics">国内冷链物流</a></dd>
                        <dd><a href="/YoE/domestic/offsite_warehousing">国内异地仓储</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-website"></i> 国际物流服务</a>
                    <dl class="layui-nav-child layui-bg-green">
                        <dd><a href="/YoE/international/air_mailing">国际空运邮寄</a></dd>
                        <dd><a href="/YoE/international/bulk_shipping">国际大宗水运</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-fonts-code"></i> 科技赋能</a>
                    <dl class="layui-nav-child layui-bg-green">
                        <dd><a href="https://hugegraph.apache.org/cn/" target="_blank">图数据库 Hugegraph</a></dd>
                        <dd><a href="https://spring.io/" target="_blank">后端框架 Spring</a></dd>
                        <dd><a href="http://layui.org.cn/index.html" target="_blank">前端UI框架 Layui</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-about"></i> 关于</a>
                    <dl class="layui-nav-child layui-bg-green">
                        <dd><a href="/YoE/about/project_YoE">关于邮易</a></dd>
                        <dd><a href="/YoE/about/author_Yu_Weiyi">关于作者</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon layui-icon-link"></i> 友情链接</a>
                    <dl class="layui-nav-child layui-bg-green">
                        <dd><a href="http://10.16.63.192:8000/" target="_blank">恒达科技</a></dd>
                        <dd><a href="http://139.9.154.99/" target="_blank">蜂翼动画 FY</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
        <div class="layui-body font-SmileySans" style="color: #dddddd; left: 0px;">
            <div class="layui-container" align="center">
                <div class="layui-row" style="height: 20px"></div>
                <hr class="layui-border-green">
                <div class="layui-row" style="width: 50%">
                    <h2 class="layui-bg-blue">查询订单</h2>
                </div>
                <div class="layui-row" style="height: 60px"></div>
                <div class="layui-container">
                    <div class="layui-progress layui-progress-big" lay-showPercent="true" lay-fliter="search_order_progress_bar">
                        <div class="layui-progress-bar layui-bg-green" style="width: 80%; display: none" lay-percent="100%" id="search_order_progress_bar"></div>
                    </div>
                    <div class="layui-row" style="height: 20px"></div>
                    <form class="layui-form layui-font-black" align="left" style="display: block; width: 60%" id="search_order_form" lay-filter="search_order_form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">单号</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="order_id" required lay-verify="required" placeholder="" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">预设测试用订单号：【1145141919810】</div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="search_order_form_btn">查询</button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-row" style="height: 20px"></div>
                    <div id="result_block" style="width: 60%" align="left">
                        <ul class="layui-timeline" id="search_order_timeline">
                        </ul>
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

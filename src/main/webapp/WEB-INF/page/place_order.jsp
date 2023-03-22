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


        <title>邮易 YoE 仓储物流 发起订单</title>

        <script type="text/javascript" charset="UTF-8" src="static/js/layui.js"></script>

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
        <div class="layui-header">
            <div class="layui-row">
                <div class="layui-col-md1 layui-col-md-offset1">
                    <img src="static/image/logo_YoE.png" width="60px" height="30px"/>
                </div>
                <div class="layui-col-md2 layui-font-20">
                    邮易 YoE 仓储物流
                </div>
            </div>
            <div class="layui-row">
                <ul class="layui-nav layui-bg-green" lay-filter="">
                    <li class="layui-nav-item layui-this">
                        <a href="index.jsp"><i class="layui-icon layui-icon-home"></i> 首页</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="layui-icon layui-icon-form"></i> 业务办理</a>
                        <dl class="layui-nav-child layui-bg-green">
                            <dd><a href="">我要寄件</a></dd>
                            <dd><a href="">我要查件</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="layui-icon layui-icon-user"></i> 国内物流服务</a>
                        <dl class="layui-nav-child layui-bg-green">
                            <dd><a href="">国内特快速递</a></dd>
                            <dd><a href="">国内大宗运输<span class="layui-badge layui-bg-orange">X</span></a></dd>
                            <dd><a href="">国内冷链物流</a></dd>
                            <dd><a href="">国内异地仓储<span class="layui-badge layui-bg-orange">X</span></a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="layui-icon layui-icon-website"></i> 国际物流服务</a>
                        <dl class="layui-nav-child layui-bg-green">
                            <dd><a href="">国际空运邮寄<span class="layui-badge layui-bg-orange">X</span></a></dd>
                            <dd><a href="">国际大宗水运<span class="layui-badge layui-bg-orange">X</span></a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="layui-icon layui-icon-fonts-code"></i> 科技赋能</a>
                        <dl class="layui-nav-child layui-bg-green">
                            <dd><a href="">图数据库 Hugegraph</a></dd>
                            <dd><a href="">前端UI框架 Layui</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href=""><i class="layui-icon layui-icon-about"></i> 关于邮易</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="layui-icon layui-icon-link"></i> 友情链接</a>
                        <dl class="layui-nav-child layui-bg-green">
                            <dd><a href="">蜂翼 FENGYI</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        <div class="layui-body" style="color: #dddddd; left: 0px;">
            <div class="layui-container" align="center">
                <div class="layui-row" style="height: 20px"></div>
                <hr class="layui-border-green">
                <div class="layui-row" style="width: 50%">
                    <h2 class="layui-bg-blue">发起订单</h2>
                </div>
                <div class="layui-row" style="height: 60px"></div>
                <div class="layui-row">
                    <div class="layui-col-md6">
                        <button class="layui-btn layui-btn-radius layui=btn-lg layui-btn-disabled" style="height: 40px">
<%--                            <a href="place_order_self_help_1">--%>
                                <div class="layui-row">
                                    <i class="layui-icon layui-icon-friends"></i>
                                    <div class="layui-font-20">用户自助寄件</div>
                                </div>
<%--                            </a>--%>
                        </button>
                    </div>
                    <div class="layui-col-md6">
                        <button class="layui-btn layui-btn-radius layui=btn-lg">
                            <a href="place_order_employee_assistance">
                                <div class="layui-row">
                                    <i class="layui-icon layui-icon-group"></i>
                                    <div class="layui-font-20">员工辅助寄件</div>
                                </div>
                            </a>
                        </button>
                    </div>
                </div>
                <div class="layui-row" style="height: 60px"></div>
            </div>
            <div class="layui-row" style="height: 10px"></div>
        </div>
        <div class="layui-footer layui-bg-green">
            <div class="layui-row layui-bg-orange" style="height: 5px"></div>
            <div class="layui-container" align="center">
                <hr class="layui-border-black">
                <div class="layui-row">
                    <div class="layui-col-md8">
                        <div class="layui-col-md3">
                            <div class="layui-row">
                                <h4><b>产品服务</b></h4>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">常规寄件</a></h5>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">订单查件</a></h5>
                            </div>
                        </div>
                        <div class="layui-col-md3">
                            <div class="layui-row">
                                <h4><b>服务支持</b></h4>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">费用公示</a></h5>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">限寄规则</a></h5>
                            </div>
                        </div>
                        <div class="layui-col-md3">
                            <div class="layui-row">
                                <h4><b>科技赋能</b></h4>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">图数据库 HugeGraph</a></h5>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">前端UI框架 Layui</a></h5>
                            </div>
                        </div>
                        <div class="layui-col-md3">
                            <div class="layui-row">
                                <h4><b>关于邮易</b></h4>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">项目简介</a></h5>
                            </div>
                            <div class="layui-row" style="height: 20px"></div>
                            <div class="layui-row">
                                <h5><a href="" class="layui-font-gray">项目作者</a></h5>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md4">
                        <div class="layui-row">
                            <h4><b>联系方式</b></h4>
                        </div>
                        <div class="layui-row" style="height: 20px"></div>
                        <div class="layui-row">
                            <button type="button" class="layui-btn layui-btn-radius layui-btn-normal layui-bg-gray"
                                    id="btn_tip_email" onmouseenter="btn_show_tip_email()">
                                <i class="layui-icon layui-icon-email"></i>
                            </button>
                            <button type="button" class="layui-btn layui-btn-radius layui-btn-normal layui-bg-gray"
                                    id="btn_tip_qq" onmouseenter="btn_show_tip_qq()">
                                <i class="layui-icon layui-icon-login-qq"></i>
                            </button>
                            <button type="button" class="layui-btn layui-btn-radius layui-btn-normal layui-bg-gray"
                                    id="btn_tip_wechat" onmouseenter="btn_show_tip_wechat()">
                                <i class="layui-icon layui-icon-login-wechat"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <hr class="layui-border-black">
                <div class="layui-row">
                    <div class="layui-col-md3">
                        <b4><b>友情链接：</b></b4>
                    </div>
                    <div class="layui-col-md2">
                        <h5><a href="http://10.16.63.192:8000/" class="layui-font-gray">恒达科技</a></h5>
                    </div>
                    <div class="layui-col-md2">
                        <h5><a href="" class="layui-font-gray">蜂翼 FENGYI</a></h5>
                    </div>
                </div>
                <hr class="layui-border-black">
                <div class="layui-row" style="height: 20px"></div>
                <div class="layui-row">
                    ©2023 Yu Weiyi. All Rights Reserved.
                </div>
                <div class="layui-row" style="height: 50px"></div>
            </div>
        </div>
        <ul class="layui-fixbar">
            <li class="layui-icon layui-fixbar-top" lay-type="top" style="display: list-item;">
                <a href="javascript:scroll(0,0)"><i class="layui-icon-top"></i></a>
            </li>
        </ul>
    </body>
</html>

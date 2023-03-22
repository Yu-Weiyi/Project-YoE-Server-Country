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

        <title>邮易 YoE 仓储物流 员工辅助寄件</title>

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
                    <h2 class="layui-bg-blue">员工辅助寄件</h2>
                </div>
                <div class="layui-row" style="height: 20px"></div>
                <div class="layui-container">
                    <div class="layui-progress layui-progress-big" lay-showPercent="true" lay-fliter="place_order_employee_assistance_progress_bar">
                        <div class="layui-progress-bar layui-bg-green" style="width: 80%" lay-percent="0%"></div>
                    </div>
                    <div class="layui-row" style="height: 20px"></div>
                    <form class="layui-form layui-font-black" align="left" style="display: block; width: 60%" id="place_order_employee_assistance_form" lay-filter="place_order_employee_assistance_form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">员工<br>账号</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="employee_account_id" required lay-verify="required" placeholder="" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">测试阶段，请随意填写，该项不会被操作。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">员工<br>密码</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="password" name="employee_account_password" required lay-verify="required" placeholder="" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">测试阶段，请随意填写，该项不会被操作。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">寄件人<br>姓名</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="consigner_name" required lay-verify="required" placeholder="" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">国家规定，寄出者需要实名认证。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">寄件人<br>身份证</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="consigner_id" required lay-verify="required|identity" placeholder="此项有格式验证" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">国家规定，寄出者需要实名认证。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">寄件人<br>手机号</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="consigner_phone" required lay-verify="required|phone" placeholder="此项有格式验证" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">用于防止意外情况联系寄件人。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">收件人<br>昵称</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="consignee_name" required lay-verify="required" placeholder="" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">用于收件人识别。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">收件人<br>手机号</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="consignee_phone" required lay-verify="required|phone" placeholder="此项有格式验证" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux">用于收件人联系。</div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">货物<br>信息</label>
                            <div class="layui-input-block">
                                <textarea placeholder="" class="layui-textarea" name="cargo_info" required lay-verify="required"></textarea>
                            </div>
                            <div class="layui-form-mid layui-word-aux">请输入货物名称、体积、重量等信息。</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">货物<br>类别</label>
                            <div class="layui-input-block">
                                <input type="radio" name="cargo_type" value=0 title="一般" checked>
                                <input type="radio" name="cargo_type" value=1 title="冷链">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">验视</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" name="inspect" required lay-verify="required" placeholder="" autocomplete="off">
                            </div>
                            <div class="layui-form-mid layui-word-aux"></div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">寄件地</label>
                            <div class="layui-input-inline">
                                <select name="consigner_province" id="consigner_province" lay-filter="consigner_province">
                                    <option value="" selected>请选择省级</option>
                                    <option value="A省">A省</option>
                                    <option value="B省">B省</option>
                                    <option value="C省">C省</option>
                                    <option value="D省">D省</option>
                                    <option value="E省">E省</option>
                                    <option value="F省">F省</option>
                                    <option value="G省">G省</option>
                                    <option value="H省">H省</option>
                                    <option value="I省" disabled>I省</option>
                                    <option value="J省" disabled>J省</option>
                                    <option value="K省">K省</option>
                                    <option value="L省" disabled>L省</option>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="consigner_city" id="consigner_city" lay-filter="consigner_city">
                                    <option value="" selected>请选择地级</option>
                                    <option value="A1市">A1市</option>
                                    <option value="B1市">B1市</option>
                                    <option value="C1市">C1市</option>
                                    <option value="C2市">C2市</option>
                                    <option value="C3市">C3市</option>
                                    <option value="C4市">C4市</option>
                                    <option value="D1市">D1市</option>
                                    <option value="D2市">D2市</option>
                                    <option value="D3市">D3市</option>
                                    <option value="D4市">D4市</option>
                                    <option value="E1市">E1市</option>
                                    <option value="E2市">E2市</option>
                                    <option value="E3市">E3市</option>
                                    <option value="F1市">F1市</option>
                                    <option value="F2市">F2市</option>
                                    <option value="F3市">F3市</option>
                                    <option value="F4市">F4市</option>
                                    <option value="G1市">G1市</option>
                                    <option value="G2市">G2市</option>
                                    <option value="H1市">H1市</option>
                                    <option value="I1市" disabled>I1市</option>
                                    <option value="I2市" disabled>I2市</option>
                                    <option value="I3市" disabled>I3市</option>
                                    <option value="I4市" disabled>I4市</option>
                                    <option value="J1市" disabled>J1市</option>
                                    <option value="J2市" disabled>J2市</option>
                                    <option value="J3市" disabled>J3市</option>
                                    <option value="J4市" disabled>J4市</option>
                                    <option value="K1市">K1市</option>
                                    <option value="L1市" disabled>L1市</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">寄件地<br>详细地址</label>
                            <div class="layui-input-block">
                                <textarea placeholder="" class="layui-textarea" name="consigner_address" required lay-verify="required"></textarea>
                            </div>
                            <div class="layui-form-mid layui-word-aux"></div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">收件地</label>
                            <div class="layui-input-inline">
                                <select name="consignee_province" id="consignee_province" lay-filter="consignee_province">
                                    <option value="" selected>请选择省级</option>
                                    <option value="A省">A省</option>
                                    <option value="B省">B省</option>
                                    <option value="C省">C省</option>
                                    <option value="D省">D省</option>
                                    <option value="E省">E省</option>
                                    <option value="F省">F省</option>
                                    <option value="G省">G省</option>
                                    <option value="H省">H省</option>
                                    <option value="I省" disabled>I省</option>
                                    <option value="J省" disabled>J省</option>
                                    <option value="K省">K省</option>
                                    <option value="L省" disabled>L省</option>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="consignee_city" id="consignee_city" lay-filter="consignee_city">
                                    <option value="" selected>请选择地级</option>
                                    <option value="A1市">A1市</option>
                                    <option value="B1市">B1市</option>
                                    <option value="C1市">C1市</option>
                                    <option value="C2市">C2市</option>
                                    <option value="C3市">C3市</option>
                                    <option value="C4市">C4市</option>
                                    <option value="D1市">D1市</option>
                                    <option value="D2市">D2市</option>
                                    <option value="D3市">D3市</option>
                                    <option value="D4市">D4市</option>
                                    <option value="E1市">E1市</option>
                                    <option value="E2市">E2市</option>
                                    <option value="E3市">E3市</option>
                                    <option value="F1市">F1市</option>
                                    <option value="F2市">F2市</option>
                                    <option value="F3市">F3市</option>
                                    <option value="F4市">F4市</option>
                                    <option value="G1市">G1市</option>
                                    <option value="G2市">G2市</option>
                                    <option value="H1市">H1市</option>
                                    <option value="I1市" disabled>I1市</option>
                                    <option value="I2市" disabled>I2市</option>
                                    <option value="I3市" disabled>I3市</option>
                                    <option value="I4市" disabled>I4市</option>
                                    <option value="J1市" disabled>J1市</option>
                                    <option value="J2市" disabled>J2市</option>
                                    <option value="J3市" disabled>J3市</option>
                                    <option value="J4市" disabled>J4市</option>
                                    <option value="K1市">K1市</option>
                                    <option value="L1市" disabled>L1市</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">收件地<br>详细地址</label>
                            <div class="layui-input-block">
                                <textarea placeholder="" class="layui-textarea" name="consignee_address" required lay-verify="required"></textarea>
                            </div>
                            <div class="layui-form-mid layui-word-aux"></div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">订单<br>类别</label>
                            <div class="layui-input-block">
                                <input type="radio" name="order_type" value=0 title="现付" checked>
                                <input type="radio" name="order_type" value=1 title="到付">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="place_order_employee_assistance_form_btn">确认提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="layui-row" style="height: 20px"></div>
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
    <script type="text/javascript">
        layui.use(function () {
            var upload = layui.upload,
                form = layui.form,
                layer = layui.layer;

            form.on('select(consigner_province)',function (data) {
                var province_selected = data.value;
                $('#consigner_city').empty();
                switch (province_selected) {
                    case "A省":
                        $('#consigner_city').append("<option value='A1市'>A1市</option>");
                        break;
                    case "B省":
                        $('#consigner_city').append("<option value='B1市'>B1市</option>");
                        break;
                    case "C省":
                        $('#consigner_city').append("<option value='C1市'>C1市</option>");
                        $('#consigner_city').append("<option value='C2市'>C2市</option>");
                        $('#consigner_city').append("<option value='C3市'>C3市</option>");
                        $('#consigner_city').append("<option value='C4市'>C4市</option>");
                        break;
                    case "D省":
                        $('#consigner_city').append("<option value='D1市'>D1市</option>");
                        $('#consigner_city').append("<option value='D2市'>D2市</option>");
                        $('#consigner_city').append("<option value='D3市'>D3市</option>");
                        $('#consigner_city').append("<option value='D4市'>D4市</option>");
                        break;
                    case "E省":
                        $('#consigner_city').append("<option value='E1市'>E1市</option>");
                        $('#consigner_city').append("<option value='E2市'>E2市</option>");
                        $('#consigner_city').append("<option value='E3市'>E3市</option>");
                        break;
                    case "F省":
                        $('#consigner_city').append("<option value='F1市'>F1市</option>");
                        $('#consigner_city').append("<option value='F2市'>F2市</option>");
                        $('#consigner_city').append("<option value='F3市'>F3市</option>");
                        $('#consigner_city').append("<option value='F4市'>F4市</option>");
                        break;
                    case "G省":
                        $('#consigner_city').append("<option value='G1市'>G1市</option>");
                        $('#consigner_city').append("<option value='G2市'>G2市</option>");
                        break;
                    case "H省":
                        $('#consigner_city').append("<option value='H1市'>H1市</option>");
                        break;
                    case "I省":
                        $('#consigner_city').append("<option value='I1市'>I1市</option>");
                        $('#consigner_city').append("<option value='I2市'>I2市</option>");
                        $('#consigner_city').append("<option value='I3市'>I3市</option>");
                        $('#consigner_city').append("<option value='I4市'>I4市</option>");
                        break;
                    case "J省":
                        $('#consigner_city').append("<option value='J1市'>J1市</option>");
                        $('#consigner_city').append("<option value='J2市'>J2市</option>");
                        $('#consigner_city').append("<option value='J3市'>J3市</option>");
                        $('#consigner_city').append("<option value='J4市'>J4市</option>");
                        break;
                    case "K省":
                        $('#consigner_city').append("<option value='K1市'>K1市</option>");
                        break;
                    case "L省":
                        $('#consigner_city').append("<option value='L1市'>L1市</option>");
                        break;
                }
                form.render('select');
            });

            form.on('select(consignee_province)',function (data) {
                var province_selected = data.value;
                $('#consignee_city').empty();
                switch (province_selected) {
                    case "A省":
                        $('#consignee_city').append("<option value='A1市'>A1市</option>");
                        break;
                    case "B省":
                        $('#consignee_city').append("<option value='B1市'>B1市</option>");
                        break;
                    case "C省":
                        $('#consignee_city').append("<option value='C1市'>C1市</option>");
                        $('#consignee_city').append("<option value='C2市'>C2市</option>");
                        $('#consignee_city').append("<option value='C3市'>C3市</option>");
                        $('#consignee_city').append("<option value='C4市'>C4市</option>");
                        break;
                    case "D省":
                        $('#consignee_city').append("<option value='D1市'>D1市</option>");
                        $('#consignee_city').append("<option value='D2市'>D2市</option>");
                        $('#consignee_city').append("<option value='D3市'>D3市</option>");
                        $('#consignee_city').append("<option value='D4市'>D4市</option>");
                        break;
                    case "E省":
                        $('#consignee_city').append("<option value='E1市'>E1市</option>");
                        $('#consignee_city').append("<option value='E2市'>E2市</option>");
                        $('#consignee_city').append("<option value='E3市'>E3市</option>");
                        break;
                    case "F省":
                        $('#consignee_city').append("<option value='F1市'>F1市</option>");
                        $('#consignee_city').append("<option value='F2市'>F2市</option>");
                        $('#consignee_city').append("<option value='F3市'>F3市</option>");
                        $('#consignee_city').append("<option value='F4市'>F4市</option>");
                        break;
                    case "G省":
                        $('#consignee_city').append("<option value='G1市'>G1市</option>");
                        $('#consignee_city').append("<option value='G2市'>G2市</option>");
                        break;
                    case "H省":
                        $('#consignee_city').append("<option value='H1市'>H1市</option>");
                        break;
                    case "I省":
                        $('#consignee_city').append("<option value='I1市'>I1市</option>");
                        $('#consignee_city').append("<option value='I2市'>I2市</option>");
                        $('#consignee_city').append("<option value='I3市'>I3市</option>");
                        $('#consignee_city').append("<option value='I4市'>I4市</option>");
                        break;
                    case "J省":
                        $('#consignee_city').append("<option value='J1市'>J1市</option>");
                        $('#consignee_city').append("<option value='J2市'>J2市</option>");
                        $('#consignee_city').append("<option value='J3市'>J3市</option>");
                        $('#consignee_city').append("<option value='J4市'>J4市</option>");
                        break;
                    case "K省":
                        $('#consignee_city').append("<option value='K1市'>K1市</option>");
                        break;
                    case "L省":
                        $('#consignee_city').append("<option value='L1市'>L1市</option>");
                        break;
                }
                form.render('select');
            });

            form.on('submit(place_order_employee_assistance_form_btn)', function(data){
                var param=data.field;//定义临时变量获取表单提交过来的数据，非json格式
                console.log(JSON.stringify(param));//测试是否获取到表单数据，调试模式下在页面控制台查看
                $.ajax({
                    type:'POST',
                    url:"order/place_order",
                    dataType:'json',//预期服务器返回的数据类型
                    data:JSON.stringify(param),//表格数据序列化
                    contentType: "application/json; charset=utf-8",
                    success:function(res){//res为相应体,function为回调函数
                        if(res.status===200){
                            layer.alert('提交成功',{icon:1});
                            //$("#res").click();//调用重置按钮将表单数据清空
                        }
                        else{
                            layer.alert(data.msg,{icon:5});
                        }
                    },
                    // error:function(){
                    //     layer.alert('提交失败',{icon:5});
                    // }
                });
                return false; //阻止表单跳转
            });
        });
    </script>
</html>

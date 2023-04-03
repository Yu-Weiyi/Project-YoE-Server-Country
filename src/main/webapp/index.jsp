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

    <title>邮易 YoE 仓储物流 首页</title>

    <script type="text/javascript" charset="UTF-8" src="/static/js/layui.js"></script>

    <style type="text/css">
      @import url("/static/css/body.css") main;
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
              <dd><a href="place_order">我要寄件</a></dd>
              <dd><a href="search_order">我要查件</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon layui-icon-user"></i> 国内物流服务</a>
            <dl class="layui-nav-child layui-bg-green">
              <dd><a href="not_implemented">国内特快速递<span class="layui-badge layui-bg-orange">X</span></a></dd>
              <dd><a href="not_implemented">国内大宗运输<span class="layui-badge layui-bg-orange">X</span></a></dd>
              <dd><a href="not_implemented">国内冷链物流<span class="layui-badge layui-bg-orange">X</span></a></dd>
              <dd><a href="not_implemented">国内异地仓储<span class="layui-badge layui-bg-orange">X</span></a></dd>
            </dl>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon layui-icon-website"></i> 国际物流服务</a>
            <dl class="layui-nav-child layui-bg-green">
              <dd><a href="not_implemented">国际空运邮寄<span class="layui-badge layui-bg-orange">X</span></a></dd>
              <dd><a href="not_implemented">国际大宗水运<span class="layui-badge layui-bg-orange">X</span></a></dd>
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
            <a href="about_project"><i class="layui-icon layui-icon-about"></i> 关于邮易</a>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:;"><i class="layui-icon layui-icon-link"></i> 友情链接</a>
            <dl class="layui-nav-child layui-bg-green">
              <dd><a href="http://139.9.154.99/" target="_blank">蜂翼动画 FY</a></dd>
            </dl>
          </li>
        </ul>
      </div>
    </div>
    <div class="layui-body" style="color: #dddddd; left: 0px;">
      <div class="layui-row" style="height: 10px"></div>
      <div class="layui-carousel" id="home_carousel">
        <div carousel-item>
          <div><img src="static/image/carousel_1.jpg" style="width: 100%; height: auto;"/></div>
          <div><img src="static/image/carousel_2.jpg" style="width: 100%; height: auto;"/></div>
          <div><img src="static/image/carousel_3.jpg" style="width: 100%; height: auto;"/></div>
          <div><img src="static/image/carousel_4.jpg" style="width: 100%; height: auto;"/></div>
          <div><img src="static/image/carousel_5.jpg" style="width: 100%; height: auto;"/></div>
          <div><img src="static/image/carousel_6.jpg" style="width: 100%; height: auto;"/></div>
          <div><img src="static/image/carousel_7.jpg" style="width: 100%; height: auto;"/></div>
        </div>
      </div>
      <div class="layui-container layui-font-black" align="center">
        <div class="layui-row" style="height: 10px"></div>
        <hr class="layui-border-green">
        <div class="layui-row" style="width: 50%">
          <h2 class="layui-bg-blue">业  务  介  绍</h2>
        </div>
        <div class="layui-row" style="height: 20px"></div>
        <div class="layui-row">
          <div class="layui-col-md6">
            <img src="/static/image/country.jpg" style="width: 60%; height: auto;">
          </div>
          <div class="layui-col-md3>">
            <fieldset class="layui-elem-field" align="left" style="width: 30%">
              <legend>国内业务</legend>
              <div class="layui-field-box">
                YoE拥有首屈一指的航空和陆路运输网络以及高效发达的邮递处理中心，国内范围通达全覆盖，并拥有多种不同的快递产品和增值服务，满足客户多样化、个性化的寄件需求。
              </div>
            </fieldset>
          </div>
        </div>
        <div class="layui-row" style="height: 20px"></div>
        <div class="layui-row">
          <div class="layui-col-md6">
            <img src="/static/image/international.jpg" style="width: 60%; height: auto;">
          </div>
          <div class="layui-col-md3>">
            <fieldset class="layui-elem-field" align="left" style="width: 30%">
              <legend>国际业务</legend>
              <div class="layui-field-box">
                YoE国际计划在未来为用户提供全球200多个国家和地区的寄递服务。根据不同产品，可提供信息查询、邮件保价、延误赔偿和丢失赔偿等增值服务，以满足用户寄递物品、文件资料和信件等不同类型的需求。
              </div>
            </fieldset>
          </div>
        </div>
        <hr class="layui-border-green">
        <div class="layui-row" style="width: 50%">
          <h2 class="layui-bg-blue">行  业  解  决  方  案</h2>
        </div>
        <div class="layui-row" style="height: 20px"></div>
        <div class="layui-collapse" align="left" style="width: 80%">
          <div class="layui-colla-item">
            <h3 class="layui-colla-title">快消品行业</h3>
            <div class="layui-colla-content layui-show">
              YoE重点关注食品、酒水、连锁、化妆品、家居、烟草子行业。依托物流资源和网络优势，满足快消行业客户季节性运作需求。为您提供供应链全环节物流服务，包括：整车运输、 零担运输、仓储快递服务，并针对快消子行业 客户的不同的物流需求，可以为您提供恒温仓储、冷链运输等定制化物流服务，提供具有市场竞争力的物流服务。
            </div>
          </div>
          <div class="layui-colla-item">
            <h3 class="layui-colla-title">医药行业</h3>
            <div class="layui-colla-content layui-show">
              依托YoE全国物流网络，为药品制造和经销企业提供西药、中成药、医疗器械等物流服务，并可根据客户需求实现整车直送、零担快递、全环节的控温、恒温冷链物流服务，确保药品的全程时限和安全保障。
            </div>
          </div>
          <div class="layui-colla-item">
            <h3 class="layui-colla-title">高科技行业</h3>
            <div class="layui-colla-content layui-show">
              YoE以专注行业服务经验及资源整合能力，为您提供供应链端到端服务，包括仓储、运输配送、流通加工和装卸搬运等增值服务、供应链金融、网络规划和供应链设计等，帮助您降低运作成本与资金，让您致力于自身核心竞争力的发展。
            </div>
          </div>
          <div class="layui-colla-item">
            <h3 class="layui-colla-title">汽车行业</h3>
            <div class="layui-colla-content layui-show">
              YoE专注于为知名品牌的汽车零部件供应商及主机厂提供仓储到运输全供应链物流服务。针对客户的不同运作模式量身定做符合客户战略发展的一体化运作、供应链规划方案，服务产品涉及入厂物流、售后零部件物流、专业的仓储管理。
            </div>
          </div>
          <div class="layui-colla-item">
            <h3 class="layui-colla-title">鞋服行业</h3>
            <div class="layui-colla-content layui-show">
              YoE基于鞋服企业遍布全国的实体店及网络销售需求，结合行业季节性需求及高流动性特点，为您量身打造具有竞争力的全供应链物流解决方案，快速响应您在原材料运输、成品配送、门店调拨、退货、电子商务等方面的需求。
            </div>
          </div>
        </div>
        <hr class="layui-border-green">
        <div class="layui-row" style="width: 50%">
          <h2 class="layui-bg-blue">新  闻  资  讯</h2>
        </div>
        <fieldset class="layui-elem-field" align="left" style="width: 80%">
          <legend>TD-SCDMA</legend>
          <div class="layui-field-box">
            2005年10月9日下午2:30，重庆市人民政府新闻办公室在重庆市新闻发布中心举行了新闻发布会。会议郑重发布了“世界第一颗0.13微米工艺的TD-SCDMA 3G手机核心芯片在重庆诞生”这一令国人自豪和骄傲的重大喜讯。重庆市人民政府新闻办和重庆邮电学院在此间联合宣布：具有我国自主知识产权的世界首枚“通芯一号”3G手机核心芯片已由重庆重邮信科股份有限公司（简称重邮信科）研发成功，并向媒体人士展示亮相。这是世界上第一枚0.13微米工艺的TD-SCDMA 3G手机基带芯片。它的诞生，标志着我国3G通信核心芯片等关键技术已达到了世界领先水平。实现了从“中国制造”到“中国创造”的跨越。
          </div>
        </fieldset>
        <hr class="layui-border-green">
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
                <h5><a href="place_order" class="layui-font-gray">常规寄件</a></h5>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="search_order" class="layui-font-gray">订单查件</a></h5>
              </div>
            </div>
            <div class="layui-col-md3">
              <div class="layui-row">
                <h4><b>服务支持</b></h4>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="fee_rule" class="layui-font-gray">费用公示</a></h5>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="limit_rule" class="layui-font-gray">限寄规则</a></h5>
              </div>
            </div>
            <div class="layui-col-md3">
              <div class="layui-row">
                <h4><b>科技赋能</b></h4>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="https://hugegraph.apache.org/cn/" target="_blank" class="layui-font-gray">图数据库 HugeGraph</a></h5>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="https://spring.io/" target="_blank" class="layui-font-gray">后端框架 Spring</a></h5>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="http://layui.org.cn/index.html" target="_blank" class="layui-font-gray">前端UI框架 Layui</a></h5>
              </div>
            </div>
            <div class="layui-col-md3">
              <div class="layui-row">
                <h4><b>关于邮易</b></h4>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="about_project" class="layui-font-gray">项目简介</a></h5>
              </div>
              <div class="layui-row" style="height: 20px"></div>
              <div class="layui-row">
                <h5><a href="about_author" class="layui-font-gray">项目作者</a></h5>
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
            <h5><a href="http://139.9.154.99/" class="layui-font-gray">蜂翼动画 FY</a></h5>
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

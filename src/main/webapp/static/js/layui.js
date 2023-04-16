layui.use(['element', 'carousel', 'layer', 'util', 'table', 'form'], function(){
    var element = layui.element, <!-- layui-nav layui-colla layui-progress -->
        carousel = layui.carousel, <!-- layui-carousel -->
        layer = layui.layer, <!-- layui-layer -->
        util = layui.util, <!-- layui-fixbar -->
        table = layui.table, <!-- layui-table -->
        form = layui.form; <!-- layui-form -->

    carousel.render({
        elem: document.getElementById('home_carousel'),
        width: '100%',
        height: '500px',
        arrow: 'hover',
        anim: 'fade',
        indicator: 'outside'
    });

    util.fixbar({
        top: true,
        css : {
            right: 20,
            bottom: 50
        },
        bgcolor : '#393D49',
        // bgcolor : '#393D49 !important;display:block;',
        click: function(type) {
            if (type === 'top') {
                $('.layui-body').animate({
                    scrollTop: 0
                }, 200);
            }
        }
    });
});

function btn_show_tip_email() {
    layer.tips('Email:\nyu_weiyi@outlook.com', document.getElementById('btn_tip_email'), {
        tips: [1, '#393D49']
    });
};

function btn_show_tip_qq() {
    layer.tips('QQ:\n1360271510', document.getElementById('btn_tip_qq'), {
        tips: [1, '#393D49']
    });
};

function btn_show_tip_wechat() {
    layer.tips('WeChat:\nWilley_Yu13942377414', document.getElementById('btn_tip_wechat'), {
        tips: [1, '#393D49']
    });
};

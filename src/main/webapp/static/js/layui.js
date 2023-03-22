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
            right: 50,
            bottom: 100
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

// function place_order_employee_assistance_form_btn_p1_next() {
//     window.alert("11111111");
//
//     var palce_order_employee_assistance_form_p1 = document.getElementById('place_order_employee_assistance_form_p1'),
//         palce_order_employee_assistance_form_p2 = document.getElementById('place_order_employee_assistance_form_p2');
//
//     window.alert("2222222");
//
//     palce_order_employee_assistance_form_p1.style.display = 'none';
//     palce_order_employee_assistance_form_p2.style.display = 'block';
//
//     window.alert("333333");
//
//     element.progress('place_order_employee_assistance_progress_bar', '20%')
//
//
//     window.alert("44444444");
// }

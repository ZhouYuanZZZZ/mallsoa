(function ($) {
    $.extend({
        showMask:function (title,msg) {
            if(title == undefined){
                title = 'Please waiting';
            }

            if(msg == undefined){
                msg='Loading data...';
            }

            $.messager.progress({
                title:title,
                msg:msg
            });
        },
        closeMask:function () {
            $.messager.progress('close');
        }
    });
})(jQuery);
/**
 * 此文件中是需要调用的javascript公用方法
 */

//封装jquery形式的ajax方法

function ajax_submit(type,url,params,async){
    $.ajax({
        type:type || 'GET',
        url:url,
        dataType:'json',
        async: async || true,
        data:params,
        success:function(data){
            return data;
        },
        error:function(){
            alert("调用异常");
        }
    })
}
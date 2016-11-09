//ajax方式提交
$(document).ready(function(){
    $("#submit").click(function () {
        var params={
            UserPhone:$("#UserPhone").val(),
            UserPassword:$("#UserPassword").val()
        }
        var data=ajax_submit('POST','./user/login',params,true);
        if(data!=null){
            console.log("登录成功");
            //如果错误信息是显示的，则隐藏它.
            if(!$("#error").is(":hidden")){
                $("#error").hide();
            }
            var usergrade=data.usergrade;
            if(usergrade==2){
//            	跳转到管理员页面
            	window.location.href="/jsp/indexAdmin.html";
            }else{
            	window.location.href="/jsp/index.html";
            }
            
        }else{
            $("#error").show();
        }
    });
});

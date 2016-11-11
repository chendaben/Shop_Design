window.onload=function(){
    userList();
}
//加载用户列表
function userList(){
    var params={
        pageNow:0,
        pageSize:3
    };
    var name="http://localhost:8080/Shop_Design";
    var url="../admin/user";
    ajax_submit('GET',url,params,true,function(data){
        console.log("获取的用户列表是:"+data);
        var tbody=document.getElementsByTagName("tbody");
        console.log(tbody);
        for(var i=0;i<data.length;i++){
            var tr=document.createElement("tr");
            tbody[0].appendChild(tr);
            var td_id=document.createElement("td");
            var userid=document.createTextNode(data[i].userid);
            td_id.appendChild(userid);
            tr.appendChild(td_id);

            var td_name=document.createElement("td");
            var username=document.createTextNode(data[i].username);
            td_name.appendChild(username);
            tr.appendChild(td_name);

            var td_phone=document.createElement("td");
            var phone=document.createTextNode(data[i].username);
            td_phone.appendChild(phone);
            tr.appendChild(td_phone);

        }
    });

}
/**
 * 验证用户输入
 * @returns {Boolean}
 */
//验证书籍名称
function validateName(){
    var x=document.forms["book"]["bookname"].value;
    if (x==null || x=="") {
        document.getElementById("name").innerHTML="必填";
        return false;
    }
    if(x.length>40){
        document.getElementById("name").innerHTML="输入太长，名称范围在1到40字符之间";
    }
    else{
        document.getElementById("name").innerHTML="";
    }

}

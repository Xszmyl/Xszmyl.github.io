//信息校验
function Check() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username === ""&&password==="") {
        return false;
    }else if(username===""){
        return false;
    }else if(password===""){
        return false;
    }else if(password.length<6){
        return false;
    }else{
        return true; //符合条件，允许提交表单
    }
}

//提示框
function Confirm() {
    var tg=TGTool();
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username === ""&&password==="") {
        tg.warning("请输入用户名和密码!")
    }else if(username===""){
        tg.warning("请输入用户名!")
    }else if(password===""){
        tg.warning("请输入密码!")
    }else if(password.length<6){
        tg.warning("密码非法!")
    }
}

//请求参数解析
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}


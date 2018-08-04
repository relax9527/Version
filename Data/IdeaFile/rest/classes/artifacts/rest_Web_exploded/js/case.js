function up1() {
    var up = document.getElementById("up");
    var page =up.getAttribute("page");
    if(page==1){
        alert("已经是第一页了！");
        return;
    }
    console.log(page)
    var pages= parseInt(page);
    pages=pages-1;
    console.log(pages)
    up.setAttribute("page",page);
    var url = "user_selectAllUser.action";
    window.location=url;

}
function down1() {

    var up = document.getElementById("up");
    var count = document.getElementById("count").getAttribute("count");
    var page =up.getAttribute("page");
    if(page>=count){
        alert("已经是最后一页了！");
        return;
    }
    var pages= parseInt(page);
    pages=pages+1;
    up.setAttribute("page",page);
    var url = "user_selectAllUser.action";
    window.location=url;
}

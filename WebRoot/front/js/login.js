/**
 * Created by ucai on 2017/12/7.
 */
$(function () {
    /*公共头部和脚部调用*/
    publicHeadAndFooter();
    /*调用时设置公共样式*/
    
})
/*公共头部和脚部调用*/
function publicHeadAndFooter(){
    $(".publicHead").load("heads.html");
    $(".publicFooter").load("footers.html");
}




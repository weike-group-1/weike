/**
 * Created by ucai on 2017/12/7.
 */
$(function () {
    /*公共头部和脚部调用*/
    publicHeadAndFooter();
})
/*公共头部和脚部调用*/
function publicHeadAndFooter(){
    $(".publicHead").load("heads.html");
    $(".publicFooter").load("footers.html");
}
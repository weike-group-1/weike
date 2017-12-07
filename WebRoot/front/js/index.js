/**
 * Created by ucai on 2017/12/6.
 */
$(function () {
    /*公共头部和脚部调用*/
    publicHeadAndFooter();
    /*轮播图*/
    carousel();
})
/*公共头部和脚部调用*/
function publicHeadAndFooter(){
    $(".publicHead").load("heads.html");
    $(".publicFooter").load("footers.html");
}
/*轮播图*/
function carousel() {
    $('.carousel').carousel({
        interval: 3000
    });
}
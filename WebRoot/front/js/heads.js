/**
 * Created by ucai on 2017/12/6.
 */
$(function () {
    /*页面跳转*/
    navSkip();
})
function navSkip() {
    var pageAddress = AddressStr();
    $("#navSkip li a").each(function (index) {
        var navAddress = $("#navSkip li a").eq(index).attr("href");
        if (pageAddress == navAddress) {
            $("#navSkip li").removeClass("active");
            $("#navSkip li").eq(index).addClass("active");
        }
    });
    $("#navSkip li").mousedown(function () {
        $("#navSkip li").removeClass("active");
        $("#navSkip li").eq($(this).index()).addClass("active");
    })
        var loginAddress= $("#infoSkip li a").eq(0).attr("href");
        var createrAddress= $("#infoSkip li a").eq(1).attr("href");
        if(loginAddress==pageAddress){
            $("#navSkip").addClass("hidden");
            $("#infoSkip").addClass("hidden");
            $("#loginSkip").removeClass("hidden");
        }else if(createrAddress==pageAddress){
            $("#navSkip").addClass("hidden");
            $("#infoSkip").addClass("hidden");
        }

}
/**
 * @return {string}
 */
function AddressStr() {
    var pageAddress = window.location.pathname;
    var addressIndex = pageAddress.indexOf(".html");
    var Address = pageAddress.substring(0, addressIndex) + ".html";
    return Address;
}

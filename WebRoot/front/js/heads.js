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
/**
 * Created by ucai on 2017/12/6.
 */
$(function () {
    /*页面跳转*/
    navSkip();
})
function navSkip() {
    var pageAddress = AddressStr();

    /*头部左边页面导航跳转*/
     $("#navSkip li a").each(function (index) {
        var Address = $("#navSkip li a").eq(index).attr("href");
        var addressIndex = Address.indexOf("html");
         var addressLast = Address.indexOf(".html");
        var navAddress = Address.substring(addressIndex, addressLast) + ".html";
        if (pageAddress == navAddress) {
             $("#navSkip li").removeClass("active");
             $("#navSkip li").eq(index).addClass("active");
        }
     });

    /*头部右边页面导航跳转*/
    var loginAddress = $("#loginSkip li a").eq(0).attr("href");
    var createrAddress = $("#loginSkip li a").eq(1).attr("href");

    var loginAddressIndex = loginAddress.indexOf("html");
    var loginAddressLast = loginAddress.indexOf(".html");
    var createrAddressIndex = createrAddress.indexOf("html");
    var createrAddressLast = createrAddress.indexOf(".html");

    var loginAddressEnd = loginAddress.substring(loginAddressIndex, loginAddressLast) + ".html";
    var createrAddressEnd = createrAddress.substring(createrAddressIndex, createrAddressLast) + ".html";
    if (loginAddressEnd == pageAddress) {
        $("#navSkip").addClass("hidden");
        $("#loginSkip").addClass("hidden");
        $("#scanSkip").removeClass("hidden");
    } else if (createrAddressEnd == pageAddress) {
        $("#navSkip").addClass("hidden");
        $("#loginSkip").addClass("hidden");
    }

}
/**
 * @return {string}
 */
function AddressStr() {
    var pageAddress = window.location.pathname;
    var addressIndex = pageAddress.indexOf("html");
    var addressLast = pageAddress.indexOf(".html");
    var Address = pageAddress.substring(addressIndex, addressLast) + ".html";
    return Address;
}

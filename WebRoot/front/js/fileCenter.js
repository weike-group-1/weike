/**
 * Created by ucai on 2017/12/7.
 */
$(function () {
    /*公共头部和脚部调用*/
    publicHeadAndFooter();
    /*dtree*/
    dtree();
})
/*公共头部和脚部调用*/
function publicHeadAndFooter(){
    $(".publicHead").load("heads.html");
    $(".publicFooter").load("footers.html");
}

/*dtree*/
function dtree(){
    a = new dTree('a','dtree');
    a.config.folderLinks = false;
    a.config.closeSameLevel = true;
    a.add(0, -1, 'My example tree');
    a.add(1, 0, 'Node 1', 'example01.html');
    a.add(2, 0, 'Node 2', 'example01.html');
    a.add(3, 1, 'Node 1.1', 'example01.html');
    a.add(4, 0, 'Node 3', 'example01.html');
    a.add(5, 3, 'Node 1.1.1', 'example01.html');
    a.add(6, 5, 'Node 1.1.1.1', 'example01.html');
    a.add(7, 0, 'Node 4', 'example01.html');
    a.add(8, 1, 'Node 1.2', 'example01.html');
    a.add(9, 0, 'My Pictures', 'example01.html', 'Pictures I\'ve taken over the years', '', '', '../../image/dtree/imgfolder.gif');
    a.add(10, 9, 'The trip to Iceland', 'example01.html', 'Pictures of Gullfoss and Geysir');
    a.add(11, 9, 'Mom\'s birthday', 'example01.html');
    a.add(12, 0, 'Recycle Bin', 'example01.html', '', '', '../../image/dtree/trash.gif');
    a.draw();

    a.delegate = function (id) {
        alert(id);
    }
    $("#dtree").append(a)
}
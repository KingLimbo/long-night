<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>limbo</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/common/core/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<h3>resource</h3>
<table class="layui-hide" id="user-table"></table>


<script src="${ctx}/common/core/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#user-table'
            ,url:'${ctx}/sys-resource/list'
            ,response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'name', width:80, title: '名称'}
                ,{field:'url', width: '30%', title: 'URL', sort: true}
                ,{field:'urlType', width:80, title: 'URL类型'}
                ,{field:'type', title: '类型', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'route', title: '路由', sort: true}
                ,{field:'parentId', title: '父节点'}
                ,{field:'sort', title: '排序', sort: true}
                ,{field:'parents', title: '父节点们'}
                ,{field:'description', width:137, title: '描述', sort: true}
                ,{field:'deleted', width:137, title: '是否删除'}
                ,{field:'gmtCreate', title: '创建时间'}
                ,{field:'gmtModified', width:137, title: '修改时间', sort: true}
            ]]
        });
    });
</script>

</body>
</html>
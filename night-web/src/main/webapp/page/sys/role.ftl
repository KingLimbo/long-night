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
<h3>role</h3>
<table class="layui-hide" id="user-table"></table>


<script src="${ctx}/common/core/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#user-table'
            ,url:'${ctx}/sys-role/list'
            ,response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'name', width:80, title: '用户名'}
                ,{field:'autoGeneration', width:80, title: '自动生成', sort: true}
                ,{field:'description', width:80, title: '描述'}
                ,{field:'gmtCreate', title: '创建时间'}
                ,{field:'gmtModified', width:137, title: '修改时间', sort: true}
            ]]
        });
    });
</script>

</body>
</html>
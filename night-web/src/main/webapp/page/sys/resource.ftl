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
<form class="layui-form" action="" lay-filter="example">
    <div class="layui-form-item">
        <label class="layui-form-label">输入框</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">选择框</label>
        <div class="layui-input-block">
            <select name="interest" lay-filter="aihao">
                <option value=""></option>
                <option value="0">写作</option>
                <option value="1">阅读</option>
                <option value="2">游戏</option>
                <option value="3">音乐</option>
                <option value="4">旅行</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">复选框</label>
        <div class="layui-input-block">
            <input type="checkbox" name="like[write]" title="写作">
            <input type="checkbox" name="like[read]" title="阅读">
            <input type="checkbox" name="like[daze]" title="发呆">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">开关</label>
        <div class="layui-input-block">
            <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="desc"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn layui-btn-normal" id="LAY-component-form-setval">赋值</button>
            <button type="button" class="layui-btn layui-btn-normal" id="LAY-component-form-getval">取值</button>
            <button type="button" class="layui-btn layui-btn-normal" id="search">search</button>
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>
<table class="layui-hide" id="user-table"></table>


<script src="${ctx}/common/core/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        var tableIns = table.render({
            elem: '#user-table'
            ,url:'${ctx}/sys-resource/list'
            ,page:true
            ,response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'name', width:80, title: '名称'}
                ,{field:'url', width: 150, title: 'URL', sort: true}
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

        //表单取值
        layui.$('#search').on('click', function(){
            tableIns.reload({
                where: { //设定异步数据接口的额外参数，任意设

                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
    });
</script>

</body>
</html>
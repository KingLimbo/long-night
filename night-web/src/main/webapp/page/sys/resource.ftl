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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" action="" lay-filter="resource-form">
    <div class="layui-form-item">
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">URL类型</label>
            <div class="layui-input-block">
                <select name="interest" lay-filter="aihao">
                    <option value=""></option>
                    <option value="GET">GET</option>
                    <option value="POST">POST</option>
                    <option value="PUT">PUT</option>
                    <option value="PATCH">PATCH</option>
                    <option value="DELETE">DELETE</option>
                </select>
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select name="interest" lay-filter="aihao">
                    <option value=""></option>
                    <option value="0">资源</option>
                    <option value="1">菜单</option>
                    <option value="2">目录</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">父节点ID</label>
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
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">开关</label>
            <div class="layui-input-block">
                <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">复选框</label>
            <div class="layui-input-block">
                <input type="checkbox" name="like[write]" title="写作">
                <input type="checkbox" name="like[read]" title="阅读">
                <input type="checkbox" name="like[daze]" title="发呆">
            </div>
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
<table class="layui-hide" id="resource-table"></table>

<script type="text/html" id="resourceBar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="${ctx}/common/core/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use(['table', 'form'], function(){
        const table = layui.table
            , form = layui.form
        ;

        const tableIns = table.render({
            elem: '#resource-table'
            , url: '${ctx}/sys-resource/list'
            , page: true
            , response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            , cellMinWidth: 70 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {field: 'id', width: 70, title: 'ID', sort: true}
                , {field: 'name', width: 160, title: '名称'}
                , {field: 'url', minWidth: 150, title: 'URL', sort: true}
                , {field: 'urlType', width: 100, title: 'URL类型'}
                , {field: 'type', width: 110, title: '类型'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'route', minWidth: 200, title: '路由'}
                , {field: 'parentId', width: 80, title: '父节点'}
                , {field: 'sort', width: 80, title: '排序', sort: true}
                , {field: 'parents', width: 90, title: '父节点们'}
                , {field: 'description', width: 120, title: '描述', sort: true}
                , {field: 'deleted', width: 90, title: '是否删除'}
                , {field: 'gmtCreate', width: 170, title: '创建时间'}
                , {field: 'gmtModified', width: 150, title: '修改时间', sort: true}
                , {fixed: 'right', width: 178, align: 'center', toolbar: '#resourceBar'}
            ]]
        });
        //监听工具条
        table.on('tool(table)', function(obj){
            const data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
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
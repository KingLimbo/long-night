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
    <legend>赋值和取值</legend>
</fieldset>

<form class="layui-form" action="" lay-filter="user-form">
    <div class="layui-form-item">
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="loginAccount" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="userName" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="userSex" value="男" title="男">
                <input type="radio" name="userSex" value="女" title="女">
                <input type="radio" name="userSex" value="" title="未知">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-block">
                <input type="radio" name="userType" value="1" title="系统管理员">
                <input type="radio" name="userType" value="0" title="普通用户">
                <input type="radio" name="userType" value="" title="所有" checked="">
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-block">
                <input type="text" name="roleName" lay-verify="title" autocomplete="off" placeholder="请输入角色名称" class="layui-input">
            </div>
        </div>
        <div class="layui-row layui-col-xs4">
            <label class="layui-form-label">是否锁定</label>
            <div class="layui-input-block">
                <input type="radio" name="locked" value="1" title="是">
                <input type="radio" name="locked" value="0" title="否" checked="">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-col-xs-offset9">
            <button type="button" class="layui-btn layui-btn-sm layui-btn-warm" id="reset">重置</button>
            <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" id="search">查询</button>
        </div>
    </div>
</form>
<table class="layui-hide" id="user-table" lay-filter="table"></table>

<script type="text/html" id="userBar">
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
            elem: '#user-table'
            , url: '${ctx}/sys-user/user-role'
            , page: true
            , response: {
                statusCode: 200 //规定成功的状态码，默认：0
            }
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {field: 'id', width: 80, title: 'ID', sort: true}
                , {field: 'loginAccount', width: 100, title: '用户名'}
                , {field: 'userName', width: 100, title: '姓名', sort: true}
                , {field: 'userSex', width: 80, title: '性别', sort: true}
                , {field: 'userHead', width: 80, title: '用户头像'}
                , {field: 'userPhone', title: '用户电话', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'userEmail', title: '用户邮箱', sort: true}
                , {field: 'userType', title: '用户类型', sort: true}
                , {field: 'locked', title: '锁定', sort: true}
                , {
                    field: 'roles', title: '角色', sort: true, templet: function (res) {
                        let itemHtml = '';
                        const roles = res.roles;
                        for (const i in roles) {
                            itemHtml += roles[i].name;
                        }
                        return '<em>' + itemHtml + '</em>'
                    }
                }
                , {field: 'gmtCreate', title: '创建时间'}
                , {field: 'gmtModified', title: '修改时间', sort: true}
                , {fixed: 'right', width: 178, align: 'center', toolbar: '#userBar'}
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

        // 表单赋值
        layui.$('#reset').on('click', function(){
            form.val('user-form', {
                "loginAccount": null
                ,"userName": null
                ,"userSex": ""
                ,"userType": null
                ,"roleName": null
                ,"locked": "0"
            });
        });

        // 表单取值
        layui.$('#search').on('click', function(){
            tableIns.reload({
                // 设定异步数据接口的额外参数，任意设
                where: form.val('user-form')
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
    });
</script>

</body>
</html>
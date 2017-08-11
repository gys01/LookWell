<%--
  Created by IntelliJ IDEA.
  User: TYY
  Date: 2017/8/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级管理</title>
    <jsp:include page="basic.jsp"></jsp:include>

    <script type="text/javascript">
        $(function () {
            initGrade();
        });

        function initGrade() {
            $("#gradeDatagrid").datagrid({
                //一个URL从远程站点请求数据
                url:'${pageContext.request.contextPath}/grade/queryGrade.controller',
                //该方法类型请求远程数据
                method:'POST',
                //是否显示斑马线效果
                striped:true,
                //指明哪一个字段是标识字段
                idField:'gradeId',    //主键id
                //如果为true，则显示一个行号列
                rownumbers:true,
                //在面板头部显示的标题
                title:'班级信息',
                //如果为true，则在Datagrid控件底部显示分页工具栏
                pagination:true,
                //在设置分页属性的时候初始化页面大小
                pageSize:10,
                //在设置分页属性的时候 初始化页面大小选择列表
                pageList:[5,10,20],
                //工具栏
                toolbar:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function () {
                            showAddGradeWindow();   //展示添加窗口
                        }
                    },{
                        text:'批量删除',
                        iconCls:'icon-remove',
                        handler:function () {
                            doDeleteGradeByIdList();
                        }
                    }
                ],
                //显示的字段
                columns:[[
                    {field:'ck',checkbox:true},     //复选框
                    {field:'gradeName',title:'班级名称',width:100,align:'center'},
                    {field:'gradeDesc',title:'描述',width:160},
                    {field:'gradeStatus',title:'状态',width:100,align:'center'},
                    {field:'createTime',title:'添加时间',width:160,align:'center',formatter:dateFormat},       //格式化时间
                    {field:'updateTime',title:'最后修改时间',width:160,align:'center',formatter:dateFormat},       //格式化时间
                    {field:'gradeId',title:'操作',width:100,align:'center',formatter:operFormat}      //操作列，主键id
                ]]
            });
        }

        //格式化时间
        function dateFormat(rowData) {
            var date = new Date(rowData);
            var year = date.getFullYear();      //年
            var month = date.getMonth()+1;      //月
            var day = date.getDate();           //日
            var h = date.getHours();        //时
            var m = date.getMinutes();      //分
            var s = date.getSeconds();      //秒
            var str = year + '-' + month + '-' + day + ' ' + h + ':' + m + ':' + s;
            return str;
        }

        //操作列
        function operFormat(rowData) {
            var detailGradeStr = '<a href="javascript:showDetail(\'' + rowData + '\')" style="text-decoration-line:none" >详情</a>';
            var updateGradeStr = '<a href="javascript:showUpdateGradeWindow(\'' + rowData + '\')" style="text-decoration-line:none" >修改</a>';
            var deleteGradeStr = '<a href="javascript:doDeleteGradeById(\'' + rowData + '\')" style="text-decoration-line:none" >删除</a>';
            return detailGradeStr+' '+updateGradeStr+' '+deleteGradeStr;
        }

        //按班级名模糊查询
        function queryGradeByName(){
            var gradeName=$("#gradeName").val();
            var queryParams=$("#gradeDatagrid").datagrid('options').queryParams;
            queryParams.gradeName=gradeName;
            $("#gradeDatagrid").datagrid('load');
        }

        /*
         * 展示详情
         */
        function showDetail(gradeId) {
            $.post('${pageContext.request.contextPath}/grade/queryGradeById.controller',
                {"id":gradeId},
                function (data, status) {
                    if(status=="success") {
                        $("#gradeForm").form('load',data);
                        $("#gradeWindow").window('open');
                    }
                }
            );
        }

        /*
         * 添加班级
         *
         */
        //展示添加班级的window
        function showAddGradeWindow() {
            //2.产品combobox赋值
            addAllProject();
            //3.打开window
            $("#addGradeWindow").window('open');
        }

        //2.产品combobox赋值
        function addAllProject() {
            $.get('${pageContext.request.contextPath}/project/queryAllProject.controller',
                function (data,status) {
                    if(status=="success") {
                        $("#addProjectId").combobox({
                            data:data,
                            valueField:'projectId',
                            textField:'projectName',
                            editable:false
                        });
                    }
                }
            );
        }

        //提交添加表格
        function addGrade() {
            //添加班级名称唯一策略
//            var projectStr =$("#addProjectId").combobox('getValue');
            var projectName=$("#addProjectId").combobox('getText');
            $("#addProjectName").textbox('setValue',projectName);


            //1.提交表单
            $("#addGradeForm").form('submit',{
                url:'${pageContext.request.contextPath}/grade/addGrade.controller',
                success:function (data) {
                    var dataObj = JSON.parse(data);
                    alert(dataObj.msg);
                    //2.清空表单
                    $("#addGradeForm").form('clear');
                    //3.关闭window
                    $("#addGradeWindow").window('close');
                    //4.刷新列表
                    $("#gradeDatagrid").datagrid('load');
                }
            });
        }

        //清空添加表格
        function clearAddGrade() {
            $("#addGradeForm").form('clear');
        }

        /*
         * 修改班级
         *
         */
        //展示修改班级window
        function showUpdateGradeWindow(rowData) {
            updateGradeFormSetValue(rowData);
            //4.展示
            $("#updateGradeWindow").window('open');
        }

        function updateGradeFormSetValue(rowData) {
            $.post('${pageContext.request.contextPath}/grade/queryGradeById.controller',
                {"id":rowData},
                function (data, status) {
                    if(status=="success") {
                        //3.加载
                        $("#updateGradeForm").form('load', data);
                    }
                }
            );
        }

        //提交修改表格
        function updateGrade() {
            $("#updateGradeForm").form('submit', {
                url:'${pageContext.request.contextPath}/grade/updateGrade.controller',
                success:function (data) {
                    var dataObj = JSON.parse(data);
                    alert(dataObj.msg);
                    $("#updateGradeWindow").window('close');
                    $("#gradeDatagrid").datagrid('load');
                }
            });
        }

        //重置修改表格
        function resetUpdateGrade() {
            var gradeId = $("#updateGradeId").textbox('getValue');
            updateGradeFormSetValue(gradeId);
        }

        /*
         *删除单个班级
         *
         */
        function doDeleteGradeById(gradeId) {
            if(confirm('确定删除吗？')) {
                $.post('${pageContext.request.contextPath}/grade/deleteGradeById.controller',
                    {"id": gradeId},
                    function (data, status) {
                        if(status="success") {
                            alert(data.msg);
                            $("#gradeDatagrid").datagrid('load');
                        }
                    }
                );
            }
        }

        /*
         *删除多个班级
         */
        function doDeleteGradeByIdList() {
            //1.获取选中项的班级的id
            var item = $("#gradeDatagrid").datagrid('getSelections');
            if (item.length<1) {
                alert("请选择要删除的班级");
                return;
            }
            var ids = "";
            for(var i=0;i<item.length;i++) {
                ids += item[i].gradeId + ",";    //主键id
            }
            if (confirm("确定要删除这些班级吗？")) {
                //2.请求controller
                $.post('${pageContext.request.contextPath}/grade/deleteGradeByIdList.controller',
                    {"gradeIdListStr":ids},
                    function (data, status) {
                        if(status=="success") {
                            //3.展示返回数据
                            alert(data.msg);
                            //4.班级列表刷新
                            $("#gradeDatagrid").datagrid('load');
                        }
                    }
                );
            }
        }


    </script>
</head>
<body>
    <!--按班级名模糊查询-->
    <div>
        <form id="queryGradeForm" method="post">
            <div>
                <label>班级名称：</label>
                <input type="text" name="gradeName" id="gradeName"/>
                <a href="javascript:void(0)" onclick="queryGradeByName()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
            </div>
        </form>
    </div>

    <!--数据展示-->
    <div style="width: 900px;">
        <table id="gradeDatagrid"></table>
    </div>

    <%--展示详情的window--%>
    <div id="gradeWindow" class="easyui-window" title="班级详情" closed="true"
        style="left:30%;top:30%;width: 400px;height: 300px;padding:30px 60px; " >
        <form id="gradeForm" action="" >
            <table>
                <tr>
                    <td>班级名称：</td>
                    <td><input class="easyui-textbox" name="gradeName" readonly></td>
                </tr>
                <tr>
                    <td>描述：</td>
                    <td><input class="easyui-textbox" name="gradeDesc" data-options="multiline:true" readonly>
                </tr>
                <tr>
                    <td>状态：</td>
                    <td><input class="easyui-textbox" name="gradeStatus" readonly>
                </tr>
            </table>
        </form>
    </div>

    <%--添加班级的window--%>
    <div id="addGradeWindow" class="easyui-window" title="添加班级" closed="true"
        style="left: 30%;top: 20%;width: 400px;height: 500px;padding: 30px 60px;">
        <form id="addGradeForm" method="post">
            <table>
                <tr>
                    <td>产品：</td>
                    <td>
                        <input class="easyui-combobox" name="project.projectId" id="addProjectId"
                               data-options="required:true, missingMessage:'请选择所属产品'"/>
                        <input type="hidden" class="easyui-textbox" name="project.projectName" id="addProjectName"/>
                    </td>
                </tr>
                <tr>
                    <td>班级名称：</td>
                    <%--若采用班级名称唯一生成策略，则注释以下此格--%>
                    <%--<td>--%>
                        <%--<input class="easyui-validatebox" name="gradeName"--%>
                               <%--data-options="required:true, validType:'length[1,20]'">--%>
                    <%--</td>--%>
                </tr>
                <tr>
                    <td>描述：</td>
                    <td>
                        <input class="easyui-textbox" name="gradeDesc"
                               data-options="multiline:true, validType:'length[0,50]'">
                    </td>
                </tr>
                <tr>
                    <td>状态：</td>
                    <td>
                        <input class="easyui-combobox" name="gradeStatus" id="addGradeStatus"
                            data-options="
                                valueField: 'label', textField: 'value',
                                data: [
                                    { label: '可用', value: '可用', selected:'true' },
                                    { label: '占用', value: '占用' },
                                    { label: '自习', value: '自习' }
                                ], required:true "/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton" onclick="addGrade()">提交</a>
                    </td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton" onclick="clearAddGrade()">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <%--修改班级的window--%>
    <div id="updateGradeWindow" class="easyui-window" title="修改班级" closed="true"
        style="left: 30%; top:20%; width: 400px; height: 300px; padding:30px 60px;">
        <form id="updateGradeForm" method="post">
            <table>
                <tr>
                    <td>班级名称：</td>
                    <%--<td>
                        <input class="easyui-validatebox" name="gradeName"
                               data-options="required:true, validType:'length[1,20]'" />
                        <input class="easyui-textbox" type="hidden" name="gradeId" id="updateGradeId" />
                    </td>--%>
                    <td>
                        <input class="easyui-validatebox" name="gradeName" readonly/>
                        <input class="easyui-textbox" type="hidden" name="gradeId" id="updateGradeId" />
                    </td>
                </tr>
                <tr>
                    <td>描述：</td>
                    <td>
                        <input class="easyui-textbox" name="gradeDesc"
                               data-options="multiline:true, validType:'length[0,50]'">
                    </td>
                </tr>
                <tr>
                    <td>状态：</td>
                    <td>
                        <input class="easyui-combobox" name="gradeStatus" id="updateGradeStatus"
                               data-options="
                            valueField: 'label', textField: 'value',
                            data: [
                                { label: '可用', value: '可用' },
                                { label: '占用', value: '占用' },
                                { label: '自习', value: '自习' }
                            ]"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton" onclick="updateGrade()">提交</a>
                    </td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton" onclick="resetUpdateGrade()">重置</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>

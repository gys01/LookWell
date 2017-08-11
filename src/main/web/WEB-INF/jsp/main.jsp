<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <jsp:include page="basic.jsp"></jsp:include>
        <script type="text/javascript">
            $(function () {
                initTree();
            });

            //树形一级菜单
            function initTree() {
                $("#rootTree").tree({
                    url:'${pageContext.request.contextPath}/initTree.controller',
                    method:"GET",
                    lines:true,
                    onClick:function(node){
                        if(null!=node.children){
                            return;
                        }
                        appendTree(node);
                        if(null!=node.menuUrl&&''!=(node.menuUrl)){
                            addTabs(node.text,'${pageContext.request.contextPath}'+node.menuUrl);
                            // addTabs(node.text,node.menuUrl);
                        }
                    }
                });
            }

            //树形二级菜单
            function appendTree(node){
                $.get('${pageContext.request.contextPath}/appendTree.controller',
                    //主键Id属性
                    {"parentId":node.menuId},function(data,status){
                        if(status=="success"){
                            var selected=$("#rootTree").tree("getSelected");
                            $("#rootTree").tree('append',{
                                parent: selected.target,
                                data:data
                            });
                        }
                    }
                );
            }

            //添加选项卡
            function addTabs(title,url) {
                if($("#tt").tabs('exists',title)){
                    $("#tt").tabs('select',title);
                }else{
                    var content="<iframe src='"+url+"' frameborder='0' style='height: 100%;width: 100%'></iframe>";
                    $("#tt").tabs('add',{
                        title:title,
                        content:content,
                        closable:true
                    });
                }
            }
        </script>
    </head>
    <body class="easyui-layout">
        <div region="north" style="height: 10%">
            欢迎您： ${roleUser.tbuser.username}
        </div>
        <div region="west" style="width: 15%;" title="菜单栏">
            <ul id="rootTree"></ul>
        </div>
        <div region="center">
            <%--添加选项卡--%>
            <div id="tt" class="easyui-tabs" style="width: 100%;height: 100%">
                <div title="首页"></div>
            </div>
        </div>
        <div region="south" style="height: 10%">
            乐考无忧
        </div>
    </body>
</html>

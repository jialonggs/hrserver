webpackJsonp([22],{"ds/T":function(t,a,e){var i={"./ProMaList.vue":"ykdn"};function s(t){return e(l(t))}function l(t){var a=i[t];if(!(a+1))throw new Error("Cannot find module '"+t+"'.");return a}s.keys=function(){return Object.keys(i)},s.resolve=l,t.exports=s,s.id="ds/T"},mKUX:function(t,a){},ykdn:function(t,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var i={data:function(){return{tableLoading2:!1,dialogFormVisible2:!1,kaiPiao:{projectId:"",projectName:""},orderList:[],itemProject:{yuBaoJia:{audit:""},businessBaoJia:{audit:""}},nowTab:1,username:"",name:"",uid:"",tableLoading:!1,addloading:!1,dialogFormVisible:!1,projectfrom:{projectName:"",cilentCompanyName:"",remark:"",addUserId:"",addUserName:""},currentPage:1,itemKaiPiao:{},totalnum:0,pagesize:10,select_word:"",tableData:[],businessBaoJiaInfo:{},yuBaoJiaInfo:{},rules:{projectName:[{required:!0,message:"请输入项目名称",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],cilentCompanyName:[{required:!0,message:"请输入客户单位",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}]}}},methods:{quxiaoKai:function(){this.dialogFormVisible2=!1,this.kaiPiao={projectId:"",projectName:""}},toKaiPiao:function(t){this.dialogFormVisible2=!0,this.kaiPiao={projectId:"",projectName:"",addUserId:"",addUserName:""},this.itemKaiPiao=t},addKaiPiao:function(){var t=this,a=this,e={};(e=this.kaiPiao).projectId=a.itemKaiPiao.id,e.projectName=a.itemKaiPiao.projectName,e.addUserId=this.uid,e.addUserName=this.name,a.tableLoading2=!0,this.postRequest("/kai/piao/add",e).then(function(e){a.tableLoading2=!1,e&&200==e.status&&0==e.data.code?(t.$message.success("执行成功"),t.dialogFormVisible2=!1,t.getCollectMouldList()):t.$message.error("执行失败")})},toInfo:function(t){this.$router.push("/plant/order/info/"+t)},goBack:function(){this.nowTab=1},xiangQing:function(t){this.nowTab=2,this.itemProject=t,this.orderList=t.orders,this.businessBaoJiaInfo=t.businessBaoJia,this.yuBaoJiaInfo=t.yuBaoJia},toadd:function(){this.dialogFormVisible=!0,this.addloading=!1},addProject:function(t){var a=this;this.addloading=!0;var e=this;this.$refs[t].validate(function(t){if(!t)return!1;e.projectfrom.addUserId=e.uid,e.projectfrom.addUserName=e.name,a.postRequest("/project/list/add/project",e.projectfrom).then(function(t){if(t&&200==t.status&&0==t.data.code){t.data.data.id;a.dialogFormVisible=!1,a.$message.success("添加成功"),a.tableLoading=!0,a.getCollectMouldList()}else a.$message.error("添加失败")})})},resetForm:function(t){this.$refs[t].resetFields()},handleSizeChange:function(t){this.pagesize=t,this.getCollectMouldList()},handleCurrentChange:function(t){this.currentPage=t,this.getCollectMouldList()},getCollectMouldList:function(){var t=this;this.getRequest("/project/list/listbypage?page="+this.currentPage+"&size="+this.pagesize).then(function(a){t.tableLoading=!1,a&&200==a.status&&0==a.data.code&&(console.log(a),t.tableData=a.data.data.projectlist,t.totalnum=a.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{data:function(){var t=this;return t.tableData.filter(function(a){if(a.projectName.indexOf(t.select_word)>-1||a.cilentCompanyName.indexOf(t.select_word)>-1)return a})}}},s={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",{directives:[{name:"show",rawName:"v-show",value:1===t.nowTab,expression:"nowTab === 1"}]},[e("div",{staticClass:"crumbs"},[e("el-breadcrumb",{attrs:{separator:"/"}},[e("el-breadcrumb-item",[e("i",{staticClass:"el-icon-menu"}),t._v("项目管理")]),t._v(" "),e("el-breadcrumb-item",[t._v("我的项目")])],1)],1),t._v(" "),e("el-container",[e("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[e("div",{staticClass:"handle-box"},[e("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:function(a){t.toadd()}}},[t._v("创建项目")]),t._v(" "),e("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:t.select_word,callback:function(a){t.select_word=a},expression:"select_word"}})],1)]),t._v(" "),e("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[e("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:t.data,stripe:""}},[e("el-table-column",{attrs:{prop:"projectName",label:"项目名称"}}),t._v(" "),e("el-table-column",{attrs:{prop:"orderNums",label:"订单数量"},scopedSlots:t._u([{key:"default",fn:function(a){return[a.row.orderNums+""=="undefined"||a.row.orderNums+""==""?e("el-tag",{attrs:{type:"info"}},[t._v("0")]):t._e(),t._v(" "),a.row.orderNums+""!=""?e("el-tag",{attrs:{type:"info"}},[t._v(t._s(a.row.orderNums))]):t._e()]}}])}),t._v(" "),e("el-table-column",{attrs:{prop:"cilentCompanyName",label:"客户单位"}}),t._v(" "),e("el-table-column",{attrs:{label:"预报价状态"},scopedSlots:t._u([{key:"default",fn:function(a){return[a.row.yuBaoJia.audit+""=="undefined"?e("el-tag",{attrs:{type:"info"}},[t._v("无")]):t._e(),t._v(" "),a.row.yuBaoJia.audit+""=="0"?e("el-tag",[t._v("审核中")]):t._e(),t._v(" "),a.row.yuBaoJia.audit+""=="2"?e("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e(),t._v(" "),a.row.yuBaoJia.audit+""=="1"?e("el-tag",{attrs:{type:"success"}},[t._v("通过")]):t._e()]}}])}),t._v(" "),e("el-table-column",{attrs:{prop:"shangWuStatus",label:"商务报价状态"},scopedSlots:t._u([{key:"default",fn:function(a){return[a.row.businessBaoJia.audit+""=="undefined"?e("el-tag",{attrs:{type:"info"}},[t._v("无")]):t._e(),t._v(" "),a.row.businessBaoJia.audit+""=="0"?e("el-tag",[t._v("审核中")]):t._e(),t._v(" "),a.row.businessBaoJia.audit+""=="2"?e("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e(),t._v(" "),a.row.businessBaoJia.audit+""=="1"?e("el-tag",{attrs:{type:"success"}},[t._v("通过")]):t._e()]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"创建时间"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("span",[e("i",{staticClass:"el-icon-time"}),t._v(t._s(a.row.createTime))])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){t.xiangQing(a.row)}}},[t._v("详情")]),t._v(" "),a.row.kaiPiaoStatus+""=="0"&&a.row.businessBaoJia.audit+""=="1"&&a.row.financeStatus+""!="0"?e("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){t.toKaiPiao(a.row)}}},[t._v("开票")]):t._e()]}}])})],1)],1)],1),t._v(" "),e("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[e("el-pagination",{attrs:{"current-page":t.currentPage,"page-sizes":[10,30,80,100],"page-size":t.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1)],1),t._v(" "),e("div",{directives:[{name:"show",rawName:"v-show",value:2===t.nowTab,expression:"nowTab === 2"}]},[e("div",{staticClass:"crumbs"},[e("el-breadcrumb",{attrs:{separator:"/"}},[e("el-breadcrumb-item",[e("i",{staticClass:"el-icon-menu"}),t._v("项目管理")]),t._v(" "),e("el-breadcrumb-item",[t._v("我的项目")]),t._v(" "),e("el-breadcrumb-item",[t._v("项目详情")])],1)],1),t._v(" "),e("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","margin-top":"20px"}}),t._v(" "),e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"10px"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"line-height":"5px"}},[e("el-tag",{attrs:{type:"danger"}},[t._v("基础信息")])],1)]),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("项目名")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.itemProject.projectName))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("客户单位")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.itemProject.cilentCompanyName)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("预报价状态")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[t.itemProject.yuBaoJia.audit+""=="undefined"?e("span",{attrs:{type:"info"}},[t._v("无")]):t._e(),t._v(" "),t.itemProject.yuBaoJia.audit+""=="0"?e("span",[t._v("审核中")]):t._e(),t._v(" "),t.itemProject.yuBaoJia.audit+""=="2"?e("span",{attrs:{type:"danger"}},[t._v("驳回")]):t._e(),t._v(" "),t.itemProject.yuBaoJia.audit+""=="1"?e("span",{attrs:{type:"success"}},[t._v("通过")]):t._e()])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("商务报价状态")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[t.itemProject.businessBaoJia.audit+""=="undefined"?e("span",{attrs:{type:"info"}},[t._v("无")]):t._e(),t._v(" "),t.itemProject.businessBaoJia.audit+""=="0"?e("span",[t._v("审核中")]):t._e(),t._v(" "),t.itemProject.businessBaoJia.audit+""=="2"?e("span",{attrs:{type:"danger"}},[t._v("驳回")]):t._e(),t._v(" "),t.itemProject.businessBaoJia.audit+""=="1"?e("span",{attrs:{type:"success"}},[t._v("通过")]):t._e()])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("订单数量")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.itemProject.orderNums))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("项目状态")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v("进行中")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("创建时间")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.itemProject.createTime))])])])],1)],1),t._v(" "),e("div",{directives:[{name:"show",rawName:"v-show",value:"3"===t.itemProject.status,expression:"itemProject.status === '3'"}],staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("完结时间")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.itemProject.endtime))])])])],1)],1)]),t._v(" "),e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"30px"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"line-height":"5px"}},[e("el-tag",{attrs:{type:"danger"}},[t._v("订单列表")])],1)]),t._v(" "),e("el-col",{attrs:{span:24}},[e("div",{staticClass:"grid-content bg-purple-dark"},[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.orderList}},[e("el-table-column",{attrs:{prop:"orderName",label:"产品名称",width:"180"}}),t._v(" "),e("el-table-column",{attrs:{label:"客户单位",width:"180"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("p",[t._v(t._s(t.itemProject.cilentCompanyName))])]}}])}),t._v(" "),e("el-table-column",{attrs:{prop:"",label:"进度",width:"180"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-tag",[t._v("药检")])]}}])}),t._v(" "),e("el-table-column",{attrs:{label:"订单状态"},scopedSlots:t._u([{key:"default",fn:function(a){return[a.row.status+""==""?e("el-tag",{attrs:{type:"info"}},[t._v("加工中")]):t._e(),t._v(" "),a.row.status+""=="1"?e("el-tag",{attrs:{type:"danger"}},[t._v("完成")]):t._e()]}}])}),t._v(" "),e("el-table-column",{attrs:{prop:"",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){t.toInfo(a.row.id)}}},[t._v("查看详情")])]}}])})],1)],1)])],1),t._v(" "),e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"10px"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"line-height":"5px"}},[e("el-tag",{attrs:{type:"danger"}},[t._v("商务报价")])],1)]),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("客户单位")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.clientCompanyName))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("联系人")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.contactPerson)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("联系电话")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.contactPhone)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("车型")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.carType)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("税率")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.tax))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("含税总价")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.total))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("不含税总价")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.businessBaoJiaInfo.noTaxTotal))])])])],1)],1),t._v(" "),t.businessBaoJiaInfo.submitType+""=="1"?e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("上传文件")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("a",{staticStyle:{color:"blue"},attrs:{href:t.businessBaoJiaInfo.fuJianUrl,download:"w3logo"}},[t._v("下载原文件")])])])],1)],1):t._e(),t._v(" "),t.businessBaoJiaInfo.submitType+""=="0"?e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",[t._v("产品列表")])]),t._v(" "),e("div",[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.businessBaoJiaInfo.businessProductList,border:""}},[e("el-table-column",{attrs:{fixed:"",prop:"productName",label:"产品名称"}}),t._v(" "),e("el-table-column",{attrs:{prop:"wenlidaima",label:"纹理代码"}}),t._v(" "),e("el-table-column",{attrs:{prop:"productNum",label:"数量"}}),t._v(" "),e("el-table-column",{attrs:{prop:"price",label:"含税"}}),t._v(" "),e("el-table-column",{attrs:{prop:"price",label:"单价"}}),t._v(" "),e("el-table-column",{attrs:{prop:"area",label:"面积"}}),t._v(" "),e("el-table-column",{attrs:{prop:"price",label:"不含税价格"}})],1)],1)]):t._e()],1),t._v(" "),e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"10px"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",{staticStyle:{"line-height":"5px"}},[e("el-tag",{attrs:{type:"danger"}},[t._v("预报价")])],1)]),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("客户单位")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.clientCompanyName))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("联系人")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.contactPerson)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("联系电话")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.contactPhone)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("车型")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.carType)+" ")])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("税率")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.tax))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("含税总价")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.total))])])])],1)],1),t._v(" "),e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("不含税总价")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("span",{staticClass:"msg-span"},[t._v(t._s(t.yuBaoJiaInfo.noTaxTotal))])])])],1)],1),t._v(" "),t.yuBaoJiaInfo.submitType+""=="1"?e("div",{staticClass:"text item"},[e("el-row",[e("el-col",{attrs:{span:8}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-tag",{attrs:{type:"info"}},[t._v("上传文件")])],1)]),t._v(" "),e("el-col",{attrs:{span:16}},[e("div",{staticClass:"grid-content bg-purple-light"},[e("a",{staticStyle:{color:"blue"},attrs:{href:t.yuBaoJiaInfo.fuJianUrl,download:"w3logo"}},[t._v("下载原文件")])])])],1)],1):t._e(),t._v(" "),t.yuBaoJiaInfo.submitType+""=="0"?e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",[t._v("产品列表")])]),t._v(" "),e("div",[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.yuBaoJiaInfo.businessProductList,border:""}},[e("el-table-column",{attrs:{fixed:"",prop:"productName",label:"产品名称"}}),t._v(" "),e("el-table-column",{attrs:{prop:"wenlidaima",label:"纹理代码"}}),t._v(" "),e("el-table-column",{attrs:{prop:"productNum",label:"数量"}}),t._v(" "),e("el-table-column",{attrs:{prop:"price",label:"含税"}}),t._v(" "),e("el-table-column",{attrs:{prop:"price",label:"单价"}}),t._v(" "),e("el-table-column",{attrs:{prop:"area",label:"面积"}}),t._v(" "),e("el-table-column",{attrs:{prop:"price",label:"不含税价格"}})],1)],1)]):t._e()],1)],1),t._v(" "),e("div",{staticClass:"handle-box",staticStyle:{float:"right","margin-top":"25px"}},[e("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:function(a){t.goBack()}}},[t._v("返回列表")])],1),t._v(" "),e("el-dialog",{attrs:{title:"项目信息",visible:t.dialogFormVisible,width:"40%"},on:{"update:visible":function(a){t.dialogFormVisible=a}}},[e("div",{staticClass:"form-box"},[e("el-form",{ref:"projectfrom",attrs:{model:t.projectfrom,rules:t.rules,"label-width":"120px"}},[e("el-form-item",{attrs:{label:"项目名称：",prop:"projectName"}},[e("el-input",{attrs:{placeholder:"请输入项目名称"},model:{value:t.projectfrom.projectName,callback:function(a){t.$set(t.projectfrom,"projectName",a)},expression:"projectfrom.projectName"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"客户单位：",prop:"cilentCompanyName"}},[e("el-input",{attrs:{placeholder:"请输入客户单位"},model:{value:t.projectfrom.cilentCompanyName,callback:function(a){t.$set(t.projectfrom,"cilentCompanyName",a)},expression:"projectfrom.cilentCompanyName"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[e("el-input",{attrs:{type:"textarea"},model:{value:t.projectfrom.remark,callback:function(a){t.$set(t.projectfrom,"remark",a)},expression:"projectfrom.remark"}})],1)],1)],1),t._v(" "),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary",disabled:this.addloading},on:{click:function(a){t.addProject("projectfrom")}}},[t._v("确 定")]),t._v(" "),e("el-button",{on:{click:function(a){t.dialogFormVisible=!1}}},[t._v("取 消")])],1)]),t._v(" "),e("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading2,expression:"tableLoading2"}],attrs:{title:"开票申请",visible:t.dialogFormVisible2,width:"80%"},on:{"update:visible":function(a){t.dialogFormVisible2=a}}},[e("div",{staticClass:"form-box"},[e("el-form",{ref:"kaiPiao",attrs:{model:this.kaiPiao,"label-width":"120px"}},[e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:12}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-form-item",{attrs:{label:"合同页：",prop:"heTongYe"}},[e("el-input",{model:{value:t.kaiPiao.heTongYe,callback:function(a){t.$set(t.kaiPiao,"heTongYe",a)},expression:"kaiPiao.heTongYe"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"名 称：",prop:"unitName"}},[e("el-input",{model:{value:t.kaiPiao.unitName,callback:function(a){t.$set(t.kaiPiao,"unitName",a)},expression:"kaiPiao.unitName"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"地 址：",prop:"unitDiZhi"}},[e("el-input",{model:{value:t.kaiPiao.unitDiZhi,callback:function(a){t.$set(t.kaiPiao,"unitDiZhi",a)},expression:"kaiPiao.unitDiZhi"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"开户银行：",prop:"unitYinHang"}},[e("el-input",{model:{value:t.kaiPiao.unitYinHang,callback:function(a){t.$set(t.kaiPiao,"unitYinHang",a)},expression:"kaiPiao.unitYinHang"}})],1)],1)]),t._v(" "),e("el-col",{attrs:{span:12}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-form-item",{attrs:{label:"税 号：",prop:"unitShuiHao"}},[e("el-input",{model:{value:t.kaiPiao.unitShuiHao,callback:function(a){t.$set(t.kaiPiao,"unitShuiHao",a)},expression:"kaiPiao.unitShuiHao"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"电 话：",prop:"unitTel"}},[e("el-input",{model:{value:t.kaiPiao.unitTel,callback:function(a){t.$set(t.kaiPiao,"unitTel",a)},expression:"kaiPiao.unitTel"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"账 号：",prop:"unitZhangHao"}},[e("el-input",{model:{value:t.kaiPiao.unitZhangHao,callback:function(a){t.$set(t.kaiPiao,"unitZhangHao",a)},expression:"kaiPiao.unitZhangHao"}})],1)],1)])],1),t._v(" "),e("div",{staticStyle:{width:"100%",height:"1px","border-top":"1px solid","margin-bottom":"15px"}}),t._v(" "),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:12}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-form-item",{attrs:{label:"货物或应税劳务名称：",prop:"laoWuMingCheng","label-width":"160px"}},[e("el-input",{model:{value:t.kaiPiao.laoWuMingCheng,callback:function(a){t.$set(t.kaiPiao,"laoWuMingCheng",a)},expression:"kaiPiao.laoWuMingCheng"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"规格型号：",prop:"guiGeXingHao"}},[e("el-input",{model:{value:t.kaiPiao.guiGeXingHao,callback:function(a){t.$set(t.kaiPiao,"guiGeXingHao",a)},expression:"kaiPiao.guiGeXingHao"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"单 位：",prop:"danWei"}},[e("el-input",{model:{value:t.kaiPiao.danWei,callback:function(a){t.$set(t.kaiPiao,"danWei",a)},expression:"kaiPiao.danWei"}})],1)],1)]),t._v(" "),e("el-col",{attrs:{span:12}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-form-item",{attrs:{label:"数 量：",prop:"shuLiang"}},[e("el-input",{model:{value:t.kaiPiao.shuLiang,callback:function(a){t.$set(t.kaiPiao,"shuLiang",a)},expression:"kaiPiao.shuLiang"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"含税金额：",prop:"jinE"}},[e("el-input",{model:{value:t.kaiPiao.jinE,callback:function(a){t.$set(t.kaiPiao,"jinE",a)},expression:"kaiPiao.jinE"}})],1)],1)])],1),t._v(" "),e("div",{staticStyle:{width:"100%",height:"1px","border-top":"1px solid","margin-bottom":"15px"}}),t._v(" "),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:12}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-form-item",{attrs:{label:"发票号码：",prop:"faPiaoNum","label-width":"160px"}},[e("el-input",{model:{value:t.kaiPiao.faPiaoNum,callback:function(a){t.$set(t.kaiPiao,"faPiaoNum",a)},expression:"kaiPiao.faPiaoNum"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"备 注：",prop:"remark"}},[e("el-input",{model:{value:t.kaiPiao.remark,callback:function(a){t.$set(t.kaiPiao,"remark",a)},expression:"kaiPiao.remark"}})],1)],1)]),t._v(" "),e("el-col",{attrs:{span:12}},[e("div",{staticClass:"grid-content bg-purple"},[e("el-form-item",{attrs:{label:"是否付清：",prop:"isFuQing"}},[e("el-switch",{model:{value:t.kaiPiao.isFuQing,callback:function(a){t.$set(t.kaiPiao,"isFuQing",a)},expression:"kaiPiao.isFuQing"}})],1),t._v(" "),e("el-form-item",{attrs:{label:"付款方式：",prop:"fuKuanType"}},[e("el-radio-group",{model:{value:t.kaiPiao.fuKuanType,callback:function(a){t.$set(t.kaiPiao,"fuKuanType",a)},expression:"kaiPiao.fuKuanType"}},[e("el-radio",{attrs:{label:"现金",value:"0"}}),t._v(" "),e("el-radio",{attrs:{label:"汇票",value:"1"}}),t._v(" "),e("el-radio",{attrs:{label:"汇款",value:"2"}}),t._v(" "),e("el-radio",{attrs:{label:"支票",value:"3"}})],1)],1)],1)])],1)],1)],1),t._v(" "),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.addKaiPiao}},[t._v("提 交")]),t._v(" "),e("el-button",{on:{click:t.quxiaoKai}},[t._v("取 消")])],1)])],1)},staticRenderFns:[]};var l=e("Z0/y")(i,s,!1,function(t){e("mKUX")},"data-v-4003720d",null);a.default=l.exports}});
//# sourceMappingURL=22.322d12849a0d633191cf.js.map
webpackJsonp([12],{"2Hia":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=a("a3Yh"),i=a.n(l),n={data:function(){var e;return e={username:"",name:"",uid:"",dialogFormVisible:!1,select_word:"",form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},currentPage:1,totalnum:0,pagesize:10},i()(e,"select_word",""),i()(e,"tableData",[]),e},methods:{handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},toShenHe:function(e){var t=this;e.presentStepId,e.orderId;this.getRequest("/quality/process/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&userId="+this.uid+"&status=0").then(function(e){_this.tableLoading=!1,e&&200==e.status&&0==e.data.code?(console.log(e),t.tableData=e.data.data.qualityorderlist):console.log("获取数据失败")})},getCollectMouldList:function(){var e=this,t=this;this.getRequest("/quality/process/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&userId="+this.uid+"&status=0").then(function(a){t.tableLoading=!1,a&&200==a.status&&0==a.data.code?(console.log(a),e.tableData=a.data.data.qualityorderlist):console.log("获取数据失败")})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.wuLiaoName.indexOf(e.select_word)>-1||t.orderName.indexOf(e.select_word)>-1)return t})}}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("质量管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("下单记录")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{prop:"",label:"产品名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.orderName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"下单日期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDateTime")(t.row.order.createTime)))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(工期7天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"完工预期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDateTime")(t.row.order.createTime)))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(剩余6天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"当前步骤"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"jinDu",label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.order.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"urgency",label:"紧急程度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.order.urgency+""=="0"?a("el-tag",{attrs:{type:"info"}},[e._v("一般")]):e._e(),e._v(" "),t.row.order.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.toShenHe(t.row)}}},[e._v("审 核")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详 情")])]}}])})],1)],1)])],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"步骤审核",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{prop:"presentStepName",label:"当前步骤："}},[a("el-input",{attrs:{disabled:!0}})],1),e._v(" "),a("el-form-item",{attrs:{label:"审核备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传照片："}},[a("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"/api/posts/",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),e._v(" "),a("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),a("em",[e._v("点击上传")])])])],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(e){}}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var s=a("Z0/y")(n,r,!1,function(e){a("k+jB")},"data-v-2dc8aabe",null);t.default=s.exports},"4tNZ":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=a("a3Yh"),i=a.n(l),n={data:function(){var e;return e={username:"",name:"",uid:"",dialogFormVisible:!1,select_word:"",form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},currentPage:1,totalnum:0,pagesize:10},i()(e,"select_word",""),i()(e,"tableData",[{ordername:"订单1",chanpinname:"测试1",dqbz:"工序A",jidu:"10%",changename:"张三",jinji:"一般",date:"2016-05-02"},{ordername:"订单1",chanpinname:"测试1",dqbz:"工序A",jidu:"10%",changename:"张三",jinji:"一般",date:"2016-05-02"},{ordername:"订单1",chanpinname:"测试1",dqbz:"工序A",jidu:"10%",changename:"张三",jinji:"一般",date:"2016-05-02"},{ordername:"订单1",chanpinname:"测试1",dqbz:"工序A",jidu:"10%",changename:"张三",jinji:"一般",date:"2016-05-02"}]),e},methods:{handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/quality/process/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&userId="+this.uid+"&status=0").then(function(t){e.tableLoading=!1,t&&200==t.status&&t.data.code})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList()},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.wuLiaoName.indexOf(e.select_word)>-1||t.orderName.indexOf(e.select_word)>-1)return t})}}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("质量管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("完结的订单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{prop:"chanpinname",label:"产品名称"}}),e._v(" "),a("el-table-column",{attrs:{label:"下单日期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.date))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(工期7天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"完工预期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(t.row.date))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(剩余6天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"dqbz",label:"当前步骤"}}),e._v(" "),a("el-table-column",{attrs:{prop:"changename",label:"当前步骤负责人"}}),e._v(" "),a("el-table-column",{attrs:{prop:"jidu",label:"订单进度"}}),e._v(" "),a("el-table-column",{attrs:{prop:"jinji",label:"紧急程度"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.toXiangqing}},[e._v("查看详情")])]}}])})],1)],1)])],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"步骤审核",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"当前步骤："}},[a("el-input")],1),e._v(" "),a("el-form-item",{attrs:{label:"加工负责人："}},[a("el-input")],1),e._v(" "),a("el-form-item",{attrs:{label:"开始时间："}},[a("el-col",{attrs:{span:11}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.form.date1,callback:function(t){e.$set(e.form,"date1",t)},expression:"form.date1"}})],1),e._v(" "),a("el-col",{staticClass:"line",attrs:{span:2}},[e._v("-")]),e._v(" "),a("el-col",{attrs:{span:11}},[a("el-time-picker",{staticStyle:{width:"100%"},attrs:{type:"fixed-time",placeholder:"选择时间"},model:{value:e.form.date2,callback:function(t){e.$set(e.form,"date2",t)},expression:"form.date2"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.desc,callback:function(t){e.$set(e.form,"desc",t)},expression:"form.desc"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传照片："}},[a("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"/api/posts/",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),e._v(" "),a("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),a("em",[e._v("点击上传")])])])],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:e.open2}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var s=a("Z0/y")(n,r,!1,function(e){a("mset")},"data-v-b37ae2ea",null);t.default=s.exports},"k+jB":function(e,t){},mset:function(e,t){},r9zt:function(e,t,a){var l={"./QualityFinish.vue":"4tNZ","./QualityProcess.vue":"2Hia"};function i(e){return a(n(e))}function n(e){var t=l[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}i.keys=function(){return Object.keys(l)},i.resolve=n,e.exports=i,i.id="r9zt"}});
//# sourceMappingURL=12.231172f6d84f5ac90f28.js.map
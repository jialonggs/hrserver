webpackJsonp([9],{"2JWR":function(e,t,a){var o={"./StorDepositOrder.vue":"bVtO","./StorIssueOrder.vue":"gLSs","./StorPutOrder.vue":"o66s"};function i(e){return a(r(e))}function r(e){var t=o[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}i.keys=function(){return Object.keys(o)},i.resolve=r,e.exports=i,i.id="2JWR"},HyhW:function(e,t){},bVtO:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=a("a3Yh"),i=a.n(o),r={data:function(){return i()({form:{},dialogFormVisible:!1,nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[],itemRuKu:{}},"tableLoading",!1)},methods:{toShenHe:function(e){this.dialogFormVisible=!0,this.itemRuKu=e,this.form.kuFangRemark=""},shenhe:function(e){var t=this,a=this,o={kuFangRemark:this.form.kuFangRemark,orderId:this.itemRuKu.id,storageStatus:e};a.tableLoading=!0,this.postRequest("/storage/put/check",o).then(function(e){a.tableLoading=!1,e&&200==e.status&&0==e.data.code?(t.$message.success("执行成功"),t.dialogFormVisible=!1,t.getCollectMouldList()):t.$message.error("执行失败")})},toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/storage/have/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&storageStatus=2").then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.putorderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},n={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("库房管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("库房列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.storageStatus+""=="2"?a("el-tag",{attrs:{type:"danger"}},[e._v("待发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{title:"入库审核",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"审核备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.kuFangRemark,callback:function(t){e.$set(e.form,"kuFangRemark",t)},expression:"form.kuFangRemark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.shenhe(2)}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.shenhe(3)}}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var l=a("Z0/y")(r,n,!1,function(e){a("oiHC")},"data-v-96d163f2",null);t.default=l.exports},gLSs:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=a("a3Yh"),i=a.n(o),r={data:function(){return i()({form:{},dialogFormVisible:!1,nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[],itemRuKu:{}},"tableLoading",!1)},methods:{toShenHe:function(e){this.dialogFormVisible=!0,this.itemRuKu=e,this.form.kuFangRemark=""},shenhe:function(e){var t=this,a=this,o={kuFangRemark:this.form.kuFangRemark,orderId:this.itemRuKu.id,storageStatus:e};a.tableLoading=!0,this.postRequest("/storage/put/check",o).then(function(e){a.tableLoading=!1,e&&200==e.status&&0==e.data.code?(t.$message.success("执行成功"),t.dialogFormVisible=!1,t.getCollectMouldList()):t.$message.error("执行失败")})},toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/storage/put/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&storageStatus=3").then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.putorderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},n={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("库房管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("不合格列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.storageStatus+""=="3"?a("el-tag",{attrs:{type:"danger"}},[e._v("待处理")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{title:"入库审核",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"审核备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.kuFangRemark,callback:function(t){e.$set(e.form,"kuFangRemark",t)},expression:"form.kuFangRemark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.shenhe(2)}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.shenhe(3)}}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var l=a("Z0/y")(r,n,!1,function(e){a("gctV")},"data-v-7fbdff6a",null);t.default=l.exports},gctV:function(e,t){},o66s:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=a("a3Yh"),i=a.n(o),r={data:function(){return i()({form:{},dialogFormVisible:!1,nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[],itemRuKu:{}},"tableLoading",!1)},methods:{toQuXiao:function(){this.dialogFormVisible=!1,this.itemRuKu={},this.form={}},toShenHe:function(e){this.dialogFormVisible=!0,this.itemRuKu=e,this.form={}},addBill:function(){var e=this,t=this,a=this.form;a.addUserId=this.uid,a.addUserName=this.name,a.orderId=this.itemRuKu.id,a.orderName=this.itemRuKu.orderName,t.tableLoading=!0,this.postRequest("/storage/add/bill",a).then(function(a){t.tableLoading=!1,a&&200==a.status&&0==a.data.code?(e.$message.success("执行成功"),e.dialogFormVisible=!1,e.getCollectMouldList()):e.$message.error("执行失败")})},shenhe:function(e){var t=this,a=this,o={kuFangRemark:this.form.kuFangRemark,orderId:this.itemRuKu.id,storageStatus:e};a.tableLoading=!0,this.postRequest("/storage/put/check",o).then(function(e){a.tableLoading=!1,e&&200==e.status&&0==e.data.code?(t.$message.success("执行成功"),t.dialogFormVisible=!1,t.getCollectMouldList()):t.$message.error("执行失败")})},toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/storage/put/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&liuChengStatus=2&jingFengStatus=1&storageStatus=0").then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.putorderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},n={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("库房管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("待入库列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.storageStatus+""=="0"?a("el-tag",{attrs:{type:"danger"}},[e._v("待入库")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"warning"},on:{click:function(a){e.toShenHe(t.row)}}},[e._v("审核")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{title:"入库审核单",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"纹理状态："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.wenLiStatus,callback:function(t){e.$set(e.form,"wenLiStatus",t)},expression:"form.wenLiStatus"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"喷防锈剂前："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.penXiuQian,callback:function(t){e.$set(e.form,"penXiuQian",t)},expression:"form.penXiuQian"}})],1),e._v(" "),a("div",{staticStyle:{"border-top-style":"dotted","border-bottom-style":"dotted","margin-top":"20px","margin-bottom":"10px"}},[a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"区域："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.quYu,callback:function(t){e.$set(e.form,"quYu",t)},expression:"form.quYu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"光泽："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.guangZe,callback:function(t){e.$set(e.form,"guangZe",t)},expression:"form.guangZe"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"气孔："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.qiKong,callback:function(t){e.$set(e.form,"qiKong",t)},expression:"form.qiKong"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"碰穿边："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.pengChuanBian,callback:function(t){e.$set(e.form,"pengChuanBian",t)},expression:"form.pengChuanBian"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"材质："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.chaiZhi,callback:function(t){e.$set(e.form,"chaiZhi",t)},expression:"form.chaiZhi"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"特殊区纹理："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.teShuWenLi,callback:function(t){e.$set(e.form,"teShuWenLi",t)},expression:"form.teShuWenLi"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"缺口："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.queKou,callback:function(t){e.$set(e.form,"queKou",t)},expression:"form.queKou"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"光边："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.guangBian,callback:function(t){e.$set(e.form,"guangBian",t)},expression:"form.guangBian"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"裂缝："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.lieFeng,callback:function(t){e.$set(e.form,"lieFeng",t)},expression:"form.lieFeng"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"焊疤痕："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.hanBaHen,callback:function(t){e.$set(e.form,"hanBaHen",t)},expression:"form.hanBaHen"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"纹理数据："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.wenLiShuJu,callback:function(t){e.$set(e.form,"wenLiShuJu",t)},expression:"form.wenLiShuJu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"外观："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.waiGuan,callback:function(t){e.$set(e.form,"waiGuan",t)},expression:"form.waiGuan"}})],1)],1)],1)],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addBill}},[e._v("提 交")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:e.toQuXiao}},[e._v("取 消")])],1)])],1)},staticRenderFns:[]};var l=a("Z0/y")(r,n,!1,function(e){a("HyhW")},"data-v-5d096d03",null);t.default=l.exports},oiHC:function(e,t){}});
//# sourceMappingURL=9.82f7745534ec726d9389.js.map
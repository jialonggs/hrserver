webpackJsonp([10],{"6sP+":function(e,t,a){var l={"./FaAuditJing.vue":"YIiM","./FaAuditList.vue":"RXoc"};function r(e){return a(o(e))}function o(e){var t=l[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}r.keys=function(){return Object.keys(l)},r.resolve=o,e.exports=r,r.id="6sP+"},"E/Uj":function(e,t){},RXoc:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={data:function(){return{dialogFormVisible:!1,form:{order:{project:{}}},auditItem:"",activeName:"first",username:"",name:"",uid:"",tableLoading:!1,currentPage0:1,totalnum0:0,pagesize0:10,currentPage1:1,totalnum1:0,pagesize1:10,currentPage2:1,totalnum2:0,pagesize2:10,tableData0:[],tableData1:[],tableData2:[]}},methods:{tongGuo:function(e){var t=this,a={id:this.auditItem.id,status:e,auditId:this.uid,auditName:this.name,addUserId:this.auditItem.addUserId};this.postRequest("/fa/mo/check",a).then(function(e){e&&200==e.status&&0==e.data.code?(t.$message.success("审核成功"),t.dialogFormVisible=!1,t.getCollectMouldList(0,t.currentPage0,t.pagesize0)):t.$message.error("审核失败")})},toAudit:function(e){var t=this;this.auditItem=e,this.dialogFormVisible=!0,this.getRequest("/fa/mo/info?id="+e.id).then(function(e){e&&200==e.status&&0==e.data.code&&(t.form=e.data.data.faMo,console.log(t.form))})},tongGuoShenHe:function(e){0==e.index?this.getCollectMouldList(0,this.currentPage0,this.pagesize0):1==e.index?this.getCollectMouldList(1,this.currentPage1,this.pagesize1):2==e.index&&this.getCollectMouldList(-1,this.currentPage2,this.pagesize2)},tableRowClassName:function(e){e.row,e.rowIndex;return"warning-row"},tableRowClassName1:function(e){e.row,e.rowIndex;return"success-row"},tableRowClassName2:function(e){e.row,e.rowIndex;return"error-row"},handleSizeChange0:function(e){this.pagesize0=e,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleCurrentChange0:function(e){this.currentPage0=e,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleSizeChange1:function(e){this.pagesize1=e,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleCurrentChange1:function(e){this.currentPage1=e,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleSizeChange2:function(e){this.pagesize2=e,this.getCollectMouldList(-1,this.currentPage2,this.pagesize2)},handleCurrentChange2:function(e){this.currentPage2=e,this.getCollectMouldList(-1,this.currentPage2,this.pagesize2)},getCollectMouldList:function(e,t,a){var l=this;this.getRequest("/fa/mo/listbypage?page="+t+"&size="+a+"&status="+e).then(function(t){t&&200==t.status&&0==t.data.code&&(console.log(t),0==e?(l.tableData0=t.data.data.famolist,l.totalnum0=t.data.data.count):1==e?(l.tableData1=t.data.data.famolist,l.totalnum1=t.data.data.count):-1==e&&(l.tableData2=t.data.data.famolist,l.totalnum1=t.data.data.count))})}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList(0,1,10)}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("发模单审核")]),e._v(" "),a("el-breadcrumb-item",[e._v("商务审核记录")])],1)],1),e._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":e.tongGuoShenHe}},[a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("待审核")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData0,"row-class-name":e.tableRowClassName}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.faMoType+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("欠款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[e._v("全款发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),e._v(" "),t.row.status+""=="1"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.status+""=="-1"?a("el-tag",{attrs:{type:"danger"}},[e._v("未通过")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.liuChang+""=="true"&&t.row.liuChang+""!=""?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.liuChang+""=="false"||t.row.liuChang+""==""?a("el-tag",[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toAudit(t.row)}}},[e._v("审核")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage0,"page-sizes":[10,30,80,100],"page-size":e.pagesize0,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum0},on:{"size-change":e.handleSizeChange0,"current-change":e.handleCurrentChange0}})],1)],1),e._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("已通过")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData1,"row-class-name":e.tableRowClassName1}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.faMoType+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("欠款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[e._v("全款发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),e._v(" "),t.row.status+""=="1"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.status+""=="-1"?a("el-tag",{attrs:{type:"danger"}},[e._v("未通过")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.liuChang+""=="true"&&t.row.liuChang+""!=""?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.liuChang+""=="false"||t.row.liuChang+""==""?a("el-tag",[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage1,"page-sizes":[10,30,80,100],"page-size":e.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum1},on:{"size-change":e.handleSizeChange1,"current-change":e.handleCurrentChange1}})],1)],1),e._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("未通过")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData2,"row-class-name":e.tableRowClassName2}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.faMoType+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("欠款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[e._v("全款发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),e._v(" "),t.row.status+""=="1"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.status+""=="-1"?a("el-tag",{attrs:{type:"danger"}},[e._v("未通过")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.liuChang+""=="true"&&t.row.liuChang+""!=""?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.liuChang+""=="false"||t.row.liuChang+""==""?a("el-tag",[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage2,"page-sizes":[10,30,80,100],"page-size":e.pagesize2,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum2},on:{"size-change":e.handleSizeChange2,"current-change":e.handleCurrentChange2}})],1)],1)],1)],1)])],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{title:"正常发模申请",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"订单名称："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.orderName,callback:function(t){e.$set(e.form,"orderName",t)},expression:"form.orderName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"申请人："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.addUserName,callback:function(t){e.$set(e.form,"addUserName",t)},expression:"form.addUserName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"车牌号："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.chePai,callback:function(t){e.$set(e.form,"chePai",t)},expression:"form.chePai"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"驾驶员电话："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.driverPhone,callback:function(t){e.$set(e.form,"driverPhone",t)},expression:"form.driverPhone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"发模类型："}},[e.form.faMoType+""=="0"?a("span",[e._v("欠款发模")]):e._e(),e._v(" "),e.form.faMoType+""=="1"?a("span",[e._v("部分到款发模")]):e._e(),e._v(" "),e.form.faMoType+""=="2"?a("span",[e._v("全款发模")]):e._e()]),e._v(" "),a("el-form-item",{attrs:{label:"付款金额："}},[a("span",[e._v(e._s(e.form.order.project.financeJinE))])]),e._v(" "),a("el-form-item",{attrs:{label:"付款比例："}},[a("span",[e._v(e._s(e.form.order.project.financeBiLi)+"%")])]),e._v(" "),a("el-form-item",{attrs:{label:"欠款原因："}},[a("el-input",{attrs:{type:"textarea",disabled:!0},model:{value:e.form.faMoRemark,callback:function(t){e.$set(e.form,"faMoRemark",t)},expression:"form.faMoRemark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.tongGuo(1)}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.tongGuo(-1)}}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var o=a("Z0/y")(l,r,!1,function(e){a("V8TX"),a("l7LV")},"data-v-93d2a7b8",null);t.default=o.exports},V8TX:function(e,t){},YIiM:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={data:function(){return{dialogFormVisible:!1,form:{order:{project:{}}},auditItem:"",activeName:"first",username:"",name:"",uid:"",tableLoading:!1,currentPage0:1,totalnum0:0,pagesize0:10,currentPage1:1,totalnum1:0,pagesize1:10,currentPage2:1,totalnum2:0,pagesize2:10,tableData0:[],tableData1:[],tableData2:[]}},methods:{tongGuo:function(e){var t=this,a={id:this.auditItem.id,status:e,auditId:this.uid,auditName:this.name,addUserId:this.auditItem.addUserId};this.postRequest("/fa/mo/check",a).then(function(e){e&&200==e.status&&0==e.data.code?(t.getCollectMouldList(1,t.currentPage0,t.pagesize0),t.$message.success("审核成功"),t.dialogFormVisible=!1):t.$message.error("审核失败")})},toAudit:function(e){var t=this;this.auditItem=e,this.dialogFormVisible=!0,this.getRequest("/fa/mo/info?id="+e.id).then(function(e){e&&200==e.status&&0==e.data.code&&(t.form=e.data.data.faMo)})},tongGuoShenHe:function(e){0==e.index?this.getCollectMouldList(1,this.currentPage0,this.pagesize0):1==e.index?this.getCollectMouldList(2,this.currentPage1,this.pagesize1):2==e.index&&this.getCollectMouldList(-2,this.currentPage2,this.pagesize2)},tableRowClassName:function(e){e.row,e.rowIndex;return"warning-row"},tableRowClassName1:function(e){e.row,e.rowIndex;return"success-row"},tableRowClassName2:function(e){e.row,e.rowIndex;return"error-row"},handleSizeChange0:function(e){this.pagesize0=e,this.getCollectMouldList(1,this.currentPage0,this.pagesize0)},handleCurrentChange0:function(e){this.currentPage0=e,this.getCollectMouldList(1,this.currentPage0,this.pagesize0)},handleSizeChange1:function(e){this.pagesize1=e,this.getCollectMouldList(2,this.currentPage1,this.pagesize1)},handleCurrentChange1:function(e){this.currentPage1=e,this.getCollectMouldList(2,this.currentPage1,this.pagesize1)},handleSizeChange2:function(e){this.pagesize2=e,this.getCollectMouldList(-2,this.currentPage2,this.pagesize2)},handleCurrentChange2:function(e){this.currentPage2=e,this.getCollectMouldList(-2,this.currentPage2,this.pagesize2)},getCollectMouldList:function(e,t,a){var l=this;this.getRequest("/fa/mo/listbypage?page="+t+"&size="+a+"&status="+e).then(function(t){t&&200==t.status&&0==t.data.code&&(1==e?(l.tableData0=t.data.data.famolist,l.totalnum0=t.data.data.count):2==e?(l.tableData1=t.data.data.famolist,l.totalnum1=t.data.data.count):-2==e&&(l.tableData2=t.data.data.famolist,l.totalnum1=t.data.data.count))})}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList(1,1,10)}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("发模单审核")]),e._v(" "),a("el-breadcrumb-item",[e._v("经理审核记录")])],1)],1),e._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":e.tongGuoShenHe}},[a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("待审核")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData0,"row-class-name":e.tableRowClassName}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.faMoType+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("欠款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="1"?a("el-tag",{attrs:{type:"info"}},[e._v("部分到款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[e._v("全款发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="1"?a("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),e._v(" "),t.row.status+""=="2"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.status+""=="-2"?a("el-tag",{attrs:{type:"danger"}},[e._v("未通过")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.liuChang+""=="true"&&t.row.liuChang+""!=""?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.liuChang+""=="false"||t.row.liuChang+""==""?a("el-tag",[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toAudit(t.row)}}},[e._v("审核")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage0,"page-sizes":[10,30,80,100],"page-size":e.pagesize0,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum0},on:{"size-change":e.handleSizeChange0,"current-change":e.handleCurrentChange0}})],1)],1),e._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("已通过")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData1,"row-class-name":e.tableRowClassName1}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.faMoType+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("欠款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="1"?a("el-tag",{attrs:{type:"info"}},[e._v("部分到款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"success"}},[e._v("全款发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="1"?a("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),e._v(" "),t.row.status+""=="2"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.status+""=="-2"?a("el-tag",{attrs:{type:"danger"}},[e._v("未通过")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.liuChang+""=="true"&&t.row.liuChang+""!=""?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.liuChang+""=="false"||t.row.liuChang+""==""?a("el-tag",[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage1,"page-sizes":[10,30,80,100],"page-size":e.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum1},on:{"size-change":e.handleSizeChange1,"current-change":e.handleCurrentChange1}})],1)],1),e._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("未通过")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData2,"row-class-name":e.tableRowClassName2}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.faMoType+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("欠款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="1"?a("el-tag",{attrs:{type:"info"}},[e._v("部分到款发模")]):e._e(),e._v(" "),t.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"success"}},[e._v("全款发模")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="1"?a("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),e._v(" "),t.row.status+""=="2"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.status+""=="-2"?a("el-tag",{attrs:{type:"danger"}},[e._v("未通过")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),e._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.liuChang+""=="true"&&t.row.liuChang+""!=""?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.liuChang+""=="false"||t.row.liuChang+""==""?a("el-tag",[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage2,"page-sizes":[10,30,80,100],"page-size":e.pagesize2,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum2},on:{"size-change":e.handleSizeChange2,"current-change":e.handleCurrentChange2}})],1)],1)],1)],1)])],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],attrs:{title:"正常发模申请",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"订单名称："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.orderName,callback:function(t){e.$set(e.form,"orderName",t)},expression:"form.orderName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"申请人："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.addUserName,callback:function(t){e.$set(e.form,"addUserName",t)},expression:"form.addUserName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"申请人："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.addUserName,callback:function(t){e.$set(e.form,"addUserName",t)},expression:"form.addUserName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"车牌号："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.chePai,callback:function(t){e.$set(e.form,"chePai",t)},expression:"form.chePai"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"发模类型："}},[e.form.faMoType+""=="0"?a("span",[e._v("欠款发模")]):e._e(),e._v(" "),e.form.faMoType+""=="1"?a("span",[e._v("部分到款发模")]):e._e(),e._v(" "),e.form.faMoType+""=="2"?a("span",[e._v("全款发模")]):e._e()]),e._v(" "),a("el-form-item",{attrs:{label:"付款金额："}},[a("span",[e._v(e._s(e.form.order.project.financeJinE))])]),e._v(" "),a("el-form-item",{attrs:{label:"付款比例："}},[a("span",[e._v(e._s(e.form.order.project.financeBiLi)+"%")])]),e._v(" "),a("el-form-item",{attrs:{label:"欠款原因："}},[a("el-input",{attrs:{type:"textarea",disabled:!0},model:{value:e.form.faMoRemark,callback:function(t){e.$set(e.form,"faMoRemark",t)},expression:"form.faMoRemark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.tongGuo(2)}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.tongGuo(-2)}}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var o=a("Z0/y")(l,r,!1,function(e){a("u7l4"),a("E/Uj")},"data-v-51692bce",null);t.default=o.exports},l7LV:function(e,t){},u7l4:function(e,t){}});
//# sourceMappingURL=10.7dc7b197d34308c34ead.js.map
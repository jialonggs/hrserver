webpackJsonp([17],{"6sP+":function(t,e,a){var l={"./FaAuditList.vue":"RXoc"};function r(t){return a(o(t))}function o(t){var e=l[t];if(!(e+1))throw new Error("Cannot find module '"+t+"'.");return e}r.keys=function(){return Object.keys(l)},r.resolve=o,t.exports=r,r.id="6sP+"},RXoc:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l={data:function(){return{dialogFormVisible:!1,form:{order:{}},auditItem:"",activeName:"first",username:"",name:"",uid:"",tableLoading:!1,currentPage0:1,totalnum0:0,pagesize0:10,currentPage1:1,totalnum1:0,pagesize1:10,currentPage2:1,totalnum2:0,pagesize2:10,tableData0:[],tableData1:[],tableData2:[]}},methods:{tongGuo:function(t){var e=this,a={id:this.auditItem.id,status:t,auditId:this.uid,auditName:this.name,addUserId:this.auditItem.addUserId};this.postRequest("/fa/mo/check",a).then(function(t){t&&200==t.status&&0==t.data.code?(e.$message.success("审核成功"),e.dialogFormVisible=!1,e.tongGuoShenHe(0)):e.$message.error("审核失败")})},toAudit:function(t){var e=this;this.auditItem=t,this.dialogFormVisible=!0,this.getRequest("/fa/mo/info?id="+t.id).then(function(t){t&&200==t.status&&0==t.data.code&&(e.form=t.data.data.faMo)})},tongGuoShenHe:function(t){0==t.index?this.getCollectMouldList(0,this.currentPage0,this.pagesize0):1==t.index?this.getCollectMouldList(1,this.currentPage1,this.pagesize1):2==t.index&&this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},tableRowClassName:function(t){t.row,t.rowIndex;return"warning-row"},tableRowClassName1:function(t){t.row,t.rowIndex;return"success-row"},tableRowClassName2:function(t){t.row,t.rowIndex;return"error-row"},handleSizeChange0:function(t){this.pagesize0=t,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleCurrentChange0:function(t){this.currentPage0=t,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleSizeChange1:function(t){this.pagesize1=t,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleCurrentChange1:function(t){this.currentPage1=t,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleSizeChange2:function(t){this.pagesize2=t,this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},handleCurrentChange2:function(t){this.currentPage2=t,this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},getCollectMouldList:function(t,e,a){var l=this;this.getRequest("/fa/mo/listbypage?page="+e+"&size="+a+"&status="+t).then(function(e){e&&200==e.status&&0==e.data.code&&(0==t?(l.tableData0=e.data.data.famolist,l.totalnum0=e.data.data.count):1==t?(l.tableData1=e.data.data.famolist,l.totalnum1=e.data.data.count):2==t&&(l.tableData2=e.data.data.famolist,l.totalnum1=e.data.data.count))})}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList(0,1,10)}},r={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),t._v("商务报价审核")]),t._v(" "),a("el-breadcrumb-item",[t._v("审核记录")])],1)],1),t._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":t.tongGuoShenHe}},[a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("待审核")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData0,"row-class-name":t.tableRowClassName}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),t._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.faMoType+""=="1"?a("el-tag",{attrs:{type:"primary"}},[t._v("欠款发模")]):t._e(),t._v(" "),e.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[t._v("部分到款发模")]):t._e(),t._v(" "),e.row.faMoType+""=="3"?a("el-tag",{attrs:{type:"info"}},[t._v("全款发模")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.status+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.status+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),t._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),t._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status+""=="true"?a("el-tag",{attrs:{type:"primary"}},[t._v("是")]):t._e(),t._v(" "),e.row.status+""=="false"?a("el-tag",{attrs:{type:"danger"}},[t._v("否")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toAudit(e.row)}}},[t._v("审核")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage0,"page-sizes":[10,30,80,100],"page-size":t.pagesize0,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum0},on:{"size-change":t.handleSizeChange0,"current-change":t.handleCurrentChange0}})],1)],1),t._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("已通过")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData1,"row-class-name":t.tableRowClassName1}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),t._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.faMoType+""=="1"?a("el-tag",{attrs:{type:"primary"}},[t._v("欠款发模")]):t._e(),t._v(" "),e.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[t._v("正常发模")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.status+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.status+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),t._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),t._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status+""=="true"?a("el-tag",{attrs:{type:"primary"}},[t._v("是")]):t._e(),t._v(" "),e.row.status+""=="false"?a("el-tag",{attrs:{type:"danger"}},[t._v("否")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(t){}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage1,"page-sizes":[10,30,80,100],"page-size":t.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum1},on:{"size-change":t.handleSizeChange1,"current-change":t.handleCurrentChange1}})],1)],1),t._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("未通过")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData2,"row-class-name":t.tableRowClassName2}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),t._v(" "),a("el-table-column",{attrs:{label:"发模类型",prop:"faMoType"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.faMoType+""=="1"?a("el-tag",{attrs:{type:"primary"}},[t._v("欠款发模")]):t._e(),t._v(" "),e.row.faMoType+""=="2"?a("el-tag",{attrs:{type:"info"}},[t._v("正常发模")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.status+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.status+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"留厂数量",prop:"liuChangNum"}}),t._v(" "),a("el-table-column",{attrs:{label:"发模数量",prop:"faMoNum"}}),t._v(" "),a("el-table-column",{attrs:{label:"是否等额留厂",prop:"liuChang"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.status+""=="true"?a("el-tag",{attrs:{type:"primary"}},[t._v("是")]):t._e(),t._v(" "),e.row.status+""=="false"?a("el-tag",{attrs:{type:"danger"}},[t._v("否")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(t){}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage2,"page-sizes":[10,30,80,100],"page-size":t.pagesize2,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum2},on:{"size-change":t.handleSizeChange2,"current-change":t.handleCurrentChange2}})],1)],1)],1)],1)])],1)],1),t._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],attrs:{title:"正常发模申请",visible:t.dialogFormVisible,width:"40%"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:t.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"订单名称："}},[a("el-input",{attrs:{disabled:!0},model:{value:t.form.orderName,callback:function(e){t.$set(t.form,"orderName",e)},expression:"form.orderName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"申请人："}},[a("el-input",{attrs:{disabled:!0},model:{value:t.form.addUserName,callback:function(e){t.$set(t.form,"addUserName",e)},expression:"form.addUserName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"发模类型："}},[t.form.faMoType+""=="1"?a("span",[t._v("欠款发模")]):t._e(),t._v(" "),t.form.faMoType+""=="2"?a("span",[t._v("部分到款发模")]):t._e(),t._v(" "),t.form.faMoType+""=="3"?a("span",[t._v("全款发模")]):t._e()]),t._v(" "),a("el-form-item",{attrs:{label:"付款金额："}},[a("span",[t._v(t._s(t.form.order.financeJinE))])]),t._v(" "),a("el-form-item",{attrs:{label:"付款比例："}},[a("span",[t._v(t._s(t.form.order.financeBiLi))])]),t._v(" "),a("el-form-item",{attrs:{label:"欠款原因："}},[a("el-input",{attrs:{type:"textarea",disabled:!0},model:{value:t.form.faMoRemark,callback:function(e){t.$set(t.form,"faMoRemark",e)},expression:"form.faMoRemark"}})],1)],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.tongGuo(1)}}},[t._v("通 过")]),t._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(t){}}},[t._v("驳 回")])],1)])],1)},staticRenderFns:[]};var o=a("Z0/y")(l,r,!1,function(t){a("VXMn"),a("Zrgy")},"data-v-5218efb8",null);e.default=o.exports},VXMn:function(t,e){},Zrgy:function(t,e){}});
//# sourceMappingURL=17.cb00ed71f9e59a46a73b.js.map
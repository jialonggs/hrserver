webpackJsonp([5],{EKkj:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l=a("OIbc"),r=(a("+J3q"),{components:{VueCoreImageUpload:l.default},props:{title:String},data:function(){return{remarks:[],urlId:"",dialogFormVisible:!1,table_loading:!1,imageUrls:[],ruleForm:{tax:"17",addUserId:"",addUserName:""},form:{},elform:{productNum:"0",area:"0",dongMo:!1,price:"0",coefficient:""},productData:[],innerVisible:!1,tableData:[],select_word:"",nowTab:1}},methods:{splitUrl:function(t){var e=t.picUrls,a=[];return"undefined"!=e&&""!=e&&(a=e.split("|")),a},toAudit2:function(){var t=this,e={id:this.urlId,audit:2,addUserId:this.ruleForm.addUserId,auditId:this.uid,auditName:this.name,rejectRemark:this.form.rejectRemark};this.postRequest("/audit/per/check",e).then(function(e){e&&200==e.status&&0==e.data.code?(t.$message.success("执行成功"),t.$store.state.stomp.send("/ws/nf",{},""),t.$router.push("/audit/per")):t.$message.error("执行失败")})},toAudit:function(t){var e=this,a={id:this.urlId,audit:t,addUserId:this.ruleForm.addUserId,auditId:this.uid,auditName:this.name,rejectRemark:{}};2!==t?this.postRequest("/audit/per/check",a).then(function(t){t&&200==t.status&&0==t.data.code?(e.$message.success("执行成功"),e.$store.state.stomp.send("/ws/nf",{},""),e.$router.push("/audit/per")):e.$message.error("执行失败")}):this.dialogFormVisible=!0},getInfo:function(t){var e=this,a=this;this.getRequest("/audit/per/info?id="+t).then(function(t){if(t&&200==t.status&&0==t.data.code){a.ruleForm=t.data.data.yuinfo;var l=t.data.data.yuinfo.yuProductList,r=t.data.data.yuinfo.rejectRemark,o=e.$options.filters.splitRejectRemark;if(e.remarks=o(r),"undefined"!=a.product&&l.length>0){for(var i=[],s=0;s<l.length;s++){var n,u={};u=l[s],n=a.splitUrl(l[s]),u.picUrls=n,i.push(u)}a.productData=i}}else a.$message.error("获取失败")})},resetForm:function(t){this.$refs[t].resetFields()}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},created:function(){this.urlId=this.$route.params.id,this.getInfo(this.urlId)}}),o={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),t._v("预报价单")]),t._v(" "),a("el-breadcrumb-item",[t._v("预报价详情")])],1)],1),t._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[t.ruleForm.audit+""=="2"?a("div",[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("span",[t._v("驳回原因：")]),t._v(" "),a("div",{staticStyle:{"margin-top":"20px"}},t._l(t.remarks,function(t){return a("div",[a("el-alert",{attrs:{title:t,type:"warning",closable:!1}})],1)}))])],1):t._e(),t._v(" "),a("div",[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",staticStyle:{width:"40%"},attrs:{model:t.ruleForm,"label-width":"110px"}},[a("div",[a("el-form-item",{attrs:{label:"客户单位：",prop:"clientCompanyName"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.clientCompanyName,callback:function(e){t.$set(t.ruleForm,"clientCompanyName",e)},expression:"ruleForm.clientCompanyName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"联系人：",prop:"contactPerson"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.contactPerson,callback:function(e){t.$set(t.ruleForm,"contactPerson",e)},expression:"ruleForm.contactPerson"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"联系电话：",prop:"contactPhone"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.contactPhone,callback:function(e){t.$set(t.ruleForm,"contactPhone",e)},expression:"ruleForm.contactPhone"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"车型：",prop:"carType"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.carType,callback:function(e){t.$set(t.ruleForm,"carType",e)},expression:"ruleForm.carType"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"不含税价格：",prop:"carType"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.noTaxTotal,callback:function(e){t.$set(t.ruleForm,"noTaxTotal",e)},expression:"ruleForm.noTaxTotal"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"税率：",prop:"tax"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0,disabled:!0},model:{value:t.ruleForm.tax,callback:function(e){t.$set(t.ruleForm,"tax",e)},expression:"ruleForm.tax"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"含税价格：",prop:"carType"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.total,callback:function(e){t.$set(t.ruleForm,"total",e)},expression:"ruleForm.total"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",disabled:!0},model:{value:t.ruleForm.remark,callback:function(e){t.$set(t.ruleForm,"remark",e)},expression:"ruleForm.remark"}})],1)],1),t._v(" "),t.ruleForm.submitType+""=="1"?a("el-form-item",{attrs:{label:"下载原文件",prop:"remark"}},[[a("a",{staticStyle:{color:"blue"},attrs:{href:t.ruleForm.fuJianUrl,download:"w3logo"}},[t._v("下载原文件")])]],2):t._e()],1),t._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}})],1)],1),t._v(" "),t.ruleForm.submitType+""=="0"?a("div",[a("el-card",{directives:[{name:"loading",rawName:"v-loading",value:t.table_loading,expression:"table_loading"}],staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("产品列表")]),t._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}})]),t._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.productData,border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"productName",label:"产品名称"}}),t._v(" "),a("el-table-column",{attrs:{prop:"",label:"图片"},scopedSlots:t._u([{key:"default",fn:function(t){return[a("img",{staticClass:"image",staticStyle:{height:"30px",width:"30px"},attrs:{src:t.row.picUrls[0]}})]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"wenlidaima",label:"纹理代码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"productNum",label:"数量"}}),t._v(" "),a("el-table-column",{attrs:{prop:"price",label:"含税"}}),t._v(" "),a("el-table-column",{attrs:{prop:"price",label:"单价"}}),t._v(" "),a("el-table-column",{attrs:{prop:"area",label:"面积"}}),t._v(" "),a("el-table-column",{attrs:{prop:"price",label:"不含税价格"}}),t._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"300"},scopedSlots:t._u([{key:"default",fn:function(t){}}])})],1)],1)])],1):t._e(),t._v(" "),a("div",{staticStyle:{"margin-top":"20px","margin-bottom":"20px"}},[t.ruleForm.audit+""=="0"?a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.toAudit(1)}}},[t._v("通 过")]),t._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(e){t.toAudit(2)}}},[t._v("驳 回")])],1):t._e()]),t._v(" "),a("el-dialog",{attrs:{title:"驳回原因",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{attrs:{label:""}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.form.rejectRemark,callback:function(e){t.$set(t.form,"rejectRemark",e)},expression:"form.rejectRemark"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.toAudit2}},[t._v("提 交")]),t._v(" "),a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")])],1)],1)],1)],1)],1)])},staticRenderFns:[]},i=a("Z0/y")(r,o,!1,null,null,null);e.default=i.exports},FjOW:function(t,e){},VkyD:function(t,e){},bDna:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l={data:function(){return{activeName:"first",username:"",name:"",uid:"",tableLoading:!1,currentPage0:1,totalnum0:0,pagesize0:10,currentPage1:1,totalnum1:0,pagesize1:10,currentPage2:1,totalnum2:0,pagesize2:10,tableData0:[],tableData1:[],tableData2:[]}},methods:{toinfo:function(t){this.$router.push("/per/offer/info/"+t)},tongGuoShenHe:function(t){0==t.index?this.getCollectMouldList(0,this.currentPage0,this.pagesize0):1==t.index?this.getCollectMouldList(1,this.currentPage1,this.pagesize1):2==t.index&&this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},tableRowClassName:function(t){t.row,t.rowIndex;return"warning-row"},tableRowClassName1:function(t){t.row,t.rowIndex;return"success-row"},tableRowClassName2:function(t){t.row,t.rowIndex;return"error-row"},handleSizeChange0:function(t){this.pagesize0=t,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleCurrentChange0:function(t){this.currentPage0=t,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleSizeChange1:function(t){this.pagesize1=t,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleCurrentChange1:function(t){this.currentPage1=t,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleSizeChange2:function(t){this.pagesize2=t,this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},handleCurrentChange2:function(t){this.currentPage2=t,this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},getCollectMouldList1:function(t,e,a){var l=this;this.getRequest("/audit/bus/listbypage?page="+e+"&size="+a+"&audit=1").then(function(t){t&&200==t.status&&0==t.data.code&&(alert("dsd"),l.tableData1=t.data.data.auditbusbaojialist,l.totalnum1=t.data.data.count)})},getCollectMouldList:function(t,e,a){var l=this;this.getRequest("/audit/per/listbypage?page="+e+"&size="+a+"&audit="+t).then(function(e){e&&200==e.status&&0==e.data.code&&(0==t?(l.tableData0=e.data.data.audityubaojialist,l.totalnum0=e.data.data.count):1==t?(l.tableData1=e.data.data.audityubaojialist,l.totalnum1=e.data.data.count):2==t&&(l.tableData2=e.data.data.audityubaojialist,l.totalnum1=e.data.data.count))})}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList(0,1,10)}},r={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),t._v("商务报价审核")]),t._v(" "),a("el-breadcrumb-item",[t._v("审核记录")])],1)],1),t._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":t.tongGuoShenHe}},[a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("待审核")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData0,"row-class-name":t.tableRowClassName}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),t._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.audit+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.audit+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"费用合计",prop:"total"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toinfo(e.row.id)}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage0,"page-sizes":[10,30,80,100],"page-size":t.pagesize0,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum0},on:{"size-change":t.handleSizeChange0,"current-change":t.handleCurrentChange0}})],1)],1),t._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("已通过")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData1,"row-class-name":t.tableRowClassName1}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),t._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.audit+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.audit+""=="1"?a("el-tag",{attrs:{type:"success"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"费用合计",prop:"total"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toinfo(e.row.id)}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage1,"page-sizes":[10,30,80,100],"page-size":t.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum1},on:{"size-change":t.handleSizeChange1,"current-change":t.handleCurrentChange1}})],1)],1),t._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("未通过")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData2,"row-class-name":t.tableRowClassName2}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),t._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.audit+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.audit+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"费用合计",prop:"total"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toinfo(e.row.id)}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage2,"page-sizes":[10,30,80,100],"page-size":t.pagesize2,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum2},on:{"size-change":t.handleSizeChange2,"current-change":t.handleCurrentChange2}})],1)],1)],1)],1)])],1)],1)])},staticRenderFns:[]};var o=a("Z0/y")(l,r,!1,function(t){a("rIe9"),a("woUH")},"data-v-1c98fb1b",null);e.default=o.exports},bvDi:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l={data:function(){return{activeName:"first",username:"",name:"",uid:"",tableLoading:!1,currentPage0:1,totalnum0:0,pagesize0:10,currentPage1:1,totalnum1:0,pagesize1:10,currentPage2:1,totalnum2:0,pagesize2:10,tableData0:[],tableData1:[],tableData2:[]}},methods:{toinfo:function(t){this.$router.push("/bus/offer/info/"+t)},tongGuoShenHe:function(t){0==t.index?this.getCollectMouldList(0,this.currentPage0,this.pagesize0):1==t.index?this.getCollectMouldList(1,this.currentPage1,this.pagesize1):2==t.index&&this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},tableRowClassName:function(t){t.row,t.rowIndex;return"warning-row"},tableRowClassName1:function(t){t.row,t.rowIndex;return"success-row"},tableRowClassName2:function(t){t.row,t.rowIndex;return"error-row"},handleSizeChange0:function(t){this.pagesize0=t,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleCurrentChange0:function(t){this.currentPage0=t,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleSizeChange1:function(t){this.pagesize1=t,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleCurrentChange1:function(t){this.currentPage1=t,this.getCollectMouldList(1,this.currentPage1,this.pagesize1)},handleSizeChange2:function(t){this.pagesize2=t,this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},handleCurrentChange2:function(t){this.currentPage2=t,this.getCollectMouldList(2,this.currentPage2,this.pagesize2)},getCollectMouldList1:function(t,e,a){var l=this;this.getRequest("/audit/bus/listbypage?page="+e+"&size="+a+"&audit=1").then(function(t){t&&200==t.status&&0==t.data.code&&(alert("dsd"),l.tableData1=t.data.data.auditbusbaojialist,l.totalnum1=t.data.data.count)})},getCollectMouldList:function(t,e,a){var l=this;this.getRequest("/audit/bus/listbypage?page="+e+"&size="+a+"&audit="+t).then(function(e){e&&200==e.status&&0==e.data.code&&(0==t?(l.tableData0=e.data.data.auditbusbaojialist,l.totalnum0=e.data.data.count):1==t?(l.tableData1=e.data.data.auditbusbaojialist,l.totalnum1=e.data.data.count):2==t&&(l.tableData2=e.data.data.auditbusbaojialist,l.totalnum1=e.data.data.count))})}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList(0,1,10)}},r={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),t._v("商务报价审核")]),t._v(" "),a("el-breadcrumb-item",[t._v("审核记录")])],1)],1),t._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":t.tongGuoShenHe}},[a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("待审核")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData0,"row-class-name":t.tableRowClassName}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),t._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.audit+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.audit+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"费用合计",prop:"total"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toinfo(e.row.id)}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage0,"page-sizes":[10,30,80,100],"page-size":t.pagesize0,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum0},on:{"size-change":t.handleSizeChange0,"current-change":t.handleCurrentChange0}})],1)],1),t._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("已通过")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData1,"row-class-name":t.tableRowClassName1}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),t._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.audit+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.audit+""=="1"?a("el-tag",{attrs:{type:"success"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"费用合计",prop:"total"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toinfo(e.row.id)}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage1,"page-sizes":[10,30,80,100],"page-size":t.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum1},on:{"size-change":t.handleSizeChange1,"current-change":t.handleCurrentChange1}})],1)],1),t._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[t._v("未通过")])]),t._v(" "),a("el-table",{attrs:{data:t.tableData2,"row-class-name":t.tableRowClassName2}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),t._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),t._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.audit+""=="0"?a("el-tag",{attrs:{type:"primary"}},[t._v("待审核")]):t._e(),t._v(" "),e.row.audit+""=="1"?a("el-tag",{attrs:{type:"info"}},[t._v("审核通过")]):t._e(),t._v(" "),e.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[t._v("驳回")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"费用合计",prop:"total"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("formatDateTime")(e.row.createTime)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){t.toinfo(e.row.id)}}},[t._v("详情")])]}}])})],1),t._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":t.currentPage2,"page-sizes":[10,30,80,100],"page-size":t.pagesize2,layout:"total,sizes, prev, pager, next, jumper",total:t.totalnum2},on:{"size-change":t.handleSizeChange2,"current-change":t.handleCurrentChange2}})],1)],1)],1)],1)])],1)],1)])},staticRenderFns:[]};var o=a("Z0/y")(l,r,!1,function(t){a("FjOW"),a("VkyD")},"data-v-b1f40410",null);e.default=o.exports},dkuB:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l=a("OIbc"),r=(a("+J3q"),{components:{VueCoreImageUpload:l.default},props:{title:String},data:function(){return{remarks:[],urlId:"",dialogFormVisible:!1,table_loading:!1,imageUrls:[],ruleForm:{tax:"17",addUserId:"",addUserName:""},form:{},elform:{productNum:"0",area:"0",dongMo:!1,price:"0",coefficient:""},productData:[],innerVisible:!1,tableData:[],select_word:"",nowTab:1}},methods:{splitUrl:function(t){var e=t.picUrls,a=[];return"undefined"!=e&&""!=e&&(a=e.split("|")),a},toAudit2:function(){var t=this,e={id:this.urlId,audit:2,addUserId:this.ruleForm.addUserId,auditId:this.uid,auditName:this.name,rejectRemark:this.form.rejectRemark};this.postRequest("/audit/bus/check",e).then(function(e){e&&200==e.status&&0==e.data.code?(t.$message.success("执行成功"),t.$store.state.stomp.send("/ws/nf",{},""),t.$router.push("/audit/bus")):t.$message.error("执行失败")})},toAudit:function(t){var e=this,a={id:this.urlId,audit:t,addUserId:this.ruleForm.addUserId,auditId:this.uid,auditName:this.name,rejectRemark:{}};2!==t?this.postRequest("/audit/bus/check",a).then(function(t){t&&200==t.status&&0==t.data.code?(e.$message.success("执行成功"),e.$store.state.stomp.send("/ws/nf",{},""),e.$router.push("/audit/bus")):e.$message.error("执行失败")}):this.dialogFormVisible=!0},getInfo:function(t){var e=this,a=this;this.getRequest("/audit/bus/info?id="+t).then(function(t){if(t&&200==t.status&&0==t.data.code){a.ruleForm=t.data.data.businfo;var l=t.data.data.businfo.businessProductList,r=t.data.data.businfo.rejectRemark,o=e.$options.filters.splitRejectRemark;if(e.remarks=o(r),"undefined"!=a.product&&l.length>0){for(var i=[],s=0;s<l.length;s++){var n,u={};u=l[s],n=a.splitUrl(l[s]),u.picUrls=n,i.push(u)}a.productData=i}}else a.$message.error("获取失败")})},resetForm:function(t){this.$refs[t].resetFields()}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},created:function(){this.urlId=this.$route.params.id,this.getInfo(this.urlId)}}),o={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),t._v("预报价单")]),t._v(" "),a("el-breadcrumb-item",[t._v("预报价详情")])],1)],1),t._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[t.ruleForm.audit+""=="2"?a("div",[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("span",[t._v("驳回原因：")]),t._v(" "),a("div",{staticStyle:{"margin-top":"20px"}},t._l(t.remarks,function(t){return a("div",[a("el-alert",{attrs:{title:t,type:"warning",closable:!1}})],1)}))])],1):t._e(),t._v(" "),a("div",[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",staticStyle:{width:"40%"},attrs:{model:t.ruleForm,"label-width":"110px"}},[a("div",[a("el-form-item",{attrs:{label:"客户单位：",prop:"clientCompanyName"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.clientCompanyName,callback:function(e){t.$set(t.ruleForm,"clientCompanyName",e)},expression:"ruleForm.clientCompanyName"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"联系人：",prop:"contactPerson"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.contactPerson,callback:function(e){t.$set(t.ruleForm,"contactPerson",e)},expression:"ruleForm.contactPerson"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"联系电话：",prop:"contactPhone"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.contactPhone,callback:function(e){t.$set(t.ruleForm,"contactPhone",e)},expression:"ruleForm.contactPhone"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"车型：",prop:"carType"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.carType,callback:function(e){t.$set(t.ruleForm,"carType",e)},expression:"ruleForm.carType"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"不含税价格：",prop:"carType"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.noTaxTotal,callback:function(e){t.$set(t.ruleForm,"noTaxTotal",e)},expression:"ruleForm.noTaxTotal"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"税率：",prop:"tax"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0,disabled:!0},model:{value:t.ruleForm.tax,callback:function(e){t.$set(t.ruleForm,"tax",e)},expression:"ruleForm.tax"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"含税价格：",prop:"carType"}},[a("el-input",{attrs:{disabled:!0},model:{value:t.ruleForm.total,callback:function(e){t.$set(t.ruleForm,"total",e)},expression:"ruleForm.total"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",disabled:!0},model:{value:t.ruleForm.remark,callback:function(e){t.$set(t.ruleForm,"remark",e)},expression:"ruleForm.remark"}})],1)],1),t._v(" "),t.ruleForm.submitType+""=="1"?a("el-form-item",{attrs:{label:"下载原文件",prop:"remark"}},[[a("a",{staticStyle:{color:"blue"},attrs:{href:t.ruleForm.fuJianUrl,download:"w3logo"}},[t._v("下载原文件")])]],2):t._e()],1),t._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}})],1)],1),t._v(" "),t.ruleForm.submitType+""=="0"?a("div",[a("el-card",{directives:[{name:"loading",rawName:"v-loading",value:t.table_loading,expression:"table_loading"}],staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("产品列表")]),t._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}})]),t._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.productData,border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"productName",label:"产品名称"}}),t._v(" "),a("el-table-column",{attrs:{prop:"",label:"图片"},scopedSlots:t._u([{key:"default",fn:function(t){return[a("img",{staticClass:"image",staticStyle:{height:"30px",width:"30px"},attrs:{src:t.row.picUrls[0]}})]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"wenlidaima",label:"纹理代码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"productNum",label:"数量"}}),t._v(" "),a("el-table-column",{attrs:{prop:"price",label:"含税"}}),t._v(" "),a("el-table-column",{attrs:{prop:"price",label:"单价"}}),t._v(" "),a("el-table-column",{attrs:{prop:"area",label:"面积"}}),t._v(" "),a("el-table-column",{attrs:{prop:"price",label:"不含税价格"}}),t._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"300"},scopedSlots:t._u([{key:"default",fn:function(t){}}])})],1)],1)])],1):t._e(),t._v(" "),a("div",{staticStyle:{"margin-top":"20px","margin-bottom":"20px"}},[t.ruleForm.audit+""=="0"?a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.toAudit(1)}}},[t._v("通 过")]),t._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(e){t.toAudit(2)}}},[t._v("驳 回")])],1):t._e()]),t._v(" "),a("el-dialog",{attrs:{title:"驳回原因",visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{attrs:{model:t.form}},[a("el-form-item",{attrs:{label:""}},[a("el-input",{attrs:{type:"textarea"},model:{value:t.form.rejectRemark,callback:function(e){t.$set(t.form,"rejectRemark",e)},expression:"form.rejectRemark"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.toAudit2}},[t._v("提 交")]),t._v(" "),a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")])],1)],1)],1)],1)],1)])},staticRenderFns:[]},i=a("Z0/y")(r,o,!1,null,null,null);e.default=i.exports},o8cx:function(t,e,a){var l={"./AuditBus.vue":"bvDi","./AuditPer.vue":"bDna","./BusBaoJiaInfo.vue":"dkuB","./PerBaoJiaInfo.vue":"EKkj"};function r(t){return a(o(t))}function o(t){var e=l[t];if(!(e+1))throw new Error("Cannot find module '"+t+"'.");return e}r.keys=function(){return Object.keys(l)},r.resolve=o,t.exports=r,r.id="o8cx"},rIe9:function(t,e){},woUH:function(t,e){}});
//# sourceMappingURL=5.cfacf681a7da56e9c843.js.map
webpackJsonp([20],{fd1C:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={data:function(){return{username:"",name:"",uid:"",showTab:1,tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/material/record/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.wuliaolist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.wuLiaoName.indexOf(e.select_word)>-1||t.orderName.indexOf(e.select_word)>-1)return t})}}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("备料管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("下单记录")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.data,border:""}},[a("el-table-column",{attrs:{prop:"orderName",label:"产品名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"wuLiaoName",label:"纹理编号"}}),e._v(" "),a("el-table-column",{attrs:{prop:"wenliChengCi",label:"花纹层次"}}),e._v(" "),a("el-table-column",{attrs:{prop:"wuLiaoNum",label:"数量(张)"}}),e._v(" "),a("el-table-column",{attrs:{prop:"liaoJiang",label:"料浆"}}),e._v(" "),a("el-table-column",{attrs:{prop:"status",label:"备料进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.status+""=="0"?a("el-tag",[e._v("备料中")]):e._e(),e._v(" "),t.row.status+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("待领取")]):e._e(),e._v(" "),t.row.status+""=="2"?a("el-tag",{attrs:{type:"warning"}},[e._v("完成")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"下单时间"}}),e._v(" "),a("el-table-column",{attrs:{prop:"haveTime",label:"完结时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.haveTime+""==""||t.row.haveTime+""=="null"?a("el-tag",[e._v("进行中")]):e._e(),e._v(" "),t.row.haveTime+""!=""&&t.row.haveTime+""!="null"?a("el-tag",{attrs:{type:"danger"}},[e._v(e._s(t.row.haveTime))]):e._e()]}}])})],1)],1)])],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var l=a("Z0/y")(r,i,!1,function(e){a("oVxV")},"data-v-0a7d14fa",null);t.default=l.exports},linb:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={data:function(){return{addLoading:!1,dialogFormVisible:!0,checkLoading:!1,itemOrder:{},restaurants3:[],itemUser:{userId:"",userName:""},reform:{},form:{orderId:"",wuLiaoNum:"1",wuLiaoName:"",wenliChengCi:"",liaoJiang:"",remark:"",songTime:new Date,yinTime:new Date},rules:{wuLiaoName:[{required:!0,message:"请输入订单名称",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],wenliChengCi:[{required:!0,message:"请输入纹理层次",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],liaoJiang:[{required:!0,message:"请输入浆料",trigger:"blur"}],songTime:[{required:!0,message:"请输入送单时间",trigger:"blur"}],yinTime:[{required:!0,message:"请输入印花时间",trigger:"blur"}]}}},methods:{toadd:function(){this.$router.push("/offer/per/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},checkUserInfo:function(){var e=this,t=this;t.checkLoading=!0,this.postRequest("/login",t.reform).then(function(a){t.checkLoading=!1,a&&200==a.status?(t.dialogFormVisible=!1,t.itemUser.userId=a.data.msg.id,t.itemUser.userName=a.data.msg.name,e.getOrderList()):t.$message.error("验证失败,请重新验证")})},resetForm:function(e){this.$refs[e].resetFields()},addWuLiao:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return console.log("提交数据格式有误"),!1;a.form.addUserId=t.uid,a.form.addUserName=t.name,a.form.orderName=t.itemOrder.label,a.form.orderId=t.itemOrder.value,a.form.orderId+""!=""&&a.form.orderId+""!="undefined"?(a.addLoading=!0,t.postRequest("/material/apply",a.form).then(function(e){a.addLoading=!1,e&&200==e.status&&0==e.data.code?(a.$message.success("添加成功"),a.resetForm("form")):a.$message.error("添加失败")})):a.$message.error("请选择有效的订单!")})},handleChange:function(e){},getOrderList:function(){var e=this;this.getRequest("/material/apply/order/list?userId="+e.uid).then(function(t){if(t&&200==t.status&&0==t.data.code){for(var a=[],r=t.data.data,i=0;i<r.length;i++){var l={label:"",value:""};l.label=r[i].orderName,l.value=r[i].orderId,a.push(l)}e.restaurants3=a}else console.log("获取列表数据失败")})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getOrderList()}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("物料单管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("下物料单")])],1)],1),e._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("物料单信息")])]),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.addLoading,expression:"addLoading"}]},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"所属订单：",prop:"orderId"}},[a("el-select",{attrs:{placeholder:"请选择所属订单",required:""},model:{value:e.itemOrder,callback:function(t){e.itemOrder=t},expression:"itemOrder"}},e._l(e.restaurants3,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"纹理编号：",prop:"wuLiaoName"}},[a("el-input",{staticStyle:{width:"40%"},model:{value:e.form.wuLiaoName,callback:function(t){e.$set(e.form,"wuLiaoName",t)},expression:"form.wuLiaoName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"花纹层次：",prop:"wenliChengCi"}},[a("el-input",{staticStyle:{width:"40%"},model:{value:e.form.wenliChengCi,callback:function(t){e.$set(e.form,"wenliChengCi",t)},expression:"form.wenliChengCi"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"数量：",prop:"wuLiaoNum"}},[a("el-input-number",{attrs:{"controls-position":"right",min:1},on:{change:e.handleChange},model:{value:e.form.wuLiaoNum,callback:function(t){e.$set(e.form,"wuLiaoNum",t)},expression:"form.wuLiaoNum"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"料浆：",prop:"liaoJiang"}},[a("el-input",{staticStyle:{width:"40%"},model:{value:e.form.liaoJiang,callback:function(t){e.$set(e.form,"liaoJiang",t)},expression:"form.liaoJiang"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"送单时间：",prop:"songTime"}},[a("el-date-picker",{staticStyle:{width:"40%"},attrs:{format:"yyyy 年 MM 月 dd 日 HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime",placeholder:"选择日期时间"},model:{value:e.form.songTime,callback:function(t){e.$set(e.form,"songTime",t)},expression:"form.songTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"印料时间：",prop:"yinTime"}},[a("el-date-picker",{staticStyle:{width:"40%"},attrs:{format:"yyyy 年 MM 月 dd 日 HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime",placeholder:"选择日期时间"},model:{value:e.form.yinTime,callback:function(t){e.$set(e.form,"yinTime",t)},expression:"form.yinTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[a("el-input",{staticStyle:{width:"40%"},attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"card-bottom"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.addWuLiao("form")}}},[e._v("提 交")]),e._v(" "),a("el-button",{on:{click:function(t){e.resetForm("form")}}},[e._v("重置")])],1)])],1)])],1)],1)])},staticRenderFns:[]};var l=a("Z0/y")(r,i,!1,function(e){a("zqLt")},"data-v-b36a4d50",null);t.default=l.exports},oVxV:function(e,t){},rbIw:function(e,t,a){var r={"./MaterialApply.vue":"linb","./MaterialRecord.vue":"fd1C"};function i(e){return a(l(e))}function l(e){var t=r[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}i.keys=function(){return Object.keys(r)},i.resolve=l,e.exports=i,i.id="rbIw"},zqLt:function(e,t){}});
//# sourceMappingURL=20.6676960c16a5b79b7f51.js.map
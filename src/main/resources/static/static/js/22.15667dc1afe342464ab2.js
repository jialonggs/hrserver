webpackJsonp([22],{"0xga":function(e,t){},"5m8/":function(e,t,a){var r={"./YaoList.vue":"vChM"};function n(e){return a(l(e))}function l(e){var t=r[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}n.keys=function(){return Object.keys(r)},n.resolve=l,e.exports=n,n.id="5m8/"},siqs:function(e,t){},vChM:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("OIbc"),n=a("+J3q"),l={components:{VueCoreImageUpload:r.default},data:function(){return{ceshi:"1222",ceshi2:"ewew",upload:"",dialogFormVisible:!1,add_yaojian_loading:!1,imageData:{userId:"123",imgPakage:"yao_jian"},wen_jian_url:"",form:{fileUrl:"",orderId:"",remark:"",addUserId:"",addUserName:""},activeName:"first",username:"",name:"",uid:"",tableLoading:!1,currentPage0:1,totalnum0:0,pagesize0:10,currentPage1:1,totalnum1:0,pagesize1:10,currentPage2:1,totalnum2:0,pagesize2:10,tableData0:[],tableData1:[],tableData2:[]}},methods:{tongGuoShenHe:function(e){0==e.index?this.getCollectMouldList(!1,this.currentPage0,this.pagesize0):this.getAdded(this.currentPage1,this.pagesize1)},tableRowClassName:function(e){e.row,e.rowIndex;return"warning-row"},tableRowClassName1:function(e){e.row,e.rowIndex;return"success-row"},tableRowClassName2:function(e){e.row,e.rowIndex;return"error-row"},handleSizeChange0:function(e){this.pagesize0=e,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleCurrentChange0:function(e){this.currentPage0=e,this.getCollectMouldList(0,this.currentPage0,this.pagesize0)},handleSizeChange1:function(e){this.pagesize1=e,this.getAdded(this.currentPage1,this.pagesize1)},handleCurrentChange1:function(e){this.currentPage1=e,this.getAdded(this.currentPage1,this.pagesize1)},toAdd:function(e){this.dialogFormVisible=!0,this.form.orderId=e.id},addYaoJian:function(){var e=this;"undefined"!=e.wen_jian_url&&""!=e.wen_jian_url?(e.add_yaojian_loading=!0,e.form.addUserId=this.uid,e.form.addUserName=this.name,e.form.fileUrl=this.wen_jian_url,this.postRequest("/yao/list/add",e.form).then(function(t){e.add_yaojian_loading=!1,t&&200==t.status&&0==t.data.code?(e.$message.success("添加成功"),e.wen_jian_url="",e.form.remark="",e.dialogFormVisible=!1,e.getCollectMouldList(!1,e.currentPage0,e.pagesize0)):e.$message.error("添加失败")})):e.$message.error("请先上传文件")},getCollectMouldList:function(e,t,a){var r=this;this.getRequest("/yao/list/listbypage?page="+t+"&size="+a+"&yaoJian="+e).then(function(t){t&&200==t.status&&0==t.data.code&&(e?e&&(r.tableData1=t.data.data.yaolist,r.totalnum1=t.data.data.count):(r.tableData0=t.data.data.yaolist,r.totalnum0=t.data.data.count))})},getAdded:function(e,t){var a=this;this.getRequest("/yao/list/added?page="+e+"&size="+t).then(function(e){e&&200==e.status&&0==e.data.code&&(console.log(e),a.tableData1=e.data.data.yaolist,a.totalnum1=e.data.data.count)})},imageuploaded:function(e){this.$message.success("上传成功");var t;"undefinded"!=(t=e.url)&&t.length>0&&(this.wen_jian_url=t[0])},handleError:function(){this.$notify.error({title:"上传失败",message:"图片上传出现异常"})}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.upload=n.a.upload,this.getCollectMouldList(!1,1,10)}},o={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("药检管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("药检记录")])],1)],1),e._v(" "),a("el-container",[a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-tabs",{attrs:{type:"border-card"},on:{"tab-click":e.tongGuoShenHe}},[a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("待提交")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData0,"row-class-name":e.tableRowClassName}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"负责人",prop:"addUserName"}}),e._v(" "),a("el-table-column",{attrs:{label:"紧急程度",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.urgency+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("不急")]):e._e(),e._v(" "),t.row.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("正常")]):e._e(),e._v(" "),t.row.urgency+""=="2"?a("el-tag",{attrs:{type:"primary"}},[e._v("急C")]):e._e(),e._v(" "),t.row.urgency+""=="3"?a("el-tag",{attrs:{type:"danger"}},[e._v("急B")]):e._e(),e._v(" "),t.row.urgency+""=="4"?a("el-tag",{attrs:{type:"primary"}},[e._v("急A")]):e._e(),e._v(" "),t.row.urgency+""=="5"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急C")]):e._e(),e._v(" "),t.row.urgency+""=="6"?a("el-tag",{attrs:{type:"primary"}},[e._v("紧急B")]):e._e(),e._v(" "),t.row.urgency+""=="7"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急A")]):e._e(),e._v(" "),t.row.urgency+""=="8"?a("el-tag",{attrs:{type:"danger"}},[e._v("特急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.toAdd(t.row)}}},[e._v("提交药检报告")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage0,"page-sizes":[10,30,80,100],"page-size":e.pagesize0,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum0},on:{"size-change":e.handleSizeChange0,"current-change":e.handleCurrentChange0}})],1)],1),e._v(" "),a("el-tab-pane",[a("span",{attrs:{slot:"label"},slot:"label"},[a("i",{staticClass:"el-icon-date"},[e._v("已提交")])]),e._v(" "),a("el-table",{attrs:{data:e.tableData1,"row-class-name":e.tableRowClassName1}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"负责人",prop:"addUserName"}}),e._v(" "),a("el-table-column",{attrs:{label:"紧急程度",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.urgency+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("不急")]):e._e(),e._v(" "),t.row.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("正常")]):e._e(),e._v(" "),t.row.urgency+""=="2"?a("el-tag",{attrs:{type:"primary"}},[e._v("急C")]):e._e(),e._v(" "),t.row.urgency+""=="3"?a("el-tag",{attrs:{type:"danger"}},[e._v("急B")]):e._e(),e._v(" "),t.row.urgency+""=="4"?a("el-tag",{attrs:{type:"primary"}},[e._v("急A")]):e._e(),e._v(" "),t.row.urgency+""=="5"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急C")]):e._e(),e._v(" "),t.row.urgency+""=="6"?a("el-tag",{attrs:{type:"primary"}},[e._v("紧急B")]):e._e(),e._v(" "),t.row.urgency+""=="7"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急A")]):e._e(),e._v(" "),t.row.urgency+""=="8"?a("el-tag",{attrs:{type:"danger"}},[e._v("特急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("a",{staticStyle:{color:"blue"},attrs:{href:t.row.fileUrl,download:""}},[e._v("下载文件")])]}}])})],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage1,"page-sizes":[10,30,80,100],"page-size":e.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum1},on:{"size-change":e.handleSizeChange1,"current-change":e.handleCurrentChange1}})],1)],1)],1)],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.add_yaojian_loading,expression:"add_yaojian_loading"}],attrs:{title:"药检信息",visible:e.dialogFormVisible,width:"50%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"上传文件："}},[a("div",{directives:[{name:"show",rawName:"v-show",value:""!==e.wen_jian_url,expression:"wen_jian_url !== ''"}]},[a("p",{staticStyle:{color:"blue"}},[e._v("上传成功")])]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:""===e.wen_jian_url,expression:"wen_jian_url === ''"}]},[a("vue-core-image-upload",{class:["el-button","el-button--primary"],attrs:{crop:!1,inputOfFile:"imageFile",url:e.upload,extensions:"png,ppt,docx,txt,xlsx,pdf","max-file-size":5242880,data:e.imageData,text:"上传文件",multiple:!0,"multiple-size":30,credentials:"true"},on:{imageuploaded:e.imageuploaded,errorhandle:e.handleError}})],1)]),e._v(" "),a("el-form-item",{attrs:{label:"备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.addYaoJian()}}},[e._v("提 交")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")])],1)])],1)],1)],1)])},staticRenderFns:[]};var i=a("Z0/y")(l,o,!1,function(e){a("0xga"),a("siqs")},"data-v-30e4718c",null);t.default=i.exports}});
//# sourceMappingURL=22.15667dc1afe342464ab2.js.map
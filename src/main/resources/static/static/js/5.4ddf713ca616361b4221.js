webpackJsonp([5],{"21AK":function(e,t,a){var r={"./OfferBus.vue":"IyNY","./OfferBusAdd.vue":"hgxk","./OfferPer.vue":"K2PY","./OfferPerAdd.vue":"hBiO"};function l(e){return a(i(e))}function i(e){var t=r[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}l.keys=function(){return Object.keys(r)},l.resolve=i,e.exports=l,l.id="21AK"},IyNY:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={data:function(){return{username:"",name:"",uid:"",showTab:1,tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{toadd:function(){this.$router.push("/offer/bus/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/offer/bus/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.busbaojialist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1==e.showTab,expression:"showTab ==1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("商务报价")]),e._v(" "),a("el-breadcrumb-item",[e._v("商务报价列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:e.toadd}},[e._v("增添商务价单")]),e._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),e._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.audit+""=="0"?a("el-tag",{attrs:{type:"info"}},[e._v("审核中")]):e._e(),e._v(" "),t.row.audit+""=="1"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[e._v("驳回")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"税前合计",prop:"noTaxTotal"}}),e._v(" "),a("el-table-column",{attrs:{label:"税率",prop:"tax"}}),e._v(" "),a("el-table-column",{attrs:{label:"含税合计",prop:"total"}}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1)],1)])],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var i=a("Z0/y")(r,l,!1,function(e){a("ZPQj")},"data-v-68d22c86",null);t.default=i.exports},K2PY:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={data:function(){return{username:"",name:"",uid:"",showTab:1,tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{toadd:function(){this.$router.push("/offer/per/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/offer/per/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.yubaojialist,console.log(e.tableData),e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1==e.showTab,expression:"showTab ==1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("预报价")]),e._v(" "),a("el-breadcrumb-item",[e._v("预报价列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:e.toadd}},[e._v("增添预报价单")]),e._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),e._v(" "),a("el-table-column",{attrs:{label:"车型",prop:"carType"}}),e._v(" "),a("el-table-column",{attrs:{label:"审核状态",prop:"aduit"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.audit+""=="0"?a("el-tag",{attrs:{type:"info"}},[e._v("审核中")]):e._e(),e._v(" "),t.row.audit+""=="1"?a("el-tag",{attrs:{type:"success"}},[e._v("通过")]):e._e(),e._v(" "),t.row.audit+""=="2"?a("el-tag",{attrs:{type:"danger"}},[e._v("驳回")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"税前合计",prop:"noTaxTotal"}}),e._v(" "),a("el-table-column",{attrs:{label:"税率",prop:"tax"}}),e._v(" "),a("el-table-column",{attrs:{label:"含税合计",prop:"total"}}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详情")])]}}])})],1)],1)])],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var i=a("Z0/y")(r,l,!1,function(e){a("z9bd")},"data-v-5656cdc8",null);t.default=i.exports},ZPQj:function(e,t){},hBiO:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("3cXf"),l=a.n(r),i=a("OIbc"),o=(a("+J3q"),{components:{VueCoreImageUpload:i.default},props:{title:String},data:function(){return{upload:"http://39.107.78.95:8082/jlmanager/comm/upload/image",udapteBoolean:!1,itemIndex:"",itemRow:{},imageData:{userId:"",imgPakage:"order_pm"},table_loading:!1,imageUrls:[],ruleForm:{tax:"16",addUserId:"",addUserName:""},elform:{productNum:"0",area:"0",dongMo:!1,price:"0",coefficient:""},productData:[],restaurants3:[],innerVisible:!1,tableData:[],select_word:"",nowTab:1,rules:{productName:[{required:!0,message:"请输入产品名称",trigger:"blur"},{min:0,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],wenlidaima:[{required:!0,message:"请输入纹理代码",trigger:"blur"},{min:0,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],carType:[{required:!0,message:"请输入车型",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],clientCompanyName:[{required:!0,message:"请输入客户单位",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],contactPerson:[{required:!0,message:"请输入预报价单名称",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],contactPhone:[{required:!0,message:"请输入联系人电话",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],paytype:[{required:!0,message:"请输入付款方式",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],deliverytime:[{required:!0,message:"请输入加工周期",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],remark:[{min:0,max:2048,message:"长度在 0 到 2048 个字符",trigger:"blur"}]}}},methods:{toAadd:function(){this.innerVisible=!0,this.udapteBoolean=!1,this.resetForm("elform")},chanel:function(){this.innerVisible=!1,this.udapteBoolean=!1},commit:function(){var e=this.productData;"undefined"==e||e.length<=0?this.$message.error("请添加产品详情"):this.addYuBaoJia()},addYuBaoJia:function(){var e=this,t=this,a=t.ruleForm;a.addUserId=this.uid,a.addUserName=this.name,this.postRequest("/offer/per/add",a).then(function(a){if(a&&200==a.status&&0==a.data.code){var r=a.data.data.id;r>0?e.addProduct(r):t.$message.error("添加基础信息失败")}else t.$message.error("添加基础信息失败")})},addProduct:function(e){var t=this;this.table_loading=!0;for(var a=this,r=a.productData,i="",o=0;o<r.length;o++){var s=r[o];s.addUserId=this.uid,s.addUserName=this.name,s.yuBaoJiaId=e,s.picUrls=this.toPinjieUrl(s.picUrls),i=i+l()(s)+"|"}var n={yuBaoJiaId:e,yuProducts:i};this.postRequest("/offer/per/add/product",n).then(function(e){t.table_loading=!1,e&&200==e.status&&0==e.data.code?(a.$message.success("添加成功"),t.$router.push("/offer/per/list")):a.$message.error("添加失败")})},deleteRow:function(e,t){t.splice(e,1)},toPinjieUrl:function(e){var t="";if("undefined"==e||e.length<=0)return t;for(var a=0;a<e.length;a++)(a=e.length-1)?t+=e[a]:t=t+e[a]+",";return t},toEidtor:function(e,t){this.udapteBoolean=!0;var a;a=t,this.itemRow=a[e],this.elform=this.itemRow,this.itemIndex=e,this.innerVisible=!0},toUpdateProduct:function(){for(var e=this.elform.price*this.elform.productNum*(this.ruleForm.tax/100+1),t={yuBaoJiaId:"",productName:this.elform.productName,wenlidaima:this.elform.wenlidaima,productNum:this.elform.productNum,area:this.elform.area,dongMo:this.elform.dongMo,coefficient:this.elform.coefficient,price:this.elform.price,picUrls:this.imageUrls,tax:this.ruleForm.tax,taxPrice:this.elform.price*this.elform.productNum,total:e,immutable:!1,addUserId:this.uid,addUserName:this.name},a=[],r=0;r<this.productData.length;r++)r==this.itemIndex?a.push(t):a.push(this.productData[r]);this.$nextTick(function(){this.productData=a}),this.imageUrls=[],this.resetForm("elform"),this.innerVisible=!1},toAddProduct:function(){var e=this.elform.price*this.elform.productNum*(this.ruleForm.tax/100+1),t={yuBaoJiaId:"",productName:this.elform.productName,wenlidaima:this.elform.wenlidaima,productNum:this.elform.productNum,area:this.elform.area,dongMo:this.elform.dongMo,coefficient:this.elform.coefficient,price:this.elform.price,picUrls:this.imageUrls,tax:this.ruleForm.tax,noTaxPrice:this.elform.price*this.elform.productNum,total:e,immutable:!1,addUserId:this.uid,addUserName:this.name};this.productData.push(t),this.imageUrls=[],this.resetForm("elform"),this.innerVisible=!1},resetForm:function(e){this.$refs[e].resetFields()},submitForm:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;t.nowTab=2})},imageuploaded:function(e){if("undefined"!==e.url.length&&e.url.length>0){for(var t=e.url,a=this.imageUrls,r=0;r<t.length;r++)a.push(t[r]);this.imageUrls=a}},delMouldImage:function(e){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.todelImage(e)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},todelImage:function(e){var t=this;"undefined"!=e&&""!=e.length?this.getRequest("/config/delfile/delImage?url="+e).then(function(a){if(a&&200==a.status&&0==a.data.code){t.$message.success("删除成功");for(var r=t.imageUrls,l=[],i=0;i<r.length;i++)e!=r[i]&&l.push(r[i]);t.imageUrls=l}else t.$message.error("删除照片失败")}):t.$message.error("删除图片不存在")},loadAllProject:function(){var e=this;this.getRequest("/offer/per/list/project?addUserId="+this.uid).then(function(t){if(t&&200==t.status&&0==t.data.code){var a=[],r=t.data.data.projectlist;if("undefined"!=r&&r.length>0){for(var l=0;l<r.length;l++){var i={label:"",value:""};i.label=r[l].projectName,i.value=r[l].id,a.push(i)}e.restaurants3=a}}else console.log("获取列表数据失败")})},handleError:function(){this.$notify.error({title:"上传失败",message:"图片上传出现异常"})}},mounted:function(){this.$nextTick(function(){this.imageData.userId=this.uid=localStorage.getItem("cp_uid")}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.loadAllProject()},computed:{}}),s={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("预报价单")]),e._v(" "),a("el-breadcrumb-item",[e._v("添加预报价单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{"align-items":"center","margin-top":"40px"}},[a("el-steps",{attrs:{active:e.nowTab}},[a("el-step",{attrs:{title:"基本信息",icon:"el-icon-edit"}}),e._v(" "),a("el-step",{attrs:{title:"报价详情",icon:"el-icon-document"}})],1)],1),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("div",{directives:[{name:"show",rawName:"v-show",value:1==e.nowTab,expression:"nowTab==1"}]},[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",staticStyle:{width:"40%"},attrs:{model:e.ruleForm,rules:e.rules,"label-width":"110px"}},[a("div",[a("el-form-item",{attrs:{label:"所属项目：",prop:"projectId",required:""}},[a("el-select",{attrs:{placeholder:"请选择所属项目"},model:{value:e.ruleForm.projectId,callback:function(t){e.$set(e.ruleForm,"projectId",t)},expression:"ruleForm.projectId"}},e._l(e.restaurants3,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"客户单位：",prop:"clientCompanyName"}},[a("el-input",{model:{value:e.ruleForm.clientCompanyName,callback:function(t){e.$set(e.ruleForm,"clientCompanyName",t)},expression:"ruleForm.clientCompanyName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"联系人：",prop:"contactPerson"}},[a("el-input",{model:{value:e.ruleForm.contactPerson,callback:function(t){e.$set(e.ruleForm,"contactPerson",t)},expression:"ruleForm.contactPerson"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"联系电话：",prop:"contactPhone"}},[a("el-input",{model:{value:e.ruleForm.contactPhone,callback:function(t){e.$set(e.ruleForm,"contactPhone",t)},expression:"ruleForm.contactPhone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"车型：",prop:"carType"}},[a("el-input",{model:{value:e.ruleForm.carType,callback:function(t){e.$set(e.ruleForm,"carType",t)},expression:"ruleForm.carType"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"税率：",prop:"tax"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.ruleForm.tax,callback:function(t){e.$set(e.ruleForm,"tax",t)},expression:"ruleForm.tax"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.ruleForm.remark,callback:function(t){e.$set(e.ruleForm,"remark",t)},expression:"ruleForm.remark"}})],1)],1)]),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm("ruleForm")}}},[e._v("下一步")])],1)],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:2==e.nowTab,expression:"nowTab==2"}]},[a("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.table_loading,expression:"table_loading"}],staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("产品列表")]),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{staticClass:"el-icon-plus",attrs:{type:"primary"},on:{click:e.toAadd}},[e._v("添加")])],1)]),e._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.productData,border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"productName",label:"产品名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"",label:"图片"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("img",{staticClass:"image",staticStyle:{height:"30px",width:"30px"},attrs:{src:e.row.picUrls[0]}})]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"wenlidaima",label:"纹理代码"}}),e._v(" "),a("el-table-column",{attrs:{prop:"price",label:"单价"}}),e._v(" "),a("el-table-column",{attrs:{prop:"productNum",label:"数量"}}),e._v(" "),a("el-table-column",{attrs:{prop:"noTaxPrice",label:"不含税总计"}}),e._v(" "),a("el-table-column",{attrs:{prop:"total",label:"含税总计"}}),e._v(" "),a("el-table-column",{attrs:{prop:"area",label:"面积"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"300"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.toEidtor(t.$index,e.productData)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.deleteRow(t.$index,e.productData)}}},[e._v("\r\n         移除\r\n       ")])]}}])})],1)],1),e._v(" "),a("div",{staticStyle:{"margin-top":"20px","margin-bottom":"20px"}},[a("div",{staticClass:"card-bottom",staticStyle:{float:"left"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.nowTab=1}}},[e._v("上一步")])],1),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:e.commit}},[e._v("提 交")])],1)])])],1),e._v(" "),a("div",[a("el-dialog",{attrs:{width:"60%",title:"产品详情",visible:e.innerVisible,"close-on-click-modal":!1,"append-to-body":""},on:{"update:visible":function(t){e.innerVisible=t}}},[a("el-form",{ref:"elform",staticStyle:{width:"100%"},attrs:{model:e.elform,rules:e.rules,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"产品名称：",prop:"productName"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入产品名称"},model:{value:e.elform.productName,callback:function(t){e.$set(e.elform,"productName",t)},expression:"elform.productName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"纹理代码：",prop:"wenlidaima"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入纹理代码"},model:{value:e.elform.wenlidaima,callback:function(t){e.$set(e.elform,"wenlidaima",t)},expression:"elform.wenlidaima"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"产品数量：",prop:"productNum"}},[a("el-input-number",{attrs:{"controls-position":"right",min:1},model:{value:e.elform.productNum,callback:function(t){e.$set(e.elform,"productNum",t)},expression:"elform.productNum"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"面积：",prop:"area"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.elform.area,callback:function(t){e.$set(e.elform,"area",t)},expression:"elform.area"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"有无动模："}},[a("el-switch",{model:{value:e.elform.dongMo,callback:function(t){e.$set(e.elform,"dongMo",t)},expression:"elform.dongMo"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"系数：",prop:"coefficient"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入产品系数"},model:{value:e.elform.coefficient,callback:function(t){e.$set(e.elform,"coefficient",t)},expression:"elform.coefficient"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"单价：",prop:"price"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.elform.price,callback:function(t){e.$set(e.elform,"price",t)},expression:"elform.price"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传图片："}},[a("div",[a("vue-core-image-upload",{class:["el-button","el-button--primary"],attrs:{crop:!1,inputOfFile:"imageFile",url:e.upload,extensions:"png,gif,jpeg,jpg","max-file-size":5242880,data:e.imageData,text:"上传图片",multiple:!0,"multiple-size":30,credentials:"true"},on:{imageuploaded:e.imageuploaded,errorhandle:e.handleError}})],1)])],1),e._v(" "),a("div",{staticStyle:{border:"1px dashed #d9d9d9",width:"100%","min-height":"358px"}},[a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{gutter:20}},e._l(e.imageUrls,function(t){return a("el-col",{attrs:{span:6}},[a("el-card",{staticClass:"mould-card",attrs:{"body-style":{padding:"0px"}}},[a("img",{staticClass:"image",staticStyle:{height:"320px"},attrs:{src:t}}),e._v(" "),a("div",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"text"},on:{click:function(a){e.delMouldImage(t)}}},[a("i",{staticClass:"el-icon-error",staticStyle:{color:"red"}})])],1)])],1)}))],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:!e.udapteBoolean,expression:"!udapteBoolean"}],attrs:{type:"primary"},on:{click:e.toAddProduct}},[e._v("确 定")]),e._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.udapteBoolean,expression:"udapteBoolean"}],attrs:{type:"primary"},on:{click:e.toUpdateProduct}},[e._v("更 新")]),e._v(" "),a("el-button",{on:{click:e.chanel}},[e._v("取 消")])],1)],1)],1)])],1)],1)])},staticRenderFns:[]},n=a("Z0/y")(o,s,!1,null,null,null);t.default=n.exports},hgxk:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("3cXf"),l=a.n(r),i=a("OIbc"),o=(a("+J3q"),{components:{VueCoreImageUpload:i.default},props:{title:String},data:function(){return{upload:"http://39.107.78.95:8082/jlmanager/comm/upload/image",udapteBoolean:!1,itemIndex:"",itemRow:{},imageData:{userId:"",imgPakage:"order_pm"},table_loading:!1,imageUrls:[],ruleForm:{tax:"16",addUserId:"",addUserName:""},elform:{productNum:"0",area:"0",dongMo:!1,price:"0",coefficient:""},productData:[],restaurants3:[],innerVisible:!1,tableData:[],select_word:"",nowTab:1,rules:{productName:[{required:!0,message:"请输入产品名称",trigger:"blur"},{min:0,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],wenlidaima:[{required:!0,message:"请输入纹理代码",trigger:"blur"},{min:0,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],carType:[{required:!0,message:"请输入车型",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],clientCompanyName:[{required:!0,message:"请输入客户单位",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],contactPerson:[{required:!0,message:"请输入预报价单名称",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],contactPhone:[{required:!0,message:"请输入联系人电话",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],paytype:[{required:!0,message:"请输入付款方式",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],deliverytime:[{required:!0,message:"请输入加工周期",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],remark:[{min:0,max:2048,message:"长度在 0 到 2048 个字符",trigger:"blur"}]}}},methods:{toAadd:function(){this.innerVisible=!0,this.udapteBoolean=!1,this.resetForm("elform")},chanel:function(){this.innerVisible=!1,this.udapteBoolean=!1},commit:function(){var e=this.productData;"undefined"==e||e.length<=0?this.$message.error("请添加产品详情"):this.addYuBaoJia()},addYuBaoJia:function(){var e=this,t=this,a=t.ruleForm;a.addUserId=this.uid,a.addUserName=this.name,this.postRequest("/offer/bus/add",a).then(function(a){if(a&&200==a.status&&0==a.data.code){var r=a.data.data.id;r>0?e.addProduct(r):t.$message.error("添加基础信息失败")}else t.$message.error("添加基础信息失败")})},addProduct:function(e){var t=this;this.table_loading=!0;for(var a=this,r=a.productData,i="",o=0;o<r.length;o++){var s=r[o];s.addUserId=this.uid,s.addUserName=this.name,s.yuBaoJiaId=e,s.picUrls=this.toPinjieUrl(s.picUrls),i=i+l()(s)+"|"}var n={businessBaoJiaId:e,businessProducts:i};this.postRequest("/offer/bus/add/product",n).then(function(e){t.table_loading=!1,e&&200==e.status&&0==e.data.code?(a.$message.success("添加成功"),t.$router.push("/offer/bus/list")):a.$message.error("添加失败")})},deleteRow:function(e,t){t.splice(e,1)},toPinjieUrl:function(e){var t="";if("undefined"==e||e.length<=0)return t;for(var a=0;a<e.length;a++)(a=e.length-1)?t+=e[a]:t=t+e[a]+",";return t},toEidtor:function(e,t){this.udapteBoolean=!0;var a;a=t,this.itemRow=a[e],this.elform=this.itemRow,this.itemIndex=e,this.innerVisible=!0},toUpdateProduct:function(){for(var e=this.elform.price*this.elform.productNum*(this.ruleForm.tax/100+1),t={yuBaoJiaId:"",productName:this.elform.productName,wenlidaima:this.elform.wenlidaima,productNum:this.elform.productNum,area:this.elform.area,dongMo:this.elform.dongMo,coefficient:this.elform.coefficient,price:this.elform.price,picUrls:this.imageUrls,tax:this.ruleForm.tax,taxPrice:this.elform.price*this.elform.productNum,total:e,immutable:!1,addUserId:this.uid,addUserName:this.name},a=[],r=0;r<this.productData.length;r++)r==this.itemIndex?a.push(t):a.push(this.productData[r]);this.$nextTick(function(){this.productData=a}),this.imageUrls=[],this.resetForm("elform"),this.innerVisible=!1},toAddProduct:function(){var e=this.elform.price*this.elform.productNum*(this.ruleForm.tax/100+1),t={yuBaoJiaId:"",productName:this.elform.productName,wenlidaima:this.elform.wenlidaima,productNum:this.elform.productNum,area:this.elform.area,dongMo:this.elform.dongMo,coefficient:this.elform.coefficient,price:this.elform.price,picUrls:this.imageUrls,tax:this.ruleForm.tax,noTaxPrice:this.elform.price*this.elform.productNum,total:e,immutable:!1,addUserId:this.uid,addUserName:this.name};this.productData.push(t),this.imageUrls=[],this.resetForm("elform"),this.innerVisible=!1},resetForm:function(e){this.$refs[e].resetFields()},submitForm:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;t.nowTab=2})},imageuploaded:function(e){if("undefined"!==e.url.length&&e.url.length>0){for(var t=e.url,a=this.imageUrls,r=0;r<t.length;r++)a.push(t[r]);this.imageUrls=a}},delMouldImage:function(e){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.todelImage(e)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},todelImage:function(e){var t=this;"undefined"!=e&&""!=e.length?this.getRequest("/config/delfile/delImage?url="+e).then(function(a){if(a&&200==a.status&&0==a.data.code){t.$message.success("删除成功");for(var r=t.imageUrls,l=[],i=0;i<r.length;i++)e!=r[i]&&l.push(r[i]);t.imageUrls=l}else t.$message.error("删除照片失败")}):t.$message.error("删除图片不存在")},loadAllProject:function(){var e=this;this.getRequest("/offer/bus/list/project?addUserId="+this.uid).then(function(t){if(t&&200==t.status&&0==t.data.code){var a=[],r=t.data.data.projectlist;if("undefined"!=r&&r.length>0){for(var l=0;l<r.length;l++){var i={label:"",value:""};i.label=r[l].projectName,i.value=r[l].id,a.push(i)}e.restaurants3=a}}else console.log("获取列表数据失败")})},handleError:function(){this.$notify.error({title:"上传失败",message:"图片上传出现异常"})}},mounted:function(){this.$nextTick(function(){this.imageData.userId=this.uid=localStorage.getItem("cp_uid")}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.loadAllProject()},computed:{}}),s={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("商务报价单")]),e._v(" "),a("el-breadcrumb-item",[e._v("添加商务报价单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{"align-items":"center","margin-top":"40px"}},[a("el-steps",{attrs:{active:e.nowTab}},[a("el-step",{attrs:{title:"基本信息",icon:"el-icon-edit"}}),e._v(" "),a("el-step",{attrs:{title:"报价详情",icon:"el-icon-document"}})],1)],1),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("div",{directives:[{name:"show",rawName:"v-show",value:1==e.nowTab,expression:"nowTab==1"}]},[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",staticStyle:{width:"40%"},attrs:{model:e.ruleForm,rules:e.rules,"label-width":"110px"}},[a("div",[a("el-form-item",{attrs:{label:"所属项目：",prop:"projectId",required:""}},[a("el-select",{attrs:{placeholder:"请选择所属项目"},model:{value:e.ruleForm.projectId,callback:function(t){e.$set(e.ruleForm,"projectId",t)},expression:"ruleForm.projectId"}},e._l(e.restaurants3,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"客户单位：",prop:"clientCompanyName"}},[a("el-input",{model:{value:e.ruleForm.clientCompanyName,callback:function(t){e.$set(e.ruleForm,"clientCompanyName",t)},expression:"ruleForm.clientCompanyName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"联系人：",prop:"contactPerson"}},[a("el-input",{model:{value:e.ruleForm.contactPerson,callback:function(t){e.$set(e.ruleForm,"contactPerson",t)},expression:"ruleForm.contactPerson"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"联系电话：",prop:"contactPhone"}},[a("el-input",{model:{value:e.ruleForm.contactPhone,callback:function(t){e.$set(e.ruleForm,"contactPhone",t)},expression:"ruleForm.contactPhone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"车型：",prop:"carType"}},[a("el-input",{model:{value:e.ruleForm.carType,callback:function(t){e.$set(e.ruleForm,"carType",t)},expression:"ruleForm.carType"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"税率：",prop:"tax"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.ruleForm.tax,callback:function(t){e.$set(e.ruleForm,"tax",t)},expression:"ruleForm.tax"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.ruleForm.remark,callback:function(t){e.$set(e.ruleForm,"remark",t)},expression:"ruleForm.remark"}})],1)],1)]),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm("ruleForm")}}},[e._v("下一步")])],1)],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:2==e.nowTab,expression:"nowTab==2"}]},[a("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.table_loading,expression:"table_loading"}],staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("产品列表")]),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{staticClass:"el-icon-plus",attrs:{type:"primary"},on:{click:e.toAadd}},[e._v("添加")])],1)]),e._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.productData,border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"productName",label:"产品名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"",label:"图片"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("img",{staticClass:"image",staticStyle:{height:"30px",width:"30px"},attrs:{src:e.row.picUrls[0]}})]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"wenlidaima",label:"纹理代码"}}),e._v(" "),a("el-table-column",{attrs:{prop:"price",label:"单价"}}),e._v(" "),a("el-table-column",{attrs:{prop:"productNum",label:"数量"}}),e._v(" "),a("el-table-column",{attrs:{prop:"noTaxPrice",label:"不含税总计"}}),e._v(" "),a("el-table-column",{attrs:{prop:"total",label:"含税总计"}}),e._v(" "),a("el-table-column",{attrs:{prop:"area",label:"面积"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"300"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.toEidtor(t.$index,e.productData)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.deleteRow(t.$index,e.productData)}}},[e._v("\r\n         移除\r\n       ")])]}}])})],1)],1),e._v(" "),a("div",{staticStyle:{"margin-top":"20px","margin-bottom":"20px"}},[a("div",{staticClass:"card-bottom",staticStyle:{float:"left"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.nowTab=1}}},[e._v("上一步")])],1),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"right"}},[a("el-button",{attrs:{type:"primary"},on:{click:e.commit}},[e._v("提 交")])],1)])])],1),e._v(" "),a("div",[a("el-dialog",{attrs:{width:"60%",title:"产品详情",visible:e.innerVisible,"close-on-click-modal":!1,"append-to-body":""},on:{"update:visible":function(t){e.innerVisible=t}}},[a("el-form",{ref:"elform",staticStyle:{width:"100%"},attrs:{model:e.elform,rules:e.rules,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"产品名称：",prop:"productName"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入产品名称"},model:{value:e.elform.productName,callback:function(t){e.$set(e.elform,"productName",t)},expression:"elform.productName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"纹理代码：",prop:"wenlidaima"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入纹理代码"},model:{value:e.elform.wenlidaima,callback:function(t){e.$set(e.elform,"wenlidaima",t)},expression:"elform.wenlidaima"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"产品数量：",prop:"productNum"}},[a("el-input-number",{attrs:{"controls-position":"right",min:1},model:{value:e.elform.productNum,callback:function(t){e.$set(e.elform,"productNum",t)},expression:"elform.productNum"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"面积：",prop:"area"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.elform.area,callback:function(t){e.$set(e.elform,"area",t)},expression:"elform.area"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"有无动模："}},[a("el-switch",{model:{value:e.elform.dongMo,callback:function(t){e.$set(e.elform,"dongMo",t)},expression:"elform.dongMo"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"系数：",prop:"coefficient"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入产品系数"},model:{value:e.elform.coefficient,callback:function(t){e.$set(e.elform,"coefficient",t)},expression:"elform.coefficient"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"单价：",prop:"price"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.elform.price,callback:function(t){e.$set(e.elform,"price",t)},expression:"elform.price"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传图片："}},[a("div",[a("vue-core-image-upload",{class:["el-button","el-button--primary"],attrs:{crop:!1,inputOfFile:"imageFile",url:e.upload,extensions:"png,gif,jpeg,jpg","max-file-size":5242880,data:e.imageData,text:"上传图片",multiple:!0,"multiple-size":30,credentials:"true"},on:{imageuploaded:e.imageuploaded,errorhandle:e.handleError}})],1)])],1),e._v(" "),a("div",{staticStyle:{border:"1px dashed #d9d9d9",width:"100%","min-height":"358px"}},[a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{gutter:20}},e._l(e.imageUrls,function(t){return a("el-col",{attrs:{span:6}},[a("el-card",{staticClass:"mould-card",attrs:{"body-style":{padding:"0px"}}},[a("img",{staticClass:"image",staticStyle:{height:"320px"},attrs:{src:t}}),e._v(" "),a("div",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"text"},on:{click:function(a){e.delMouldImage(t)}}},[a("i",{staticClass:"el-icon-error",staticStyle:{color:"red"}})])],1)])],1)}))],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:!e.udapteBoolean,expression:"!udapteBoolean"}],attrs:{type:"primary"},on:{click:e.toAddProduct}},[e._v("确 定")]),e._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.udapteBoolean,expression:"udapteBoolean"}],attrs:{type:"primary"},on:{click:e.toUpdateProduct}},[e._v("更 新")]),e._v(" "),a("el-button",{on:{click:e.chanel}},[e._v("取 消")])],1)],1)],1)])],1)],1)])},staticRenderFns:[]},n=a("Z0/y")(o,s,!1,null,null,null);t.default=n.exports},z9bd:function(e,t){}});
//# sourceMappingURL=5.4ddf713ca616361b4221.js.map
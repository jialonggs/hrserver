webpackJsonp([11],{"9Gdp":function(e,t){},Hp5G:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={components:{BuChongGongYi:a("IcNb").default},data:function(){return{item_wenli:"",item_orderId:"",orderTitle:"",techCard:{},itemOrderId:"",dialogFormVisible:!1,addtechloading:!1,nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[],form:{tieHuaBuShu:"1"},rules:{nanDuXiShu:[{required:!0,message:"请输入难度系数",trigger:"blur"}],gongYiCanShu:[{required:!0,message:"请输入加工参数",trigger:"blur"}]}}},methods:{chaXun:function(){this.getCollectMouldList()},showChild:function(e){this.nowTab=1},toAdd:function(e){this.techCard=e,this.nowTab=2},handleChange:function(e){},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},submitForm:function(e){var t=this,a=this;a.addtechloading=!0,this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;a.form.orderId=a.itemOrderId,t.postRequest("/tech/stay/add/tech",a.form).then(function(e){a.addtechloading=!1,e&&200==e.status&&0==e.data.code?(t.$message.success("添加成功"),t.resetForm("form"),t.tableLoading=!0,t.dialogFormVisible=!1,t.getCollectMouldList()):t.$message.error("添加失败")})})},resetForm:function(e){this.$refs[e].resetFields()},getCollectMouldList:function(){var e=this;this.getRequest("/tech/added/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&wenli="+this.item_wenli+"&orderId="+this.item_orderId).then(function(t){t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.stayorderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.orderName.indexOf(e.select_word)>-1||t.addUserName.indexOf(e.select_word)>-1)return t})}}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("工艺管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("已提交记录")])],1)],1),e._v(" "),a("el-container",[a("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"},attrs:{shadow:"never"}},[a("div",{staticClass:"handle-box"},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:6}},[e._v("\r\n                纹理代码:"),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"请输入纹理代码",icon:"search"},model:{value:e.item_wenli,callback:function(t){e.item_wenli=t},expression:"item_wenli"}})],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"grid-content bg-purple"},[e._v("\r\n                  订单编号:"),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"请输入订单编号",icon:"search"},model:{value:e.item_orderId,callback:function(t){e.item_orderId=t},expression:"item_orderId"}})],1)])],1)],1),e._v(" "),a("div",{staticClass:"handle-box"},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:function(t){e.chaXun()}}},[e._v("搜索")])],1)]),e._v(" "),a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"0px"}}),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"订单编号",prop:"orderId"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\r\n              "+e._s(t.row.orderId)+"\r\n            ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\r\n              "+e._s(t.row.techTyeOrder.orderName)+"\r\n            ")]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"紧急程度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.techTyeOrder.urgency+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("不急")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("正常")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="2"?a("el-tag",{attrs:{type:"primary"}},[e._v("急C")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="3"?a("el-tag",{attrs:{type:"danger"}},[e._v("急B")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="4"?a("el-tag",{attrs:{type:"primary"}},[e._v("急A")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="5"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急C")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="6"?a("el-tag",{attrs:{type:"primary"}},[e._v("紧急B")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="7"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急A")]):e._e(),e._v(" "),t.row.techTyeOrder.urgency+""=="8"?a("el-tag",{attrs:{type:"danger"}},[e._v("特急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"纹理代码"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.wenli.wenliName))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单当前步骤"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.techTyeOrder.presentStepName))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"商务负责人"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.techTyeOrder.addUserName))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"添加人",prop:"addUserName"}}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toAdd(t.row)}}},[e._v("查看详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:2==e.nowTab,expression:"nowTab==2"}]},[a("BuChongGongYi",{attrs:{techCards:e.techCard},on:{listenToChild:e.showChild}})],1)])},staticRenderFns:[]};var o=a("Z0/y")(r,i,!1,function(e){a("Qt5k")},"data-v-39bd1575",null);t.default=o.exports},IcNb:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={props:{techCards:{type:Object}},data:function(){return{restaurants2:[],toupdate:!1,NowpresentStepName:"",upadte_tech_loading:!1,addlanmo_loading:!1,dialogFormVisible:!1,item_techId:"",uid:"",name:"",username:"",updatDisable:!1,itemOrder1:{controlOrderFrom:{quYu:"",shenDu:""},project:{processUnit:{clientCompanyName:""},car:{name:"",mainEngine:{name:""}}}},mouldLists:[],ruleform:{order:{presentStepName:""}},form:{},tableData:[],user_role:[],rules:{productName:[{required:!0,message:"请输入产品名称",trigger:"blur"},{min:0,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],wenlidaima:[{required:!0,message:"请输入纹理代码",trigger:"blur"},{min:0,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],carType:[{required:!0,message:"请输入车型",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],clientCompanyName:[{required:!0,message:"请输入客户单位",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],contactPerson:[{required:!0,message:"请输入预报价单名称",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],contactPhone:[{required:!0,message:"请输入联系人电话",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],paytype:[{required:!0,message:"请输入付款方式",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],deliverytime:[{required:!0,message:"请输入加工周期",trigger:"blur"},{min:1,max:255,message:"长度在 1 到 255 个字符",trigger:"blur"}],remark:[{min:0,max:2048,message:"长度在 0 到 2048 个字符",trigger:"blur"}]}}},methods:{querySearch2:function(e,t){var a=this.restaurants2;t(e?restaurants2.filter(this.createFilter(e)):a)},buChong:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;t.upadte_tech_loading=!0,t.postRequest("/tech/added/update/techcard",t.ruleform).then(function(e){t.upadte_tech_loading=!1,e&&200==e.status&&0==e.data.code?(a.$message.success("更新成功"),t.toParent()):a.$message.error("更新失败")})})},addLanMo:function(){this.form={},this.dialogFormVisible=!0},updateForm:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;t.addlanmo_loading=!0,t.postRequest("/tech/added/update/lanmo",t.form).then(function(e){t.addlanmo_loading=!1,e&&200==e.status&&0==e.data.code?(a.$message.success("更新成功"),t.dialogFormVisible=!1,t.resetForm("form"),t.updatDisable=!1,t.getLanMoList()):a.$message.error("更新失败")})})},quit:function(){this.resetForm("form"),this.dialogFormVisible=!1,this.updatDisable=!1},toEdit:function(e){this.updatDisable=!0,this.form=e,this.dialogFormVisible=!0},toGetInfo:function(e){var t=this;this.getRequest("/tech/added/get/tech?orderId="+e).then(function(e){e&&200==e.status&&0==e.data.code&&(t.ruleform=e.data.data.techcard,t.item_techId=e.data.data.techcard.id,t.getLanMoList())})},toParent:function(){this.$emit("listenToChild",1)},resetForm:function(e){this.$refs[e].resetFields()},submitForm:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;t.addlanmo_loading=!0,a.form.addUserId=t.uid,a.form.addUserName=t.name,""!=t.item_techId&&"undefinded"!=t.item_techId?(a.form.techId=t.item_techId,t.postRequest("/tech/added/add/lanmo",t.form).then(function(e){t.addlanmo_loading=!1,e&&200==e.status&&0==e.data.code&&(t.dialogFormVisible=!1,a.resetForm("form"),t.getLanMoList())})):a.$message.error("添加失败")})},getLanMoList:function(){var e=this;this.getRequest("/tech/added/lanmo/list?techId="+this.item_techId).then(function(t){t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.lanmolist)})},deletedLanMo:function(e){var t=this,a=this;this.getRequest("/tech/added/del/lanmo?id="+e.id).then(function(e){e&&200==e.status&&0==e.data.code?(a.$message.success("删除成功"),t.getLanMoList()):a.$message.success("删除失败")})},checkRole:function(){var e=localStorage.getItem("user"),t=JSON.parse(e);if(this.user_role=t.roles,"undefinded"!=this.user_role&&this.user_role.length>0)for(var a=0;a<this.user_role.length;a++)if("ROLE_admin"===this.user_role[a].name||"ROLE_jishu"===this.user_role[a].name)return void(this.toupdate=!0)},loadAll2:function(){return[{value:"统烂药水"},{value:"三氯化铁"}]},delMouldRecord:function(e){var t=this;this.$confirm("此操作将删除此条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.deletedLanMo(e)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})}},mounted:function(){this.$nextTick(function(){}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.restaurants2=this.loadAll2(),this.checkRole()},watch:{techCards:function(e,t){this.ruleform=e,this.itemOrder1=e.techTyeOrder;var a=this.itemOrder1.mouldInfoList;if(""!==a&&"undefined"!==a){for(var r=[],i=0;i<a.length;i++){var o=a[i].picUrls;if(""===o||"undefined"===o||o instanceof Array)r.push(a[i]);else{var n=o.split("|");a[i].picUrls=n,r.push(a[i])}}this.mouldLists=r}console.log("---------------"),console.log(e),this.NowpresentStepName=this.itemOrder1.presentStepName,this.toGetInfo(e.id)}}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("el-container",[a("el-header",{staticStyle:{"align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("工艺管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("已提交记录")]),e._v(" "),a("el-breadcrumb-item",[e._v("记录详情")])],1)],1)]),e._v(" "),a("el-main",{directives:[{name:"loading",rawName:"v-loading",value:e.upadte_tech_loading,expression:"upadte_tech_loading"}],staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("div",{staticClass:"table"},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("补充工艺信息")])]),e._v(" "),a("div",[a("el-form",{ref:"ruleform",attrs:{model:e.ruleform,rules:e.rules,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"皮纹代码",prop:"piWenDaiMa"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入纹理代码",disabled:!0},model:{value:e.ruleform.piWenDaiMa,callback:function(t){e.$set(e.ruleform,"piWenDaiMa",t)},expression:"ruleform.piWenDaiMa"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"难度系数",prop:"nanDuXiShu"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入难度系数",disabled:!e.toupdate},model:{value:e.ruleform.nanDuXiShu,callback:function(t){e.$set(e.ruleform,"nanDuXiShu",t)},expression:"ruleform.nanDuXiShu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"贴花步数",prop:"tieHuaBuShu"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入贴花数",disabled:!e.toupdate},model:{value:e.ruleform.tieHuaBuShu,callback:function(t){e.$set(e.ruleform,"tieHuaBuShu",t)},expression:"ruleform.tieHuaBuShu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"工艺参数",prop:"gongYiCanShu"}},[a("el-input",{staticClass:"textarea",staticStyle:{width:"50%"},attrs:{type:"textarea",autosize:"true",placeholder:"请输入工艺参数",disabled:!e.toupdate},model:{value:e.ruleform.gongYiCanShu,callback:function(t){e.$set(e.ruleform,"gongYiCanShu",t)},expression:"ruleform.gongYiCanShu"}})],1),e._v(" "),a("div",{staticStyle:{height:"1px",width:"100%","border-bottom":"1px solid #e6ebf5","box-sizing":"border-box","margin-bottom":"15px"}}),e._v(" "),a("div",[a("p",[e._v("主机厂："+e._s(e.itemOrder1.project.car.mainEngine.name))]),e._v(" "),a("p",[e._v("车型："+e._s(e.itemOrder1.project.car.name))]),e._v(" "),a("p",[e._v("客户单位："+e._s(e.itemOrder1.project.processUnit.clinetSortName))]),e._v(" "),a("span",[e._v("项目名称："+e._s(e.itemOrder1.project.projectName))]),e._v(" "),a("span",[e._v("区域："+e._s(e.itemOrder1.controlOrderFrom.quYu))]),e._v(" "),a("span",[e._v("深度："+e._s(e.itemOrder1.controlOrderFrom.shenDu))]),e._v(" "),e._l(this.mouldLists,function(t,r){return a("div",{staticStyle:{"margin-top":"10px"},attrs:{index:r}},[a("div",[a("span",[e._v(e._s(t.productName)+"的图片为:")])]),e._v(" "),e._l(t.picUrls,function(e){return a("div",{staticStyle:{"margin-top":"5px"}},[a("img",{staticStyle:{width:"358px"},attrs:{src:e}})])})],2)})],2),e._v(" "),a("div",{staticStyle:{height:"1px",width:"100%","border-bottom":"1px solid #e6ebf5","box-sizing":"border-box","margin-bottom":"15px"}}),e._v(" "),a("div",{staticClass:"handle-box"},[a("span",{staticStyle:{color:"red"}},[e._v("订单当前加工步骤："+e._s(e.NowpresentStepName))]),e._v(" "),a("el-button",{staticClass:"mr10",staticStyle:{float:"right"},attrs:{type:"primary",icon:"plus"},on:{click:function(t){e.addLanMo()}}},[a("i",{staticClass:"el-icon-plus"})])],1),e._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:""}},[a("el-table-column",{attrs:{label:"序号",type:"index",width:"50"}}),e._v(" "),a("el-table-column",{attrs:{prop:"beginTime",label:"起始时间"}}),e._v(" "),a("el-table-column",{attrs:{prop:"needLanMoTime",label:"烂模时间"}}),e._v(" "),a("el-table-column",{attrs:{prop:"shenDu",label:"烂模总深度"}}),e._v(" "),a("el-table-column",{attrs:{prop:"yaoShui",label:"烂模药水"}}),e._v(" "),a("el-table-column",{attrs:{prop:"caoZuoRen",label:"操作人"}}),e._v(" "),a("el-table-column",{attrs:{prop:"remark",label:"备注"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toEdit(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.delMouldRecord(t.row)}}},[e._v("删除")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticStyle:{height:"1px",width:"100%","border-bottom":"1px solid #e6ebf5","box-sizing":"border-box","margin-bottom":"15px","margin-top":"15px"}}),e._v(" "),a("div",{staticClass:"card-bottom"},[a("el-button",{attrs:{type:"primary"},on:{click:e.toParent}},[e._v("返回列表")]),e._v(" "),a("el-button",{staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:function(t){e.buChong("ruleform")}}},[e._v("保存")])],1)]),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.addlanmo_loading,expression:"addlanmo_loading"}]},[a("el-dialog",{attrs:{title:"添加记录",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"起始时间",prop:"beginTime"}},[a("el-date-picker",{staticStyle:{width:"50%"},attrs:{format:"yyyy 年 MM 月 dd 日 HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime",placeholder:"选择日期时间"},model:{value:e.form.beginTime,callback:function(t){e.$set(e.form,"beginTime",t)},expression:"form.beginTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"烂模时间"}},[a("el-input",{staticStyle:{width:"40%"},attrs:{placeholder:"请输入分"},model:{value:e.form.lanMoTimeFen,callback:function(t){e.$set(e.form,"lanMoTimeFen",t)},expression:"form.lanMoTimeFen"}},[a("template",{slot:"append"},[e._v(" 分")])],2),e._v(" "),a("el-input",{staticStyle:{width:"40%"},attrs:{placeholder:"请输入秒"},model:{value:e.form.lanMoTimeMiao,callback:function(t){e.$set(e.form,"lanMoTimeMiao",t)},expression:"form.lanMoTimeMiao"}},[a("template",{slot:"append"},[e._v(" 秒")])],2)],1),e._v(" "),a("el-form-item",{attrs:{label:"烂模总深度",prop:"shenDu"}},[a("el-input",{staticStyle:{width:"40%"},attrs:{placeholder:"请输入烂模总深度"},model:{value:e.form.shenDu,callback:function(t){e.$set(e.form,"shenDu",t)},expression:"form.shenDu"}},[a("template",{slot:"append"},[e._v(" 丝")])],2)],1),e._v(" "),a("el-form-item",{attrs:{label:"烂模药水",prop:"yaoShui"}},[a("el-autocomplete",{staticClass:"inline-input",staticStyle:{width:"50%"},attrs:{placeholder:"请输入烂模药水","fetch-suggestions":e.querySearch2},on:{select:e.handleSelect},model:{value:e.form.yaoShui,callback:function(t){e.$set(e.form,"yaoShui",t)},expression:"form.yaoShui"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"操作人",prop:"caoZuoRen"}},[a("el-input",{staticStyle:{width:"50%"},attrs:{placeholder:"请输入操作人姓名"},model:{value:e.form.caoZuoRen,callback:function(t){e.$set(e.form,"caoZuoRen",t)},expression:"form.caoZuoRen"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"备注",prop:"remark"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:!this.updatDisable,expression:"!this.updatDisable"}],attrs:{type:"primary"},on:{click:function(t){e.submitForm("form")}}},[e._v("提 交")]),e._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:this.updatDisable,expression:"this.updatDisable"}],attrs:{type:"primary"},on:{click:function(t){e.updateForm("form")}}},[e._v("保 存")]),e._v(" "),a("el-button",{on:{click:e.quit}},[e._v("取 消")])],1)])],1)],1)])],1)],1)])},staticRenderFns:[]};var o=a("Z0/y")(r,i,!1,function(e){a("fjAM")},"data-v-9aa1b494",null);t.default=o.exports},OKBx:function(e,t,a){var r={"./TechAdded.vue":"Hp5G","./TechStay.vue":"wZLW"};function i(e){return a(o(e))}function o(e){var t=r[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}i.keys=function(){return Object.keys(r)},i.resolve=o,e.exports=i,i.id="OKBx"},Qt5k:function(e,t){},fjAM:function(e,t){},wZLW:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={data:function(){return{orderTitle:"",itemOrderId:"",dialogFormVisible:!1,addtechloading:!1,nowTab:1,username:"",name:"",uid:"",mouldLists:[],itemWenLi:{},tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[],itemOrder:{project:{projectName:"",processUnit:{clientCompanyName:""},car:{name:"",mainEngine:{name:""}}},controlOrderFrom:{shenDu:"",quYu:""}},form:{tieHuaBuShu:"1"},rules:{nanDuXiShu:[{required:!0,message:"请输入难度系数",trigger:"blur"}],gongYiCanShu:[{required:!0,message:"请输入加工参数",trigger:"blur"}]}}},methods:{objectSpanMethod:function(e){e.row,e.column;var t=e.rowIndex;if(0===e.columnIndex)return t%2==0?{rowspan:2,colspan:1}:{rowspan:0,colspan:0}},toAdd:function(e,t){this.itemWenLi={},this.mouldLists=[],this.itemOrder=[],this.itemOrderId="",this.dialogFormVisible=!0,this.orderTitle="添加订单 [ "+e.orderName+" ] 的工艺卡",this.itemOrderId=e.id,this.itemOrder=e;var a=this.itemOrder.mouldInfoList;if(""!==a&&"undefined"!==a){for(var r=[],i=0;i<a.length;i++){var o=a[i].picUrls;if(""===o||"undefined"===o||o instanceof Array)r.push(a[i]);else{var n=o.split("|");a[i].picUrls=n,r.push(a[i])}}this.mouldLists=r}this.itemWenLi=t},handleChange:function(e){},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},submitForm:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;a.form.orderId=a.itemOrderId,a.form.piWenDaiMa=a.itemWenLi.wenliName,a.form.wenliId=a.itemWenLi.id,a.form.addUserName=t.name,a.form.addUserUid=t.uid,a.addtechloading=!0,t.postRequest("/tech/stay/add/tech",a.form).then(function(e){a.addtechloading=!1,e&&200==e.status&&0==e.data.code?(t.$message.success("添加成功"),t.resetForm("form"),t.tableLoading=!0,t.dialogFormVisible=!1,t.getCollectMouldList()):t.$message.error("添加失败")})})},resetForm:function(e){this.$refs[e].resetFields()},getCollectMouldList:function(){var e=this;this.getRequest("/tech/stay/listbypage?page="+this.currentPage+"&size="+this.pagesize).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.stayorderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.orderName.indexOf(e.select_word)>-1||t.addUserName.indexOf(e.select_word)>-1)return t})}}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("工艺管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("待提交记录")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.data,border:""}},[a("el-table-column",{attrs:{label:"订单名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"紧急程度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.urgency+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("不急")]):e._e(),e._v(" "),t.row.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("正常")]):e._e(),e._v(" "),t.row.urgency+""=="2"?a("el-tag",{attrs:{type:"primary"}},[e._v("急C")]):e._e(),e._v(" "),t.row.urgency+""=="3"?a("el-tag",{attrs:{type:"danger"}},[e._v("急B")]):e._e(),e._v(" "),t.row.urgency+""=="4"?a("el-tag",{attrs:{type:"primary"}},[e._v("急A")]):e._e(),e._v(" "),t.row.urgency+""=="5"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急C")]):e._e(),e._v(" "),t.row.urgency+""=="6"?a("el-tag",{attrs:{type:"primary"}},[e._v("紧急B")]):e._e(),e._v(" "),t.row.urgency+""=="7"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急A")]):e._e(),e._v(" "),t.row.urgency+""=="8"?a("el-tag",{attrs:{type:"danger"}},[e._v("特急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"负责人",prop:"addUserName"}}),e._v(" "),a("el-table-column",{attrs:{label:"纹理代码",prop:"addUserName"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("el-table",{attrs:{data:e.row.wenlis}},[a("el-table-column",{attrs:{prop:"wenliName"}})],1)]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"面积",prop:"addUserName"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("el-table",{attrs:{data:e.row.wenlis}},[a("el-table-column",{attrs:{prop:"area"}})],1)]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"倍数",prop:"addUserName"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("el-table",{attrs:{data:e.row.wenlis}},[a("el-table-column",{attrs:{prop:"times"}})],1)]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-table",{attrs:{data:t.row.wenlis}},[a("el-table-column",{scopedSlots:e._u([{key:"default",fn:function(r){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.toAdd(t.row,r.row)}}},[e._v("编辑工艺卡")])]}}])})],1)]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1),e._v(" "),a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.addtechloading,expression:"addtechloading"}],attrs:{title:e.orderTitle,visible:e.dialogFormVisible,width:"50%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",[a("div",[a("div",[a("p",[e._v("主机厂："+e._s(this.itemOrder.project.car.mainEngine.name))]),e._v(" "),a("p",[e._v("车型："+e._s(this.itemOrder.project.car.name))]),e._v(" "),a("p",[e._v("客户单位："+e._s(this.itemOrder.project.processUnit.clinetSortName))]),e._v(" "),a("span",[e._v("项目名称："+e._s(this.itemOrder.project.projectName))]),e._v(" "),a("span",[e._v("区域："+e._s(this.itemOrder.controlOrderFrom.quYu))]),e._v(" "),a("span",[e._v("深度："+e._s(this.itemOrder.controlOrderFrom.shenDu))]),e._v(" "),e._l(this.mouldLists,function(t,r){return a("div",{staticStyle:{"margin-top":"10px"},attrs:{index:r}},[a("div",[a("span",[e._v(e._s(t.productName)+"的图片为:")])]),e._v(" "),e._l(t.picUrls,function(e){return a("div",{staticStyle:{"margin-top":"5px"}},[a("img",{staticStyle:{width:"358px"},attrs:{src:e}})])})],2)})],2),e._v(" "),a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"皮纹代码："}},[a("span",[e._v(e._s(e.itemWenLi.wenliName))])]),e._v(" "),a("el-form-item",{attrs:{label:"难度系数：",prop:"nanDuXiShu"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入难度系数"},model:{value:e.form.nanDuXiShu,callback:function(t){e.$set(e.form,"nanDuXiShu",t)},expression:"form.nanDuXiShu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"贴花步数：",prop:"tieHuaBuShu"}},[a("el-input-number",{attrs:{"controls-position":"right",min:1},on:{change:e.handleChange},model:{value:e.form.tieHuaBuShu,callback:function(t){e.$set(e.form,"tieHuaBuShu",t)},expression:"form.tieHuaBuShu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"工艺参数：",prop:"gongYiCanShu"}},[a("el-input",{staticStyle:{width:"50%"},attrs:{type:"textarea",autosize:!0,placeholder:"请输入工艺参数"},model:{value:e.form.gongYiCanShu,callback:function(t){e.$set(e.form,"gongYiCanShu",t)},expression:"form.gongYiCanShu"}})],1)],1)],1),e._v(" "),a("div",{staticClass:"card-bottom"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm("form")}}},[e._v("提 交")]),e._v(" "),a("el-button",{on:{click:function(t){e.resetForm("form")}}},[e._v("重 置")])],1)])])],1)])},staticRenderFns:[]};var o=a("Z0/y")(r,i,!1,function(e){a("9Gdp")},"data-v-8cdbff74",null);t.default=o.exports}});
//# sourceMappingURL=11.7bbf1b3eb6dd1832108c.js.map
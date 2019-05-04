webpackJsonp([18],{Bjri:function(e,t,a){var l={"./OrderAdd.vue":"zRBn","./OrderInfo.vue":"uIsJ","./OrderList.vue":"DdJ0"};function r(e){return a(i(e))}function i(e){var t=l[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}r.keys=function(){return Object.keys(l)},r.resolve=i,e.exports=r,r.id="Bjri"},DdJ0:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={data:function(){return{select_engine:"",select_car:"",select_project:"",select_unit:"",allUnit:[],Engineoptions:[],allCars:[],allProject:[],nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.selectAll()},handleCurrentChange:function(e){this.currentPage=e,this.selectAll()},getAllEngineList:function(){var e=this;this.getRequest("/engine/all").then(function(t){if(t&&200==t.status&&0==t.data.code){var a=t.data.data.allenginelist;"undefined"!=a&&a.length>0&&(e.Engineoptions=a)}})},getAllCarList:function(){var e=this;this.getRequest("/car/all").then(function(t){if(t&&200==t.status&&0==t.data.code){var a=t.data.data.allcarlist;"undefined"!=a&&a.length>0&&(e.allCars=a)}})},loadAllProject:function(){var e=this;this.getRequest("/project/list/byuid?uid="+this.uid).then(function(t){if(t&&200==t.status&&0==t.data.code){var a=t.data.data.projectlist;"undefined"!=a&&a.length>0&&(e.allProject=a)}else console.log("获取列表数据失败")})},loadAllUnit:function(){var e=this;this.getRequest("/unit/all").then(function(t){if(t&&200==t.status&&0==t.data.code){var a=t.data.data.unitlist;"undefined"!=a&&a.length>0&&(e.allUnit=a)}else console.log("获取列表数据失败")})},selectAll:function(){var e=this,t="";""!==this.select_engine&&"undefined"!==this.select_engine&&(t=t+"&engineId="+this.select_engine),""!==this.select_car&&"undefined"!==this.select_car&&(t=t+"&carId="+this.select_car),""!==this.select_unit&&"undefined"!==this.select_unit&&(t=t+"&unitId="+this.select_unit),""!==this.select_project&&"undefined"!==this.select_project&&(t=t+"&projectId="+this.select_project),this.getRequest("/order/list/by/condition?addUserId="+this.uid+"&page="+this.currentPage+"&size="+this.pagesize+t).then(function(t){t&&200==t.status&&0==t.data.code?(e.tableLoading=!1,e.tableData=t.data.data.orderlist,console.log(e.tableData),e.totalnum=t.data.data.count):console.log("获取列表数据失败")})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.selectAll(),this.getAllEngineList(),this.getAllCarList(),this.loadAllProject(),this.loadAllUnit()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("订单管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("订单列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:e.toadd}},[e._v("创建订单")])],1)]),e._v(" "),a("el-card",{staticClass:"box-card",attrs:{shadow:"never"}},[a("div",{staticClass:"handle-box"},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:6}},[e._v("\r\n                主机厂："),a("el-select",{attrs:{clearable:"",placeholder:"请选择主机厂"},model:{value:e.select_engine,callback:function(t){e.select_engine=t},expression:"select_engine"}},e._l(e.Engineoptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"grid-content bg-purple"},[e._v("\r\n                  车型：\r\n                  "),a("el-select",{attrs:{clearable:"",placeholder:"请选择车型"},model:{value:e.select_car,callback:function(t){e.select_car=t},expression:"select_car"}},e._l(e.allCars,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"grid-content bg-purple"},[e._v("\r\n                  单位："),a("el-select",{attrs:{clearable:"",placeholder:"请选择客户单位"},model:{value:e.select_unit,callback:function(t){e.select_unit=t},expression:"select_unit"}},e._l(e.allUnit,function(e){return a("el-option",{key:e.id,attrs:{label:e.clientCompanyName,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"grid-content bg-purple"},[e._v("\r\n                  项目： "),a("el-select",{attrs:{clearable:"",placeholder:"请选择项目"},model:{value:e.select_project,callback:function(t){e.select_project=t},expression:"select_project"}},e._l(e.allProject,function(e){return a("el-option",{key:e.id,attrs:{label:e.projectName,value:e.id}})}))],1)])],1)],1),e._v(" "),a("div",{staticClass:"handle-box"},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:function(t){e.selectAll()}}},[e._v("搜索")])],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"10px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"所属项目",prop:"projectName"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.project.projectName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"客户单位",prop:"cilentCompanyName"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.project.processUnit.clientCompanyName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"success"}},[e._v(e._s(t.row.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"纹理代码"},scopedSlots:e._u([{key:"default",fn:function(t){return e._l(t.row.wenlis,function(t){return a("el-tag",{key:t.id,staticStyle:{"margin-right":"5px"},attrs:{type:"success",size:"mini","disable-transitions":!1}},[e._v(e._s(t.wenliName)+"\r\n                ")])})}}])}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toinfo(t.row.id)}}},[e._v("查看详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var i=a("Z0/y")(l,r,!1,function(e){a("qN3z")},"data-v-496315f8",null);t.default=i.exports},qN3z:function(e,t){},xPas:function(e,t){},zRBn:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l,r=a("a3Yh"),i=a.n(r),s=a("3cXf"),o=a.n(s),n=a("OIbc"),c=a("+J3q"),u={data:function(){return{table_loading:!1,udapteBoolean:!1,wenliData:[],elform1:{wenliName:"",area:"0",times:"1"},innerVisible:!1,contr_loading:!1,base_loading:!1,exform:{addUserId:"",addUserName:"",orderId:"",qiKong:"待定",queKou:"待定",lieFeng:"待定",hanBa:"待定",dianHuoHua:"待定",youShiSi:"待定",pianXi:"待定",buPing:"待定",heMoBian:"0",fenXingBian:"0",tongGZ:!1,zuiHouShiMoJian:"0",ckd:"0",guangJian:"0"},filterText:"",tree_loading:!1,item_order_id:"2",defaultProps:{children:"children",label:"label"},select_part:[],upload:"",data3:[],nowTab:1,username:"",name:"",uid:"",imageUrls:[],restaurants1:[],restaurants2:[],restaurants3:[],restaurants4:[],imageData:{userId:"",imgPakage:"order_pm"},ruleForm:{managerName:"",orderName:"",addUserId:"",addUserName:"",projectId:"",hasRemark:!1,picUrls:"",urgency:"0",remark:"",realityArea:"0",expectedTime:"",beiShu:"1",machiningType:""},restaurants:[],rules:{orderName:[{required:!0,message:"请输入订单名称",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],wenliName:[{required:!0,message:"请输入订单名称",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],piWenDaiMa:[{required:!0,message:"请输入订单名称",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}],machiningType:[{required:!0,message:"请选择工艺类型",trigger:"blur"}],managerId:[{required:!0,message:"请选择车间负责人",trigger:"blur"}],realityArea:[{required:!0,message:"请输入加工面积",trigger:"blur"}],projectId:[{required:!0,message:"请选择所属项目",trigger:"blur"}],urgency:[{required:!0,message:"请选择订单紧急成度",trigger:"blur"}],beiShu:[{required:!0,message:"请填写倍数",trigger:"blur"}],expectedTime:[{required:!0,message:"请选择加工预期",trigger:"blur"}]}}},components:{VueCoreImageUpload:n.default},watch:{filterText:function(e){this.$refs.tree2.filter(e)}},methods:(l={deleteRow:function(e,t){t.splice(e,1)},toUpdateProduct:function(){},addWenLi:function(){if("undefined"==this.elform1.times||this.elform1.times<=0)this.$message.error("请正确填写面积倍数");else{var e={wenliName:this.elform1.wenliName,times:this.elform1.times,area:this.elform1.area,addUserId:this.uid,addUserName:this.name};this.wenliData.push(e),this.elform1={wenliName:"",area:"0",times:"1"},this.innerVisible=!1}},chanel:function(){this.innerVisible=!1,this.elform1={wenliName:"",area:"0",times:"1"}},toAddWenLi:function(){this.innerVisible=!0},toCommit:function(){this.contr_loading=!0,this.toAddNew()},toAddNew:function(){for(var e=this,t=this,a="",l=t.ruleForm.managerId,r=0;r<t.restaurants4.length;r++)l===t.restaurants4[r].value&&(t.ruleForm.managerName=t.restaurants4[r].label);var i=t.ruleForm;if(0!=t.imageUrls.length)for(var s=0;s<t.imageUrls.length;s++)s==t.imageUrls.length-1?a+=t.imageUrls[s]:a=t.imageUrls[s]+"|"+a;i.picUrls=a,i.addUserId=this.uid,i.addUserName=this.name,i.wenlis=this.wenliData;var o=0;for(s=0;s<this.wenliData.length;s++)o+=this.wenliData[s].area*this.wenliData[s].times;i.realityArea=o,t.exform.orderId=t.item_order_id,t.exform.addUserId=t.uid,t.exform.addUserName=t.name;var n={order:i,mouldIds:this.toGetMouldIds(),controlOrderFrom:t.exform,wenlis:this.wenliData};this.jsonPostRequest("/order/list/new/add",n).then(function(a){a&&200==a.status&&0==a.data.code?(t.$message.success("订单添加成功"),t.resetForm("ruleForm"),t.imageUrls=[],t.$store.state.stomp.send("/ws/nf",{},""),e.$router.push("/order/list")):t.$message.error("订单添加失败")})},toGetMouldIds:function(){for(var e="",t=0;t<this.select_part.length;t++)t==this.select_part.length-1?e+=this.select_part[t].collectPartinfoEntity.id:e=e+this.select_part[t].collectPartinfoEntity.id+",";return e},toControl:function(){"undefined"===this.select_part||!this.select_part.length>0?this.$message.info("请选择有效的模具"):this.nowTab=2},addcontroInfo:function(){var e=this,t=this;t.exform.orderId=t.item_order_id,t.exform.addUserId=t.uid,t.exform.addUserName=t.name,this.postRequest("/order/list/add/control",t.exform).then(function(a){e.contr_loading=!1,a&&200==a.status&&0==a.data.code?(t.$message.success("订单添加成功"),t.$store.state.stomp.send("/ws/nf",{},""),e.$router.push("/order/list")):t.$message.error(data.msg)})},initSysMsgs:function(){var e=this;this.getRequest("/chat/sysmsgs").then(function(t){e.sysmsgs=t.data;var a=!1;e.sysmsgs.forEach(function(e){0==e.state&&(a=!0)}),e.$store.commit("toggleNFDot",a)})},splitUrl:function(e){var t=e.picUrls,a=[];return"undefined"!=t&&""!=t&&(a=t.split("|")),a},addSelected:function(e){var t=this.select_part;if(0===t.length)e.collectPartinfoEntity.picurl instanceof Array?t.push(e):(e.collectPartinfoEntity.picurl=this.splitUrl(e.collectPartinfoEntity),t.push(e));else{for(var a=!0,l=0;l<t.length;l++)if(t[l].id===e.id){a=!1;break}a&&(e.collectPartinfoEntity.picurl instanceof Array?t.push(e):(e.collectPartinfoEntity.picurl=this.splitUrl(e.collectPartinfoEntity),t.push(e)))}},delSelected:function(e){for(var t=this.select_part,a=[],l=0;l<t.length;l++)t[l].id!==e.id&&a.push(t[l]);this.select_part=a},toChangeCheck:function(e,t){var a=e.disabled;t&&!a?"undefined"!==e.collectPartinfoEntity&&this.addSelected(e):t||a||"undefined"!==e.collectPartinfoEntity&&this.delSelected(e)},filterNode:function(e,t){return!e||-1!==t.label.indexOf(e)},toChangeSet:function(){var e=this;if("undefined"===e.select_part||!e.select_part.length>0)e.$message.info("请选择有效的模具");else{for(var t={partIds:[]},a=0;a<e.select_part.length;a++)t.partIds.push(e.select_part[a].collectPartinfoEntity.id);if("undefined"===t.partIds||!t.partIds.length>0)e.$message.info("请选择有效的模具");else{var l={data:o()(t),userId:"123",userToken:"",md5:"",source:""};c.a.updateSetOrderMould(l).then(function(t){"0"==t.code?(e.$message.success("修改成功"),e.getMouldTree(),e.select_part=[],e.is_set=!1):e.$message.error(t.msg)})}}},toSetMouldPart:function(){for(var e=this,t=this,a={orderId:t.item_order_id,uid:this.uid,mouldIds:""},l="",r=0;r<t.select_part.length;r++)r==t.select_part.length-1?l+=t.select_part[r].collectPartinfoEntity.id:l=l+t.select_part[r].collectPartinfoEntity.id+",";a.mouldIds=l,this.postRequest("/order/list/set/mould",a).then(function(a){a&&200==a.status&&0==a.data.code?e.addcontroInfo():t.$message.error("模具设置失败")})},getMouldTree:function(){var e=this,t=this;this.getRequest("/order/list/mould/tree").then(function(a){e.tree_loading=!1,a&&200==a.status&&0==a.data.code&&(t.data3=a.data.data.tree)})},resetForm:function(e){this.$refs[e].resetFields()},resetForm1:function(e){this.exform={addUserId:"",addUserName:"",orderId:"",qiKong:"无",queKou:"无",lieFeng:"无",hanBa:"无",dianHuoHua:"无",youShiSi:"无",heMoBian:"0",fenXingBian:"0",tongGZ:!1,zuiHouShiMoJian:"0",ckd:"0",guangJian:"0"}},submitForm:function(e){var t=this,a=this;this.$refs[e].validate(function(e){if(!e)return a.$message.error("请检查输入信息的格式"),!1;t.nowTab=3})},toAddBaseInfo:function(){for(var e=this,t=this,a="",l=t.ruleForm.managerId,r=0;r<t.restaurants4.length;r++)l===t.restaurants4[r].value&&(t.ruleForm.managerName=t.restaurants4[r].label);var i=t.ruleForm;if(0!=t.imageUrls.length)for(var s=0;s<t.imageUrls.length;s++)s==t.imageUrls.length-1?a+=t.imageUrls[s]:a=t.imageUrls[s]+"|"+a;i.picUrls=a,i.addUserId=this.uid,i.addUserName=this.name,this.postRequest("/order/list/add/order",i).then(function(a){if(a&&200==a.status&&0==a.data.code){t.resetForm("ruleForm"),t.imageUrls=[];var l=a.data.data.id;t.item_order_id=l,l>0?e.toSetMouldPart():t.$message.error("基础信息创建失败")}else t.$message.error("基础信息创建失败")})},handleSelect:function(e){console.log(e)},querySearch:function(e,t){var a=this.restaurants;t(e?a.filter(this.createFilter(e)):a)},querySearch1:function(e,t){var a=this.restaurants1;t(e?restaurants1.filter(this.createFilter(e)):a)},querySearch2:function(e,t){var a=this.restaurants2;t(e?restaurants2.filter(this.createFilter(e)):a)},querySearch5:function(e,t){var a=this.restaurants5;t(e?restaurants5.filter(this.createFilter(e)):a)},querySearch6:function(e,t){var a=this.restaurants6;t(e?restaurants6.filter(this.createFilter(e)):a)},createFilter:function(e){return function(t){return 0===t.value.toLowerCase().indexOf(e.toLowerCase())}},delMouldImage:function(e){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.todelImage(e)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},todelImage:function(e){var t=this;"undefined"!=e&&""!=e.length?this.getRequest("/config/delfile/delImage?url="+e).then(function(a){if(a&&200==a.status&&0==a.data.code){t.$message.success("删除成功");for(var l=t.imageUrls,r=[],i=0;i<l.length;i++)e!=l[i]&&r.push(l[i]);t.imageUrls=r}else t.$message.error("删除照片失败")}):t.$message.error("删除图片不存在")},imageuploaded:function(e){if("undefined"!==e.url.length&&e.url.length>0){for(var t=e.url,a=this.imageUrls,l=0;l<t.length;l++)a.push(t[l]);this.imageUrls=a}},handleError:function(){this.$notify.error({title:"上传失败",message:"图片上传出现异常"})},loadAllProject:function(){var e=this;this.getRequest("/project/list/byuid?uid="+this.uid).then(function(t){if(t&&200==t.status&&0==t.data.code){var a=[],l=t.data.data.projectlist;if("undefined"!=l&&l.length>0){for(var r=0;r<l.length;r++){var i={label:"",value:""};i.label=l[r].projectName,i.value=l[r].id,a.push(i)}e.restaurants3=a}}else console.log("获取列表数据失败")})},loadAllManger:function(){var e=this;this.getRequest("/order/list/mangers?role=ROLE_chejian").then(function(t){if(t&&200==t.status&&0==t.data.code){var a=[],l=t.data.data;if("undefined"!=l&&l.length>0){for(var r=0;r<l.length;r++){var i={label:"",value:""};i.label=l[r].name,i.value=l[r].id,a.push(i)}e.restaurants4=a}}else console.log("获取车间负责人失败")})}},i()(l,"handleError",function(){this.$notify.error({title:"上传失败",message:"图片上传出现异常"})}),i()(l,"loadAll5",function(){return[{value:"区域件"},{value:"纹理件"}]}),i()(l,"loadAll6",function(){return[{value:"按样板"},{value:"按皮纹件"},{value:"按匹配件"}]}),i()(l,"loadAll",function(){return[{value:"传统"},{value:"电火花"},{value:"喷砂"},{value:"激光"},{value:"其他"}]}),i()(l,"loadAll1",function(){return[{value:"无"},{value:"按客户划线多做"},{value:"按客户划线少做"},{value:"喷砂多做"},{value:"喷砂少做"},{value:"激光多做"},{value:"激光少做"},{value:"其他"}]}),i()(l,"loadAll2",function(){return[{value:"无"},{value:"按客户划线多做"},{value:"按客户划线少做"},{value:"喷砂多做"},{value:"喷砂少做"},{value:"激光多做"},{value:"激光少做"},{value:"其他"},{value:"全做"}]}),i()(l,"getCollectMouldList",function(){var e=this;this.getRequest("/order/list/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.orderlist,e.totalnum=t.data.data.count)})}),l),mounted:function(){this.$nextTick(function(){this.imageData.userId=localStorage.getItem("cp_uid"),this.upload=c.a.upload}),this.restaurants=this.loadAll(),this.restaurants1=this.loadAll1(),this.restaurants2=this.loadAll2(),this.restaurants5=this.loadAll5(),this.restaurants6=this.loadAll6(),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.restaurants=this.loadAll(),this.loadAllProject(),this.loadAllManger(),this.tree_loading=!0,this.getMouldTree()}},d={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("订单管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("创建订单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{"align-items":"center","margin-top":"40px"}},[a("el-steps",{attrs:{active:e.nowTab}},[a("el-step",{attrs:{title:"基本信息",icon:"el-icon-edit"}}),e._v(" "),a("el-step",{attrs:{title:"选择模具",icon:"el-icon-picture"}}),e._v(" "),a("el-step",{attrs:{title:"下控制单",icon:"el-icon-document"}})],1)],1),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("div",{directives:[{name:"show",rawName:"v-show",value:2===e.nowTab,expression:"nowTab === 2"},{name:"loading",rawName:"v-loading",value:e.base_loading,expression:"base_loading"}]},[a("el-card",{staticStyle:{"margin-top":"30px"}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"120px"}},[a("div",[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"订单名称：",prop:"orderName"}},[a("el-input",{staticStyle:{width:"217px"},attrs:{placeholder:"请输入订单名称"},model:{value:e.ruleForm.orderName,callback:function(t){e.$set(e.ruleForm,"orderName",t)},expression:"ruleForm.orderName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"所属项目：",prop:"projectId"}},[a("el-select",{attrs:{placeholder:"请选择所属项目"},model:{value:e.ruleForm.projectId,callback:function(t){e.$set(e.ruleForm,"projectId",t)},expression:"ruleForm.projectId"}},e._l(e.restaurants3,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"车间负责人：",prop:"managerId"}},[a("el-select",{attrs:{placeholder:"请选择所属项目"},model:{value:e.ruleForm.managerId,callback:function(t){e.$set(e.ruleForm,"managerId",t)},expression:"ruleForm.managerId"}},e._l(e.restaurants4,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"加工预期：",prop:"expectedTime"}},[a("el-date-picker",{staticStyle:{width:"40%"},attrs:{format:"yyyy 年 MM 月 dd 日 HH:mm:ss","value-format":"yyyy-MM-dd HH:mm:ss",type:"datetime",placeholder:"选择日期时间"},model:{value:e.ruleForm.expectedTime,callback:function(t){e.$set(e.ruleForm,"expectedTime",t)},expression:"ruleForm.expectedTime"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传图片："}},[a("div",[a("vue-core-image-upload",{class:["el-button","el-button--primary"],attrs:{crop:!1,inputOfFile:"imageFile",url:e.upload,extensions:"png,gif,jpeg,jpg","max-file-size":5242880,data:e.imageData,text:"上传图片",multiple:!0,"multiple-size":30,credentials:"true"},on:{imageuploaded:e.imageuploaded,errorhandle:e.handleError}})],1)])],1),e._v(" "),a("el-col",{attrs:{span:2}},[a("div",{staticStyle:{width:"100%",height:"1px"}})]),e._v(" "),a("el-col",{attrs:{span:10}},[a("el-form-item",{attrs:{label:"紧急程度：",prop:"urgency"}},[a("el-select",{attrs:{placeholder:"请选择紧急程度"},model:{value:e.ruleForm.urgency,callback:function(t){e.$set(e.ruleForm,"urgency",t)},expression:"ruleForm.urgency"}},[a("el-option",{attrs:{label:"特急",value:"8"}}),e._v(" "),a("el-option",{attrs:{label:"紧急A",value:"7"}}),e._v(" "),a("el-option",{attrs:{label:"紧急B",value:"6"}}),e._v(" "),a("el-option",{attrs:{label:"紧急C",value:"5"}}),e._v(" "),a("el-option",{attrs:{label:"急A",value:"4"}}),e._v(" "),a("el-option",{attrs:{label:"急B",value:"3"}}),e._v(" "),a("el-option",{attrs:{label:"急C",value:"2"}}),e._v(" "),a("el-option",{attrs:{label:"正常",value:"1"}}),e._v(" "),a("el-option",{attrs:{label:"不急",value:"0"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"加工类型：",prop:"machiningType"}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch,placeholder:"请输入加工类型"},on:{select:e.handleSelect},model:{value:e.ruleForm.machiningType,callback:function(t){e.$set(e.ruleForm,"machiningType",t)},expression:"ruleForm.machiningType"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"是否有备忘：",prop:"hasRemark"}},[a("el-switch",{attrs:{"active-text":"有","inactive-text":"无"},model:{value:e.ruleForm.hasRemark,callback:function(t){e.$set(e.ruleForm,"hasRemark",t)},expression:"ruleForm.hasRemark"}})],1),e._v(" "),a("el-form-item",{staticStyle:{width:"80%"},attrs:{label:"备注：",prop:"remark"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.ruleForm.remark,callback:function(t){e.$set(e.ruleForm,"remark",t)},expression:"ruleForm.remark"}})],1)],1)],1)],1)]),e._v(" "),a("div",{staticStyle:{"margin-bottom":"15px"}},[a("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.table_loading,expression:"table_loading"}],staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("纹理列表")]),e._v(" "),a("el-button",{staticClass:"el-icon-plus",staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:e.toAddWenLi}},[e._v("添加")])],1),e._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.wenliData,border:"","show-summary":""}},[a("el-table-column",{attrs:{prop:"wenliName",label:"纹理代码"}}),e._v(" "),a("el-table-column",{attrs:{prop:"times",label:"倍数"}}),e._v(" "),a("el-table-column",{attrs:{prop:"area",label:"面积"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"300"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.deleteRow(t.$index,e.wenliData)}}},[e._v("\r\n             移除\r\n           ")])]}}])})],1)],1)])],1),e._v(" "),a("div",{staticStyle:{border:"1px dashed #d9d9d9",width:"100%","min-height":"358px"}},[a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{gutter:20}},e._l(e.imageUrls,function(t){return a("el-col",{attrs:{span:6}},[a("el-card",{staticClass:"mould-card",attrs:{"body-style":{padding:"0px"}}},[a("img",{staticClass:"image",staticStyle:{height:"420px"},attrs:{src:t}}),e._v(" "),a("div",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"text"},on:{click:function(a){e.delMouldImage(t)}}},[a("i",{staticClass:"el-icon-error",staticStyle:{color:"red"}})])],1)])],1)}))],1),e._v(" "),a("div",{staticClass:"card-bottom"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm("ruleForm")}}},[e._v("下一步")])],1)],1),e._v(" "),a("div",[a("el-dialog",{attrs:{width:"60%",title:"纹理详情",visible:e.innerVisible,"close-on-click-modal":!1,"append-to-body":""},on:{"update:visible":function(t){e.innerVisible=t}}},[a("el-form",{ref:"elform1",staticStyle:{width:"100%"},attrs:{model:e.elform1,rules:e.rules,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"纹理名称：",prop:"wenliName"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入纹理代码"},model:{value:e.elform1.wenliName,callback:function(t){e.$set(e.elform1,"wenliName",t)},expression:"elform1.wenliName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"倍数：",prop:"times"}},[a("el-input",{staticStyle:{width:"30%"},attrs:{"controls-position":"right"},model:{value:e.elform1.times,callback:function(t){e.$set(e.elform1,"times",t)},expression:"elform1.times"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"加工面积：",prop:"area"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.elform1.area,callback:function(t){e.$set(e.elform1,"area",t)},expression:"elform1.area"}})],1),e._v(" "),a("span",{staticStyle:{color:"red"}},[e._v("面积不能为0，请填写大于0的数字")])],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.addWenLi()}}},[e._v("确 定")]),e._v(" "),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.udapteBoolean,expression:"udapteBoolean"}],attrs:{type:"primary"},on:{click:e.toUpdateProduct}},[e._v("更 新")]),e._v(" "),a("el-button",{on:{click:e.chanel}},[e._v("取 消")])],1)],1)],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("选择模具")])]),e._v(" "),a("div",[a("el-row",{attrs:{gutter:30}},[a("el-col",{directives:[{name:"loading",rawName:"v-loading",value:e.tree_loading,expression:"tree_loading"}],attrs:{span:4}},[a("el-input",{attrs:{placeholder:"输入关键字进行过滤"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),e._v(" "),a("el-tree",{ref:"tree2",staticClass:"filter-tree",staticStyle:{"border-right":"1px solid #e6e6e6","min-height":"260px"},attrs:{data:e.data3,props:e.defaultProps,"default-expand-all":"","filter-node-method":e.filterNode,"show-checkbox":"","node-key":"id"},on:{"check-change":e.toChangeCheck}})],1),e._v(" "),a("el-col",{attrs:{span:20}},[a("div",{staticStyle:{"min-height":"15px",width:"100%"}},[a("el-row",{attrs:{gutter:30}},e._l(e.select_part,function(t){return a("el-col",{attrs:{span:6}},[a("el-card",{staticClass:"mould-card",attrs:{"body-style":{padding:"0px"}}},[a("img",{staticClass:"image",staticStyle:{height:"260px"},attrs:{src:t.collectPartinfoEntity.picurl[0]}}),e._v(" "),a("div",{staticStyle:{padding:"14px"}},[a("h4",[e._v(e._s(t.collectPartinfoEntity.mouldName))]),e._v(" "),a("span",[e._v("备注："+e._s(t.collectPartinfoEntity.remark))]),e._v(" "),a("div",{staticClass:"bottom clearfix"},[a("time",{staticClass:"time"},[e._v(e._s(t.collectPartinfoEntity.createTime))])])])])],1)}))],1)])],1)],1),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"left"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.nowTab=1}}},[e._v("上一步")])],1),e._v(" "),a("div",{staticClass:"card-bottom"},[a("el-button",{attrs:{type:"primary"},on:{click:e.toControl}},[e._v("下一步")])],1)])],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:3===e.nowTab,expression:"nowTab===3"}],staticStyle:{"margin-top":"40px"}},[a("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.contr_loading,expression:"contr_loading"}],staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("控制单")])]),e._v(" "),a("div",[a("el-form",{ref:"exform",staticClass:"demo-ruleForm",attrs:{model:e.exform,"label-width":"180px"}},[a("div",[a("el-row",{attrs:{gutter:30}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"气孔："}},[a("el-radio-group",{model:{value:e.exform.qiKong,callback:function(t){e.$set(e.exform,"qiKong",t)},expression:"exform.qiKong"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"补"}}),e._v(" "),a("el-radio",{attrs:{label:"不补"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"缺口："}},[a("el-radio-group",{model:{value:e.exform.queKou,callback:function(t){e.$set(e.exform,"queKou",t)},expression:"exform.queKou"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"补"}}),e._v(" "),a("el-radio",{attrs:{label:"不补"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"裂缝："}},[a("el-radio-group",{model:{value:e.exform.lieFeng,callback:function(t){e.$set(e.exform,"lieFeng",t)},expression:"exform.lieFeng"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"补"}}),e._v(" "),a("el-radio",{attrs:{label:"不补"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"焊疤："}},[a("el-radio-group",{model:{value:e.exform.hanBa,callback:function(t){e.$set(e.exform,"hanBa",t)},expression:"exform.hanBa"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"优化"}}),e._v(" "),a("el-radio",{attrs:{label:"不处理"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"电火花："}},[a("el-radio-group",{model:{value:e.exform.dianHuoHua,callback:function(t){e.$set(e.exform,"dianHuoHua",t)},expression:"exform.dianHuoHua"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"抛光"}}),e._v(" "),a("el-radio",{attrs:{label:"不抛光"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"油石丝："}},[a("el-radio-group",{model:{value:e.exform.youShiSi,callback:function(t){e.$set(e.exform,"youShiSi",t)},expression:"exform.youShiSi"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"抛光"}}),e._v(" "),a("el-radio",{attrs:{label:"不抛光"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"不平："}},[a("el-radio-group",{model:{value:e.exform.buPing,callback:function(t){e.$set(e.exform,"buPing",t)},expression:"exform.buPing"}},[a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"处理"}}),e._v(" "),a("el-radio",{attrs:{label:"不处理"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.exform.remark,callback:function(t){e.$set(e.exform,"remark",t)},expression:"exform.remark"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"材质偏析："}},[a("el-radio-group",{model:{value:e.exform.pianXi,callback:function(t){e.$set(e.exform,"pianXi",t)},expression:"exform.pianXi"}},[a("el-radio",{attrs:{label:"待定"}}),e._v(" "),a("el-radio",{attrs:{label:"无"}}),e._v(" "),a("el-radio",{attrs:{label:"有"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"区域："}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch5,placeholder:"请输入"},on:{select:e.handleSelect},model:{value:e.exform.quYu,callback:function(t){e.$set(e.exform,"quYu",t)},expression:"exform.quYu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"深度："}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch6,placeholder:"请输入"},on:{select:e.handleSelect},model:{value:e.exform.shenDu,callback:function(t){e.$set(e.exform,"shenDu",t)},expression:"exform.shenDu"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"同光泽处理区域："}},[a("el-switch",{attrs:{"active-text":"有","inactive-text":"无"},model:{value:e.exform.tongGZ,callback:function(t){e.$set(e.exform,"tongGZ",t)},expression:"exform.tongGZ"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"最后试模件："}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.exform.zuiHouShiMoJian,callback:function(t){e.$set(e.exform,"zuiHouShiMoJian",t)},expression:"exform.zuiHouShiMoJian"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"CKD件："}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.exform.ckd,callback:function(t){e.$set(e.exform,"ckd",t)},expression:"exform.ckd"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"光件（非最后试模件）："}},[a("el-input-number",{attrs:{"controls-position":"right",min:0},model:{value:e.exform.guangJian,callback:function(t){e.$set(e.exform,"guangJian",t)},expression:"exform.guangJian"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"分型线光边："}},[a("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.exform.fenXingBian,callback:function(t){e.$set(e.exform,"fenXingBian",t)},expression:"exform.fenXingBian"}},[a("template",{slot:"append"},[e._v("mm")])],2)],1),e._v(" "),a("el-form-item",{attrs:{label:"合模线光边："}},[a("el-input",{attrs:{placeholder:"请输入内容"},model:{value:e.exform.heMoBian,callback:function(t){e.$set(e.exform,"heMoBian",t)},expression:"exform.heMoBian"}},[a("template",{slot:"append"},[e._v("mm")])],2)],1),e._v(" "),a("el-form-item",{attrs:{label:"光泽："}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch1,placeholder:"请输入"},model:{value:e.exform.guangze,callback:function(t){e.$set(e.exform,"guangze",t)},expression:"exform.guangze"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"碰穿边："}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch1,placeholder:"请输入"},on:{select:e.handleSelect},model:{value:e.exform.pengChuanBian,callback:function(t){e.$set(e.exform,"pengChuanBian",t)},expression:"exform.pengChuanBian"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"碰穿孔："}},[a("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":e.querySearch2,placeholder:"请输入"},on:{select:e.handleSelect},model:{value:e.exform.pengChuanKong,callback:function(t){e.$set(e.exform,"pengChuanKong",t)},expression:"exform.pengChuanKong"}})],1)],1)],1)],1)])],1),e._v(" "),a("div",{staticClass:"card-bottom",staticStyle:{float:"left"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.nowTab=2}}},[e._v("上一步")])],1),e._v(" "),a("div",{staticClass:"card-bottom"},[a("el-button",{attrs:{type:"primary"},on:{click:e.toCommit}},[e._v("提 交")]),e._v(" "),a("el-button",{on:{click:function(t){e.resetForm1("exform")}}},[e._v("重 置")])],1)])],1)])],1)],1)])},staticRenderFns:[]};var m=a("Z0/y")(u,d,!1,function(e){a("xPas")},"data-v-7854a870",null);t.default=m.exports}});
//# sourceMappingURL=18.f6cfb95a6e1c9c007a7e.js.map
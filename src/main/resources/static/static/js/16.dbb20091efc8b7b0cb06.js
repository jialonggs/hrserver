webpackJsonp([16],{"1wOu":function(e,t){},"2Hia":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("a3Yh"),l=a.n(r),i=a("OIbc"),s=a("+J3q"),n={components:{VueCoreImageUpload:i.default},data:function(){var e;return e={activeName2:"first",zhiliang:[],restaurants4:[],itemYga:{},form1:{},Ygas:[],orderUsers:{},dialogTableVisible1:!1,stepId:"",wen_jian_url:"",upload:"",wenjianData:{userId:"",imgPakage:"yu_bao_jia"}},l()(e,"form1",{biLi:5}),l()(e,"username",""),l()(e,"name",""),l()(e,"uid",""),l()(e,"itemOrderId",""),l()(e,"dialogFormVisible",!1),l()(e,"select_word",""),l()(e,"form",{presentStepName:""}),l()(e,"flowStepId",""),l()(e,"currentPage",1),l()(e,"totalnum",0),l()(e,"pagesize",10),l()(e,"select_word",""),l()(e,"tableData1",[]),l()(e,"currentPage1",1),l()(e,"totalnum1",0),l()(e,"pagesize1",10),l()(e,"select_word1",""),l()(e,"tableData1",[]),e},methods:{toJieSuan:function(){var e=this,t=this;if(this.Ygas.length<=0)t.$message.error("请至少分配一名工艺师");else{for(var a=0,r=0;r<this.Ygas.length;r++)a+=this.Ygas[r].biLi;if(10===a){var l={orderId:this.itemTiaoZhen.order.id,orderName:this.itemTiaoZhen.order.orderName,addUserId:this.uid,addUserName:this.name,ygas:this.Ygas};this.jsonPostRequest("/quality/jie/jingfeng",l).then(function(a){a&&200==a.status&&0==a.data.code?(t.$message.success("精封结算成功"),e.quxiao()):t.$message.error("精封结算失败")})}else t.$message.error("精封面积总分配不为10%")}},quxiao:function(){this.Ygas=[],this.zhiliang=[],this.dialogTableVisible1=!1},deleteRow:function(e,t){t.splice(e,1)},selectYga:function(){var e=this.zhiliang,t=(this.itemYga,this.Ygas),a=this.itemTiaoZhen.order.workArea,r=this.form1.biLi;if(e.length<=0)this.$message.error("请选择有效工艺师");else{var l=0;if(l=r*e.length,t.length>0)for(var i=0;i<t.length;i++)l+=t[i].biLi;if(l>10)this.$message.error("面积分配比例超限");else{if(t.length>0){for(i=0;i<t.length;i++){for(var s=t[i],n=!1,o=0;o<e.length;o++)if(e[o].value===s.userId){n=!0;break}if(n)return void this.$message.error("员工已被添加")}for(var u=0;u<e.length;u++){var c={userId:"",userName:"",biLi:"",jingFengArea:"",orderNeedArea:"",jingFengBiLi:""};c.userId=e[u].value,c.userName=e[u].label,c.biLi=r,c.jingFengArea=a*r/100,c.orderNeedArea=a,c.jingFengBiLi=r,this.Ygas.push(c)}}else for(u=0;u<e.length;u++){var d={userId:"",userName:"",biLi:"",jingFengArea:"",orderNeedArea:"",jingFengBiLi:""};d.userId=e[u].value,d.userName=e[u].label,d.biLi=r,d.jingFengArea=a*r/100,d.orderNeedArea=a,d.jingFengBiLi=r,this.Ygas.push(d)}this.$message.success("添加成功"),this.itemYga={},this.form={},this.zhiliang=[]}}},toJingFeng:function(e){var t=this;this.Ygas=[],this.zhiliang=[],this.itemTiaoZhen=e;var a=e.order.id;this.getRequest("/plant/users?status=0&orderId="+a).then(function(e){e&&200==e.status&&0==e.data.code&&(t.orderUsers=e.data.data.orderusers,t.dialogTableVisible1=!0,t.loadAllYuanGongA())})},imageupwenjian:function(e){this.$message.success("上传成功");var t;"undefinded"!=(t=e.url)&&t.length>0&&(this.wen_jian_url=t[0])},handleError:function(){this.$notify.error({title:"上传失败",message:"图片上传出现异常"})},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},handleSizeChange1:function(e){this.pagesize1=e,this.getAllCollectMouldList()},handleCurrentChange1:function(e){this.currentPage1=e,this.getAllCollectMouldList()},toShenHe:function(e){this.dialogFormVisible=!0,this.form.presentStepName=e.order.presentStepName,this.form.remark="",this.stepId=e.order.presentStepId,this.itemOrderId=e.order.id},shenhe:function(){var e=this;if("undefined"!=this.stepId&&""!=this.stepId){var t={presentStepId:this.stepId,orderId:this.itemOrderId,remark:this.form.remark,fuJianUrl:this.wen_jian_url,userId:this.uid,userName:this.name,auditResult:0};this.postRequest("/quality/audit",t).then(function(t){t&&200==t.status&&0==t.data.code?(e.dialogFormVisible=!1,e.getCollectMouldList(),e.getAllCollectMouldList(),e.$message.success("审核成功")):e.$message.error("审核失败")})}else this.$message.error("当前步骤信息有误")},loadAllYuanGongA:function(){var e=this;this.getRequest("/config/mangers?role=ROLE_yga").then(function(t){if(t&&200==t.status&&0==t.data.code){var a=[],r=t.data.data;if("undefined"!=r&&r.length>0){for(var l=0;l<r.length;l++){var i={label:"",value:""};i.label=r[l].name,i.value=r[l].id,a.push(i)}e.restaurants4=a}}else console.log("获取列表数据失败")})},getCollectMouldList:function(){var e=this,t=this;this.getRequest("/quality/process/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&userId="+this.uid+"&status=0").then(function(a){t.tableLoading=!1,a&&200==a.status&&0==a.data.code&&(e.tableData=a.data.data.qualityorderlist,e.totalnum=a.data.data.count)})},getAllCollectMouldList:function(){var e=this,t=this;this.getRequest("/quality/process/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&userId=3&status=0").then(function(a){t.tableLoading=!1,a&&200==a.status&&0==a.data.code&&(e.tableData1=a.data.data.qualityorderlist,e.totalnum1=a.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList(),this.getAllCollectMouldList(),this.upload=s.a.upload}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.wuLiaoName.indexOf(e.select_word)>-1||t.orderName.indexOf(e.select_word)>-1)return t})}}},o={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("质量管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("加工中订单")])],1)],1),e._v(" "),a("div",{staticStyle:{"margin-top":"30px"}},[a("el-tabs",{attrs:{type:"card"},model:{value:e.activeName2,callback:function(t){e.activeName2=t},expression:"activeName2"}},[a("el-tab-pane",{attrs:{label:"我负责的订单",name:"first"}},[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{prop:"",label:"产品名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.orderName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"",label:"项目经理"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.addUserName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"下单日期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDateTime")(t.row.order.createTime)))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(工期["+e._s(e._f("formatDateTime3")(t.row.order.createTime,t.row.order.expectedTime))+"]天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"完工预期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDateTime")(t.row.order.expectedTime)))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(剩余["+e._s(e._f("formatDateTime2")(t.row.order.expectedTime))+"]天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"当前步骤"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"presentSchedule",label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.order.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"urgency",label:"紧急程度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.order.urgency+""=="0"?a("el-tag",{attrs:{type:"info"}},[e._v("一般")]):e._e(),e._v(" "),t.row.order.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.order.liuChengStatus+""=="0"?a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.toShenHe(t.row)}}},[e._v("审 核")]):e._e(),e._v(" "),t.row.order.jingFengStatus+""=="0"?a("el-button",{attrs:{size:"mini",type:"warning"},on:{click:function(a){e.toJingFeng(t.row)}}},[e._v("精 封")]):e._e(),e._v(" "),a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详 情")])]}}])})],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-tab-pane",{attrs:{label:"全部订单",name:"second"}},[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData1}},[a("el-table-column",{attrs:{prop:"",label:"产品名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.orderName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"",label:"项目经理"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.addUserName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"下单日期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDateTime")(t.row.order.createTime)))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(工期["+e._s(e._f("formatDateTime3")(t.row.order.createTime,t.row.order.expectedTime))+"]天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"完工预期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDateTime")(t.row.order.expectedTime)))]),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v("(剩余["+e._s(e._f("formatDateTime2")(t.row.order.expectedTime))+"]天)")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"当前步骤"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.order.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"presentSchedule",label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.order.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"",label:"负责人"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.userName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"urgency",label:"紧急程度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.order.urgency+""=="0"?a("el-tag",{attrs:{type:"info"}},[e._v("一般")]):e._e(),e._v(" "),t.row.order.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.order.liuChengStatus+""=="0"?a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){e.toShenHe(t.row)}}},[e._v("审 核")]):e._e(),e._v(" "),t.row.order.jingFengStatus+""=="0"?a("el-button",{attrs:{size:"mini",type:"warning"},on:{click:function(a){e.toJingFeng(t.row)}}},[e._v("精 封")]):e._e(),e._v(" "),a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(e){}}},[e._v("详 情")])]}}])})],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage1,"page-sizes":[10,30,80,100],"page-size":e.pagesize1,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum1},on:{"size-change":e.handleSizeChange1,"current-change":e.handleCurrentChange1}})],1)],1)],1)],1)]),e._v(" "),a("el-dialog",{attrs:{title:"步骤审核",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{prop:"presentStepName",label:"当前步骤："}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.presentStepName,callback:function(t){e.$set(e.form,"presentStepName",t)},expression:"form.presentStepName"}},[e._v("44")])],1),e._v(" "),a("el-form-item",{attrs:{label:"审核备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传文件："}},[a("div",{directives:[{name:"show",rawName:"v-show",value:""!==e.wen_jian_url,expression:"wen_jian_url !== ''"}]},[a("p",{staticStyle:{color:"blue"}},[e._v("上传成功")])]),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:""===e.wen_jian_url,expression:"wen_jian_url === ''"}]},[a("vue-core-image-upload",{class:["el-button","el-button--primary"],attrs:{crop:!1,inputOfFile:"imageFile",url:e.upload,extensions:"png,ppt,doc,txt,jpg,xsl","max-file-size":5242880,data:e.wenjianData,text:"上传文件",multiple:!0,"multiple-size":30,credentials:"true"},on:{imageuploaded:e.imageupwenjian,errorhandle:e.handleError}})],1)])],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.shenhe}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:function(e){}}},[e._v("驳 回")])],1)]),e._v(" "),a("el-dialog",{attrs:{title:"精封结算",visible:e.dialogTableVisible1},on:{"update:visible":function(t){e.dialogTableVisible1=t}}},[a("el-table",{attrs:{data:e.orderUsers}},[a("el-table-column",{attrs:{property:"orderName",label:"订单名称"}}),e._v(" "),a("el-table-column",{attrs:{property:"biLi",label:"贴花分配比例"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.biLi)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{property:"userName",label:"工艺师"}}),e._v(" "),a("el-table-column",{attrs:{property:"zongJiArea",label:"分配贴花面积"}}),e._v(" "),a("el-table-column",{attrs:{property:"wanChengArea",label:"已完成面积"}}),e._v(" "),a("el-table-column",{attrs:{property:"shengYuArea",label:"未完成面积"}})],1),e._v(" "),a("div",{staticStyle:{"border-top-style":"dotted","border-bottom-style":"dotted","margin-top":"40px"}},[a("p",[e._v(" 结算精封面积：")]),e._v(" "),a("el-form",{attrs:{model:e.form1,"label-width":"30%"}},[a("el-form-item",{attrs:{label:"选择工艺师：",prop:"qualityUsers"}},[a("el-select",{staticStyle:{width:"50%"},attrs:{multiple:"",placeholder:"选择工艺师："},model:{value:e.zhiliang,callback:function(t){e.zhiliang=t},expression:"zhiliang"}},e._l(e.restaurants4,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e}})}))],1),e._v(" "),a("el-form-item",{attrs:{label:"面积比例:"}},[a("el-input-number",{attrs:{"controls-position":"right",min:0,max:10},model:{value:e.form1.biLi,callback:function(t){e.$set(e.form1,"biLi",t)},expression:"form1.biLi"}})],1),e._v(" "),a("el-form-item",[a("el-button",{staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:e.selectYga}},[e._v("确 定")])],1)],1)],1),e._v(" "),e.Ygas.length>0?a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.Ygas,border:""}},[a("el-table-column",{attrs:{prop:"orderNeedArea",label:"产品总面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"userName",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"biLi",label:"精封面积比例"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"danger"}},[e._v(e._s(t.row.biLi)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"jingFengArea",label:"精封面积"}}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.deleteRow(t.$index,e.Ygas)}}},[e._v("移除\r\n  ")])]}}])})],1):e._e(),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.toJieSuan}},[e._v("结算精封")]),e._v(" "),a("el-button",{on:{click:e.quxiao}},[e._v("取 消")])],1)],1)],1)},staticRenderFns:[]};var u=a("Z0/y")(n,o,!1,function(e){a("1wOu")},"data-v-4ad53009",null);t.default=u.exports},"4tNZ":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("a3Yh"),l=a.n(r),i={data:function(){var e;return e={username:"",name:"",uid:"",dialogFormVisible:!1,select_word:"",form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},currentPage:1,totalnum:0,pagesize:10},l()(e,"select_word",""),l()(e,"tableData",[]),e},methods:{handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this,t=this;this.getRequest("/quality/over/listbypage?page="+this.currentPage+"&size="+this.pagesize).then(function(a){t.tableLoading=!1,a&&200==a.status&&0==a.data.code&&(e.tableData=a.data.data.overorderlist,e.totalnum=a.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getCollectMouldList()},computed:{data:function(){var e=this;return e.tableData.filter(function(t){if(t.wuLiaoName.indexOf(e.select_word)>-1||t.orderName.indexOf(e.select_word)>-1)return t})}}},s={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("质量管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("完结的订单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"30px"}},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px","margin-top":"20px"}},[a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{prop:"orderName",label:"产品名称"}}),e._v(" "),a("el-table-column",{attrs:{label:"下单日期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDate")(t.row.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"加工完成"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),e._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[e._v(e._s(e._f("formatDate")(t.row.finishTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"审核负责人"},scopedSlots:e._u([{key:"default",fn:function(t){return e._l(t.row.qualityOrderUsers,function(t){return a("el-tag",{attrs:{type:"success"}},[e._v(e._s(t.userName))])})}}])}),e._v(" "),a("el-table-column",{attrs:{label:"紧急程度"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.urgency+""=="0"?a("el-tag",{attrs:{type:"primary"}},[e._v("一般")]):e._e(),e._v(" "),t.row.urgency+""=="1"?a("el-tag",{attrs:{type:"danger"}},[e._v("紧急")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.toXiangqing}},[e._v("查看详情")])]}}])})],1)],1)])],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"步骤审核",visible:e.dialogFormVisible,width:"40%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{staticClass:"form-box"},[a("el-form",{ref:"form",attrs:{model:e.form,"label-width":"120px"}},[a("el-form-item",{attrs:{label:"当前步骤："}},[a("el-input")],1),e._v(" "),a("el-form-item",{attrs:{label:"加工负责人："}},[a("el-input")],1),e._v(" "),a("el-form-item",{attrs:{label:"开始时间："}},[a("el-col",{attrs:{span:11}},[a("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.form.date1,callback:function(t){e.$set(e.form,"date1",t)},expression:"form.date1"}})],1),e._v(" "),a("el-col",{staticClass:"line",attrs:{span:2}},[e._v("-")]),e._v(" "),a("el-col",{attrs:{span:11}},[a("el-time-picker",{staticStyle:{width:"100%"},attrs:{type:"fixed-time",placeholder:"选择时间"},model:{value:e.form.date2,callback:function(t){e.$set(e.form,"date2",t)},expression:"form.date2"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"备注："}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.form.desc,callback:function(t){e.$set(e.form,"desc",t)},expression:"form.desc"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"上传照片："}},[a("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"/api/posts/",multiple:""}},[a("i",{staticClass:"el-icon-upload"}),e._v(" "),a("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),a("em",[e._v("点击上传")])])])],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("通 过")]),e._v(" "),a("el-button",{attrs:{type:"danger"},on:{click:e.open2}},[e._v("驳 回")])],1)])],1)},staticRenderFns:[]};var n=a("Z0/y")(i,s,!1,function(e){a("qi5H")},"data-v-3023545d",null);t.default=n.exports},qi5H:function(e,t){},r9zt:function(e,t,a){var r={"./QualityFinish.vue":"4tNZ","./QualityProcess.vue":"2Hia"};function l(e){return a(i(e))}function i(e){var t=r[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}l.keys=function(){return Object.keys(r)},l.resolve=i,e.exports=l,l.id="r9zt"}});
//# sourceMappingURL=16.dbb20091efc8b7b0cb06.js.map
webpackJsonp([20],{bvfC:function(e,t,s){var i={"./WorkFlow.vue":"wS0L","./WorkStep.vue":"vw+t"};function a(e){return s(o(e))}function o(e){var t=i[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}a.keys=function(){return Object.keys(i)},a.resolve=o,e.exports=a,a.id="bvfC"},"vw+t":function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i={props:{title:String},data:function(){return{dialogFormVisible:!1,checkLoading:!1,steps:[],username:"",name:"",uid:"",form:{isCheck:!0,isBusRemark:!1},rules:{stepName:[{required:!0,message:"请输入步骤名称",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}]}}},methods:{submitForm:function(e){var t=this,s=this;this.$refs[e].validate(function(e){if(!e)return!1;s.checkLoading=!0,s.form.addUserId=t.uid,s.form.addUserName=t.name,t.postRequest("/work/step/add",s.form).then(function(e){s.checkLoading=!1,e&&200==e.status&&0==e.data.code?(s.$message.success("添加成功"),s.dialogFormVisible=!1,s.loadAllSteps()):s.$message.error("添加失败")})})},addbuzhou:function(){this.dialogFormVisible=!0},loadAllSteps:function(){var e=this;this.getRequest("/work/step/list?").then(function(t){t&&200==t.status&&0==t.data.code?e.steps=t.data.data.steplist:console.log("获取列表数据失败")})},del:function(e){var t=this;this.$confirm("此操作将永久删除该步骤, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.todel(e)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},todel:function(e){var t=this;this.getRequest("/work/step/del?id="+e).then(function(e){e&&200==e.status&&0==e.data.code?(t.$message.success("删除成功"),t.loadAllSteps()):t.$message.error("删除失败")})},resetForm:function(e){this.$refs[e].resetFields()}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.loadAllSteps()}},a={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",[s("div",[s("div",{staticClass:"crumbs"},[s("el-breadcrumb",{attrs:{separator:"/"}},[s("el-breadcrumb-item",[s("i",{staticClass:"el-icon-share"}),e._v("车间管理")]),e._v(" "),s("el-breadcrumb-item",[e._v("步骤管理")])],1)],1),e._v(" "),s("el-container",[s("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[s("div",[s("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[s("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[s("span",[e._v("已有步骤")])]),e._v(" "),s("div",[s("el-row",{attrs:{gutter:20}},[s("el-col",{attrs:{span:6}},[s("div",{on:{click:e.addbuzhou}},[s("el-card",{staticClass:"mould-card",staticStyle:{"min-height":"121px"}},[s("div",{staticStyle:{padding:"14px"}},[s("img",{staticClass:"image"}),e._v(" "),s("i",{staticClass:"el-icon-plus"},[e._v("新增步骤")])])])],1)]),e._v(" "),e._l(e.steps,function(t){return s("el-col",{attrs:{span:6}},[s("el-card",{staticClass:"mould-card",attrs:{"body-style":{padding:"0px"}}},[s("div",{staticStyle:{padding:"14px"}},[s("h4",[e._v(e._s(t.stepName))]),e._v(" "),s("h5",[e._v("添加人:"+e._s(t.addUserName))]),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:!1===t.isCheck,expression:"step.isCheck === false"}]},[s("h6",[e._v("无需审核")])]),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:!0===t.isCheck,expression:"step.isCheck === true"}]},[s("h6",[e._v("需要审核")])]),e._v(" "),s("div",{staticClass:"bottom clearfix"},[s("p",{staticClass:"time"},[e._v("说明："+e._s(t.remark))]),e._v(" "),s("el-dropdown",{staticStyle:{float:"right",color:"#409EFF"}},[s("span",{staticClass:"el-dropdown-link"},[s("i",{staticClass:"el-icon-edit"})]),e._v(" "),s("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[s("el-dropdown-item",[s("el-button",{attrs:{type:"text"},on:{click:function(s){e.del(t.id)}}},[e._v("删 除")])],1)],1)],1)],1)])])],1)})],2)],1)])],1)])],1)],1),e._v(" "),s("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.checkLoading,expression:"checkLoading"}],attrs:{title:"添加步骤","show-close":!1,"close-on-click-modal":!1,"close-on-press-escape":!1,visible:e.dialogFormVisible,width:"50%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[s("div",{staticClass:"form-box"},[s("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[s("el-form-item",{attrs:{label:"步骤名称",prop:"stepName"}},[s("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"请输入步骤名称"},model:{value:e.form.stepName,callback:function(t){e.$set(e.form,"stepName",t)},expression:"form.stepName"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"质量审查"}},[s("el-switch",{model:{value:e.form.isCheck,callback:function(t){e.$set(e.form,"isCheck",t)},expression:"form.isCheck"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"商务监察"}},[s("el-switch",{model:{value:e.form.isBusRemark,callback:function(t){e.$set(e.form,"isBusRemark",t)},expression:"form.isBusRemark"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"说明"}},[s("el-input",{staticStyle:{width:"50%"},attrs:{type:"textarea"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:function(t){e.submitForm("form")}}},[e._v("提 交")]),e._v(" "),s("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")])],1)],1)])],1)},staticRenderFns:[]},o=s("Z0/y")(i,a,!1,null,null,null);t.default=o.exports},wS0L:function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=s("3cXf"),a=s.n(i),o=s("a3Yh"),l=s.n(o),n={props:{title:String},data:function(){var e;return e={morens:[],dialogFormVisible:!1,checkLoading:!1,username:"",name:"",uid:"",form:{isCheck:!0,isBusRemark:!1},buzhounum:"1",active:0},l()(e,"form",{}),l()(e,"steps",[]),l()(e,"restaurants3",[]),l()(e,"itemstep",""),l()(e,"moren",!0),l()(e,"liuchengId",""),l()(e,"liuchengname",""),l()(e,"rules",{flowName:[{required:!0,message:"请输入流程名称",trigger:"blur"},{min:1,max:255,message:"长度在 0 到 255 个字符",trigger:"blur"}]}),e},methods:{handleChange:function(e){},zidingyi:function(){this.dialogFormVisible=!0},submitForm:function(e){var t=this,s=this;this.$refs[e].validate(function(e){if(!e)return!1;s.checkLoading=!0,s.form.addUserId=t.uid,s.form.addUserName=t.name,t.postRequest("/work/step/add",s.form).then(function(e){s.checkLoading=!1,e&&200==e.status&&0==e.data.code?(s.$message.success("添加成功"),s.dialogFormVisible=!1,s.loadAllSteps()):s.$message.error("添加失败")})})},addbuzhou:function(){this.dialogFormVisible=!0},loadAllSteps:function(){var e=this;this.getRequest("/work/step/list?").then(function(t){if(t&&200==t.status&&0==t.data.code){for(var s=t.data.data.steplist,i=[],a=0;a<s.length;a++){var o={label:"",value:""};o.label=s[a].stepName,o.value=s[a].id,i.push(o)}e.restaurants3=i}else console.log("获取列表数据失败")})},loadAllFlows:function(){var e=this;this.getRequest("/work/flow/list/steps?").then(function(t){t&&200==t.status&&0==t.data.code?e.morens=t.data.data.flowlist:console.log("获取列表数据失败")})},del:function(e){var t=this;this.$confirm("此操作将永久删除该步骤, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.todel(e)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},todel:function(e){var t=this;this.getRequest("/work/step/del?id="+e).then(function(e){e&&200==e.status&&0==e.data.code?(t.$message.success("删除成功"),t.loadAllSteps()):t.$message.error("删除失败")})},resetForm:function(e){this.$refs[e].resetFields()},next:function(){this.active++>this.buzhounum-1?(this.active=this.buzhounum,this.steps[this.active-1].stepname=this.itemstep.label,this.steps[this.active-1].stepid=this.itemstep.value):(this.steps[this.active-1].stepname=this.itemstep.label,this.steps[this.active-1].stepid=this.itemstep.value)},up:function(){if(this.active--<1)this.active=0,this.steps[this.active].stepname="步骤 "+(this.active+1),this.steps[this.active].stepid="";else{var e=this.active;this.steps[e].stepname="步骤 "+(this.active+1),this.steps[e].stepid=""}},toAdd:function(){var e=this;if(""!==e.liuchengname)if(""!==e.steps[e.buzhounum-1].stepid){e.checkLoading=!0;var t={flowName:e.liuchengname,moren:e.moren,stepNum:e.buzhounum,addUserId:this.uid,addUserName:this.name};this.postRequest("/work/flow/add",t).then(function(t){e.checkLoading=!1,t&&200==t.status&&0==t.data.code?e.toaddStepAndFlow(t.data.data.id):e.$message.error("添加失败")})}else e.$message.error("请将流程步骤设置完整");else e.$message.error("请填写流程名称")},toaddStepAndFlow:function(e){var t=this,s=this;if(""!==e&&"undefinded"!==e){s.checkLoading=!0;for(var i="",o=0;o<this.steps.length;o++){var l=this.steps[o],n={stepId:l.stepid,addUserId:this.uid,addUserName:this.name,stepIndex:o+1,stepName:l.stepname,flowId:e};i=i+a()(n)+"|"}var r={steps:i};this.postRequest("/work/flow/add/steps",r).then(function(e){s.checkLoading=!1,e&&200==e.status&&0==e.data.code?(s.$message.success("添加成功"),t.dialogFormVisible=!1,t.loadAllFlows()):s.$message.error()})}}},watch:{buzhounum:function(e,t){if(this.steps=[],1!==e)for(var s=1;s<=e;s++){var i={stepname:"步骤 "+s,stepid:""};this.steps.push(i)}}},mounted:function(){this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.loadAllSteps(),this.loadAllFlows()}},r={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",[s("div",[s("div",{staticClass:"crumbs"},[s("el-breadcrumb",{attrs:{separator:"/"}},[s("el-breadcrumb-item",[s("i",{staticClass:"el-icon-share"}),e._v("工序管理")]),e._v(" "),s("el-breadcrumb-item",[e._v("流程管理")])],1)],1),e._v(" "),s("el-container",{staticStyle:{"margin-top":"30px"}},[s("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[s("div",[s("div",[s("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogFormVisible=!1}}},[s("i",{staticClass:"el-icon-document"}),e._v("默认流程")]),e._v(" "),s("el-button",{on:{click:e.zidingyi}},[s("i",{staticClass:"el-icon-edit"}),e._v("自定义流程")])],1),e._v(" "),e._l(e.morens,function(t){return s("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"15px"}},[s("el-dropdown",[s("span",{staticClass:"el-dropdown-link"},[s("i",{staticClass:"el-icon-setting"})]),e._v(" "),s("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[s("el-dropdown-item",[e._v("详情")]),e._v(" "),s("el-dropdown-item",[e._v("删除")])],1)],1),e._v(" "),s("span",[e._v(e._s(t.flowName))]),e._v(" "),s("el-steps",{attrs:{"align-center":""}},e._l(t.stepslist,function(e){return s("el-step",{attrs:{title:e.stepName,description:e.remark}})}))],1)})],2)])],1)],1),e._v(" "),s("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:e.checkLoading,expression:"checkLoading"}],attrs:{title:"自定义流程","show-close":!0,"close-on-click-modal":!1,"close-on-press-escape":!1,visible:e.dialogFormVisible,width:"70%"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[s("div",{staticClass:"form-box"},[s("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[s("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[s("span",[e._v("流程名称："),s("el-input",{staticStyle:{width:"20%"},model:{value:e.liuchengname,callback:function(t){e.liuchengname=t},expression:"liuchengname"}})],1),e._v(" "),s("span",{staticStyle:{"margin-left":"20px"}},[e._v("设置步骤数："),s("el-input-number",{attrs:{"controls-position":"right",min:1},on:{change:e.handleChange},model:{value:e.buzhounum,callback:function(t){e.buzhounum=t},expression:"buzhounum"}})],1)]),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:1!==e.buzhounum,expression:"buzhounum !== 1"}]},[s("el-steps",{attrs:{active:e.active,"finish-status":"success"}},e._l(e.steps,function(e){return s("el-step",{attrs:{title:e.stepname}})}))],1),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:1!==e.buzhounum,expression:"buzhounum !== 1"}],staticStyle:{"margin-top":"25px"}},[s("el-form",{attrs:{"label-width":"80px"}},[s("el-form-item",{attrs:{label:"设定步骤"}},[s("el-select",{attrs:{placeholder:"请选择步骤"},model:{value:e.itemstep,callback:function(t){e.itemstep=t},expression:"itemstep"}},e._l(e.restaurants3,function(e){return s("el-option",{key:e.value,attrs:{label:e.label,value:e}})}))],1),e._v(" "),s("el-form-item",[s("el-button",{attrs:{disabled:this.active===e.buzhounum||""===this.itemstep,type:"primary"},on:{click:e.next}},[e._v("下一步")]),e._v(" "),s("el-button",{attrs:{disabled:0===this.active,type:"primary"},on:{click:e.up}},[e._v("上一步")])],1)],1)],1),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:1!==e.buzhounum,expression:"buzhounum !== 1"}],staticStyle:{height:"1px",width:"100%","border-bottom":"1px solid #e6ebf5","box-sizing":"border-box","margin-bottom":"15px"}}),e._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:1!==e.buzhounum,expression:"buzhounum !== 1"}],staticStyle:{"margin-top":"25px"}},[s("el-form",{attrs:{"label-width":"120px"}},[s("el-form-item",{attrs:{label:"设为默认流程"}},[s("el-switch",{model:{value:e.moren,callback:function(t){e.moren=t},expression:"moren"}})],1)],1),e._v(" "),s("div",[s("el-button",{attrs:{type:"primary"},on:{click:e.toAdd}},[e._v("保存此流程")]),e._v(" "),s("el-button",{attrs:{type:""},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1)])],1)])],1)},staticRenderFns:[]},c=s("Z0/y")(n,r,!1,null,null,null);t.default=c.exports}});
//# sourceMappingURL=20.d273ef514c008abc79b5.js.map
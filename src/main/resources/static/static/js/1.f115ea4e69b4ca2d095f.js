webpackJsonp([1],{"/LNZ":function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",{staticStyle:{"text-align":"left"}},[i("el-input",{staticStyle:{width:"300px"},attrs:{placeholder:"position"==e.state?"添加职位...":"添加职称...",size:"mini","prefix-icon":"el-icon-plus"},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13,t.key))return null;e.addPosition(t)}},model:{value:e.positionName,callback:function(t){e.positionName=t},expression:"positionName"}}),e._v(" "),"jobtitle"==e.state?i("el-select",{attrs:{size:"mini",placeholder:"职称等级"},model:{value:e.titleLevel,callback:function(t){e.titleLevel=t},expression:"titleLevel"}},e._l(e.titleLevels,function(e){return i("el-option",{key:e,attrs:{label:e,value:e}})})):e._e(),e._v(" "),i("el-button",{attrs:{type:"primary",icon:"el-icon-plus",size:"mini"},on:{click:e.addPosition}},[e._v("添加")])],1),e._v(" "),i("div",{staticStyle:{"margin-top":"10px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:e.posData,size:"mini",stripe:"",border:""},on:{"selection-change":e.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55",align:"left"}}),e._v(" "),i("el-table-column",{attrs:{prop:"id",label:"编号",width:"80",align:"left"}}),e._v(" "),i("el-table-column",{attrs:{prop:"name",label:"position"==e.state?"职位名称":"职称名称",width:"180",align:"left"}}),e._v(" "),"jobtitle"==e.state?i("el-table-column",{attrs:{prop:"titleLevel",label:"职称级别",width:"180",align:"left"}}):e._e(),e._v(" "),i("el-table-column",{attrs:{width:"180",label:"创建时间",align:"left"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDate")(t.row.createDate)))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"操作",align:"left"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.handleEdit(t.$index,t.row)}}},[e._v("编辑\n          ")]),e._v(" "),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){e.handleDelete(t.$index,t.row)}}},[e._v("删除\n          ")])]}}])})],1)],1),e._v(" "),i("div",{staticStyle:{"text-align":"left","margin-top":"10px"}},[e.posData.length>0?i("el-button",{attrs:{type:"danger",size:"mini",disabled:0==e.multipleSelection.length},on:{click:e.deleteMany}},[e._v("批量删除\n    ")]):e._e()],1),e._v(" "),i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{attrs:{title:"position"==e.state?"编辑职位名称":"编辑职称",visible:e.dialogVisible,width:"25%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("el-input",{attrs:{size:"mini",placeholder:"请输入新的职位名称..."},model:{value:e.updatePosName,callback:function(t){e.updatePosName=t},expression:"updatePosName"}}),e._v(" "),"jobtitle"==e.state?i("el-select",{staticStyle:{"margin-top":"10px"},attrs:{size:"mini",placeholder:"职称等级"},model:{value:e.updateTitleLevel,callback:function(t){e.updateTitleLevel=t},expression:"updateTitleLevel"}},e._l(e.titleLevels,function(e){return i("el-option",{key:e,attrs:{label:e,value:e}})})):e._e(),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"mini"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:e.updatePosNameExec}},[e._v("确 定")])],1)],1)],1)])},staticRenderFns:[]},n=i("Z0/y")({mounted:function(){this.loadTableData()},methods:{updatePosNameExec:function(){var e=this;if(this.isNotNullORBlank(this.updatePosName)){this.loading=!0;var t=this;this.putRequest("position"==this.state?"/system/basic/position":"/system/basic/joblevel",{name:this.updatePosName,id:this.updatePosId,titleLevel:this.updateTitleLevel}).then(function(i){if(t.loading=!1,i&&200==i.status){e.dialogVisible=!1;var a=i.data;t.$message({type:a.status,message:a.msg}),t.loadTableData()}})}else this.$message.warning("position"==this.state?"职位名称不能为空!":"职称名称不能为空!")},deleteMany:function(){var e=this,t=this;this.$confirm("删除"+this.multipleSelection.length+"条数据, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e="";t.multipleSelection.forEach(function(t){e=e+t.id+","}),t.doDelete(e)}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},addPosition:function(){if(this.isNotNullORBlank(this.positionName))if("jobtitle"!=this.state||this.isNotNullORBlank(this.titleLevel)){var e=this;this.loading=!0,this.postRequest("position"==this.state?"/system/basic/position":"/system/basic/joblevel",{name:this.positionName,titleLevel:this.titleLevel}).then(function(t){if(e.loading=!1,t&&200==t.status){var i=t.data;e.$message({type:i.status,message:i.msg}),e.loadTableData(),e.positionName="",e.titleLevel=""}})}else this.$message.warning("请选择职称级别!");else this.$message.warning("position"==this.state?"职位名称不能为空!":"职称名称不能为空!")},handleSelectionChange:function(e){this.multipleSelection=e},handleEdit:function(e,t){this.updatePosName=t.name,this.updatePosId=t.id,this.updateTitleLevel=t.titleLevel,this.dialogVisible=!0},handleDelete:function(e,t){var i=this,a=this;this.$confirm("删除["+t.name+"], 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.doDelete(t.id)}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},doDelete:function(e){var t=this;t.loading=!0;var i="position"==this.state?"/system/basic/position/":"/system/basic/joblevel/";this.deleteRequest(i+e).then(function(e){t.loading=!1,e&&200==e.status&&t.loadTableData()})},loadTableData:function(){var e=this;this.loading=!0,this.getRequest("position"==this.state?"/system/basic/positions":"/system/basic/joblevels").then(function(t){e.loading=!1,t&&200==t.status&&(e.posData=t.data)})}},data:function(){return{positionName:"",updatePosName:"",updateTitleLevel:"",titleLevel:"",updatePosId:-1,loading:!1,dialogVisible:!1,multipleSelection:[],type:[],titleLevels:["正高级","副高级","中级","初级","员级"],nameLabelName:"position"==this.state?"职位名称":"职称名称",posData:[]}},props:["state"]},a,!1,null,null,null);t.default=n.exports},"5xQo":function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("奖惩规则")])])}]},n=i("Z0/y")(null,a,!1,null,null,null);t.default=n.exports},Dfk2:function(e,t){},FvOz:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=i("a3Yh"),n=i.n(a),s={data:function(){return{keywords:"",depName:"",treeLoading:!1,dialogVisible:!1,allDeps:[],pDep:"",treeData:[],defaultProps:{label:"name",isLeaf:"leaf",children:"children"}}},mounted:function(){this.treeLoading=!0,this.loadTreeData()},watch:{keywords:function(e){this.$refs.tree.filter(e)}},methods:{filterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},loadTreeData:function(){var e=this;this.getRequest("/system/basic/dep/-1").then(function(t){e.treeLoading=!1,t&&200==t.status&&(e.treeData=t.data)})},setDataToTree:function(e,t,i){for(var a=0;a<e.length;a++){var n=e[a];if(n.id==t)return void(e[a].children=e[a].children.concat(i));this.setDataToTree(n.children,t,i)}},addDep:function(){var e=this;this.dialogVisible=!1,this.treeLoading=!0,this.postRequest("/system/basic/dep",{name:this.depName,parentId:this.pDep}).then(function(t){if(e.treeLoading=!1,t&&200==t.status){var i=t.data;e.depName="",e.$message({type:i.status,message:"添加成功!"}),e.setDataToTree(e.treeData,e.pDep,i.msg)}})},loadAllDeps:function(){var e=this;this.getRequest("/system/basic/deps").then(function(t){t&&200==t.status&&(e.allDeps=t.data)})},showAddDepView:function(e,t){this.loadAllDeps(),this.dialogVisible=!0,this.pDep=e.id,t.stopPropagation()},deleteDep:function(e,t){var i=this;e.children.length>0?this.$message({message:"该部门下尚有其他部门，不能被删除!",type:"warning"}):this.$confirm("删除["+e.name+"]部门, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){i.treeLoading=!0,i.deleteRequest("/system/basic/dep/"+e.id).then(function(t){if(i.treeLoading=!1,t&&200==t.status){var a=t.data;i.$message({message:a.msg,type:a.status}),i.deleteLocalDep(i.treeData,e)}})}).catch(function(){i.$message({type:"info",message:"已取消删除"})}),t.stopPropagation()},deleteLocalDep:function(e,t){for(var i=0;i<e.length;i++){var a=e[i];if(a.id==t.id)return void e.splice(i,1);this.deleteLocalDep(a.children,t)}},renderContent:function(e,t){var i,a,s=this,l=t.node,o=t.data;t.store;return e("span",{style:"flex: 1; display: flex; align-items: center; justify-content: space-between; font-size: 14px; padding-right: 8px;"},[e("span",[e("span",[l.label])]),e("span",[e("el-button",(i={style:"font-size: 12px;",attrs:{type:"primary",size:"mini"}},n()(i,"style","padding:3px"),n()(i,"on",{click:function(){return s.showAddDepView(o,event)}}),i),["添加部门"]),e("el-button",(a={style:"font-size: 12px;",attrs:{type:"danger",size:"mini"}},n()(a,"style","padding:3px"),n()(a,"on",{click:function(){return s.deleteDep(o,event)}}),a),["删除部门"])])])}}},l={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",{staticStyle:{"text-align":"left"}},[i("el-input",{staticStyle:{width:"500px",margin:"0px",padding:"0px"},attrs:{placeholder:"输入部门名称搜索部门...",size:"mini","prefix-icon":"el-icon-search"},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}})],1),e._v(" "),i("div",[i("el-tree",{directives:[{name:"loading",rawName:"v-loading",value:e.treeLoading,expression:"treeLoading"}],ref:"tree",staticStyle:{width:"500px","margin-top":"10px"},attrs:{props:e.defaultProps,data:e.treeData,"filter-node-method":e.filterNode,"render-content":e.renderContent}}),e._v(" "),i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{attrs:{title:"添加部门",visible:e.dialogVisible,width:"25%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("div",[i("span",[e._v("上级部门")]),e._v(" "),i("el-select",{staticStyle:{width:"200px"},attrs:{placeholder:"请选择",size:"mini"},model:{value:e.pDep,callback:function(t){e.pDep=t},expression:"pDep"}},e._l(e.allDeps,function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1),e._v(" "),i("div",{staticStyle:{"margin-top":"10px"}},[i("span",[e._v("部门名称")]),e._v(" "),i("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini",placeholder:"请输入部门名称..."},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13,t.key))return null;e.addDep(t)}},model:{value:e.depName,callback:function(t){e.depName=t},expression:"depName"}})],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取消")]),e._v(" "),i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.addDep}},[e._v("添加")])],1)])],1)],1)])},staticRenderFns:[]},o=i("Z0/y")(s,l,!1,null,null,null);t.default=o.exports},LJAE:function(e,t,i){var a={"./SysBasic.vue":"fc7a","./SysCfg.vue":"ubks","./SysData.vue":"UK/j","./SysHr.vue":"ewEk","./SysInit.vue":"agXO","./SysLog.vue":"ZDkW","./basic/DepMana.vue":"FvOz","./basic/ECMana.vue":"5xQo","./basic/JobTitleMana.vue":"c98W","./basic/MenuRole.vue":"eLaH","./basic/PosMana.vue":"/LNZ"};function n(e){return i(s(e))}function s(e){var t=a[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}n.keys=function(){return Object.keys(a)},n.resolve=s,e.exports=n,n.id="LJAE"},PpBR:function(e,t,i){"use strict";var a={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("职称管理")])])}]};t.a=a},"UK/j":function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("\n    备份恢复数据库\n  ")])])}]},n=i("Z0/y")(null,a,!1,null,null,null);t.default=n.exports},YhzV:function(e,t){},ZDkW:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("\n    操作日志管理\n  ")])])}]},n=i("Z0/y")(null,a,!1,null,null,null);t.default=n.exports},agXO:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("\n    初始化数据库\n  ")])])}]},n=i("Z0/y")(null,a,!1,null,null,null);t.default=n.exports},c98W:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=i("YhzV"),n=i.n(a);for(var s in a)"default"!==s&&function(e){i.d(t,e,function(){return a[e]})}(s);var l=i("PpBR"),o=i("Z0/y")(n.a,l.a,!1,null,null,null);t.default=o.exports},eLaH:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=i("oAV5"),n={mounted:function(){this.loading=!0,this.initRoles()},methods:{deleteRole:function(e,t){var i=this;this.$confirm("删除角色["+t+"], 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){i.loading=!0,i.deleteRequest("/system/basic/role/"+e).then(function(e){if(e&&200==e.status){var t=e.data;i.$message({type:t.status,message:t.msg}),i.initRoles()}else i.loading=!1})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},addNewRole:function(){if(Object(a.b)(this.newRole,this.newRoleZh)){this.loading=!0;var e=this;this.postRequest("/system/basic/addRole",{role:this.newRole,roleZh:this.newRoleZh}).then(function(t){if(t&&200==t.status){var i=t.data;e.$message({type:i.status,message:i.msg}),e.initRoles(),e.newRole="",e.newRoleZh=""}else e.loading=!1})}},updateRoleMenu:function(e){var t=this.$refs.tree[e].getCheckedKeys(!0),i=this;this.putRequest("/system/basic/updateMenuRole",{rid:this.activeColItem,mids:t}).then(function(e){if(e&&200==e.status){var t=e.data;i.$message({type:t.status,message:t.msg}),i.activeColItem=-1}})},collapseChange:function(e){if(""!=e){var t=this;this.getRequest("/system/basic/menuTree/"+e).then(function(e){if(e&&200==e.status){var i=e.data;t.treeData=i.menus,t.checkedKeys=i.mids}})}},handleCheckChange:function(e,t,i){},initRoles:function(){var e=this;this.getRequest("/system/basic/roles").then(function(t){e.loading=!1,t&&200==t.status&&(e.roles=t.data,e.activeColItem=-1)})},cancelUpdateRoleMenu:function(){this.activeColItem=-1}},data:function(){return{props:{label:"name",children:"children"},newRole:"",newRoleZh:"",roles:[],treeData:[],checkedKeys:[],loading:!1,activeColItem:-1}}},s={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{"text-align":"left"}},[i("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"请输入角色英文名称...",size:"mini"},model:{value:e.newRole,callback:function(t){e.newRole=t},expression:"newRole"}},[i("template",{slot:"prepend"},[e._v("ROLE_")])],2),e._v(" "),i("el-input",{staticStyle:{width:"250px"},attrs:{placeholder:"请输入角色中文名称...",size:"mini"},model:{value:e.newRoleZh,callback:function(t){e.newRoleZh=t},expression:"newRoleZh"}}),e._v(" "),i("el-button",{staticStyle:{"margin-left":"5px"},attrs:{type:"primary",size:"mini"},on:{click:e.addNewRole}},[e._v("添加角色")])],1),e._v(" "),i("div",{staticStyle:{"margin-top":"10px","text-align":"left"}},[i("el-collapse",{staticStyle:{width:"500px"},attrs:{accordion:""},on:{change:e.collapseChange},model:{value:e.activeColItem,callback:function(t){e.activeColItem=t},expression:"activeColItem"}},e._l(e.roles,function(t,a){return i("el-collapse-item",{key:t.name,attrs:{title:t.nameZh,name:t.id}},[i("el-card",{staticClass:"box-card"},[i("div",{attrs:{slot:"header"},slot:"header"},[i("span",[e._v("可访问的资源")]),e._v(" "),i("el-button",{staticStyle:{color:"#f6061b",margin:"0px",float:"right",padding:"3px 0",width:"15px",height:"15px"},attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(i){e.deleteRole(t.id,t.nameZh)}}})],1),e._v(" "),i("div",[i("el-tree",{key:t.id,ref:"tree",refInFor:!0,attrs:{props:e.props,data:e.treeData,"default-checked-keys":e.checkedKeys,"node-key":"id","show-checkbox":"","highlight-current":""},on:{"check-change":e.handleCheckChange}})],1),e._v(" "),i("div",{staticStyle:{display:"flex","justify-content":"flex-end","margin-right":"10px"}},[i("el-button",{attrs:{size:"mini"},on:{click:e.cancelUpdateRoleMenu}},[e._v("取消修改")]),e._v(" "),i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){e.updateRoleMenu(a)}}},[e._v("确认修改")])],1)])],1)}))],1)])},staticRenderFns:[]},l=i("Z0/y")(n,s,!1,null,null,null);t.default=l.exports},ewEk:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={data:function(){return{hr:{},userface:"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg",item:{},phone:"",telephone:"",rules:{},addLoading:!1,dialogTitle:"",tableLoading:!1,dialogVisible:!1,currentPage:1,totalCount:-1,advanceSearchViewVisible:!1,keywords:"",fullloading:!1,hrs:[],cardLoading:[],eploading:[],allRoles:[],moreBtnState:!1,selRoles:[],selRolesBak:[],itemHr:{},itemSelRoles:[],dialogVisible1:!1}},mounted:function(){this.initCards(),this.loadAllRoles()},methods:{toQuxiao:function(){this.dialogVisible1=!1,this.itemHr=item,this.selRoles=[]},toUpdate:function(e){this.dialogVisible1=!0,this.itemHr=e,this.selRoles=[]},updateRole:function(){this.selRoles.length<=0?this.$message.error("请至少选择一个角色"):this.updateHrRoles(this.itemHr.id)},handleSelectionChange:function(e){this.multipleSelection=e},cancelEidt:function(){this.dialogVisible=!1},currentChange:function(e){this.currentPage=e,this.loadEmps.initCards()},toEnabled:function(e){var t=this;this.$confirm("禁用["+e.name+"]的登录权限, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.switchChange(!1,e.id)}).catch(function(){_this.$message({type:"info",message:"已取消删除"})})},toEnabl:function(e){var t=this;this.$confirm("禁用["+e.name+"]的登录权限, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.switchChange(!0,e.id)}).catch(function(){_this.$message({type:"info",message:"已取消删除"})})},selectEmpByPhone:function(){var e=this,t=this,i=t.phone;""!==i&&11===i.length?this.getRequest("/employee/basic/empbyphone?phone="+i).then(function(i){i&&200==i.status?e.item=i.data.emp:null===i.data.emp?t.$message.error("未找到此员工信息,请核对手机号是否正确"):t.$message.error("系统出错,匹配失败")}):t.$message.error("请检查手机号填写是否正确")},toAddHr:function(){this.addLoading=!0;var e=this,t={username:this.item.phone,name:this.item.name,password:"123456",phone:this.item.phone,userface:this.userface,empId:this.item.id,telephone:this.telephone};this.putRequest("/system/hr/hr/register",t).then(function(t){if(e.addLoading=!1,t&&200==t.status){var i=t.data.id;-1==i?e.$message.error("此员工信息已被绑定请，检查"):2==i?e.$message.error("注册失败"):e.updateHrRoles(i)}})},showAddEmpView:function(){this.dialogTitle="添加操作人员",this.dialogVisible=!0,this.phone="",this.item={},this.selRoles=[]},keywordsChange:function(e){""==e&&this.initCards()},searchEmp:function(){this.initCards()},searchClick:function(){this.initCards(),this.loadAllRoles()},updateHrRoles:function(e){var t=this;this.moreBtnState=!1;var i=this;if(this.selRolesBak.length==this.selRoles.length){for(var a=0;a<this.selRoles.length;a++)for(var n=0;n<this.selRolesBak.length;n++)if(this.selRoles[a]==this.selRolesBak[n]){this.selRolesBak.splice(n,1);break}if(0==this.selRolesBak.length)return}this.putRequest("/system/hr/roles",{hrId:e,rids:this.selRoles}).then(function(e){t.addLoading=!1,e&&200==e.status&&"success"==e.data.status&&(i.$message.success("添加成功"),t.dialogVisible=!1,i.initCards(),t.dialogVisible1&&t.toQuxiao())})},refreshHr:function(e,t){var i=this;i.cardLoading.splice(t,1,!0),this.putRequest("/system/hr/id/"+e).then(function(e){i.cardLoading.splice(t,1,!1),i.hrs.splice(t,1,e.data)})},loadSelRoles:function(e,t){var i=this;this.moreBtnState=!0,this.selRoles=[],this.selRolesBak=[],e.forEach(function(e){i.selRoles.push(e.id),i.selRolesBak.push(e.id)})},loadAllRoles:function(){var e=this;this.getRequest("/system/basic/roles").then(function(t){e.fullloading=!1,t&&200==t.status&&(e.allRoles=t.data)})},switchChange:function(e,t){var i=this;this.putRequest("/system/hr/",{enabled:e,id:t}).then(function(e){if(e&&200==e.status){var t=e.data;i.initCards(),i.$message({type:t.status,message:t.msg})}})},initCards:function(){this.fullloading=!0,this.tableLoading=!0;var e,t=this;e=""===this.keywords?"all":this.keywords,this.getRequest("/system/hr/list?page="+this.currentPage+"&size=10&keywords="+e).then(function(e){t.tableLoading=!1,e&&200==e.status&&(t.hrs=e.data.hrs,t.totalCount=e.data.count)})},deleteHr:function(e){var t=this;this.fullloading=!0,this.deleteRequest("/system/hr/"+e).then(function(e){if(t.fullloading=!1,e&&200==e.status){var i=e.data;t.$message({type:i.status,message:i.msg}),"success"==i.status&&(t.initCards(),t.loadAllRoles())}})}}},n={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("el-container",[i("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center"}},[i("div",{staticStyle:{display:"inline"}},[i("el-input",{staticStyle:{width:"300px",margin:"0px",padding:"0px"},attrs:{placeholder:"通过员工名搜索员工,记得回车哦...",clearable:"",size:"mini",disabled:e.advanceSearchViewVisible,"prefix-icon":"el-icon-search"},on:{change:e.keywordsChange},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13,t.key))return null;e.searchEmp(t)}},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}}),e._v(" "),i("el-button",{staticStyle:{"margin-left":"5px"},attrs:{type:"primary",size:"mini",icon:"el-icon-search"},on:{click:e.searchEmp}},[e._v("搜索\r\n        ")])],1),e._v(" "),i("div",{staticStyle:{"margin-left":"5px","margin-right":"20px",display:"inline"}},[i("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-plus"},on:{click:e.showAddEmpView}},[e._v("\r\n          添加操作人员\r\n        ")])],1)]),e._v(" "),i("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[i("div",[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.hrs,border:"",stripe:"",size:"mini"},on:{"selection-change":e.handleSelectionChange}},[i("el-table-column",{attrs:{prop:"name",align:"center",fixed:"",label:"姓名"}}),e._v(" "),i("el-table-column",{attrs:{prop:"phone",align:"center",label:"登录账号"}}),e._v(" "),i("el-table-column",{attrs:{prop:"telephone",align:"center",label:"电话号码"}}),e._v(" "),i("el-table-column",{attrs:{prop:"idCard",align:"center",label:"角色"},scopedSlots:e._u([{key:"default",fn:function(t){return e._l(t.row.roles,function(t){return i("el-tag",{key:t.id,staticStyle:{"margin-right":"5px"},attrs:{type:"success",size:"mini","disable-transitions":!1}},[e._v(e._s(t.nameZh)+"\r\n                ")])})}}])}),e._v(" "),i("el-table-column",{attrs:{prop:"wedlock",align:"center",label:"状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[!0===t.row.enabled?i("el-tag",{staticStyle:{"margin-right":"5px"},attrs:{type:"warning",size:"mini","disable-transitions":!1}},[e._v("正常\r\n                ")]):e._e(),e._v(" "),!1===t.row.enabled?i("el-tag",{staticStyle:{"margin-right":"5px"},attrs:{type:"danger",size:"mini","disable-transitions":!1}},[e._v("禁用\r\n                ")]):e._e()]}}])}),e._v(" "),i("el-table-column",{attrs:{fixed:"right",label:"操作",align:"center",width:"195"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{directives:[{name:"show",rawName:"v-show",value:!0===t.row.enabled,expression:"scope.row.enabled === true"}],staticStyle:{padding:"3px 4px 3px 4px",margin:"2px"},attrs:{type:"danger",size:"mini"},on:{click:function(i){e.toEnabled(t.row)}}},[e._v("禁 用\r\n                ")]),e._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:!1===t.row.enabled,expression:"scope.row.enabled === false"}],staticStyle:{padding:"3px 4px 3px 4px",margin:"2px"},attrs:{type:"primary",size:"mini"},on:{click:function(i){e.toEnabl(t.row)}}},[e._v("启 用\r\n                ")]),e._v(" "),i("el-button",{directives:[{name:"show",rawName:"v-show",value:!0===t.row.enabled,expression:"scope.row.enabled === true"}],staticStyle:{padding:"3px 4px 3px 4px",margin:"2px"},attrs:{type:"info",size:"mini"},on:{click:function(i){e.toUpdate(t.row)}}},[e._v("编 辑\r\n                ")])]}}])})],1)],1)])],1),e._v(" "),i("el-form",{ref:"addEmpForm",staticStyle:{margin:"0px",padding:"0px"},attrs:{model:e.hr,rules:e.rules}},[i("div",{staticStyle:{"text-align":"left"}},[i("el-dialog",{staticStyle:{padding:"0px"},attrs:{title:e.dialogTitle,"close-on-click-modal":!1,visible:e.dialogVisible,width:"47%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("el-row",{attrs:{gutter:10}},[i("el-col",{attrs:{span:12}},[i("div",[i("el-form-item",{attrs:{label:"手机号码:",prop:"name"}},[i("el-input",{staticStyle:{width:"50%"},attrs:{"prefix-icon":"el-icon-edit",placeholder:"请输入员工手机号码"},on:{blur:e.selectEmpByPhone},model:{value:e.phone,callback:function(t){e.phone=t},expression:"phone"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"电话号码:",prop:"name"}},[i("el-input",{staticStyle:{width:"50%"},attrs:{"prefix-icon":"el-icon-edit",placeholder:"请输入员工电话号码"},model:{value:e.telephone,callback:function(t){e.telephone=t},expression:"telephone"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"选定角色:",prop:"name"}},[i("el-select",{attrs:{multiple:"",placeholder:"请选择角色"},model:{value:e.selRoles,callback:function(t){e.selRoles=t},expression:"selRoles"}},e._l(e.allRoles,function(e){return i("el-option",{key:e.id,attrs:{label:e.nameZh,value:e.id}})}))],1)],1)]),e._v(" "),i("el-col",{staticStyle:{"border-left":"1px solid #00F"},attrs:{span:12}},[i("div")])],1),e._v(" "),i("div",{staticStyle:{display:"flex","justify-content":"space-around","flex-wrap":"wrap","text-align":"left"}},[i("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.addLoading,expression:"addLoading"}],staticStyle:{width:"350px","margin-bottom":"20px"}},[i("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[this.item.name+""=="undefined"?i("span",[e._v("待选定人员...")]):e._e(),e._v(" "),""!==this.item.name?i("span",{staticStyle:{color:"red"}},[e._v(e._s(e.item.name))]):e._e()]),e._v(" "),i("div",[i("div",{staticStyle:{width:"100%",display:"flex","justify-content":"center"}},[i("img",{staticStyle:{width:"70px",height:"70px","border-radius":"70px"},attrs:{src:this.userface}})]),e._v(" "),i("div",{staticStyle:{"margin-top":"20px"}},[i("div",[i("span",{staticClass:"user-info"},[e._v("用户名:"),i("span",[e._v(e._s(e.item.name))])])]),e._v(" "),i("div",[i("span",{staticClass:"user-info"},[e._v("手机号码:"+e._s(e.item.phone))])]),e._v(" "),i("div",[i("span",{staticClass:"user-info"},[e._v("电话号码:"+e._s(e.item.telephone))])]),e._v(" "),i("div",[i("span",{staticClass:"user-info"},[e._v("备注:"+e._s(e.item.remark))])])])])]),e._v(" "),i("span",[e._v("*特别提醒：员工手机号将作为登录账号，初始密码为：123456。待员工首次登录时需修改登录密码。")])],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"mini",type:"primary",disabled:this.item.name+""=="undefined"||this.selRoles.length+""=="0"||this.addLoading},on:{click:e.toAddHr}},[e._v("确 定")]),e._v(" "),i("el-button",{attrs:{size:"mini"},on:{click:e.cancelEidt}},[e._v("取 消")])],1)],1)],1)]),e._v(" "),i("el-dialog",{staticStyle:{padding:"0px"},attrs:{title:"修改员工角色","close-on-click-modal":!0,visible:e.dialogVisible1,width:"47%"},on:{"update:visible":function(t){e.dialogVisible1=t}}},[i("div",[i("el-form",{staticStyle:{margin:"0px",padding:"0px"},model:{value:e.itemHr,callback:function(t){e.itemHr=t},expression:"itemHr"}},[i("el-form-item",{attrs:{label:"员工姓名:",prop:"name"}},[i("el-input",{staticStyle:{width:"50%"},attrs:{disabled:!0},model:{value:this.itemHr.name,callback:function(t){e.$set(this.itemHr,"name",t)},expression:"this.itemHr.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"员工角色:",prop:"name"}},e._l(this.itemHr.roles,function(t){return i("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.nameZh))])})),e._v(" "),i("el-form-item",{attrs:{label:"选定角色:"}},[i("el-select",{attrs:{multiple:"",placeholder:"请选择角色"},model:{value:e.selRoles,callback:function(t){e.selRoles=t},expression:"selRoles"}},e._l(e.allRoles,function(e){return i("el-option",{key:e.id,attrs:{label:e.nameZh,value:e.id}})}))],1)],1)],1),e._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.updateRole}},[e._v("确 定")]),e._v(" "),i("el-button",{attrs:{size:"mini"},on:{click:e.toQuxiao}},[e._v("取 消")])],1)])],1)},staticRenderFns:[]};var s=i("Z0/y")(a,n,!1,function(e){i("Dfk2")},null,null);t.default=s.exports},fc7a:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=i("eLaH"),n=i("FvOz"),s=i("5xQo"),l=i("c98W"),o=i("/LNZ"),r={data:function(){return{defaultTab:"depMana"}},methods:{},components:{"menu-role":a.default,"dep-mana":n.default,"ec-mana":s.default,"jobtitle-mana":l.default,"pos-mana":o.default}},c={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticStyle:{"margin-top":"10px"}},[i("el-tabs",{attrs:{type:"card"},model:{value:e.defaultTab,callback:function(t){e.defaultTab=t},expression:"defaultTab"}},[i("el-tab-pane",{attrs:{label:"部门管理",name:"depMana"}},[i("dep-mana")],1),e._v(" "),i("el-tab-pane",{attrs:{label:"职位管理",name:"positionMana"}},[i("pos-mana",{attrs:{state:"position"}})],1),e._v(" "),i("el-tab-pane",{attrs:{label:"职称管理",name:"jobTitleMana"}},[i("pos-mana",{attrs:{state:"jobtitle"}})],1),e._v(" "),i("el-tab-pane",{attrs:{label:"权限组",name:"menuRole"}},[i("menu-role")],1)],1)],1)},staticRenderFns:[]},d=i("Z0/y")(r,c,!1,null,null,null);t.default=d.exports},ubks:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("\n    系统管理\n  ")])])}]},n=i("Z0/y")(null,a,!1,null,null,null);t.default=n.exports}});
//# sourceMappingURL=1.f115ea4e69b4ca2d095f.js.map
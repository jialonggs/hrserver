webpackJsonp([4],{Gc0D:function(e,t){},JMJ2:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n={data:function(){return{nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/order/list/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.orderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("车间管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("已完成订单列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:e.toadd}},[e._v("创建订单")]),e._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"success"}},[e._v(e._s(t.row.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"实际面积",prop:"realityArea"}}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toinfo(t.row.id)}}},[e._v("查看详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var r=a("Z0/y")(n,l,!1,function(e){a("Gc0D")},"data-v-60e59a9f",null);t.default=r.exports},"M6+o":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n={data:function(){return{nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/order/list/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.orderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("车间管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("进行中订单表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:e.toadd}},[e._v("创建订单")]),e._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"success"}},[e._v(e._s(t.row.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"实际面积",prop:"realityArea"}}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toinfo(t.row.id)}}},[e._v("查看详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var r=a("Z0/y")(n,l,!1,function(e){a("tFyH")},"data-v-f4aaaab0",null);t.default=r.exports},aX9G:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n={data:function(){return{nowTab:1,username:"",name:"",uid:"",tableLoading:!1,currentPage:1,totalnum:0,pagesize:10,select_word:"",tableData:[]}},methods:{toinfo:function(e){this.$router.push("/order/info/"+e)},toadd:function(){this.$router.push("/order/add")},handleSizeChange:function(e){this.pagesize=e,this.getCollectMouldList()},handleCurrentChange:function(e){this.currentPage=e,this.getCollectMouldList()},getCollectMouldList:function(){var e=this;this.getRequest("/order/list/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&addUserId="+this.uid).then(function(t){e.tableLoading=!1,t&&200==t.status&&0==t.data.code&&(e.tableData=t.data.data.orderlist,e.totalnum=t.data.data.count)})}},mounted:function(){this.$nextTick(function(){this.tableLoading=!0,this.getCollectMouldList()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name")},computed:{}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowTab,expression:"nowTab === 1"}]},[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("车间管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("待分配订单列表")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{padding:"0px",display:"flex","justify-content":"space-between","align-items":"center","margin-top":"20px"}},[a("div",{staticClass:"handle-box"},[a("el-button",{staticClass:"mr10",attrs:{type:"primary",icon:"plus"},on:{click:e.toadd}},[e._v("创建订单")]),e._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"筛选关键词",icon:"search"},model:{value:e.select_word,callback:function(t){e.select_word=t},expression:"select_word"}})],1)]),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{width:"100%"},attrs:{data:e.tableData,stripe:""}},[a("el-table-column",{attrs:{label:"产品名称",prop:"orderName"}}),e._v(" "),a("el-table-column",{attrs:{label:"客户单位",prop:"clientCompanyName"}}),e._v(" "),a("el-table-column",{attrs:{label:"订单状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"success"}},[e._v(e._s(t.row.presentStepName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"订单进度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",{attrs:{type:"info"}},[e._v(e._s(t.row.presentSchedule)+"%")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"实际面积",prop:"realityArea"}}),e._v(" "),a("el-table-column",{attrs:{label:"工艺类型",prop:"machiningType"}}),e._v(" "),a("el-table-column",{attrs:{label:"备忘"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.hasRemark+""=="true"?a("el-tag",[e._v("有")]):e._e(),e._v(" "),t.row.hasRemark+""=="false"?a("el-tag",{attrs:{type:"info"}},[e._v("无")]):e._e()]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e._f("formatDateTime")(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(a){e.toinfo(t.row.id)}}},[e._v("查看详情")])]}}])})],1)],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)])},staticRenderFns:[]};var r=a("Z0/y")(n,l,!1,function(e){a("czlt")},"data-v-8d78f526",null);t.default=r.exports},czlt:function(e,t){},tFyH:function(e,t){},wlKU:function(e,t,a){var n={"./PlantMaOrder.vue":"M6+o","./PlantNewOrder.vue":"aX9G","./PlantOverOrder.vue":"JMJ2"};function l(e){return a(r(e))}function r(e){var t=n[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}l.keys=function(){return Object.keys(n)},l.resolve=r,e.exports=l,l.id="wlKU"}});
//# sourceMappingURL=4.fead15ec2537c7331cf0.js.map
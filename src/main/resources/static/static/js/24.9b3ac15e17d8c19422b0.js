webpackJsonp([24],{PsTJ:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l={data:function(){var e=this;return{itemStaffId:"",currentPage:1,totalnum:0,pagesize:10,filterText:"",tree_loading:!1,tableData1:[],tableData6:[],data3:[],value1:{},value2:"",pickerOptions0:{disabledDate:function(t){return""!=e.value2?t.getTime()>Date.now()||t.getTime()>e.value2:t.getTime()>Date.now()}},pickerOptions1:{disabledDate:function(t){return t.getTime()<e.value1||t.getTime()>Date.now()}}}},watch:{filterText:function(e){this.$refs.tree2.filter(e)}},methods:{handleSizeChange:function(){this.pagesize=val,this.handleNodeClick(this.itemStaffId)},handleCurrentChange:function(){this.currentPage=val,this.handleNodeClick(this.itemStaffId)},handleNodeClick:function(e){var t=this,a=this,l=e.id;l!=this.itemStaffId&&(this.currentPage=1,this.totalnum=0,this.pagesize=10),this.itemStaffId=l,this.getRequest("/count/work/user/order/listbypage?page="+this.currentPage+"&size="+this.pagesize+"&userId="+l+"&startTime="+this.value1+"&endTime="+this.value2).then(function(e){e&&200==e.status&&0==e.data.code?(a.tableData6=e.data.data.userordercount,t.totalnum=e.data.data.count):(a.tableData6=[],a.currentPage=1,a.totalnum=0)})},filterNode:function(){},getSummaries:function(e){var t=e.columns,a=e.data,l=[];return t.forEach(function(e,t){if(0!==t){var r=a.map(function(t){return Number(t[e.property])});r.every(function(e){return isNaN(e)})?l[t]="N/A":(l[t]=r.reduce(function(e,t){var a=Number(t);return isNaN(a)?e:e+t},0),l[t]+=" 元")}else l[t]="总价"}),l},toChangeCheck:function(){},defaultProps:function(){},getHuiZong:function(){var e=this;this.getRequest("/count/work/huizong").then(function(t){t&&200==t.status&&0==t.data.code&&(e.tableData1=t.data.data.huizong)})},getYgaTree:function(){var e=this;this.getRequest("/config/mangers?role=ROLE_yga").then(function(t){if(t&&200==t.status&&0==t.data.code){for(var a=t.data.data,l=[],r=0;r<a.length;r++){var n={id:"",label:""};n.id=a[r].id,n.label=a[r].name,l.push(n)}e.data3=l}})}},mounted:function(){this.$nextTick(function(){var e=new Date,t=new Date;this.value1=e.setDate(1),this.value2=t.getTime()}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getHuiZong(),this.getYgaTree()}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("订单管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("创建订单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{"align-items":"center","margin-top":"10px"}}),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("div",[a("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"0px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("汇总表")])]),e._v(" "),a("div",[a("div",{staticStyle:{"min-height":"15px",width:"100%"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData1,border:"","show-summary":""}},[a("el-table-column",{attrs:{prop:"userName",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"workTime",label:"工时"}}),e._v(" "),a("el-table-column",{attrs:{prop:"lastMonthArge",label:"上月遗留面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthArge",label:"本月接单面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthNeedArge",label:"本月需完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthFinishArge",label:"本月已完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthShenYuArge",label:"本月未完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"efficiency",label:"平均效率"}})],1)],1)])])],1),e._v(" "),a("div",[a("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"25px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("员工工作量统计")])]),e._v(" "),a("el-alert",{staticStyle:{"margin-bottom":"15px"},attrs:{title:"默认统计当月数据",type:"info",center:"","show-icon":"",closable:!1}}),e._v(" "),a("div",{staticClass:"block",staticStyle:{"margin-bottom":"15px"}},[a("span",[e._v("开始日期：")]),e._v(" "),a("el-date-picker",{attrs:{type:"date","value-format":"timestamp",placeholder:"开始日期","picker-options":e.pickerOptions0},model:{value:e.value1,callback:function(t){e.value1=t},expression:"value1"}}),e._v(" "),a("span",{staticStyle:{"margin-left":"15px"}},[e._v("结束日期：")]),e._v(" "),a("el-date-picker",{attrs:{type:"date","value-format":"timestamp",placeholder:"结束日期","picker-options":e.pickerOptions1},model:{value:e.value2,callback:function(t){e.value2=t},expression:"value2"}})],1),e._v(" "),a("div",[a("el-row",{attrs:{gutter:30}},[a("el-col",{directives:[{name:"loading",rawName:"v-loading",value:e.tree_loading,expression:"tree_loading"}],attrs:{span:4}},[a("el-input",{attrs:{placeholder:"输入关键字进行过滤"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),e._v(" "),a("el-tree",{ref:"tree2",staticStyle:{"border-right":"1px solid #e6e6e6","min-height":"260px"},attrs:{data:e.data3,"default-expand-all":"","filter-node-method":e.filterNode,"node-key":"id"},on:{"check-change":e.toChangeCheck,"node-click":e.handleNodeClick}})],1),e._v(" "),a("el-col",{attrs:{span:20}},[a("div",{staticStyle:{"min-height":"15px",width:"100%"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData6,stripe:"",border:""}},[a("el-table-column",{attrs:{fixed:"",width:"120",prop:"projectName",label:"项目"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.orderInfo.project.projectName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{fixed:"",width:"120",label:"订单名称"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.orderInfo.orderName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{width:"120",label:"贴花工序"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.orderInfo.techCard.tieHuaBuShu))])]}}])}),e._v(" "),a("el-table-column",{attrs:{width:"120",align:"left",prop:"jingFengArea",label:"精封面积"}}),e._v(" "),a("el-table-column",{attrs:{width:"120",align:"left",prop:"tieHuaArea",label:"每道面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"wanChengArea",width:"120",label:"完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"zongJiArea",width:"120",label:"合计"}}),e._v(" "),a("el-table-column",{attrs:{width:"120",label:"难度"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.orderInfo.nanDuDengJi))])]}}])}),e._v(" "),a("el-table-column",{attrs:{width:"120",label:"皮纹代码"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.orderInfo.piWenDaiMa))])]}}])}),e._v(" "),a("el-table-column",{attrs:{width:"120",align:"left",label:"经办"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(t.row.orderInfo.addUserName))])]}}])}),e._v(" "),a("el-table-column",{attrs:{width:"160",align:"left",label:"完成日期"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(e._f("formatDateTime")(t.row.orderInfo.createTime)))])]}}])}),e._v(" "),a("el-table-column",{attrs:{width:"160",align:"left",label:"下单时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tag",[e._v(e._s(e._f("formatDateTime")(t.row.orderInfo.createTime)))])]}}])})],1)],1),e._v(" "),a("div",{staticClass:"block",staticStyle:{float:"right","margin-top":"15px"}},[a("el-pagination",{attrs:{"current-page":e.currentPage,"page-sizes":[10,30,80,100],"page-size":e.pagesize,layout:"total,sizes, prev, pager, next, jumper",total:e.totalnum},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)])],1)],1)],1)],1)])],1)],1)])},staticRenderFns:[]};var n=a("Z0/y")(l,r,!1,function(e){a("QXFO")},"data-v-3b39015d",null);t.default=n.exports},QXFO:function(e,t){},SdRK:function(e,t,a){var l={"./CountWork.vue":"PsTJ"};function r(e){return a(n(e))}function n(e){var t=l[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}r.keys=function(){return Object.keys(l)},r.resolve=n,e.exports=r,r.id="SdRK"}});
//# sourceMappingURL=24.9b3ac15e17d8c19422b0.js.map
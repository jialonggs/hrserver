webpackJsonp([20],{PsTJ:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n={data:function(){return{filterText:"",tree_loading:!1,tableData1:[],tableData6:[{projectName:"12987122",piWenDaiMa:"王小虎",addUserName:"234",createTime:"3.2",finishTime:10,gongXu:2,jingFeng:45,tieHua:450,heJi:400,nanDu:1},{projectName:"12987122",piWenDaiMa:"王小虎",addUserName:"234",createTime:"3.2",finishTime:10,gongXu:2,jingFeng:45,tieHua:450,heJi:400,nanDu:1},{projectName:"12987122",piWenDaiMa:"王小虎",addUserName:"234",createTime:"3.2",finishTime:10,gongXu:2,jingFeng:45,tieHua:450,heJi:400,nanDu:1},{projectName:"12987122",piWenDaiMa:"王小虎",addUserName:"234",createTime:"3.2",finishTime:10,gongXu:2,jingFeng:45,tieHua:450,heJi:400,nanDu:1},{projectName:"12987122",piWenDaiMa:"王小虎",addUserName:"234",createTime:"3.2",finishTime:10,gongXu:2,jingFeng:45,tieHua:450,heJi:400,nanDu:1}]}},watch:{filterText:function(e){this.$refs.tree2.filter(e)}},methods:{getSummaries:function(e){var t=e.columns,a=e.data,n=[];return t.forEach(function(e,t){if(0!==t){var r=a.map(function(t){return Number(t[e.property])});r.every(function(e){return isNaN(e)})?n[t]="N/A":(n[t]=r.reduce(function(e,t){var a=Number(t);return isNaN(a)?e:e+t},0),n[t]+=" 元")}else n[t]="总价"}),n},getHuiZong:function(){var e=this;this.getRequest("/count/work/huizong").then(function(t){t&&200==t.status&&0==t.data.code&&(e.tableData1=t.data.data.huizong,console.log(e.tableData1))})}},mounted:function(){this.$nextTick(function(){}),this.username=localStorage.getItem("cp_username"),this.uid=localStorage.getItem("cp_uid"),this.name=localStorage.getItem("cp_name"),this.getHuiZong()}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",[a("i",{staticClass:"el-icon-menu"}),e._v("订单管理")]),e._v(" "),a("el-breadcrumb-item",[e._v("创建订单")])],1)],1),e._v(" "),a("el-container",[a("el-header",{staticStyle:{"align-items":"center","margin-top":"10px"}}),e._v(" "),a("el-main",{staticStyle:{"padding-left":"0px","padding-top":"0px"}},[a("div",[a("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"0px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("汇总表")])]),e._v(" "),a("div",[a("div",{staticStyle:{"min-height":"15px",width:"100%"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData1,border:"","show-summary":""}},[a("el-table-column",{attrs:{prop:"userName",label:"姓名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"workTime",label:"工时"}}),e._v(" "),a("el-table-column",{attrs:{prop:"lastMonthArge",label:"上月遗留面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthArge",label:"本月接单面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthNeedArge",label:"本月需完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthFinishArge",label:"本月已完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"currentMonthShenYuArge",label:"本月未完成面积"}}),e._v(" "),a("el-table-column",{attrs:{prop:"efficiency",label:"平均效率"}})],1)],1)])])],1)])],1)],1)])},staticRenderFns:[]};var i=a("Z0/y")(n,r,!1,function(e){a("qnWg")},"data-v-bd89d29e",null);t.default=i.exports},SdRK:function(e,t,a){var n={"./CountWork.vue":"PsTJ"};function r(e){return a(i(e))}function i(e){var t=n[e];if(!(t+1))throw new Error("Cannot find module '"+e+"'.");return t}r.keys=function(){return Object.keys(n)},r.resolve=i,e.exports=r,r.id="SdRK"},qnWg:function(e,t){}});
//# sourceMappingURL=20.c443ecc53b4b61da8017.js.map
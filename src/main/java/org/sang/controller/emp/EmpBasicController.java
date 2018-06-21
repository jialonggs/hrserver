package org.sang.controller.emp;

import org.sang.bean.*;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.common.EmailRunnable;
import org.sang.common.poi.PoiUtils;
import org.sang.config.ErrCodeMsg;
import org.sang.service.DepartmentService;
import org.sang.service.EmpService;
import org.sang.service.JobLevelService;
import org.sang.service.PositionService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * Created by sang on 2018/1/12.
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmpService empService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PositionService positionService;
    @Autowired
    JobLevelService jobLevelService;
//    @Autowired
//    ExecutorService executorService;

    @RequestMapping(value = "/basicdata", method = RequestMethod.GET)
    public Map<String, Object> getAllNations() {
        Map<String, Object> map = new HashMap<>();
        map.put("nations", empService.getAllNations());
        map.put("politics", empService.getAllPolitics());
        map.put("deps", departmentService.getDepByPid(-1L));
        map.put("positions", positionService.getAllPos());
        map.put("joblevels", jobLevelService.getAllJobLevels());
        map.put("workID", String.format("%08d", empService.getMaxWorkID() + 1));
        return map;
    }

    @RequestMapping("/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", empService.getMaxWorkID() + 1);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public RespBean addEmp(Employee employee) {
        if(employee.getBirthday() == null){
            employee.setBirthday(new Date());
        }
        if(employee.getConversionTime() == null){
            employee.setConversionTime(new Date());
        }
        if(employee.getNotWorkDate() == null){
            employee.setNotWorkDate(new Date());
        }
        if(employee.getBeginDate() == null){
            employee.setBeginDate(new Date());
        }
        if(employee.getBeginContract() == null){
            employee.setBeginContract(new Date());
        }
        if(employee.getEndContract() == null){
            employee.setEndContract(new Date());
        }
        if(employee.getPoliticId() == null){
            employee.setPoliticId(13L);
        }
        if(employee.getNationId() == null){
            employee.setNationId(1L);
        }
        if(employee.getDepartmentId() == null){
            employee.setDepartmentId(1L);
        }
        if(employee.getJobLevelId() == null){
            employee.setJobLevelId(18L);
        }
        if(employee.getPosId() == null){
            employee.setPosId(1L);
        }
        if(employee.getContractTerm() == null) {
            employee.setContractTerm(1.0);
        }
            if (empService.addEmp(employee) == 1) {
//            List<Position> allPos = positionService.getAllPos();
//            for (Position allPo : allPos) {
//                if (allPo.getId() == employee.getPosId()) {
//                    employee.setPosName(allPo.getName());
//                }
//            }
//            executorService.execute(new EmailRunnable(employee));
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public RespBean updateEmp(Employee employee) {
        if (empService.updateEmp(employee) == 1) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteEmpById(@PathVariable String ids) {
        if (empService.deleteEmpById(ids)) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope) {
        Map<String, Object> map = new HashMap<>();
        List<Employee> employeeByPage = empService.getEmployeeByPage(page, size, keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, beginDateScope);
        Long count = empService.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, beginDateScope);
        map.put("emps", employeeByPage);
        map.put("count", count);
        return map;
    }

    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public Map<String, Object> getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Employee> orderslist = new ArrayList<>();
        PageBean<Employee> list = empService.getEmpsList(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("emplist", orderslist);
        return map;
    }

    @RequestMapping(value = "/empbyphone", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPhone(@RequestParam String phone) {
        Map<String, Object> map = new HashMap<>();
        Employee employeeById = empService.getEmployeeByPhone(phone);
        map.put("emp", employeeById);
        return map;
    }

    @RequestMapping(value = "/exportEmp", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        List<Employee> employees = empService.getAllEmployees2();
        if(null == employees || employees.isEmpty() ){
            new RespBean("error", "导出失败");
        }
        for(Employee employee: employees ){
            if(employee.getPoliticId() == null){
                employee.setPoliticId(13L);
            }
            if(employee.getNationId() == null){
                employee.setNationId(1L);
            }
            if(employee.getDepartmentId() == null){
                employee.setDepartmentId(1L);
            }
            if(employee.getJobLevelId() == null){
                employee.setJobLevelId(18L);
            }
            if(employee.getPosId() == null){
                employee.setPosId(1L);
            }
            if(employee.getContractTerm() == null){
                employee.setContractTerm(1.0);
            }
        }
        return PoiUtils.exportEmp2Excel(employees);
    }

    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
    public RespBean importEmp(MultipartFile file) {
        List<Employee> emps = PoiUtils.importEmp2List(file,empService.getAllNations(),empService.getAllPolitics(),departmentService.getAllDeps(),positionService.getAllPos(),jobLevelService.getAllJobLevels());
        if (empService.addEmps(emps) == emps.size()) {
            return new RespBean("success", "导入成功!");
        }
        return new RespBean("error", "导入失败!");
    }
}

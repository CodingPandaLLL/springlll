package com.lll.ui;

import com.lll.bean.Employee;
import com.lll.rebbitmq.MessageProducer;
import com.lll.services.EmployeeService;
import com.lll.utils.JacksonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
@ResponseBody
public class EmployeeUI {

    @Resource
    private EmployeeService employeeServices;

    @Resource
    private MessageProducer messageProducer;


    /**
     * @time 2018年7月31日下午4:42:58
     * @author lll
     * @describe 查询
     */
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeServices.getEmployeeById(id);

    }

    /**
     * @time 2018年7月31日下午4:42:58
     * @author lll
     * @describe 查询所有
     */
    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeServices.getAllEmployee();
    }

    /**
     * @time 2018年7月31日下午4:43:50
     * @author lll
     * @describe 删除
     */
    @DeleteMapping("/{id}")
    public void delEmployee(@PathVariable("id") int id) {
        employeeServices.delEmployee(id);
    }

    /**
     * @time 2018年7月31日下午4:45:41
     * @author lll
     * @describe 增加
     */
    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeServices.addEmployee(employee);
    }

    /**
     * @time 2018年7月31日下午4:45:41
     * @author lll
     * @describe 通过消息对接异步添加
     */
    @PostMapping("/addByRebbitmq")
    public String addByRebbitmq(@RequestBody Employee employee) {
        try{
            String message = JacksonUtil.toJsonString(employee);
            messageProducer.send(message);
            return  "success";
        }catch (Exception e){
            return  e.getMessage();
        }
    }


    /**
     * @time 2018年7月31日下午4:46:36
     * @author lll
     * @describe 修改
     */
    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeServices.updateEmployee(employee);
    }


}

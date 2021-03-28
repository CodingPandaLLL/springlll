package com.lll.ui;

import javax.annotation.Resource;

import com.lll.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lll.services.EmployeeService;

@Controller
@RequestMapping("/employee")
@ResponseBody
public class EmployeeUI {

  @Resource
  private EmployeeService employeeServices;

  /**
   * @time 2018年7月31日下午4:42:58
   * @author lll
   * @describe 查询
   */
  @GetMapping("/")
  public Employee getEmployee() {
    return employeeServices.getEmployee();
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
   *@time 2018年7月31日下午4:46:36
   *@author lll
   *@describe 修改
   */
  @PutMapping("/")
  public Employee updateEmployee(@RequestBody Employee employee) {
    return employeeServices.updateEmployee(employee);
  }
  
  
}

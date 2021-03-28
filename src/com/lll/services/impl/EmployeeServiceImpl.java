package com.lll.services.impl;

import javax.annotation.Resource;

import com.lll.bean.Employee;
import org.springframework.stereotype.Service;

import com.lll.dao.EmployeeDao;
import com.lll.services.EmployeeService;

import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

  @Resource
  private EmployeeDao employeeDao;

  @Override
  public Employee getEmployeeById(int id) {
    Employee employee = employeeDao.getEmployeeById(id);
    return employee;
  }

  @Override
  public List<Employee> getAllEmployee() {
    return employeeDao.getAllEmployee();
  }

  @Override
  public void delEmployee(int id) {
    employeeDao.delEmployee(id);
  }

  @Override
  public Employee addEmployee(Employee employee) {
    employeeDao.addEmployee(employee);
//    int i=1/0;
    return employee;
  }

  @Override
  public Employee updateEmployee(Employee employee) {
     employeeDao.updateEmployee(employee);
     return employee;
  }

}

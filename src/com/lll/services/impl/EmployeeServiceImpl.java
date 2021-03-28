package com.lll.services.impl;

import javax.annotation.Resource;

import com.lll.bean.Employee;
import org.springframework.stereotype.Service;

import com.lll.dao.EmployeeDao;
import com.lll.services.EmployeeService;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

  @Resource
  private EmployeeDao employeeDao;

  @Override
  public Employee getEmployee() {

    // Employee employee = new Employee();
    // employee.setEmail("lll@qw.com");
    // employee.setGender("2");
    // employee.setLastName("lll");

    Employee employee = employeeDao.getEmployee().get(0);
    return employee;
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

package com.lll.services;

import com.lll.bean.Employee;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeService {
  
  public Employee getEmployee();

  public void delEmployee(int id);

  public Employee addEmployee(Employee employee);

  public Employee updateEmployee(Employee employee);

}

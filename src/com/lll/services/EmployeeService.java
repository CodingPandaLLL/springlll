package com.lll.services;

import com.lll.bean.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeService {
  
  public Employee getEmployeeById(int id);
  public List<Employee> getAllEmployee();
  public void delEmployee(int id);
  public Employee addEmployee(Employee employee);
  public Employee updateEmployee(Employee employee);

}

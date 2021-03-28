package com.lll.dao;

import java.util.List;

import com.lll.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository("EmployeeDao")
public interface EmployeeDao {

  public List<Employee> getEmployee();

  public void addEmployee(Employee employee);

  public void delEmployee(int id);

  public void updateEmployee(Employee employee);
}

package com.lll.services.impl;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lll.bean.Employee;
import com.lll.dao.EmployeeDao;
import com.lll.services.EmployeeService;
import com.lll.utils.JacksonUtil;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonValue;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private RedisTemplate<String, Employee> redisTemplate;

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        //尝试通过id从redis中获取用户信息
        employee = redisTemplate.opsForValue().get(id + "");
        //如果从redis中获取的用户信息不为空，直接读取redis获取的用户信息，否则查询数据库
        if (employee != null) {
            logger.info("从redis中获取数据： " + JacksonUtil.toJsonString(employee));
        } else {
            //查询数据库
            employee = employeeDao.getEmployeeById(id);
            //向redis数据库从插入用户信息
            redisTemplate.opsForValue().set(id + "", employee);
            logger.info("从数据库中获取数据： " + JacksonUtil.toJsonString(employee));
        }
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
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
        return employee;
    }

}

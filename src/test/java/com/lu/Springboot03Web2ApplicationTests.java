package com.lu;

import com.lu.dao.DepartmentDao;
import com.lu.dao.EmployeeDao;
import com.lu.pojo.Department;
import com.lu.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Springboot03Web2ApplicationTests {

    @Test
    void contextLoads() {
        Employee employee=new Employee(1006,"AA4","1578828702@qq.com",1,new Department(101,"教学部"),new Date(2000/12/10));
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.save(employee);
        DepartmentDao departmentDao = new DepartmentDao();
        departmentDao.getDepartmentById(101);
    }

}

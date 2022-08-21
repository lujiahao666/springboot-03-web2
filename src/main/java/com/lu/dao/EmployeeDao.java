package com.lu.dao;

import com.lu.pojo.Department;
import com.lu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    //模拟数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"AA","1578828702@qq.com",1,new Department(101,"教学部"),new Date(2000/12/10)));
        employees.put(1002,new Employee(1002,"AA1","1578828702@qq.com",0,new Department(101,"教学部"),new Date(2000/12/10)));
        employees.put(1003,new Employee(1003,"AA2","1578828702@qq.com",1,new Department(105,"后勤部"),new Date(2000/12/10)));
        employees.put(1004,new Employee(1004,"AA3","1578828702@qq.com",1,new Department(101,"教学部"),new Date(2000/12/10)));
        employees.put(1005,new Employee(1005,"AA4","1578828702@qq.com",1,new Department(101,"教学部"),new Date(2000/12/10)));
    }
    //主键自增id
    private static Integer initId = 1006;
    public void save(Employee employee){
        if(employee.getId()==null) {
            employee.setId(initId++);
        }
        int id = employee.getDepartment().getId();
        employee.setDepartment(departmentDao.getDepartmentById(id));
        employees.put(employee.getId(),employee);
    }


    //查询全部员工
    public Collection<Employee> getAll(){
        System.out.println("123");
        return employees.values();
    }
    //通过id查询
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工通过id
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

    public void addEmployee(Employee employee){
        employees.put(initId++,new Employee(initId++,employee.getLastName(),employee.getEmail(),employee.getGender(),employee.getDepartment(),employee.getBirth()));

    }
}

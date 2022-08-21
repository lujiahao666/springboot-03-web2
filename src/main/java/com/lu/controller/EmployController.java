package com.lu.controller;

import com.lu.dao.DepartmentDao;
import com.lu.dao.EmployeeDao;
import com.lu.pojo.Department;
import com.lu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/emp")
    public String selectEmployee(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/add";
    }

    @PostMapping("/add")
    public String add1(Employee employee){
        System.out.println("+02+"+employee.getDepartment().getId());
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emp";
    }
}

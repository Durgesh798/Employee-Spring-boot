package com.mms.emp.service;

import com.mms.emp.entity.Employee;
import com.mms.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmp(Employee employee){
       employeeRepository.save(employee);
       return "employee data saved";
    }

    public List<Employee> getAllEmp(){
        return employeeRepository.findAll();
    }
}

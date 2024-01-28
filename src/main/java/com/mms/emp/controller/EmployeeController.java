package com.mms.emp.controller;

import com.mms.emp.entity.Employee;
import com.mms.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        return "hello spring";
    }

    @PostMapping("/emp")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmp(employee);
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmp();
    }

    @GetMapping("/apis")
    public List<Object> getPublicAPI(){
        String uri="https://restcountries.com/v3.1/all";
        Object[] st= restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(st);
    }
}

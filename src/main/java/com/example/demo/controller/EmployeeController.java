package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployee")
    public List<Employee> getEmployee()
    {
        return employeeService.getEmployee();
    }

    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id)
    {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
      
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);

    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(employee);
    }
}

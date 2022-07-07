package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public  String deleteEmployee(int id) {
        if(employeeRepository.existsById(id))
        {
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully";
        }
        else{
            return "No Employee Exist with this id";
        }

    }


    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(int id) {
        return  employeeRepository.findById(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return;
    }

    public String updateEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getId()))
        {
            employeeRepository.save(employee);
            return "employee updated";
        }
        else{
            return "Employee With this Id Does Not Exist";
        }
    }
}

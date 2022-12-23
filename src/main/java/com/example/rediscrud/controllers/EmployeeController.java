package com.example.rediscrud.controllers;

import com.example.rediscrud.entity.Employee;
import com.example.rediscrud.responses.ApiResponse;
import com.example.rediscrud.respository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeDao employeeDao;
    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody Employee employee) {
        employeeDao.save(employee);
        return new ResponseEntity<>(new ApiResponse("Employee created successfully", true, new Date()),
                HttpStatus.CREATED);
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable Integer id) {
        return employeeDao.findEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> remove(@PathVariable Integer id) {
        employeeDao.deleteEmployee(id);
        return new ResponseEntity<>(new ApiResponse("Employee deleted successfully", true, new Date()), HttpStatus.OK);
    }
}
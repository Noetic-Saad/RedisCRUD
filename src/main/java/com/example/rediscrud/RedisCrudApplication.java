package com.example.rediscrud;

import com.example.rediscrud.entity.Employee;
import com.example.rediscrud.responses.ApiResponse;
import com.example.rediscrud.respository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RedisCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisCrudApplication.class, args);
    }
}
package com.example.rediscrud.respository;

import com.example.rediscrud.entity.Employee;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class EmployeeDao {
    private final RedisTemplate template;
    public EmployeeDao(RedisTemplate template) {
        this.template = template;
    }
    public void save(Employee employee) {
        employee.setId(randomIntegerGenerator());
        template.opsForHash().put(getKey(), employee.getId(), employee);
    }
    public List<Employee> findAll() {
        return template.opsForHash().values(getKey());
    }
    public Employee findEmployeeById(Integer id) {
        return (Employee) template.opsForHash().get(getKey(),id);
    }
    public void deleteEmployee(Integer id) {
         template.opsForHash().delete(getKey(),id);
    }
    private static String getKey() {
        return "Employee";
    }
    private static int randomIntegerGenerator() {
        return 100000 + new Random(System.currentTimeMillis()).nextInt(999999);
    }
}
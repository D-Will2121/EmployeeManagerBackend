package com.myprojects.employeemanager.service;

import com.myprojects.employeemanager.exception.UserNotFoundException;
import com.myprojects.employeemanager.model.Employee;
import com.myprojects.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
        Employee employee1 = new Employee(1L, "Michael Thompson", "micheal@gmail.com",
                "web designer", "9541236844",
                "https://www.edgepointlearning.com/assets/images/generated/blog/2017-04-27-top-10-types-of-employee-training-1170-36e7538ee.jpg"
                , UUID.randomUUID().toString());
        Employee employee2 = new Employee(2L, "Bob Marshall", "bob@gmail.com",
                "Marketing", "477123657",
                "https://www.glassdoor.com/employers/app/uploads/sites/2/2018/09/resources-benefits-employees-want-most-min-768x483-1-e1540508225245.jpg?x60772"
        , UUID.randomUUID().toString());
        Employee employee3 = new Employee(3L, "Riley Roswell", "riley@gmail.com",
                "Quality Assurance", "8845132269",
                "https://st2.depositphotos.com/1054749/6808/i/600/depositphotos_68088663-stock-photo-portrait-of-a-young-african.jpg"
                , UUID.randomUUID().toString());
        employeeRepo.save(employee1);
        employeeRepo.save(employee2);
        employeeRepo.save(employee3);

    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
          return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() ->
                new UserNotFoundException("User with id " + id + " does not exist!"));
    }
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}

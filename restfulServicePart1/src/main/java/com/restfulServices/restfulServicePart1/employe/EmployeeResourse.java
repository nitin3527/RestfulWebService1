package com.restfulServices.restfulServicePart1.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
public class EmployeeResourse {

    @Autowired
    private EmployeeDaoService service;

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmp(){
        return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee getEmp(@PathVariable int id){
        Employee emp =  service.findOne(id);
        if(emp == null) throw new EmployeeNotFoundException("id- " + id);
        return emp;
    }
    @DeleteMapping(path = "/employees/{id}")
    public void deleteEmp(@PathVariable int id){
        Employee emp =  service.delete(id);
        if(emp.getId() == null) throw new EmployeeNotFoundException("id- " + id);
    }
    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        Employee employee1 = service.updateEmployeeDetails(employee);
        if (employee1 == null)
            throw new EmployeeNotFoundException("Incorrect id");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PostMapping("/employees")
    public ResponseEntity<Object> getEmp(@Valid @RequestBody Employee emp){
        Employee emp1 =  service.saveEmployee(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}

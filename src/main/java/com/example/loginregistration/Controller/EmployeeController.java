package com.example.loginregistration.Controller;

import com.example.loginregistration.DTO.EmployeeDTO;
import com.example.loginregistration.DTO.LoginDTO;
import com.example.loginregistration.Service.EmployeeService;
import com.example.loginregistration.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/employees/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String ID = employeeService.addEmployee(employeeDTO);
        return ID;
    }

    @PostMapping("/api/employees/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        if(loginResponse.getStatus()){
            return ResponseEntity.ok(loginResponse);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

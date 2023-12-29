package com.example.loginregistration.Service.impl;

import com.example.loginregistration.DTO.EmployeeDTO;
import com.example.loginregistration.DTO.LoginDTO;
import com.example.loginregistration.Entity.EmployeeEntity;
import com.example.loginregistration.Repo.EmployeeRepository;
import com.example.loginregistration.Service.EmployeeService;
import com.example.loginregistration.response.LoginResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeID(employeeDTO.getEmployeeID());
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(this.passwordEncoder.encode(employeeDTO.getPassword()));

        employeeRepository.save(employee);

        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String message = "";
        EmployeeEntity employee = employeeRepository.findByEmail(loginDTO.getEmail());
        if(employee != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();
            Boolean isPwdCorrect = passwordEncoder.matches(password, encodedPassword);
            if(isPwdCorrect) {
                Optional<EmployeeEntity> employee1 = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(employee1.isPresent()) {
                    return new LoginResponse("Login Successs", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Login credentials not valid.", false);
            }
        } else {
            return new LoginResponse("Login credentials not valid.", false);
        }
    }
}

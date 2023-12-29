package com.example.loginregistration.Service;

import com.example.loginregistration.DTO.EmployeeDTO;
import com.example.loginregistration.DTO.LoginDTO;
import com.example.loginregistration.response.LoginResponse;

public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}

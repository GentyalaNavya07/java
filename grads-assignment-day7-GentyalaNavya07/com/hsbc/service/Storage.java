package com.hsbc.service;

import com.hsbc.bean.Employee;
import com.hsbc.exception.*;
public interface Storage {

    void addEmployee(Employee employee)throws EmployeeAlreadyExistsException;

    Employee getEmployee(int empNo)throws EmployeeNotFoundException;
}

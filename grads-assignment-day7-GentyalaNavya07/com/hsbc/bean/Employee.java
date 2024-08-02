package com.hsbc.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private int empNo;
    private String firstName;
    private String lastName;
    private String city;
    private double salary;

    public Employee() {
    }

    public Employee(int empNo, String firstName, String lastName, String city, double salary) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}


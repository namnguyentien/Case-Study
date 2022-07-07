package services;

import models.Employee;

public interface EmployeeService extends Service  {
    public Employee isEmployee(int employeeCode);
}

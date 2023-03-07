package models;

import java.io.Serializable;
import java.util.Arrays;

public class Employee extends Person implements Serializable {
    private int employeeCode;
    private final String[] academicLevelArr = {"Trung cap", "Cao dang", "Dai hoc", "Sau dai hoc"};
    private String academicLevel;
    private final String[] positionArray = {"Le tan", "Phuc vu", "Chuyen vien", "Giam sat", "Quan ly", "Giam doc"};
    private String position;
    private float salary;

    public Employee(int employeeCode, int academicLevel, int position, float salary) {
        this.employeeCode = employeeCode;
        this.academicLevel = academicLevelArr[academicLevel];
        this.position = positionArray[position];
        this.salary = salary;
    }

    public Employee(String name, String dateOfBirth, String sex, int identityCardNumber, String telephoneNumber, String email, int employeeCode, int academicLevel, int position, float salary) {
        super(name, dateOfBirth, sex, identityCardNumber, telephoneNumber, email);
        this.employeeCode = employeeCode;
        this.academicLevel = academicLevelArr[academicLevel];
        this.position = positionArray[position];
        this.salary = salary;
    }

    public Employee() {
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String[] getAcademicLevelArr() {
        return academicLevelArr;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(int academicLevel) {
        this.academicLevel = academicLevelArr[academicLevel];
    }

    public String[] getPositionArray() {
        return positionArray;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = positionArray[position];
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode=" + employeeCode +
                ", academicLevelArr=" + Arrays.toString(academicLevelArr) +
                ", academicLevel='" + academicLevel + '\'' +
                ", positionArray=" + Arrays.toString(positionArray) +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

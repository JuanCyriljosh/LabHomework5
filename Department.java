import java.util.*;

public class Department {

    private String depCode;
    private String depName;
    private Double depTotalSalary;
    private HashMap<String, Employee> employeeMap;

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
    
    public String getDepName() { 
        return depName;
    }

    public void setDepTotalSalary(double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }

    public double getDepTotalSalary() {
        return depTotalSalary;
    }
    
    public void setEmployeeMap(HashMap<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }
    
    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
    
}
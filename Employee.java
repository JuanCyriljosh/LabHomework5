public class Employee {

    private String empNo;
    private String lastName;
    private String firstName;
    private double salary;

    public void setEmpNo(String empNo){
        this.empNo = empNo;
    }

    public String getEmpNo(){
        return empNo;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }
    
}
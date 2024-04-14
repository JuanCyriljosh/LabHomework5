import java.util.*;
import java.io.*;
import java.text.*;

public class DepartmentDA {

    private HashMap<String, Employee> empMap;

    public DepartmentDA() throws FileNotFoundException {
        Scanner keyboard = new Scanner(new FileReader("dep.csv"));
        empMap = new HashMap<>();

        while(keyboard.hasNext()) {
            String row = keyboard.nextLine();
            String[] rowSpecific = new String[2];
            rowSpecific = row.split(",");

            Department depts = new Department();
            depts.setDepCode(rowSpecific[0]);
            depts.setDepName(rowSpecific[1].trim());

            readDepEmp(depts);
            depts.setEmployeeMap(empMap);

            Double salary = 0.00;

            for(Map.Entry<String, Employee> entryMap: depts.getEmployeeMap().entrySet()) {
                salary += entryMap.getValue().getSalary();
            }
            depts.setDepTotalSalary(salary);
            printdepts(depts);
        }
        keyboard.close();
    }

    private void readDepEmp(Department depts) throws FileNotFoundException {
        Scanner keyboard1 = new Scanner(new FileReader("deptemp.csv"));
        empMap.clear();
        Integer key = 0;

        while(keyboard1.hasNext()) {
            String row2 = keyboard1.nextLine();
            String[] rowSpecific2 = new String[3];

            rowSpecific2 = row2.split(",");

            if(depts.getDepCode().equals(rowSpecific2[0])) {
                EmployeeDA employeeDA = new EmployeeDA(rowSpecific2[1].trim(), 
                Double.parseDouble(rowSpecific2[2].trim()));

                empMap.put(rowSpecific2[1].trim()+key, employeeDA.getEmployee());
                key++;
            }
        }
        keyboard1.close();
    }

    private void printdepts(Department depts) {
        DecimalFormat decim = new DecimalFormat("###,###.00");

        System.out.println("Department Code: " + depts.getDepCode());
        System.out.println("Department Name: " + depts.getDepName());
        System.out.println("Department Total Salary: " + decim.format(depts.getDepTotalSalary()));
        System.out.println();
        System.out.println("---------------------Details------------------------");
        System.out.println("EmpNo\t\tEmployee Name\t\t Salary");

        for (Map.Entry<String, Employee> entryMap : depts.getEmployeeMap().entrySet()) {
        System.out.printf("%-15s %-15s %16s%n",entryMap.getValue().getEmpNo()
                                                     ,entryMap.getValue().getLastName() 
                                                     + "," + entryMap.getValue().getFirstName()
                                                     ,decim.format(entryMap.getValue().getSalary()));
        }
        System.out.println();
    }
}
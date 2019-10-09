package CompanyRosterExercise;

import java.util.*;

/*
Define a class Employee that holds the following information: name, salary, position, department, email and age. The
name, salary, position and department are mandatory while the rest are optional.
Your task is to write a program which takes N lines of information about employees from the console and calculates the
department with the highest average salary and prints for each employee in that department his name, salary, email and
age - sorted by salary in descending order. If an employee doesn’t have an email – in place of that field you should
print "n/a" instead, if he doesn’t have an age – print "-1" instead. The salary should be printed to two decimal places
after the seperator.

Hint: you can define a Department class that holds list of employees.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> companyStructure = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Employee employee;
            employee = generateEmployee(input);

            companyStructure.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            companyStructure.get(employee.getDepartment()).add(employee);
        }

        String theDep = "";
        double bestSalary = 0;

        for (Map.Entry<String, List<Employee>> depAndSalary : companyStructure.entrySet()) {
            double avgSalary = depAndSalary
                    .getValue()
                    .stream()
                    .map(Employee::getSalary)
                    .mapToDouble(e -> e)
                    .average()
                    .getAsDouble();

            if (avgSalary > bestSalary) {
                bestSalary = avgSalary;
                theDep = depAndSalary.getKey();
            }
        }

        System.out.println(String.format("Highest Average Salary: %s", theDep));
        companyStructure.get(theDep).stream().sorted((e1, e2) -> {
            return Double.compare(e2.getSalary(), e1.getSalary());
        }).forEach(employee -> {
            System.out.println(String.format("%s %.2f %s %d",
                    employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
        });
    }

    private static Employee generateEmployee(String[] input) {
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];
        Employee employee = new Employee(name, salary, position, department);

        if (input.length == 5) {
            if (input[4].contains("@")) {
                employee.setEmail(input[4]);
            } else {
                employee.setAge(Integer.parseInt(input[4]));
            }
        } else if (input.length == 6) {
            employee.setEmail(input[4]);
            employee.setAge(Integer.parseInt(input[5]));
        }

        return employee;
    }
}

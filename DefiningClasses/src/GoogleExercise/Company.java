package GoogleExercise;

public class Company {
    private String name;
    private String department;
    private double salary;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getName(), this.getDepartment(), this.getSalary());
    }
}

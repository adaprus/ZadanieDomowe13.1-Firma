public class EmployeeUtils {
    public double averageSalary(Employee[] employees) {
        double salarySum = 0;
        for (Employee value : employees) {
            salarySum += value.getSalary();
        }
        return salarySum / employees.length;
    }

    public double minSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            minSalary = employees[i].getSalary() < minSalary ? employees[i].getSalary() : minSalary;
        }
        return minSalary;
    }

    public double maxSalary(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            maxSalary = employee.getSalary() > maxSalary ? employee.getSalary() : maxSalary;
        }
        return maxSalary;
    }

    public int personsInDepartment(Employee[] employees, String department) {
        int counter = 0;
        for (Employee employee : employees) {
            if ((employee.getDepartment().toLowerCase()).equals(department.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }
}
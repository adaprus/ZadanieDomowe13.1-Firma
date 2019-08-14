import java.io.*;

public class EmployeeTest {
    public static void main(String[] args) {
        String path = "C:\\Users\\adria\\IdeaProjects\\ZadanieDomowe13.1-Firma\\employees.csv";
        EmployeeUtils utils = new EmployeeUtils();
        Employee[] employees = readFile(path);
        writeStatistics(utils, employees);
    }

    private static Employee[] readFile(String path) {
        File file = new File(path);
        Employee[] employees = new Employee[4];

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int index = 0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                employees[index] = new Employee(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
                index++;
            }
        } catch (IOException e) {
            System.out.println("Błąd pliku");
        }
        return employees;
    }

    private static void writeStatistics(EmployeeUtils utils, Employee[] employees) {
        File file = new File("statystykiFirmy.txt");

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Średnia wypłata: " + utils.averageSalary(employees));
            bufferedWriter.newLine();
            bufferedWriter.write("Najmniejsza wypłata: " + utils.minSalary(employees));
            bufferedWriter.newLine();
            bufferedWriter.write("Największa wypłata: " + utils.maxSalary(employees));
            bufferedWriter.newLine();
            bufferedWriter.write("Łączna liczba pracowników: " + employees.length);
            bufferedWriter.newLine();
            bufferedWriter.write("Liczba osób w dziale IT: " + utils.personsInDepartment(employees, "it"));
            bufferedWriter.newLine();
            bufferedWriter.write("Liczba osób w dziale Support: " + utils.personsInDepartment(employees, "Support"));
            bufferedWriter.newLine();
            bufferedWriter.write("Liczba osób w dziale Management: " + utils.personsInDepartment(employees, "Management"));
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

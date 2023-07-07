import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IEFile extends Controller{
    public final static String PATH = System.getProperty("user.dir") + "\\src\\";

    public void departmentExportFile(Scanner scan) {
        System.out.print("Укажите имя файла для записи: ");

        try {
            FileWriter fileWriter = new FileWriter(PATH + scan.nextLine(), true);

            Department [] temp = getCollection().getDepartments();

            int size = getCollection().getCountDepartments();
            for (int i = 0; i < size; ++i) {
                departmentWriteElement(temp[i], fileWriter);
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void employeeExportFile(Scanner scan) {
        System.out.print("Укажите имя файла для записи: ");

        try {
            FileWriter fileWriter = new FileWriter(PATH + scan.nextLine(), true);

            Employee[] temp = getCollection().getEmployees();

            int size = getCollection().getCountEmployees();
            for (int i = 0; i < size; ++i) {
                employeeWriteElement(temp[i], fileWriter);
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void candidateExportFile(Scanner scan) {
        System.out.print("Укажите имя файла для записи: ");

        try {
            FileWriter fileWriter = new FileWriter(PATH + scan.nextLine(), true);

            Candidate[] temp = getCollection().getCandidates();

            int size = getCollection().getCountEmployees();
            for (int i = 0; i < size; ++i) {
                candidateWriteElement(temp[i], fileWriter);
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void departmentWriteElement(Department department, FileWriter fileWriter) {
        try {
            fileWriter.write(department.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void employeeWriteElement(Employee employee, FileWriter fileWriter) {
        try {
            fileWriter.write(employee.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void candidateWriteElement(Candidate candidate, FileWriter fileWriter) {
        try {
            fileWriter.write(candidate.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void departmentImportFile(Scanner scan) {
        System.out.print("Укажите имя файла для получения данных: ");

        try {
            FileReader fileReader = new FileReader(PATH + scan.nextLine());
            Scanner fileScan = new Scanner(fileReader);

            while (fileScan.hasNextLine()) {
                this.createDepartment(departmentReadElement(fileScan));
            }

            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void employeeImportFile(Scanner scan) {
        System.out.print("Укажите имя файла для получения данных: ");

        try {
            FileReader fileReader = new FileReader(PATH + scan.nextLine());
            Scanner fileScan = new Scanner(fileReader);

            while (fileScan.hasNextLine()) {
                this.createEmployee(employeeReadElement(fileScan));
            }

            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void candidateImportFile(Scanner scan) {
        System.out.print("Укажите имя файла для получения данных: ");

        try {
            FileReader fileReader = new FileReader(PATH + scan.nextLine());
            Scanner fileScan = new Scanner(fileReader);

            while (fileScan.hasNextLine()) {
                this.createCandidate(candidateReadElement(fileScan));
            }

            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Department departmentReadElement(Scanner scan) {
        return new Department();
    }
    public Employee employeeReadElement(Scanner scan) {
        return new Employee();
    }
    public Candidate candidateReadElement(Scanner scan) {
        return new Candidate();
    }
}

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.Double.parseDouble;

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

            int size = getCollection().getCountCandidates();

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
            fileWriter.write(department.toString() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void employeeWriteElement(Employee employee, FileWriter fileWriter) {
        try {
            fileWriter.write(employee.toString() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void candidateWriteElement(Candidate candidate, FileWriter fileWriter) {
        try {
            fileWriter.write(candidate.toString() + "\n");
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Department departmentReadElement(Scanner scan) {
        scan.nextLine(); scan.nextLine();

        String temp = scan.nextLine().substring(13);

        Department department = new Department();
        department.setName(temp);

        scan.nextLine();

        return department;
    }
    public Employee employeeReadElement(Scanner scan) throws Exception {
        scan.nextLine(); scan.nextLine();

        Employee employee = new Employee();

        final int space = 21;

        String temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        employee.setFirstName(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        employee.setSecondName(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        employee.setTelephoneNumber(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        employee.setEducation(temp.equals("Высшее"));

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        employee.setBoss(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        try {
            employee.setSalary(parseDouble(temp));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        employee.setPosition(temp);


        scan.nextLine(); scan.nextLine();

        temp = scan.nextLine().substring(13);

        Department[] departments = getCollection().getDepartments();

        int i, kol = getCollection().getCountDepartments();

        for (i = 0; i < kol; ++i) {
            if (departments[i].getName().equals(temp)) {
                break;
            }
        }

        if (i != kol) {
            employee.setDepartment(departments[i]);
        } else {
            throw new Exception("Не найден указанный департамент.");
        }


        scan.nextLine(); scan.nextLine();

        return employee;
    }
    public Candidate candidateReadElement(Scanner scan) throws Exception {
        scan.nextLine(); scan.nextLine();

        Candidate candidate = new Candidate();

        final int space = 21;

        String temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        candidate.setFirstName(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        candidate.setSecondName(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        candidate.setTelephoneNumber(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        candidate.setEducation(temp.equals("Высшее"));

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        candidate.setBoss(temp);

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        try {
            candidate.setSalary(parseDouble(temp));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        temp = scan.nextLine(); temp = temp.substring(space, temp.length() - 1);
        String[] temp2 = temp.split(", ");
        candidate.setPotentialPosition(temp2);


        scan.nextLine(); scan.nextLine();

        temp = scan.nextLine().substring(13);

        Department[] departments = getCollection().getDepartments();

        int i, kol = getCollection().getCountDepartments();

        for (i = 0; i < kol; ++i) {
            if (departments[i].getName().equals(temp)) {
                break;
            }
        }

        if (i != kol) {
            candidate.setDepartment(departments[i]);
        } else {
            throw new Exception("Не найден указанный департамент.");
        }


        scan.nextLine(); scan.nextLine();

        return candidate;
    }
}

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Controller {
    private final Collection collection;

    public Controller() {
        collection = new Collection();
    }

    public void createDepartment(Department department) {
        int count = collection.getCountDepartments();
        Department[] departments = collection.getDepartments();

        if (count == departments.length) {
            collection.incSizeDepartments();
            departments = collection.getDepartments();
        }

        departments[count] = department;
        collection.setDepartments(departments);
        collection.incCountDepartments(true);
    }
    public void createEmployee(Employee employee) {
        int count = collection.getCountEmployees();
        Employee[] employees = collection.getEmployees();

        if (count == employees.length) {
            collection.incSizeEmployees();
            employees = collection.getEmployees();
        }

        employees[count] = employee;
        collection.setEmployees(employees);
        collection.incCountEmployees(true);
    }
    public void createCandidate(Candidate candidate) {
        int count = collection.getCountCandidates();
        Candidate[] candidates = collection.getCandidates();

        if (count == candidates.length) {
            collection.incSizeCandidates();
            candidates = collection.getCandidates();
        }

        candidates[count] = candidate;
        collection.setCandidates(candidates);
        collection.incCountCandidates(true);
    }

    public void readDepartments(int index) {
        try {
            if (index >= collection.getCountDepartments())
                throw new Exception("Нельзя вывести элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Department[] departments = collection.getDepartments();

        System.out.format("  №%2d: ", index);
        System.out.println(departments[index]);
    }
    public void readEmployees(int index) {
        try {
            if (index >= collection.getCountEmployees())
                throw new Exception("Нельзя вывести элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Employee[] employees = collection.getEmployees();

        System.out.format("  №%2d: ", index);
        System.out.println(employees[index]);
    }
    public void readCandidates(int index) {
        try {
            if (index >= collection.getCountCandidates())
                throw new Exception("Нельзя вывести элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Candidate[] candidates = collection.getCandidates();

        System.out.format("  №%2d: ", index);
        System.out.println(candidates[index]);
    }

    public void readAllDepartments() {
        collection.printDepartments();
    }
    public void readAllEmployees() {
        collection.printEmployees();
    }
    public void readAllCandidates() {
        collection.printCandidates();
    }

    public void updateDepartment(int index, Scanner scan) {
        try {
            if (index >= collection.getCountDepartments())
                throw new Exception("Нельзя изменить элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Department department = new Department();
        department.fill(collection, scan);
        collection.getDepartments()[index] = department;
    }
    public void updateEmployee(int index, Scanner scan) {
        try {
            if (index >= collection.getCountEmployees())
                throw new Exception("Нельзя изменить элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Employee employee = new Employee();
        employee.fill(this, scan);
        collection.getEmployees()[index] = employee;
    }
    public void updateCandidate(int index, Scanner scan) {
        try {
            if (index >= collection.getCountCandidates())
                throw new Exception("Нельзя изменить элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Candidate candidate = new Candidate();
        candidate.fill(this, scan);
        collection.getCandidates()[index] = candidate;
    }

    public void deleteDepartment(int index) {
        int size = collection.getDepartments().length;

        try {
            if (index >= collection.getCountDepartments())
                throw new Exception("Нельзя удалить элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Department[] departments = collection.getDepartments();

        --size;
        for(int i = index; i < size; ++i)
            departments[i] = departments[i + 1];

        collection.setDepartments(departments);
        collection.incCountDepartments(false);
    }
    public void deleteEmployee(int index) {
        int size = collection.getEmployees().length;

        try {
            if (index >= collection.getCountEmployees())
                throw new Exception("Нельзя удалить элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Employee[] employees = collection.getEmployees();

        --size;
        for(int i = index; i < size; ++i)
            employees[i] = employees[i + 1];

        collection.setEmployees(employees);
        collection.incCountEmployees(false);
    }
    public void deleteCandidate(int index) {
        int size = collection.getCandidates().length;

        try {
            if (index >= collection.getCountCandidates())
                throw new Exception("Нельзя удалить элемент, которого нет.");

            if (index < 0)
                throw new Exception("Индекс меньше нуля.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Candidate[] candidates = collection.getCandidates();

        --size;
        for(int i = index; i < size; ++i)
            candidates[i] = candidates[i + 1];

        collection.setCandidates(candidates);
        collection.incCountCandidates(false);
    }

    public void searchEmployeeName(String fN, String sN) {
        Employee[] employees = collection.getEmployees();

        int size = collection.getCountEmployees();

        for (int i = 0; i < size; ++i) {
            if (employees[i].getFirstName().equals(fN) && employees[i].getSecondName().equals(sN)) {
                System.out.println(employees[i]);
            }
        }
    }
    public void searchCandidateName(String fN, String sN) {
        Candidate[] candidates = collection.getCandidates();

        int size = collection.getCountCandidates();

        for (int i = 0; i < size; ++i) {
            if (candidates[i].getFirstName().equals(fN) && candidates[i].getSecondName().equals(sN)) {
                System.out.println(candidates[i]);
            }
        }
    }

    public void searchEmployeeBoss(String b) {
        Employee[] employees = collection.getEmployees();

        int size = collection.getCountEmployees();

        for (int i = 0; i < size; ++i) {
            if (employees[i].getBoss().equals(b)) {
                System.out.println(employees[i]);
            }
        }
    }
    public void searchCandidateBoss(String b) {
        Candidate[] candidates = collection.getCandidates();

        int size = collection.getCountCandidates();

        for (int i = 0; i < size; ++i) {
            if (candidates[i].getBoss().equals(b)) {
                System.out.println(candidates[i]);
            }
        }
    }

    public void searchEmployeePosition(String p) {
        Employee[] employees = collection.getEmployees();

        int size = collection.getCountEmployees();

        for (int i = 0; i < size; ++i) {
            if (employees[i].getPosition().equals(p)) {
                System.out.println(employees[i]);
            }
        }
    }
    public void searchCandidatePotentialPosition(String p) {
        Candidate[] candidates = collection.getCandidates();

        int size = collection.getCountCandidates();

        for (int i = 0; i < size; ++i) {
            String[] temp = candidates[i].getPotentialPosition();

            for (String element : temp) {
                if (element.equals(p)) {
                    System.out.println(candidates[i]);
                    break;
                }
            }
        }
    }

    public void searchEmployeeDepartment(String d) {
        Employee[] employees = collection.getEmployees();

        int size = collection.getCountEmployees();

        for (int i = 0; i < size; ++i) {
            if (employees[i].getDepartment().equals(d)) {
                System.out.println(employees[i]);
            }
        }
    }
    public void searchCandidateDepartment(String d) {
        Candidate[] candidates = collection.getCandidates();

        int size = collection.getCountCandidates();

        for (int i = 0; i < size; ++i) {
            if (candidates[i].getDepartment().equals(d)) {
                System.out.println(candidates[i]);
            }
        }
    }

    public Department distribute(Scanner scan) {
        System.out.println("Выберете один из приведённых ниже, указав его номер.");
        collection.printDepartments();

        System.out.println("Если нет нужного департамента, то его можно создать.\nДля создания нажмите '+'" +
                ", другой символ означает игнорирование данного сообщения.");

        String temp = scan.nextLine();

        if (temp.equals("+")) {
            createDepartment(Department.createNewDepartment(collection, scan));
        }

        if (collection.getCountDepartments() == 0) {
            System.out.println("Нет ни одного департамента, его необходимо создать.\nОн будет выбран для данного человека.");
            createDepartment(Department.createNewDepartment(collection, scan));
            return collection.getDepartments()[0];
        }

        System.out.println("Выберете один из приведённых ниже, указав его номер.");
        collection.printDepartments();

        int num;

        while (true) {
            try {
                num = parseInt(scan.nextLine());

                if (num < 0 || num >= collection.getCountDepartments())
                    throw new Exception("Департамента №" + num + " не существует.");

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Это не число. Попробуйте ещё раз.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return collection.getDepartments()[num];
    }

    public Collection getCollection() {
        return collection;
    }
}

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String[] menuStructure = {"Exit", "Department", "Employee", "Candidate"};
        String[] menuOptions = {"Back", "Create", "Read", "ReadAll", "Update", "Delete", "Import", "Export"};
        String[] menuSpecialOptions = {"Back", "by Name", "by Boss", "by Position", "by Department"};

        Scanner scan = new Scanner(System.in);

        IEFile controller = new IEFile();

        int option;

        while (true) {
            System.out.println("Выберите элемент из списка: ");

            int size = menuStructure.length;

            for (int i = 0; i < size; ++i) {
                System.out.println(i + ". " + menuStructure[i]);
            }

            try {
                option = scanMenu(scan, size);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (option) {
                case 0 -> System.exit(0);

                case 1 -> {
                    while (true) {
                        System.out.println("Выберите элемент из списка: ");

                        int size2 = menuOptions.length;

                        for (int i = 0; i < size2; ++i) {
                            System.out.println(i + ". " + menuOptions[i]);
                        }

                        try {
                            option = scanMenu(scan, size2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        if (option == 0)
                            break;

                        switch (option) {
                            case 1 -> controller.createDepartment(Department.createNewDepartment(scan));
                            case 2 -> controller.readDepartments(scanIndex(scan));
                            case 3 -> controller.readAllDepartments();
                            case 4 -> controller.updateDepartment(scanIndex(scan), scan);
                            case 5 -> controller.deleteDepartment(scanIndex(scan));
                            case 6 -> controller.departmentImportFile(scan);
                            case 7 -> controller.departmentExportFile(scan);
                        }
                    }
                }

                case 2 -> {
                    while (true) {
                        System.out.println("Выберите элемент из списка: ");

                        int size2 = menuOptions.length;

                        for (int i = 0; i < size2; ++i) {
                            System.out.println(i + ". " + menuOptions[i]);
                        }

                        System.out.println(size2 + ". Search");

                        try {
                            option = scanMenu(scan, size2 + 1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        if (option == 0)
                            break;

                        switch (option) {
                            case 1 -> controller.createEmployee(Employee.createNewEmployee(controller, scan));
                            case 2 -> controller.readEmployees(scanIndex(scan));
                            case 3 -> controller.readAllEmployees();
                            case 4 -> controller.updateEmployee(scanIndex(scan), scan);
                            case 5 -> controller.deleteEmployee(scanIndex(scan));
                            case 6 -> controller.employeeImportFile(scan);
                            case 7 -> controller.employeeExportFile(scan);
                            case 8 -> {
                                while (true) {
                                    System.out.println("Выберите элемент из списка: ");

                                    int size3 = menuSpecialOptions.length;

                                    for (int i = 0; i < size3; ++i) {
                                        System.out.println(i + ". " + menuSpecialOptions[i]);
                                    }

                                    try {
                                        option = scanMenu(scan, size3);
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        continue;
                                    }

                                    if (option == 0)
                                        break;

                                    switch (option) {
                                        case 1 -> {
                                            System.out.print("Введите имя: ");
                                            String firstName = scan.nextLine();

                                            System.out.print("Введите фамилию: ");
                                            String secondName = scan.nextLine();

                                            controller.searchEmployeeName(firstName, secondName);
                                        }

                                        case 2 -> {
                                            System.out.print("Введите руководителя: ");
                                            String boss = scan.nextLine();

                                            controller.searchEmployeeBoss(boss);
                                        }

                                        case 3 -> {
                                            System.out.print("Введите должность: ");
                                            String position = scan.nextLine();

                                            controller.searchEmployeePosition(position);
                                        }

                                        case 4 -> {
                                            System.out.print("Введите департамент: ");
                                            String department = scan.nextLine();

                                            controller.searchEmployeeDepartment(department);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                case 3 -> {
                    while (true) {
                        System.out.println("Выберите элемент из списка: ");

                        int size2 = menuOptions.length;

                        for (int i = 0; i < size2; ++i) {
                            System.out.println(i + ". " + menuOptions[i]);
                        }

                        System.out.println(size2 + ". Search");

                        try {
                            option = scanMenu(scan, size2 + 1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        if (option == 0)
                            break;

                        switch (option) {
                            case 1 -> controller.createCandidate(Candidate.createNewCandidate(controller, scan));
                            case 2 -> controller.readCandidates(scanIndex(scan));
                            case 3 -> controller.readAllCandidates();
                            case 4 -> controller.updateCandidate(scanIndex(scan), scan);
                            case 5 -> controller.deleteCandidate(scanIndex(scan));
                            case 6 -> controller.candidateImportFile(scan);
                            case 7 -> controller.candidateExportFile(scan);
                            case 8 -> {
                                while (true) {
                                    System.out.println("Выберите элемент из списка: ");

                                    int size3 = menuSpecialOptions.length;

                                    for (int i = 0; i < size3; ++i) {
                                        System.out.println(i + ". " + menuSpecialOptions[i]);
                                    }

                                    try {
                                        option = scanMenu(scan, size3);
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        continue;
                                    }

                                    if (option == 0)
                                        break;

                                    switch (option) {
                                        case 1 -> {
                                            System.out.print("Введите имя: ");
                                            String firstName = scan.nextLine();

                                            System.out.print("Введите фамилию: ");
                                            String secondName = scan.nextLine();

                                            controller.searchCandidateName(firstName, secondName);
                                        }

                                        case 2 -> {
                                            System.out.print("Введите руководителя: ");
                                            String boss = scan.nextLine();

                                            controller.searchCandidateBoss(boss);
                                        }

                                        case 3 -> {
                                            System.out.print("Введите должность: ");
                                            String position = scan.nextLine();

                                            controller.searchCandidatePotentialPosition(position);
                                        }

                                        case 4 -> {
                                            System.out.print("Введите департамент: ");
                                            String department = scan.nextLine();

                                            controller.searchCandidateDepartment(department);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static int scanMenu(Scanner scan, int size) throws Exception {
        int option;

        while (true) {
            try {
                option = parseInt(scan.nextLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Это не число. Попробуйте ещё раз.");
            }
        }

        if (option < 0 || option >= size) {
            throw new Exception("Действие " + option + " не существует.");
        }

        return option;
    }

    public static int scanIndex(Scanner scan) {
        System.out.print("Укажите индекс: ");

        int index;

        while (true) {
            try {
                index = parseInt(scan.nextLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Это не число. Попробуйте ещё раз.");
            }
        }

        return index;
    }
}

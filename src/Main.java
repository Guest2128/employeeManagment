import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String[] menuStructure = {"Exit", "Department", "Employee", "Candidate"};
        String[] menuOptions = {"Back", "Create", "Read", "ReadAll", "Update", "Delete"};

        Scanner scan = new Scanner(System.in);

        Controller controller = new Controller();

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
                            case 1 -> controller.createDepartment(scan);
                            case 2 -> controller.readDepartments(scanIndex(scan));
                            case 3 -> controller.readAllDepartments();
                            case 4 -> controller.updateDepartment(scanIndex(scan), scan);
                            case 5 -> controller.deleteDepartment(scanIndex(scan));
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

                        try {
                            option = scanMenu(scan, size2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        if (option == 0)
                            break;
                        switch (option) {
                            case 1 -> controller.createEmployee(scan);
                            case 2 -> controller.readEmployees(scanIndex(scan));
                            case 3 -> controller.readAllEmployees();
                            case 4 -> controller.updateEmployee(scanIndex(scan), scan);
                            case 5 -> controller.deleteEmployee(scanIndex(scan));
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

                        try {
                            option = scanMenu(scan, size2);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        if (option == 0)
                            break;
                        switch (option) {
                            case 1 -> controller.createCandidate(scan);
                            case 2 -> controller.readCandidates(scanIndex(scan));
                            case 3 -> controller.readAllCandidates();
                            case 4 -> controller.updateCandidate(scanIndex(scan), scan);
                            case 5 -> controller.deleteCandidate(scanIndex(scan));
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

        if (option < 0 || option >= size)
            throw new Exception("Действие " + option + " не существует.");

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

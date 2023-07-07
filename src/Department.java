import java.util.Scanner;

public class Department {
    private String name;

    Department() {
        name = "Пусто";
    }

//    Department(String n) {
//        name = n;
//    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void fill(Scanner scan) {
        System.out.println("Департамент:");

        System.out.print("  Название: ");
        while (name.length() == 0 || name.equals("Пусто")) {
            name = scan.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Департамент\n{\n  " +
                "Название = " + name + "\n}";
    }

    public static Department createNewDepartment(Scanner scan) {
        Department department = new Department();
        department.fill(scan);
        return department;
    }
}

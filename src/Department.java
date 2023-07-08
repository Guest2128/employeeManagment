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

    public void fill(Collection collection, Scanner scan) {
        System.out.println("Департамент:");

        System.out.print("  Название: ");
        while (name.length() == 0 || name.equals("Пусто")) {
            name = scan.nextLine();
        }

        if (isEquals(collection)) {
            collection.incCountDepartments(false);

            System.out.println("Такой департамент уже есть.");
        }
    }

    public boolean isEquals(Collection collection) {
        Department[] departments = collection.getDepartments();

        int size = collection.getCountDepartments();

        for (int i = 0; i < size; ++i) {
            if (departments[i].getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Департамент\n{\n  " +
                "Название = " + name + "\n}";
    }

    public static Department createNewDepartment(Collection collection, Scanner scan) {
        Department department = new Department();
        department.fill(collection, scan);

        return department;
    }
}

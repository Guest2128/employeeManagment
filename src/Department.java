import java.util.Scanner;

public class Department {
    private String name;

    Department() {
        name = "Пусто";
    }
    Department(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void fill(Scanner scan) {
        System.out.println("Департамент:");

        System.out.print("  Название: ");
        name = scan.nextLine();
    }

    @Override
    public String toString() {
        return "Департамент\n{\n  " +
                "Название = " + name + "\n}";
    }
}

import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Employee {
    private String firstName;
    private String secondName;
    private String telephoneNumber;
    private boolean education;
    private String boss;
    private double salary;
    private String position;
    private Department department;

    Employee() {
        firstName = secondName = telephoneNumber = boss = position = "Пусто";
        education = false;
        salary = 0;
        department = new Department();
    }

//    Employee(String fN, String sN, String tN, boolean e, String b, double s, String p, Department d) {
//        firstName = fN;
//        secondName = sN;
//        telephoneNumber = tN;
//        education = e;
//        boss = b;
//        salary = s;
//        position = p;
//        department = d;
//    }

//    public String getFirstName() {
//        return firstName;
//    }
//    public String getSecondName() {
//        return secondName;
//    }
//    public String getTelephoneNumber() {
//        return telephoneNumber;
//    }

    public String getEducation() {
        return education ? "Высшее" : "Нет";
    }

//    public String getBoss() {
//        return boss;
//    }
//    public double getSalary() {
//        return salary;
//    }
//    public String getPosition() {
//        return position;
//    }
//    public String getDepartment() {
//        return department.getName();
//    }

    public void setFirstName(String fN) {
        firstName = fN;
    }
    public void setSecondName(String sN) {
        secondName = sN;
    }
    public void setTelephoneNumber(String tN) {
        telephoneNumber = tN;
    }
    public void setEducation(boolean e) {
        education = e;
    }
    public void setBoss(String b) {
        boss = b;
    }
    public void setSalary(double s) {
        salary = s;
    }
    public void setPosition(String p) {
        position = p;
    }
    public void setDepartment(Department d) {
        department = d;
    }

    public void fill(Controller controller, Scanner scan) {
        System.out.println("Сотрудник:");

        System.out.print("  Имя: ");
        while (firstName.length() == 0 || firstName.equals("Пусто")) {
            firstName = scan.nextLine();
        }

        System.out.print("  Фамилия: ");
        while (secondName.length() == 0 || secondName.equals("Пусто")) {
            secondName = scan.nextLine();
        }

        System.out.print("  Номер телефона: ");
        while (telephoneNumber.length() == 0 || telephoneNumber.equals("Пусто")) {
            telephoneNumber = scan.nextLine();
        }

        System.out.print("  Высшее образование (+ / -): ");
        while (true) {
            String temp;

            try {
                temp = scan.nextLine();

                if (!temp.equals("+") && !temp.equals("-"))
                    throw new Exception("Выбрано некорректное значение. Выберите '+' или '-'.");

                setEducation(temp.equals("+"));

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("  Начальник: ");
        while (boss.length() == 0 || boss.equals("Пусто")) {
            boss = scan.nextLine();
        }

        System.out.print("  Заработная плата: ");
        while (true) {
            try {
                salary = parseDouble(scan.nextLine());

                if (salary < 0) {
                    throw new Exception();
                }

                break;
            } catch (Exception e) {
                System.out.println("Указано некорректное значение. Попробуйте ещё раз.");
            }
        }

        System.out.print("  Должность: ");
        while (position.length() == 0 || position.equals("Пусто")) {
            position = scan.nextLine();
        }

        department = controller.distribute(scan);
    }

    @Override
    public String toString() {
        String temp = String.format("%.2f", salary).replace(',', '.');

        return "Сотрудник\n{\n  " +
                "Имя              = " + firstName       + ",\n  " +
                "Фамилия          = " + secondName      + ",\n  " +
                "Номер телефона   = " + telephoneNumber + ",\n  " +
                "Образование      = " + getEducation()  + ",\n  " +
                "Начальник        = " + boss            + ",\n  " +
                "Заработная плата = " + temp            + ",\n  " +
                "Желаемая позиция = " + position        + ",\n  " +
                "Департамент      = " + department      + "\n}";
    }

    public static Employee createNewEmployee(Controller controller, Scanner scan) {
        Employee employee = new Employee();
        employee.fill(controller, scan);
        return employee;
    }
}

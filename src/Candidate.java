import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Candidate {
    private String firstName;
    private String secondName;
    private String telephoneNumber;
    private boolean education;
    private String boss;
    private double salary;
    private String[] potentialPosition;
    private Department department;

    Candidate() {
        firstName = secondName = telephoneNumber = boss = "Пусто";
        education = false;
        salary = 0;
        potentialPosition = new String[] {"Пусто"};
        department = new Department();
    }
    Candidate(String fN, String sN, String tN, boolean e, String b, double s, String[] pP, Department d) {
        firstName = fN;
        secondName = sN;
        telephoneNumber = tN;
        education = e;
        boss = b;
        salary = s;
        potentialPosition = pP;
        department = d;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public String getEducation() {
        return education ? "Высшее" : "Нет";
    }
    public String getBoss() {
        return boss;
    }
    public double getSalary() {
        return salary;
    }
    public String[] getPotentialPosition() {
        return potentialPosition;
    }
    public String getDepartment() {
        return department.getName();
    }

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
    public void setPotentialPosition(String[] pP) {
        potentialPosition = pP;
    }
    public void setDepartment(Department d) {
        department = d;
    }

    public void fill(Controller controller, Scanner scan) {
        System.out.println("Кандидат:");

        System.out.print("  Имя: ");
        firstName = scan.nextLine();

        System.out.print("  Фамилия: ");
        secondName = scan.nextLine();

        System.out.print("  Номер телефона: ");
        telephoneNumber = scan.nextLine();

        System.out.print("  Высшее образование (+ / -): ");
        while (true) {
            String temp;
            try {
                temp = scan.nextLine();
                if (!temp.equals("+") && !temp.equals("-"))
                    throw new Exception("Выбрано некорректное значение. Выберите '+' или '-'.");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("  Начальник: ");
        boss = scan.nextLine();

        System.out.print("  Заработная плата: ");
        while (true) {
            try {
                salary = parseDouble(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Указано некорректное значение. Попробуйте ещё раз.");
            }
        }

        System.out.println("  Желаемые должности (в одной строке одна должность, строка, равная '0', есть признак конца:");
        {
            String temp = scan.nextLine();
            int i = 0;
            while (!temp.equals("0")) {
                if (potentialPosition.length == i) {
                    String[] last = potentialPosition;
                    int size = 2 * potentialPosition.length;
                    potentialPosition = new String[size];
                    System.arraycopy(last, 0, potentialPosition, 0, last.length);
                }
                potentialPosition[i] = temp;
                ++i;
                temp = scan.nextLine();
            }
        }

        department = controller.distribute(controller, scan);
    }

    @Override
    public String toString() {
        StringBuilder pP = new StringBuilder();
        {
            int size = potentialPosition.length - 1;
            int i;
            for (i = 0; i < size && potentialPosition[i] != null; ++i) {
                pP.append(potentialPosition[i]);

                if (i + 1 < size && potentialPosition[i + 1] != null) {
                    pP.append(", ");
                }
            }
        }

        return "Кандидат\n{\n  " +
                "Имя              = " + firstName                      + ",\n  " +
                "Фамилия          = " + secondName                     + ",\n  " +
                "Номер телефона   = " + telephoneNumber                + ",\n  " +
                "Образование      = " + getEducation()                 + ",\n  " +
                "Начальник        = " + boss                           + ",\n  " +
                "Заработная плата = " + String.format("%.2f", salary) + ",\n  " +
                "Желаемые позиции = " + pP                             + ",\n  " +
                "Департамент      = " + department                     + "\n}";
    }
}

public class Collection {
    private Department[] departments;
    private Employee[] employees;
    private Candidate[] candidates;

    private int countDepartments = 0;
    private int countEmployees = 0;
    private int countCandidates = 0;

    private int sizeDepartments = 1;
    private int sizeEmployees = 1;
    private int sizeCandidates = 1;

    Collection() {
        departments = new Department[1];
        employees = new Employee[1];
        candidates = new Candidate[1];
    }

    public Department[] getDepartments() {
        return departments;
    }
    public Employee[] getEmployees() {
        return employees;
    }
    public Candidate[] getCandidates() {
        return candidates;
    }

    public void setDepartments(Department[] d) {
        departments = d;
    }
    public void setEmployees(Employee[] e) {
        employees = e;
    }
    public void setCandidates(Candidate[] c) {
        candidates = c;
    }

    public int getCountDepartments() {
        return countDepartments;
    }
    public int getCountEmployees() {
        return countEmployees;
    }
    public int getCountCandidates() {
        return countCandidates;
    }

    public void incCountDepartments(boolean isInc) {
        if (isInc) {
            ++countDepartments;
        } else {
            --countDepartments;
        }
    }
    public void incCountEmployees(boolean isInc) {
        if (isInc) {
            ++countEmployees;
        } else {
            --countEmployees;
        }
    }
    public void incCountCandidates(boolean isInc) {
        if (isInc) {
            ++countCandidates;
        } else {
            --countCandidates;
        }
    }

    public void incSizeDepartments() {
        Department[] last = departments;
        sizeDepartments *= 2;
        departments = new Department[sizeDepartments];
        System.arraycopy(last, 0, departments, 0, last.length);
    }
    public void incSizeEmployees() {
        Employee[] last = employees;
        sizeEmployees *= 2;
        employees = new Employee[sizeEmployees];
        System.arraycopy(last, 0, employees, 0, last.length);
    }
    public void incSizeCandidates() {
        Candidate[] last = candidates;
        sizeCandidates *= 2;
        candidates = new Candidate[sizeCandidates];
        System.arraycopy(last, 0, candidates, 0, last.length);
    }

    public void printDepartments() {
        System.out.println("Департаменты:");

        if (countDepartments == 0) {
            System.out.println("Отсутствуют.");
        }

        for (int i = 0; i < countDepartments; ++i) {
            System.out.format("  №%2d: ", i);
            System.out.println(departments[i]);
        }
    }
    public void printEmployees() {
        System.out.println("Сотрудники:");

        if (countEmployees == 0) {
            System.out.println("Отсутствуют.");
        }

        for (int i = 0; i < countEmployees; ++i) {
            System.out.format("  №%2d: ", i);
            System.out.println(employees[i]);
        }
    }
    public void printCandidates() {
        System.out.println("Кандидаты:");

        if (countCandidates == 0) {
            System.out.println("Отсутствуют.");
        }

        for (int i = 0; i < countCandidates; ++i) {
            System.out.format("  №%2d: ", i);
            System.out.println(candidates[i]);
        }
    }
}

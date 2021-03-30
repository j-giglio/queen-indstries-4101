import java.util.ArrayList;

public class Manager extends Employee {
    private int bonus;
    private ArrayList<Employee> reports;

    public Manager (int s, int b, String n, String d, String t, ArrayList<Employee> r, int tr) throws Exception {
        super(s, n, d, t, tr);
        bonus = b;
        validateReports(r);
        reports = r;
    }

    public void validateReports(ArrayList<Employee> r) throws Exception {
        for (Employee e : r) {
            if (this.compareTo(e) < 1) {
                throw new Exception("ERROR: cannot supervise an Employee of an equal or greater tier.");
            }
        }
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public ArrayList<Employee> getReports() {
        return reports;
    }

    public void hire (Employee emp) throws Exception {
        if (this.compareTo(emp) > 0) {
            System.out.println();
            System.out.print("LOG: new Employee hired (" + emp.getName() + ", " + emp.getDepartment() + ", " + emp.getTitle() + ")");
            reports.add(emp);
        } else {
            throw new Exception("ERROR: cannot hire an Employee of an equal or greater tier.");
        }
    }

    public void fire (Employee emp) throws Exception {
        if (compareTo(emp) > 0) {
            if (!reports.contains(emp)) {
                throw new Exception("ERROR: cannot fire an Employee who is not a direct or indirect report.");
            } else {
                System.out.println();
                System.out.print("LOG: existing Employee fired (" + emp.getName() + ", " + emp.getDepartment() + ", " + emp.getTitle() + ")");
                reports.remove(emp);
            }
        } else {
            throw new Exception("ERROR: cannot fire an Employee of an equal or greater tier.");
        }
    }
}

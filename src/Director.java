import java.util.ArrayList;

public class Director extends Manager {
    int shares;

    public Director(int s, int sh, int b, String n, String d, String t, ArrayList<Employee> r, int tr) throws Exception {
        super(s, b, n, d, t, r, tr);
        shares = sh;
    }

    public void adjustSalary (int delta, Employee x) throws Exception {
        for (Employee e : getReports()) {
            if (x.equals(e)) {
                x.setSalary(x.getSalary() + delta);
                return;
            }
            Manager em = (Manager) e;
            for (Employee f : em.getReports()) {
                if (x.equals(f)) {
                    x.setSalary(x.getSalary() + delta);
                    return;
                }
            }
        }
        throw new Exception("ERROR: cannot alter salary of an Employee who is not a report.");
    }

    public void fire (Employee emp) throws Exception {
        for (int i = 0; i < getReports().size(); i++) {
            Manager mang = (Manager) getReports().get(i);
            for (int j = 0; j < mang.getReports().size(); j++) {
                if (mang.getReports().get(j) == emp) {
                    System.out.println();
                    System.out.print("LOG: existing Employee fired (" + emp.getName() + ", " + emp.getDepartment() + ", " + emp.getTitle() + ")");
                    getReports().remove(j);
                    return;
                }
            }
        }
        super.fire(emp);
    }
}

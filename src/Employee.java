public class Employee implements Comparable<Employee> {
    private int tier;
    private int salary;
    private String name;
    private String department;
    private String title;

    public Employee (int s, String n, String d, String t) {
        tier = 1;
        salary = s;
        name = n;
        department = d;
        title = t;
    }

    public Employee (int s, String n, String d, String t, int tr) {
        tier = tr;
        salary = s;
        name = n;
        department = d;
        title = t;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getTier() > o.getTier()) {
            return 1;
        } else if (this.getTier() < o.getTier()) {
            return -1;
        } else {
            return 0;
        }
    }
}

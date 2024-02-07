import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String e_name;
    private int e_id;

    // Constructor
    public Employee(String name, int id) {
        this.e_name = name;
        this.e_id = id;
    }

    // by the following declaration of the methods--> achieve Encapsulation
    public String getEmployeeName() {
        return e_name;
    }

    public int getEmployeeId() {
        return e_id;
    }

    // declaring abstract method
    public abstract double calcaulateSalary();

    // toString method is used to provide a string representation of an object
    // method overriding
    @Override
    public String toString() {
        return "Employee [name=" + e_name + ",id=" + e_id + ",salary= " + calcaulateSalary() + "]";
    }
}

// child class
class FulltimeEmployee extends Employee {
    private double e_monthlySalary;

    public FulltimeEmployee(String name, int id, double monthysalary) {
        // super is used to invoke access fields of parent class constructore
        super(name, id);
        this.e_monthlySalary = monthysalary;
    }

    // define and override of the abstract method
    @Override
    public double calcaulateSalary() {
        return e_monthlySalary;
    }
}

class ParttimeEmployee extends Employee {
    private int e_hoursWork;
    private double e_hourlyPrice;

    public ParttimeEmployee(String name, int id, int hourswork, double hourlyPrice) {
        super(name, id);
        this.e_hoursWork = hourswork;
        this.e_hourlyPrice = hourlyPrice;

    }

    @Override
    public double calcaulateSalary() {
        return e_hoursWork * e_hourlyPrice;
    }
}

class PaySystem {
    private List<Employee> e_list;

    public PaySystem() {
        e_list = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        e_list.add(emp);
    }

    public void removeEmployee(int id) {
        Employee value = null;
        for (Employee e : e_list) {
            if (e.getEmployeeId() == id) {
                value = e;
                break;
            }
        }
        if (value != null) {
            e_list.remove(value);
        }
    }

    public void displaydetails() {
        for (Employee e : e_list) {
            System.out.println(e);
        }
    }

}

public class App {
    public static void main(String[] args) {
        PaySystem system1 = new PaySystem();

        FulltimeEmployee emp1 = new FulltimeEmployee("Bikash", 1, 90000);
        ParttimeEmployee emp2 = new ParttimeEmployee("Bitupon", 2, 8, 1000);
        system1.addEmployee(emp1);
        system1.addEmployee(emp2);
        System.out.println("Employee Details list");
        system1.displaydetails();
        System.out.println("Remove id 2");
        system1.removeEmployee(2);
        System.out.println("after removal employee details list");

        system1.displaydetails();
    }
}

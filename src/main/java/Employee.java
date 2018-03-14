/**
 * Class implementing an employee.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/10/">Lab 10 Description</a>
 */
public class Employee {
    /** name */
    private String name;

    /** manager */
    private String manager;

    /**
     * Constructor for initialization.
     * @param name name
     * @param manager manager
     */
    public Employee(final String name, final String manager) {
        this.name = name;
        this.manager = manager;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter for manager.
     * @return manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * Setter for manager.
     * @param manager manager
     */
    public void setManager(final String manager) {
        this.manager = manager;
    }

    /** list of employees. */
    private java.util.List<Employee> employees;

    /**
     * Constructor which initializes the employees list.
     */
    public EmployeeDatabase() {
        
    }

    /**
     * Returns the manager for the given employee.
     * @param employee the employee to return the manager for
     * @return the employee's manager
     */
    public Employee findManager(final Employee employee) {
        String managerName = employee.getManager();
        for (int i = 0; i < employees.size(); i++) {
            Employee temp = employees.get(i);
            if (managerName.equals(temp.toString())) {
                return employees.get(i);
            }
        }
    }

    /**
     * Count the number of managers above this employee.
     * @param employee the name of the employee
     * @return the number of managers above
     */
    public int countManagersAbove(final Employee employee) {
        int count = 0;
        Employee temp = findManager(employee);
        while (temp != null) {
            count++;
            temp = findManager(temp);
        }
        return count;
    }

    /**
     * Count the number of employees under this manager.
     * @param employee name of the employee
     * @return number of employees under this manager
     */
    public int countEmployeesUnder(final Employee employee) {
        int counter = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee temp = employees.get(i);
            temp = temp.findManager();
            if (temp.equals(employee)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Main method for testing.
     * @param unused unused input arguments
     */
    public static void main(java.lang.String[] unused) {

    }

}

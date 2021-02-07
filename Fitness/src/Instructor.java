public class Instructor extends Employee {


    public Instructor(String name, String cpr, int hours, int salary) {
        super(name, cpr, hours, salary);
    }

    public int getSalary() {

        return super.getHours() * super.getSalary();
    }

    @Override
    public String toString() {
        return
                super.getName() + "     " + super.getCpr() + "     " + getHours() + "     " + +getSalary() + "     \n";
    }
}

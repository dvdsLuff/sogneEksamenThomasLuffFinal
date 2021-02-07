public class Administration extends Employee {

   private int vacation;

    public Administration(String name, String cpr) {
        super(name, cpr, 37, 33000);
        this.vacation = 5;
    }


    public int getVacation() {
        return vacation;
    }

    @Override
    public String toString() {
        return super.getName() + "     " +
                super.getCpr() + "     " +
                getHours() + "     " +
                +getSalary() + "     "
                + vacation + "\n";
    }
}

import java.util.ArrayList;

public class MEmployeeList {

    private ArrayList<Person> employees = new ArrayList<>();
    private ArrayList<Person> members = new ArrayList<>();
    private ArrayList<Person> MEmployees = new ArrayList<>();

    public void add(Person person) {
        MEmployees.add(person);
        if (person instanceof Member) {
            members.add(person);
        } else employees.add(person);

    }



    public String employeeToString() {

        return "*******************************************************" + "\n" +
                "name     cpr      hours     salary   vacation\n" +
                employees.toString() +
                "\n";
    }

    public String memberToString() {

        return "*******************************************************" + "\n" +
                "name     cpr          type                fee\n" +
                members.toString() +
                "\n";
    }


    public String everyoneToString() {
        String str="";
        for (Person person:MEmployees) {
            str += person.getName() + "     " + person.getCpr() +"\n" ;

        }

        return"Employees/Members*******************************************************" + "\n" +
                "name     cpr\n" +
                str;
    }
}

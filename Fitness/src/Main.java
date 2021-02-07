public class Main {

    public static void main(String[] args) {
        MEmployeeList memployees = new MEmployeeList();

        Instructor instructor1 = new Instructor("Line", "16091990", 35, 199);
        Instructor instructor2 = new Instructor("lars", "16091992", 25, 199);
        Instructor instructor3 = new Instructor("emil", "16091991", 28, 199);
        Administration admin = new Administration("Lone", "14051988");

        Member member1 = new Member("alan", "25121990", false);
        Member member2 = new Member("tom ", "25121990", true);
        Member member3 = new Member("lasse", "22121990", false);
        Member member4 = new Member("signe", "21121990", true);

        memployees.add(instructor1);
        memployees.add(instructor2);
        memployees.add(instructor3);
        memployees.add(admin);
        memployees.add(member1);
        memployees.add(member2);
        memployees.add(member3);
        memployees.add(member4);

        System.out.println(memployees.employeeToString());
        System.out.println(memployees.memberToString());
        System.out.println(memployees.everyoneToString());


    }
}

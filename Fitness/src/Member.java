public class Member extends Person {


    boolean isBasic;


    public Member(String name, String cpr,boolean isBasic) {
        super(name, cpr);
        this.isBasic=isBasic;
    }

    public String getMemberType(){
        if(isBasic){
            return "basic membership";
        }else return "full membership";
    }

    public int monthlyFee(){
        if(isBasic){
            return 199;
        }else return 299;
    }

    @Override
    public String toString() {
        return super.getName() + "     "+
                 super.getCpr() + "     " +
                 getMemberType()+ "     " +
                monthlyFee() + "\n";
    }
}

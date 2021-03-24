package Task_Polymorphism;

public class IndependenceDay extends Movie {
    public IndependenceDay(){
        super("independence day");
    }

    @Override
    public String plot(){
        return "Aliens attemt to take over planet earth";
    }
}

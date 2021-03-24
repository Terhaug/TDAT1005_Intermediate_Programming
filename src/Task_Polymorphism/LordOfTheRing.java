package Task_Polymorphism;

public class LordOfTheRing extends Movie{
    public LordOfTheRing(){
        super("The lord of the Rings");
    }
    @Override
    public String plot(){
        return "A fellowship tries to destroy a ring";
    }
}

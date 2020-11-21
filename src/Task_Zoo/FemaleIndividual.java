package Task_Zoo;

public class FemaleIndividual extends Individual implements ScandinavianPredators{

    private int amLitter;

    public FemaleIndividual(String norName, String latName, int arrivalDate, String addresse, String name, int fDate, boolean male, boolean dangerous, int amLitter) {
        super(norName, latName, arrivalDate, addresse, name, fDate, male, dangerous);
        this.amLitter = amLitter;
    }

    public int getAmLitter(){
        return amLitter;
    }

    public void addLitter(int amount){
        amLitter += amount;
    }

}

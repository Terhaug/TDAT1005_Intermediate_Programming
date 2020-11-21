package Task_Zoo;

public class MaleIndividual extends Individual implements ScandinavianPredators{
    public MaleIndividual(String norName, String latName, int arrivalDate, String addresse, String name, int fDate, boolean male, boolean dangerous) {
        super(norName, latName, arrivalDate, addresse, name, fDate, male, dangerous);
    }

    public int getAmLitter(){
        return 0;
    }

    public void addLitter(int amount){

    }
}

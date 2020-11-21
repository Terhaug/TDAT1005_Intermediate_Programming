package Task_Zoo;

public class PredatorFactory {

    public ScandinavianPredators newFemaleBear(int arrivalDate, String addresse, String name, int fDate, int amLitter){
        return new FemaleIndividual("Brownbear", "ursus arctos", arrivalDate, addresse, name, fDate, false, true, amLitter);
    }

    public ScandinavianPredators newMaleBear(int arrivalDate, String addresse, String name, int fDate){
        return new MaleIndividual("Brownbear", "ursus arctos", arrivalDate, addresse, name, fDate, true, true);
    }

    public ScandinavianPredators newFemaleWolf(int arrivalDate, String addresse, String name, int fDate, int amLitter){
        return new FemaleIndividual("Wolf", "Rupus", arrivalDate, addresse, name, fDate, false, true, amLitter);
    }

    public ScandinavianPredators newMaleWolf(int arrivalDate, String addresse, String name, int fDate){
        return new MaleIndividual("Wolf", "Rupus", arrivalDate, addresse, name, fDate, true, true);
    }
}

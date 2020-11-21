package Task_Zoo;

public class FlockBirds extends AnimalGroup {
    private final int averageWeight;
    private final boolean swimmer;

    public FlockBirds(String norName, String latName, int arrivalDate, String addresse, String groupName, int amIndividuals, int averageWeight, boolean swimmer) {
        super(norName, latName, arrivalDate, addresse, groupName, amIndividuals);
        this.averageWeight = averageWeight;
        this.swimmer = swimmer;
    }

    public int getAverageWeight() {
        return averageWeight;
    }

    public boolean isSwimmer() {
        return swimmer;
    }

    @Override
    public String toString() {
        return "FlockBirds{" +
                "Norwegian name: " + getNorName() +
                "averageWeight=" + averageWeight +
                ", swimmer=" + swimmer +
                '}';
    }
}

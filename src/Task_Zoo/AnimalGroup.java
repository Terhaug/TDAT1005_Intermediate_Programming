package Task_Zoo;

public abstract class AnimalGroup extends Animal{
    private final String groupName;
    private int amIndividuals;

    public AnimalGroup(String norName, String latName, int arrivalDate, String addresse, String groupName, int amIndividuals) {
        super(norName, latName, arrivalDate, addresse);
        this.groupName = groupName;
        this.amIndividuals = amIndividuals;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getAmIndividuals() {
        return amIndividuals;
    }

    @Override
    public String getNorName() {
        return "Group of " + super.getNorName();
    }

    public void setAmIndividuals(int amIndividuals) {
        this.amIndividuals = amIndividuals;
    }

    @Override
    public String toString() {
        return "AnimalGroup{" +
                "Norwegian name: " + getNorName() +
                "groupName='" + groupName + '\'' +
                ", amIndividuals=" + amIndividuals +
                '}';
    }
}

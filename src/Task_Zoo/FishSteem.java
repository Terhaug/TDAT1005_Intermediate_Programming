package Task_Zoo;

public class FishSteem extends AnimalGroup {
    private final int averageLength;
    private final boolean canShareAquarium;

    public FishSteem(String norName, String latName, int arrivalDate, String addresse, String groupName, int amIndividuals, int averageLength, boolean canShareAquarium) {
        super(norName, latName, arrivalDate, addresse, groupName, amIndividuals);
        this.averageLength = averageLength;
        this.canShareAquarium = canShareAquarium;
    }

    public int getAverageLength() {
        return averageLength;
    }

    public boolean isCanShareAquarium() {
        return canShareAquarium;
    }

    @Override
    public String toString() {
        return "FishSteem{" +
                "Norwegian name: " + getNorName() +
                "averageLength=" + averageLength +
                ", canShareAquarium=" + canShareAquarium +
                '}';
    }
}


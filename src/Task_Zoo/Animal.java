package Task_Zoo;

public abstract class Animal {
    private final String norName;
    private final String latName;
    private final int arrivalDate;
    private String addresse;

    public Animal(String norName, String latName, int arrivalDate, String addresse) {
        this.norName = norName;
        this.latName = latName;
        this.arrivalDate = arrivalDate;
        this.addresse = addresse;
    }

    public String getNorName() {
        return norName;
    }

    public String getLatName() {
        return latName;
    }

    public int getArrivalDate() {
        return arrivalDate;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "norName='" + norName + '\'' +
                ", latName='" + latName + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", addresse='" + addresse + '\'' +
                '}';
    }
}
